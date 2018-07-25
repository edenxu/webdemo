package cn.com.gxbolian.databank.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import cn.com.gxbolian.databank.dao.IGreenplumCommonDAO;
import cn.com.gxbolian.databank.dao.XtpzBzhzjpzMapper;
import cn.com.gxbolian.databank.dao.XtpzCxfaMapper;
import cn.com.gxbolian.databank.dao.XtpzSjglysGxhMapper;
import cn.com.gxbolian.databank.dao.XtpzSjglysMapper;
import cn.com.gxbolian.databank.dao.XtpzSjyGxhMapper;
import cn.com.gxbolian.databank.dao.XtpzSjyMapper;
import cn.com.gxbolian.databank.dao.XtpzSjzdGxhMapper;
import cn.com.gxbolian.databank.dao.XtpzSjzdMapper;
import cn.com.gxbolian.databank.dao.XtpzTableGxhMapper;
import cn.com.gxbolian.databank.dao.XtpzXlcsMapper;
import cn.com.gxbolian.databank.dao.XtpzXlcstzMapper;
import cn.com.gxbolian.databank.entity.BootstrapTreeViewEntity;
import cn.com.gxbolian.databank.entity.ParamsObject;
import cn.com.gxbolian.databank.entity.XtpzBzhzjpz;
import cn.com.gxbolian.databank.entity.XtpzBzhzjpzExample;
import cn.com.gxbolian.databank.entity.XtpzCxfa;
import cn.com.gxbolian.databank.entity.XtpzCxfaExample;
import cn.com.gxbolian.databank.entity.XtpzSjglys;
import cn.com.gxbolian.databank.entity.XtpzSjglysExample;
import cn.com.gxbolian.databank.entity.XtpzSjglysGxh;
import cn.com.gxbolian.databank.entity.XtpzSjglysGxhExample;
import cn.com.gxbolian.databank.entity.XtpzSjy;
import cn.com.gxbolian.databank.entity.XtpzSjyExample;
import cn.com.gxbolian.databank.entity.XtpzSjyGxh;
import cn.com.gxbolian.databank.entity.XtpzSjyGxhExample;
import cn.com.gxbolian.databank.entity.XtpzSjzd;
import cn.com.gxbolian.databank.entity.XtpzSjzdExample;
import cn.com.gxbolian.databank.entity.XtpzSjzdGxh;
import cn.com.gxbolian.databank.entity.XtpzSjzdGxhExample;
import cn.com.gxbolian.databank.entity.XtpzTableGxh;
import cn.com.gxbolian.databank.entity.XtpzXlcs;
import cn.com.gxbolian.databank.entity.XtpzXlcsExample;
import cn.com.gxbolian.databank.entity.XtpzXlcstz;
import cn.com.gxbolian.databank.entity.XtpzXlcstzExample;
import cn.com.gxbolian.databank.util.CommonUtil;
import cn.com.gxbolian.databank.util.IdWorker;

@Service
public class DemoServiceImpl implements IDemoService {
	protected final Logger log = LogManager.getLogger(DemoServiceImpl.class);
	@Autowired
	private XtpzSjyMapper sjyDao;
	@Autowired
	private XtpzSjzdMapper sjzdDao;
	@Autowired
	private XtpzSjglysMapper sjglDao;
	@Autowired
	private XtpzXlcsMapper xlcsDao;
	@Autowired
	private XtpzXlcstzMapper xlcstzDao;
	@Autowired
	private XtpzTableGxhMapper tablegxhDao;
	@Autowired
	private XtpzSjzdGxhMapper sjzdGxhDao;
	@Autowired
	private XtpzSjyGxhMapper sjyGxhDao;
	@Autowired
	private XtpzSjglysGxhMapper sjglGxhDao;
	@Autowired
	private XtpzBzhzjpzMapper bzhzjpzDao;
	@Autowired
	private XtpzCxfaMapper cxfaDao;
	@Autowired
	private IGreenplumCommonDAO greenplumCommonDAOImpl;

	@Override
	@Cacheable("getXtpzSjyListByExample")
	public List<XtpzSjy> getXtpzSjyListByExample(XtpzSjy sjy) {
		XtpzSjyExample example = new XtpzSjyExample();
		if (sjy.getFlbm() == null || "".equals(sjy.getFlbm())) {
			example.createCriteria().andFlbmEqualTo("0");
		} else {
			example.createCriteria().andFlbmEqualTo(sjy.getFlbm());
		}
		example.setOrderByClause(" sjybm asc ");
		return sjyDao.selectByExample(example);
	}

	@Override
	@Cacheable("getXtpzSjzdListByExample")
	public List<XtpzSjzd> getXtpzSjzdListByExample(XtpzSjzd sjzd) {
		XtpzSjzdExample example = new XtpzSjzdExample();
		if (sjzd.getSjybm() == null || "".equals(sjzd.getSjybm())) {
			example.createCriteria().andSjybmEqualTo("000");
		} else {
			example.createCriteria().andSjybmEqualTo(sjzd.getSjybm());
		}
		example.setOrderByClause(" zdbm asc ");
		return sjzdDao.selectByExample(example);
	}

