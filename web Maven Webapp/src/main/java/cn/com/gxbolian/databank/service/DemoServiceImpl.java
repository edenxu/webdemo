package cn.com.gxbolian.databank.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import cn.com.gxbolian.databank.dao.IGreenplumCommonDAO;
import cn.com.gxbolian.databank.dao.XtpzSjglysMapper;
import cn.com.gxbolian.databank.dao.XtpzSjyMapper;
import cn.com.gxbolian.databank.dao.XtpzSjzdMapper;
import cn.com.gxbolian.databank.dao.XtpzXlcsMapper;
import cn.com.gxbolian.databank.dao.XtpzXlcstzMapper;
import cn.com.gxbolian.databank.entity.BootstrapTreeViewEntity;
import cn.com.gxbolian.databank.entity.ParamsObject;
import cn.com.gxbolian.databank.entity.XtpzSjglys;
import cn.com.gxbolian.databank.entity.XtpzSjglysExample;
import cn.com.gxbolian.databank.entity.XtpzSjy;
import cn.com.gxbolian.databank.entity.XtpzSjyExample;
import cn.com.gxbolian.databank.entity.XtpzSjzd;
import cn.com.gxbolian.databank.entity.XtpzSjzdExample;
import cn.com.gxbolian.databank.entity.XtpzXlcs;
import cn.com.gxbolian.databank.entity.XtpzXlcsExample;
import cn.com.gxbolian.databank.entity.XtpzXlcstz;
import cn.com.gxbolian.databank.entity.XtpzXlcstzExample;
import cn.com.gxbolian.databank.util.CommonUtil;

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
	private IGreenplumCommonDAO greenplumCommonDAOImpl;

	@Override
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
	public String makeUpSelectSQL(ParamsObject object) {
		String selectColumns = "";
		StringBuffer sb = new StringBuffer();
		// 获取读取字段所涉及的相关数据表【经过去重处理】
		String[] tableArray = CommonUtil.TableListDuplicateRemoval(object.getSelectTables());
		log.info("tableArray:" + new Gson().toJson(tableArray));
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
		if (object.getGroupFlag() != null && "Y".equals(object.getGroupFlag().trim())) {
			sb.append(" GROUP BY ").append(object.getGroupClause());
		}
		if (!"".equals(object.getHavingClause())) {
			sb.append(" HAVING ").append(object.getHavingClause());
		}
		return sb.toString();
	}

	@Override
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

	@Override
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

	@Override
	public List<Map<String, Object>> getTableColumnNameAndDescription(String tableName) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list = greenplumCommonDAOImpl.getTableColumnNameAndDescription(tableName);
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

	@Override
	public List<XtpzXlcs> getXtpzXlcsListByExample(XtpzXlcs xlcs) {
		XtpzXlcsExample example = new XtpzXlcsExample();
		example.createCriteria().andZdbmEqualTo(xlcs.getZdbm());
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
	public List<XtpzXlcstz> getXtpzXlcstzListByExample(XtpzXlcstz xlcstz) {
		XtpzXlcstzExample example = new XtpzXlcstzExample();
		example.createCriteria().andZblshEqualTo(xlcstz.getZblsh());
		example.setOrderByClause(" lsh asc ");
		return xlcstzDao.selectByExample(example);
	}

}