	@Override
	@Cacheable("getNodeInfoForTree")
	public String getNodeInfoForTree(String nodeId) {
		XtpzSjy sjy = new XtpzSjy();
		Gson gson = new Gson();
		sjy.setFlbm(nodeId);
		List<XtpzSjy> sjyList = this.getXtpzSjyListByExample(sjy);
		List<XtpzSjzd> sjzdList = new ArrayList<XtpzSjzd>();
		if (sjyList.size() > 0) {
			Iterator<XtpzSjy> it = sjyList.iterator();
			while (it.hasNext()) {
				XtpzSjzd sjzd = new XtpzSjzd();
				sjy = it.next();
				sjzd = new XtpzSjzd();
				sjzd.setZdbm(sjy.getSjybm());
				sjzd.setZdmc(sjy.getSjymc());
				sjzd.setPnode(true);
				sjzd.setSjybm(sjy.getFlbm());
				sjzdList.add(sjzd);
			}
			return gson.toJson(sjzdList);
		} else {
			XtpzSjzd sjzd = new XtpzSjzd();
			sjzd = new XtpzSjzd();
			sjzd.setSjybm(nodeId);
			return gson.toJson(this.getXtpzSjzdListByExample(sjzd));
		}
	}

	@Override
	public String getNodeInfoForTree(String nodeId, String operator) {
		XtpzSjy sjy = new XtpzSjy();
		Gson gson = new Gson();
		sjy.setFlbm(nodeId);
		List<XtpzSjy> sjyList = this.getXtpzSjyListByExample(sjy);
		/** 补充个性化拓展的数据域内容 **/
		XtpzSjyGxhExample sjyGxhExample = new XtpzSjyGxhExample();
		sjyGxhExample.createCriteria().andFlbmEqualTo(nodeId).andCzybmEqualTo(operator).andSjymcNotEqualTo("");
		sjyGxhExample.setOrderByClause(" sjybm asc");
		List<XtpzSjyGxh> gxhSjyList = this.sjyGxhDao.selectByExample(sjyGxhExample);
		for (XtpzSjyGxh gxh : gxhSjyList) {
			XtpzSjy tempSjy = new XtpzSjy();
			tempSjy.setSjybm(gxh.getSjybm());
			tempSjy.setSjymc(gxh.getSjymc());
			tempSjy.setFlbm(gxh.getFlbm());
			tempSjy.setBz(gxh.getBz());
			sjyList.add(tempSjy);
		}
		List<XtpzSjzd> sjzdList = new ArrayList<XtpzSjzd>();
		if (sjyList.size() > 0) {
			Iterator<XtpzSjy> it = sjyList.iterator();
			while (it.hasNext()) {
				XtpzSjzd sjzd = new XtpzSjzd();
				sjy = it.next();
				sjzd = new XtpzSjzd();
				sjzd.setZdbm(sjy.getSjybm());
				sjzd.setZdmc(sjy.getSjymc());
				sjzd.setPnode(true);
				sjzd.setSjybm(sjy.getFlbm());
				sjzdList.add(sjzd);
			}

		} else {
			XtpzSjzd sjzd = new XtpzSjzd();
			sjzd = new XtpzSjzd();
			sjzd.setSjybm(nodeId);
			sjzdList = this.getXtpzSjzdListByExample(sjzd);
			/** 补充个性化拓展的数据字典内容 **/
			XtpzSjzdGxhExample sjzdGxhExample = new XtpzSjzdGxhExample();
			sjzdGxhExample.createCriteria().andSjybmEqualTo(nodeId).andCzybmEqualTo(operator);
			sjzdGxhExample.setOrderByClause(" zdbm asc");
			List<XtpzSjzdGxh> sjzdGxhList = sjzdGxhDao.selectByExample(sjzdGxhExample);
			for (XtpzSjzdGxh gxh : sjzdGxhList) {
				XtpzSjzd swap = new XtpzSjzd();
				swap.setZdbm(gxh.getZdbm());
				swap.setSjybm(gxh.getSjybm());
				swap.setZdmc(gxh.getZdmc());
				swap.setYbmc(gxh.getYbmc());
				swap.setYbzd(gxh.getYbzd());
				swap.setSjlx(gxh.getSjlx());
				swap.setJhbz(gxh.getJhbz());
				swap.setXlzdbm(gxh.getXlzdbm());
				sjzdList.add(swap);
			}
			// 补充标准化组件的部分
			if ("888".equals(nodeId)) {
				XtpzBzhzjpzExample sjzdBzhzjpzExample = new XtpzBzhzjpzExample();
				sjzdBzhzjpzExample.createCriteria().andSjybmEqualTo(nodeId);
				sjzdBzhzjpzExample.setOrderByClause(" lsh asc");
				List<XtpzBzhzjpz> bzhzjpzList = bzhzjpzDao.selectByExample(sjzdBzhzjpzExample);
				for (XtpzBzhzjpz bzhzjpz : bzhzjpzList) {
					XtpzSjzd swap = new XtpzSjzd();
					swap.setZdbm(bzhzjpz.getLsh());
					swap.setSjybm(bzhzjpz.getSjybm());
					swap.setZdmc(bzhzjpz.getMc());
					sjzdList.add(swap);
				}
			}
			// 补充查询方案的部分
			if ("9999".equals(nodeId)) {
				XtpzCxfaExample cxfaExample = new XtpzCxfaExample();
				cxfaExample.createCriteria().andSjybmEqualTo(nodeId);
				cxfaExample.setOrderByClause(" lsh asc");
				List<XtpzCxfa> cxfaList = cxfaDao.selectByExample(cxfaExample);
				for (XtpzCxfa cxfa : cxfaList) {
					XtpzSjzd swap = new XtpzSjzd();
					swap.setZdbm(cxfa.getLsh());
					swap.setSjybm(cxfa.getSjybm());
					swap.setZdmc(cxfa.getMc());
					sjzdList.add(swap);
				}
			}
		}
		return gson.toJson(sjzdList);
	}

	@Override
	public String makeUpSelectSQL(ParamsObject object) {
		String selectColumns = "";
		StringBuffer sb = new StringBuffer();
		// 获取读取字段所涉及的相关数据表【经过去重处理】
		String[] tableArray = CommonUtil.TableListDuplicateRemoval(object.getSelectTables());
		// log.info("tableArray:" + new Gson().toJson(tableArray));
		// 获取需要查询的字段内容
		selectColumns = CommonUtil.pickUpSelectedColumns(object.getSelectTables());
		selectColumns = selectColumns.substring(0, selectColumns.length() - 1);
		String fromTablesAndRelation = makeUpFromTablesAndColumnRelation(tableArray);

		if (tableArray.length <= 1) {
			sb.append(selectColumns).append(fromTablesAndRelation);
			if (!"".equals(object.getWhereClause())) {
				sb.append(" WHERE ").append(object.getWhereClause());
			}
		} else {
			sb.append(selectColumns).append(fromTablesAndRelation);
			if (!"".equals(object.getWhereClause())) {
				sb.append(" AND ").append(object.getWhereClause());
			}
		}
		if (object.getGroupFlag() != null && "Y".equals(object.getGroupFlag().trim())
				&& !"".equals(object.getGroupClause())) {
			// 如果分组标识为Y，并且GroupClause不为空（即：统计结果除了聚合字段还有其他字段) 则添加Group By 从句
			sb.append(" GROUP BY ").append(object.getGroupClause());
		}
		if (!"".equals(object.getHavingClause())) {
			sb.append(" HAVING ").append(object.getHavingClause());
		}
		return sb.toString();
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
	public String makeUpSelectSQL(String tableName, ParamsObject object, String operator) {
		String selectColumns = "";
		StringBuffer sb = new StringBuffer();
		// 获取读取字段所涉及的相关数据表【经过去重处理】
		String[] tableArray = CommonUtil.TableListDuplicateRemoval(object.getSelectTables());
		log.info("tableArray:" + new Gson().toJson(tableArray));
		// 获取需要查询的字段内容
		String tableNickName = object.getMyTableName();
		String fromTablesAndRelation = makeUpFromTablesAndColumnRelation(tableArray, operator);
		// 如果fromTablesAndRelation字段为空串，则表示相关节点无法联通，直接返回空串到前台
		if ("".equals(fromTablesAndRelation)) {
			return "";
		}

		// 开始进行相关构造SQL语句的业务处理，包括生成个性化数据域、个性化数据字典、个性化连通图关系等
		selectColumns = this.pickUpSelectedColumns(tableName, tableNickName, object.getSelectTables(), operator);
		selectColumns = selectColumns.substring(0, selectColumns.length() - 1);
		if (tableArray.length <= 1) {
			sb.append(selectColumns).append(fromTablesAndRelation);
			if (!"".equals(object.getWhereClause())) {
				sb.append(" WHERE ").append(object.getWhereClause());
			}
		} else {
			sb.append(selectColumns).append(fromTablesAndRelation);
			if (!"".equals(object.getWhereClause())) {
				sb.append(" AND ").append(object.getWhereClause());
			}
		}
		if (object.getGroupFlag() != null && "Y".equals(object.getGroupFlag().trim())
				&& !"".equals(object.getGroupClause())) {
			// 如果分组标识为Y，并且GroupClause不为空（即：统计结果除了聚合字段还有其他字段) 则添加Group By 从句
			sb.append(" GROUP BY ").append(object.getGroupClause());
		}
		if (!"".equals(object.getHavingClause())) {
			sb.append(" HAVING ").append(object.getHavingClause());
		}
		return sb.toString();
	}

	@Override
	@Cacheable("getNodeInfoForBootstrapTreeviewEntity")
	public BootstrapTreeViewEntity getNodeInfoForBootstrapTreeviewEntity(String nodeId) {
		XtpzSjy result = sjyDao.selectByPrimaryKey(nodeId);
		BootstrapTreeViewEntity entity = new BootstrapTreeViewEntity();
		entity.setText(result.getSjymc());
		entity.setSjybm(result.getSjybm());
		XtpzSjyExample example = new XtpzSjyExample();
		example.createCriteria().andFlbmEqualTo(result.getSjybm());
		example.setOrderByClause(" sjybm asc");
		List<XtpzSjy> sjyList = sjyDao.selectByExample(example);
		for (XtpzSjy temp : sjyList) {
			BootstrapTreeViewEntity m = getNodeInfoForBootstrapTreeviewEntity(temp.getSjybm()); // 递归
			m.setText(temp.getSjymc());
			m.setSjybm(temp.getSjybm());
			// 为每一个节点下挂数据字典中配置的相关统计指标
			List<XtpzSjzd> sjzdList = new ArrayList<XtpzSjzd>();
			XtpzSjzdExample sjzdExample = new XtpzSjzdExample();
			sjzdExample.createCriteria().andSjybmEqualTo(temp.getSjybm());
			sjzdExample.setOrderByClause(" zdbm asc");
			sjzdList = sjzdDao.selectByExample(sjzdExample);
			for (XtpzSjzd sjzd : sjzdList) {
				BootstrapTreeViewEntity mc = new BootstrapTreeViewEntity();
				mc.setText(sjzd.getZdmc());
				mc.setSjybm(sjzd.getSjybm());
				mc.setZdbm(sjzd.getZdbm());
				mc.setZdmc(sjzd.getZdmc());
				mc.setJhbz(sjzd.getJhbz());
				mc.setSjlx(sjzd.getSjlx());
				mc.setYbmc(sjzd.getYbmc());
				mc.setYbzd(sjzd.getYbzd());
				mc.setSjybm(sjzd.getSjybm());
				mc.setXlzdbm(sjzd.getXlzdbm());
				mc.setZjbz(sjzd.getZjbz());
				m.getNodes().add(mc);
			}
			entity.getNodes().add(m);
		}
		return entity;
	}

	@Override
	public BootstrapTreeViewEntity getNodeInfoForBootstrapTreeviewEntity(String nodeId, String operator) {
		XtpzSjy result = greenplumCommonDAOImpl.getXtpzSjyInUnionMode(nodeId, operator, "1").get(0);
		BootstrapTreeViewEntity entity = new BootstrapTreeViewEntity();
		entity.setText(result.getSjymc());
		entity.setSjybm(result.getSjybm());
		List<XtpzSjy> sjyList = greenplumCommonDAOImpl.getXtpzSjyInUnionMode(result.getSjybm(), operator, "2");
		for (XtpzSjy temp : sjyList) {
			BootstrapTreeViewEntity m = getNodeInfoForBootstrapTreeviewEntity(temp.getSjybm(), operator); // 递归
			m.setText(temp.getSjymc());
			m.setSjybm(temp.getSjybm());
			// 为每一个节点下挂数据字典中配置的相关统计指标
			List<XtpzSjzd> sjzdList = new ArrayList<XtpzSjzd>();
			sjzdList = greenplumCommonDAOImpl.getXtpzSjzdInUnionMode(temp.getSjybm(), operator, "1");
			for (XtpzSjzd sjzd : sjzdList) {
				BootstrapTreeViewEntity mc = new BootstrapTreeViewEntity();
				mc.setText(sjzd.getZdmc());
				mc.setSjybm(sjzd.getSjybm());
				mc.setZdbm(sjzd.getZdbm());
				mc.setZdmc(sjzd.getZdmc());
				mc.setJhbz(sjzd.getJhbz());
				mc.setSjlx(sjzd.getSjlx());
				mc.setYbmc(sjzd.getYbmc());
				mc.setYbzd(sjzd.getYbzd());
				mc.setSjybm(sjzd.getSjybm());
				mc.setXlzdbm(sjzd.getXlzdbm());
				mc.setZjbz(sjzd.getZjbz());
				m.getNodes().add(mc);
			}
			entity.getNodes().add(m);
		}
		return entity;
	}

	@Override
	public String createTableAsSelectSQL(String sql) {
		String tableName = greenplumCommonDAOImpl.createTableAsSelectSQL(sql);
		return tableName;
	}

	public void createTableAsSelectSQL(String tableName, String sql) {
		greenplumCommonDAOImpl.createTableAsSelectSQL(tableName, sql);
	}

	@Override
	@Cacheable("getDataForBootstrapDataTable")
	public Map<String, Object> getDataForBootstrapDataTable(String tableName, String columns, String condition,
			String orderByColumn, String orderByMode, String limit, String offset) {
		Map<String, Object> map = new HashMap<String, Object>();
		long rowcount = greenplumCommonDAOImpl.getTableRowcountByCondition(tableName, condition);
		List<Map<String, Object>> list = greenplumCommonDAOImpl.getTableDataByConditionTransforColumns(tableName,
				columns, condition, orderByColumn, orderByMode, limit, offset);
		map.put("total", rowcount);
		map.put("rows", list);
		return map;
	}

	@Cacheable("getDataForBootstrapDataTable")
	public Map<String, Object> getDataForBootstrapDataTable(String tableName, String columns, String condition,
			String orderByColumn, String orderByMode, String limit, String offset, String operator) {
		Map<String, Object> map = new HashMap<String, Object>();
		long rowcount = greenplumCommonDAOImpl.getTableRowcountByCondition(tableName, condition);
		List<Map<String, Object>> list = greenplumCommonDAOImpl.getTableDataByConditionTransforColumns(tableName,
				columns, condition, orderByColumn, orderByMode, limit, offset, operator);
		map.put("total", rowcount);
		map.put("rows", list);
		return map;
	}

	@Override
	@Cacheable("getTableColumnNameAndDescription")
	public List<Map<String, Object>> getTableColumnNameAndDescription(String tableName) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = greenplumCommonDAOImpl.getTableColumnNameAndDescription(tableName);
		return list;
	}

	@Override
	@Cacheable("getTableColumnNameAndDescription")
	public List<Map<String, Object>> getTableColumnNameAndDescription(String tableName, String operator) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = greenplumCommonDAOImpl.getTableColumnNameAndDescription(tableName, operator);
		return list;
	}

	@Override
	public String makeUpFromTablesAndColumnRelation(String[] tablesArray) {
		StringBuffer sb = new StringBuffer();
		// 如果只涉及一张表，直接返回
		if (tablesArray.length == 1) {
			return sb.append(" FROM ").append(tablesArray[0]).toString();
		}
		// 获取所有数据表的网络连通图
		HashMap<String, HashMap<String, Integer>> stepLength = new HashMap<String, HashMap<String, Integer>>();
		stepLength = getAllConnectedGraphBySjzd();
		// 在关系图中获取连接所有查询统计所需数据表的最佳路径
		List<String> road = CommonUtil.findOutTheBestRoadForTheArray(tablesArray, stepLength);
		String[] roadArray = new String[road.size()];
		boolean firstFlag = true;
		road.toArray(roadArray);

		// 将关系图中的线路节点进行去重处理后，作为SQL语句中FROM子句的数据表来源
		String tablesNameList = Arrays.toString(CommonUtil.StringArrayDuplicateRemoval(roadArray));
		tablesNameList = tablesNameList.substring(1, tablesNameList.length() - 1);
		sb.append(" FROM ").append(tablesNameList).append(" WHERE ");
		int size = roadArray.length;
		for (int i = 0; i < size - 1; i++) {
			String a = roadArray[i], b = roadArray[i + 1];
			XtpzSjglysExample example = new XtpzSjglysExample();
			example.createCriteria().andYbmcaEqualTo(a).andYbmcbEqualTo(b);
			example.setOrderByClause(" ybmca asc");
			List<XtpzSjglys> list = sjglDao.selectByExample(example);
			Iterator<XtpzSjglys> it = list.iterator();
			while (it.hasNext()) {
				XtpzSjglys sjgl = it.next();
				if (firstFlag) {
					sb.append(sjgl.getYbzda()).append(" = ").append(sjgl.getYbzdb());
					firstFlag = false;
				} else {
					sb.append(" AND ").append(sjgl.getYbzda()).append(" = ").append(sjgl.getYbzdb());
				}
			}
		}
		return sb.toString();
	}

	@Override
	public String makeUpFromTablesAndColumnRelation(String[] tablesArray, String operator) {
		StringBuffer sb = new StringBuffer();
		// 如果只涉及一张表，直接返回
		if (tablesArray.length == 1) {
			return sb.append(" FROM ").append(tablesArray[0]).toString();
		}
		// 获取所有数据表的网络连通图
		HashMap<String, HashMap<String, Integer>> stepLength = new HashMap<String, HashMap<String, Integer>>();
		stepLength = getAllConnectedGraphBySjzd(operator);
		// 在关系图中获取连接所有查询统计所需数据表的最佳路径
		List<String> road = CommonUtil.findOutTheBestRoadForTheArray(tablesArray, stepLength);
		String[] roadArray = new String[road.size()];
		boolean firstFlag = true;
		road.toArray(roadArray);
		// 如果联通数组为空，则证明相关节点无法正常联通，直接返回
		if (roadArray.length == 0) {
			return "";
		}

		// 将关系图中的线路节点进行去重处理后，作为SQL语句中FROM子句的数据表来源
		String tablesNameList = Arrays.toString(CommonUtil.StringArrayDuplicateRemoval(roadArray));
		tablesNameList = tablesNameList.substring(1, tablesNameList.length() - 1);
		sb.append(" FROM ").append(tablesNameList).append(" WHERE ");
		int size = roadArray.length;
		for (int i = 0; i < size - 1; i++) {
			String a = roadArray[i], b = roadArray[i + 1];
			XtpzSjglysExample example = new XtpzSjglysExample();
			example.createCriteria().andYbmcaEqualTo(a).andYbmcbEqualTo(b);
			example.setOrderByClause(" ybmca asc");
			List<XtpzSjglys> list = sjglDao.selectByExample(example);
			// 补充个性化关联关系的部分
			XtpzSjglysGxhExample exampleGxh = new XtpzSjglysGxhExample();
			exampleGxh.createCriteria().andYbmcaEqualTo(a).andYbmcbEqualTo(b).andCzybmEqualTo(operator);
			exampleGxh.setOrderByClause(" ybmca asc");
			List<XtpzSjglysGxh> listGxh = sjglGxhDao.selectByExample(exampleGxh);
			for (XtpzSjglysGxh gxh : listGxh) {
				XtpzSjglys sjgl = new XtpzSjglys();
				sjgl.setLsh(gxh.getLsh());
				sjgl.setYbmca(gxh.getYbmca());
				sjgl.setYbzda(gxh.getYbzda());
				sjgl.setYbmcb(gxh.getYbmcb());
				sjgl.setYbzdb(gxh.getYbzdb());
				list.add(sjgl);
			}
			Iterator<XtpzSjglys> it = list.iterator();
			while (it.hasNext()) {
				XtpzSjglys sjgl = it.next();
				if (firstFlag) {
					sb.append(sjgl.getYbzda()).append(" = ").append(sjgl.getYbzdb());
					firstFlag = false;
				} else {
					sb.append(" AND ").append(sjgl.getYbzda()).append(" = ").append(sjgl.getYbzdb());
				}
			}
		}
		return sb.toString();
	}

	@Override
	@Cacheable("getAllConnectedGraphBySjzd")
	public HashMap<String, HashMap<String, Integer>> getAllConnectedGraphBySjzd() {
		HashMap<String, HashMap<String, Integer>> stepLength = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> step = new HashMap<String, Integer>();
		XtpzSjglysExample example = new XtpzSjglysExample();
		example.setOrderByClause(" ybmca asc ");
		List<XtpzSjglys> list = new ArrayList<XtpzSjglys>();
		list = sjglDao.selectByExample(example);
		String last = "", current = "";
		for (int i = 0; i < list.size(); i++) {
			String a = list.get(i).getYbmca();
			current = a;
			String b = list.get(i).getYbmcb();
			if (!last.equals(current)) {
				if ("".equals(last)) {
					stepLength.put(current, step);
				} else {
					step = new HashMap<String, Integer>();
					stepLength.put(current, step);
				}
			}
			step.put(b, 1);
			last = current;
		}
		return stepLength;
	}

	@Cacheable("getAllConnectedGraphBySjzd")
	public HashMap<String, HashMap<String, Integer>> getAllConnectedGraphBySjzd(String operator) {
		HashMap<String, HashMap<String, Integer>> stepLength = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> step = new HashMap<String, Integer>();
		List<XtpzSjglys> list = new ArrayList<XtpzSjglys>();
		list = greenplumCommonDAOImpl.getXtpzSjglysInUnionMode(operator);
		String last = "", current = "";
		for (int i = 0; i < list.size(); i++) {
			String a = list.get(i).getYbmca();
			current = a;
			String b = list.get(i).getYbmcb();
			if (!last.equals(current)) {
				if ("".equals(last)) {
					stepLength.put(current, step);
				} else {
					step = new HashMap<String, Integer>();
					stepLength.put(current, step);
				}
			}
			step.put(b, 1);
			last = current;
		}
		return stepLength;
	}

	@Override
	@Cacheable("getXtpzXlcsListByZdbm")
	public List<XtpzXlcs> getXtpzXlcsListByZdbm(String zdbm) {
		XtpzXlcsExample example = new XtpzXlcsExample();
		example.createCriteria().andZdbmEqualTo(zdbm);
		example.setOrderByClause(" lsh asc ");
		List<XtpzXlcs> list = xlcsDao.selectByExample(example);
		int listSize = list.size();
		for (int i = 0; i < listSize; i++) {
			XtpzXlcs swap = list.get(i);
			if ("Y".equals(swap.getTzbz())) {
				List<XtpzXlcstz> tzList = new ArrayList<XtpzXlcstz>();
				XtpzXlcstz xlcsTz = new XtpzXlcstz();
				xlcsTz.setZblsh(swap.getLsh());
				tzList = getXtpzXlcstzListByExample(xlcsTz);
				Iterator<XtpzXlcstz> it = tzList.iterator();
				String sjz = "";
				while (it.hasNext()) {
					xlcsTz = it.next();
					sjz += xlcsTz.getSjz() + ",";
				}
				sjz = sjz.substring(0, sjz.length() - 1);
				list.get(i).setSjz(sjz);
			}
		}
		return list;
	}

	@Override
	@Cacheable("getXtpzXlcstzListByExample")
	public List<XtpzXlcstz> getXtpzXlcstzListByExample(XtpzXlcstz xlcstz) {
		XtpzXlcstzExample example = new XtpzXlcstzExample();
		example.createCriteria().andZblshEqualTo(xlcstz.getZblsh());
		example.setOrderByClause(" lsh asc ");
		return xlcstzDao.selectByExample(example);
	}

	@Override
	public List<List<Map<String, Object>>> getDataForBootstrapDataTableToExport(String tableName, String columns,
			String condition, String orderByColumn, String orderByMode, String limit, String offset) {
		List<List<Map<String, Object>>> list = greenplumCommonDAOImpl.getTableDataByConditionTransforColumnsSorted(
				tableName, columns, condition, orderByColumn, orderByMode, limit, offset);
		return list;
	}

	@Override
	public List<List<Map<String, Object>>> getDataForBootstrapDataTableToExport(String tableName, String columns,
			String condition, String orderByColumn, String orderByMode, String limit, String offset, String operator) {
		List<List<Map<String, Object>>> list = greenplumCommonDAOImpl.getTableDataByConditionTransforColumnsSorted(
				tableName, columns, condition, orderByColumn, orderByMode, limit, offset, operator);
		return list;
	}

	@Override
	@Cacheable("getTotoalRowcountByTableName")
	public long getTotoalRowcountByTableName(String tableName) {
		return greenplumCommonDAOImpl.getTableRowcountByCondition(tableName, "");
	}

	@Override
	public void insertPersonalGridInfo(String operator, String tableName, List<Map<String, Object>> resultMeta) {
		IdWorker id = new IdWorker(2);
		Iterator<Map<String, Object>> it = resultMeta.iterator();
		// 自定义结果集在挂载到联通图上的时候，优先挂载到具有关联关系的自定义表上。xu_xz 2018-07-06
		// 要挂载的关联数据表名
		boolean continueFlag = true;
		String ybzd = "";
		while (it.hasNext()) {
			Map<String, Object> map = it.next();
			for (Entry<String, Object> entry : map.entrySet()) {
				if ("field".equals(entry.getKey())) {
					ybzd = entry.getValue().toString();
					XtpzSjzdGxhExample sjzdGxhExample = new XtpzSjzdGxhExample();
					sjzdGxhExample.createCriteria().andYbzdEqualTo(ybzd).andCzybmEqualTo(operator);
					// 从自定义
					if (sjzdGxhDao.selectByExample(sjzdGxhExample).size() > 0) {
						continueFlag = false;
					}
				}
				if (!continueFlag) {
					break;
				}
			}
			if (!continueFlag) {
				break;
			}
		}
		// 写入自定义关系网络
		// ybzd = ybzd.replaceAll("\"", "\"\"");
		XtpzSjglysGxh mySjglys = new XtpzSjglysGxh();
		mySjglys.setLsh(String.valueOf(id.nextId()));
		mySjglys.setYbmca(tableName);
		mySjglys.setYbzda(tableName + ".\"" + ybzd + "\"");
		mySjglys.setYbmcb(ybzd.substring(0, ybzd.indexOf(".")));
		mySjglys.setYbzdb(ybzd);
		mySjglys.setCzybm(operator);
		sjglGxhDao.insert(mySjglys);
		mySjglys = new XtpzSjglysGxh();
		mySjglys.setLsh(String.valueOf(id.nextId()));
		mySjglys.setYbmcb(tableName);
		mySjglys.setYbzdb(tableName + ".\"" + ybzd + "\"");
		mySjglys.setYbmca(ybzd.substring(0, ybzd.indexOf(".")));
		mySjglys.setYbzda(ybzd);
		mySjglys.setCzybm(operator);
		sjglGxhDao.insert(mySjglys);
	}

	@Override
	public void insertAutoGenerateTableInfo(String tableName, String tableNickName, String operator, String status) {
		XtpzTableGxh tableGxh = new XtpzTableGxh();
		IdWorker id = new IdWorker(2);
		tableGxh.setLsh(String.valueOf(id.nextId()));
		tableGxh.setCzybm(operator);
		tableGxh.setMc(tableName);
		tableGxh.setBm(tableNickName);
		tableGxh.setScsj(new Date(System.currentTimeMillis()));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = df.parse("2099-12-31 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		long time = cal.getTimeInMillis();
		tableGxh.setSxsj(new Date(time));
		tableGxh.setZt(status);
		tablegxhDao.insert(tableGxh);
	}

	@Override
	public void insertPersonalDirectory(String operator, String tableName, String tableNickName,
			List<Map<String, Object>> resultMeta) {
		IdWorker id = new IdWorker(2);
		String sjybm = insertPersonalDomain(operator, tableNickName);
		resultMeta.forEach(item -> {
			for (Entry<String, Object> entry : item.entrySet()) {
				if ("field".equals(entry.getKey())) {
					XtpzSjzd sjzd = this.greenplumCommonDAOImpl
							.getXtpzSjzdInUnionMode(entry.getValue().toString(), operator, "2").get(0);
					XtpzSjzdGxh gxhSjzd = new XtpzSjzdGxh();
					gxhSjzd.setZdbm(String.valueOf(id.nextId()));
					// 个性化数据域
					gxhSjzd.setSjybm(sjybm);
					gxhSjzd.setZdmc(sjzd.getZdmc());
					gxhSjzd.setYbmc(tableName);
					gxhSjzd.setYbzd(tableName + ".\"" + entry.getValue().toString().replaceAll("\"", "\"\"") + "\"");
					gxhSjzd.setSjlx(sjzd.getSjlx());
					gxhSjzd.setJhbz("N");
					gxhSjzd.setCzybm(operator);
					gxhSjzd.setXlzdbm(sjzd.getXlzdbm());
					sjzdGxhDao.insert(gxhSjzd);
				}
			}
		});
	}

	@Override
	public String insertPersonalDomain(String operator, String tableNickName) {
		IdWorker id = new IdWorker(2);
		XtpzSjyGxh mySjy = new XtpzSjyGxh();
		String sjybm = String.valueOf(id.nextId());
		mySjy.setSjybm(sjybm);
		mySjy.setSjymc(tableNickName);
		mySjy.setFlbm("999");
		mySjy.setCzybm(operator);
		sjyGxhDao.insert(mySjy);
		return sjybm;
	}

	@Override
	public void insertTablsRelationToGrid(String tableA, String columnA, String tableB, String columnB, String type) {
		// TODO Auto-generated method stub

	}

	@Override
	public String pickUpSelectedColumns(String tableName, String tableNickName, List<XtpzSjzd> list, String operator) {
		int j = list.size();
		StringBuffer sb = new StringBuffer();
		// 生成个性化数据域信息
		String sjybm = insertPersonalDomain(operator, tableNickName);
		IdWorker id = new IdWorker(2);
		String ybzd = "", glbm = "", glzd = "", zjbz = "N";
		boolean continueFind = true;
		sb.append("SELECT DISTINCT ");
		for (int i = 0; i < j; i++) {
			/** 源表字段非空的情况下才放到SELECT字段列表，因为部分因Where条件拓展引入的数据表只有表名称、无字段，并且是不需要字段展示的，需要排除掉 */
			if (null != list.get(i).getYbzd() && !"".equals(list.get(i).getYbzd())) {
				sb.append(list.get(i).getYbzd()).append(" AS ").append("C" + i).append(",");

				// 主键标志
				zjbz = list.get(i).getZjbz();
				// 如果该字段是主键字段，并且是来源于自定义数据表内容，则直接挂载到该数据表上，不用再继续考虑是否挂载其他表上
				if ("Y".equals(zjbz) && continueFind) {
					glbm = list.get(i).getYbmc();
					glzd = list.get(i).getYbzd();
					ybzd = "C" + i;
					XtpzSjzdGxhExample sjzdGxhExample = new XtpzSjzdGxhExample();
					sjzdGxhExample.createCriteria().andYbzdEqualTo(glzd).andCzybmEqualTo(operator);
					// 如果该字段属于个性化数据字典，则优先挂载到个性化数据字典的字段中
					if (sjzdGxhDao.selectByExample(sjzdGxhExample).size() > 0) {
						continueFind = false;
					}
				}

				// 生成个性化数据字典信息
				XtpzSjzd sjzd = this.greenplumCommonDAOImpl.getXtpzSjzdInUnionMode(list.get(i).getYbzd(), operator, "2")
						.get(0);
				XtpzSjzdGxh gxhSjzd = new XtpzSjzdGxh();
				gxhSjzd.setZdbm(String.valueOf(id.nextId()));
				// 个性化数据域
				gxhSjzd.setSjybm(sjybm);
				gxhSjzd.setZdmc(sjzd.getZdmc());
				gxhSjzd.setYbmc(tableName);
				gxhSjzd.setYbzd(tableName + ".C" + i);
				gxhSjzd.setSjlx(sjzd.getSjlx());
				gxhSjzd.setJhbz("N");
				gxhSjzd.setCzybm(operator);
				gxhSjzd.setXlzdbm(sjzd.getXlzdbm());
				gxhSjzd.setZjbz(sjzd.getZjbz());
				sjzdGxhDao.insert(gxhSjzd);
			}
		}
		// 写入自定义关系网络
		// 如果当前的结果集不包含主键，则不将结果挂载到连通图中，因为没有主键的数据无法准确支撑二次分析，失去了挂载到连通图的意义
		if (!"".equals(glbm) && !"".equals(glzd)) {
			XtpzSjglysGxh mySjglys = new XtpzSjglysGxh();
			mySjglys.setLsh(String.valueOf(id.nextId()));
			mySjglys.setYbmca(tableName);
			mySjglys.setYbzda(tableName + "." + ybzd);
			mySjglys.setYbmcb(glbm);
			mySjglys.setYbzdb(glzd);
			mySjglys.setCzybm(operator);
			sjglGxhDao.insert(mySjglys);
			mySjglys = new XtpzSjglysGxh();
			mySjglys.setLsh(String.valueOf(id.nextId()));
			mySjglys.setYbmcb(tableName);
			mySjglys.setYbzdb(tableName + "." + ybzd);
			mySjglys.setYbmca(glbm);
			mySjglys.setYbzda(glzd);
			mySjglys.setCzybm(operator);
			sjglGxhDao.insert(mySjglys);
		}
		return sb.toString();
	}

}
