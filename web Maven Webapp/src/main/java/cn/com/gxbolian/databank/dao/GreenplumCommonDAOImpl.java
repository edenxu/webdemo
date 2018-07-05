package cn.com.gxbolian.databank.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Repository;

import cn.com.gxbolian.databank.entity.XtpzSjy;
import cn.com.gxbolian.databank.entity.XtpzSjzd;
import cn.com.gxbolian.databank.entity.XtpzSjzdExample;
import cn.com.gxbolian.databank.entity.XtpzSjzdGxh;
import cn.com.gxbolian.databank.entity.XtpzSjzdGxhExample;
import cn.com.gxbolian.databank.entity.XtpzXlcs;
import cn.com.gxbolian.databank.entity.XtpzXlcsExample;
import cn.com.gxbolian.databank.util.IdWorker;

@Repository
public class GreenplumCommonDAOImpl implements IGreenplumCommonDAO {
	protected final Logger log = LogManager.getLogger(GreenplumCommonDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private XtpzSjzdMapper sjzdDao;
	@Autowired
	private XtpzSjzdGxhMapper sjzdGxhDao;
	@Autowired
	private XtpzXlcsMapper xlcsDao;

	@Override
	public String createTableAsSelectSQL(String sql) {
		IdWorker worker = new IdWorker(2);
		String pre = "AUTO_" + String.valueOf(worker.nextId());
		String executeSql = "CREATE TABLE " + pre + " AS " + sql;
		this.jdbcTemplate.update(executeSql);
		return pre;
	}

	@Override
	public long getTableRowcountByCondition(String tableName, String condition) {
		String sql = "SELECT COUNT(1) FROM " + tableName + " ";
		if (!"".equals(condition)) {
			sql += condition;
		}
		return this.jdbcTemplate.queryForObject(sql, long.class);
	}

	@Override
	public List<Map<String, Object>> getTableDataByCondition(String tableName, String columns, String condition,
			String orderByColumn, String orderByMode, String limit, String offset) {
		String selectColumns = "";
		if ("".equals(columns)) {
			selectColumns = "*";
		}
		String sql = "SELECT " + selectColumns + " FROM " + tableName;
		if (!"".equals(condition)) {
			sql += condition;
		}
		String orderColumn = "".equals(orderByColumn) ? "1" : orderByColumn;
		String orderMode = "".equals(orderByMode) ? "asc" : orderByMode;
		// 根据第一个字段排序，主要为了解决每次返回的数据次序不一致的问题
		if ("1".equals(orderColumn)) {
			sql += " order by " + orderColumn + " " + orderMode + " limit " + limit + " offset " + offset;
		} else {
			sql += " order by \"" + orderColumn + "\" " + orderMode + " limit " + limit + " offset " + offset;
		}
		// log.info("sql:" + sql);
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		SqlRowSetMetaData sqlRsmd = rowSet.getMetaData();
		int columnNum = sqlRsmd.getColumnCount();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		while (rowSet.next()) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			for (int i = 1; i <= columnNum; i++) {
				dataMap.put(sqlRsmd.getColumnName(i), rowSet.getObject(i));
			}
			result.add(dataMap);
		}
		return result;
	}

	@Override
	public void dropTemporaryTable(String tableName) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Map<String, Object>> getTableColumnNameAndDescription(String tableName) {
		String sql = "select * from " + tableName + " limit 0";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		SqlRowSetMetaData sqlRsmd = rowSet.getMetaData();
		int columnNum = sqlRsmd.getColumnCount();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (int i = 1; i <= columnNum; i++) {
			String columnName = sqlRsmd.getColumnName(i);
			XtpzSjzdExample example = new XtpzSjzdExample();
			example.createCriteria().andYbzdEqualTo(columnName);
			List<XtpzSjzd> list = sjzdDao.selectByExample(example);
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("field", columnName);
			temp.put("title", list.get(0).getZdmc());
			result.add(temp);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getTableColumnNameAndDescription(String tableName, String operator) {
		String sql = "select * from " + tableName + " limit 0";
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		SqlRowSetMetaData sqlRsmd = rowSet.getMetaData();
		int columnNum = sqlRsmd.getColumnCount();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for (int i = 1; i <= columnNum; i++) {
			String columnName = sqlRsmd.getColumnName(i);
			List<XtpzSjzd> list = this.getXtpzSjzdInUnionMode(columnName, operator, "2");
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("field", columnName);
			temp.put("title", list.get(0).getZdmc());
			result.add(temp);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getTableDataByConditionTransforColumns(String tableName, String columns,
			String condition, String orderByColumn, String orderByMode, String limit, String offset) {
		String selectColumns = "";
		if ("".equals(columns)) {
			selectColumns = "*";
		}
		String sql = "SELECT " + selectColumns + " FROM " + tableName;
		if (!"".equals(condition)) {
			sql += condition;
		}

		// 排序字段
		String orderColumn = "".equals(orderByColumn) ? "1" : orderByColumn;
		// 排序方式
		String orderMode = "".equals(orderByMode) ? "asc" : orderByMode;
		// 如果没有指定排序字段，则默认用结果集的第一个字段作为升序排序字段依据【解决GP每次合并查询结果后返回的数据次序不一致的问题】
		if ("1".equals(orderColumn)) {
			sql += " order by " + orderColumn + " " + orderMode + " limit " + limit + " offset " + offset;
		} else {
			sql += " order by \"" + orderColumn + "\" " + orderMode + " limit " + limit + " offset " + offset;
		}
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		SqlRowSetMetaData sqlRsmd = rowSet.getMetaData();
		int columnNum = sqlRsmd.getColumnCount();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		// 获取当前数据结果集的字段列表
		List<String> columnList = new ArrayList<String>();
		for (int i = 1; i <= columnNum; i++) {
			columnList.add(sqlRsmd.getColumnName(i).replaceAll("\"", "\"\""));
		}
		/**
		 * 找出当前数据集相关字段中所有涉及下拉的字段 并对字段中的值进行下拉显示值的转换
		 */
		// 获取当前数据集中各个字段在数据字典中的配置
		XtpzSjzdExample sjzdExample = new XtpzSjzdExample();
		sjzdExample.createCriteria().andYbzdIn(columnList);
		sjzdExample.setOrderByClause(" zdbm asc");
		List<XtpzSjzd> sjzdList = sjzdDao.selectByExample(sjzdExample);
		Iterator<XtpzSjzd> sjzdIt = sjzdList.iterator();
		// 存储每个字段的字段编码及源表字段的关系
		Map<String, String> relaMap = new HashMap<String, String>();
		columnList.clear();
		while (sjzdIt.hasNext()) {
			XtpzSjzd sjzd = sjzdIt.next();
			// 将下拉参数和源表字段的关联性保存起来，后面处理字段显示值需要用到
			relaMap.put(sjzd.getBz(), sjzd.getYbzd());
			columnList.add(sjzd.getBz().replaceAll("\"", "\"\""));
		}
		XtpzXlcsExample xlcsExample = new XtpzXlcsExample();
		xlcsExample.createCriteria().andZdbmIn(columnList);
		xlcsExample.setOrderByClause(" zdbm asc");
		List<XtpzXlcs> xlcsList = xlcsDao.selectByExample(xlcsExample);
		Iterator<XtpzXlcs> xlcsIt = xlcsList.iterator();
		String lastZd = "", currentZd = "";
		// 将结果以Map的方式存储，例如:{"YXSCDB.KH_YDKH":{"10":"大用户","20":"中小用户"}}
		Map<String, Map<String, String>> transMap = new HashMap<String, Map<String, String>>();
		Map<String, String> temp = null;
		while (xlcsIt.hasNext()) {
			XtpzXlcs xlcs = xlcsIt.next();
			// 当前结果提取的是字段编码
			currentZd = xlcs.getZdbm();
			if (!currentZd.equals(lastZd)) {
				if (!"".equals(lastZd)) {
					// 实际存储的是字段编码对应的源表来源字段【与当前数据集的字段名一致】
					transMap.put(relaMap.get(lastZd), temp);
				}
				temp = new HashMap<String, String>();
				temp.put(xlcs.getSjz(), xlcs.getXsz());
			} else {
				temp.put(xlcs.getSjz(), xlcs.getXsz());
			}
			lastZd = currentZd;
		}
		// 实际存储的是字段编码对应的源表来源字段【与当前数据集的字段名一致】
		// 只有存在有字段存在下拉菜单映射的情况下才需要插入
		if (xlcsList.size() > 0) {
			transMap.put(relaMap.get(currentZd), temp);
		}

		for (Entry<String, Map<String, String>> key : transMap.entrySet()) {
			log.info("key:" + key);
		}
		/** 查询结果集数据处理并返回 */
		while (rowSet.next()) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			for (int i = 1; i <= columnNum; i++) {
				String columnName = sqlRsmd.getColumnName(i);
				// 如果该字段存在下拉映射值，则将Value替换为下拉映射的显示值
				if (transMap.containsKey(columnName)) {
					Map<String, String> valuesMap = new HashMap<String, String>();
					valuesMap = transMap.get(columnName);
					log.info(valuesMap.toString());
					dataMap.put(columnName, valuesMap.get(rowSet.getObject(i)));
				} else {
					dataMap.put(columnName, rowSet.getObject(i));
				}
			}
			result.add(dataMap);
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getTableDataByConditionTransforColumns(String tableName, String columns,
			String condition, String orderByColumn, String orderByMode, String limit, String offset, String operator) {
		String selectColumns = "";
		if ("".equals(columns)) {
			selectColumns = "*";
		}
		String sql = "SELECT " + selectColumns + " FROM " + tableName;
		if (!"".equals(condition)) {
			sql += condition;
		}

		// 排序字段
		String orderColumn = "".equals(orderByColumn) ? "1" : orderByColumn;
		// 排序方式
		String orderMode = "".equals(orderByMode) ? "asc" : orderByMode;
		// 如果没有指定排序字段，则默认用结果集的第一个字段作为升序排序字段依据【解决GP每次合并查询结果后返回的数据次序不一致的问题】
		if ("1".equals(orderColumn)) {
			sql += " order by " + orderColumn + " " + orderMode + " limit " + limit + " offset " + offset;
		} else {
			sql += " order by \"" + orderColumn + "\" " + orderMode + " limit " + limit + " offset " + offset;
		}
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		SqlRowSetMetaData sqlRsmd = rowSet.getMetaData();
		int columnNum = sqlRsmd.getColumnCount();
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		// 获取当前数据结果集的字段列表
		List<String> columnList = new ArrayList<String>();
		for (int i = 1; i <= columnNum; i++) {
			columnList.add(sqlRsmd.getColumnName(i));
		}
		/**
		 * 找出当前数据集相关字段中所有涉及下拉的字段 并对字段中的值进行下拉显示值的转换
		 */
		// 获取当前数据集中各个字段在数据字典中的配置
		XtpzSjzdExample sjzdExample = new XtpzSjzdExample();
		sjzdExample.createCriteria().andYbzdIn(columnList);
		sjzdExample.setOrderByClause(" zdbm asc");
		List<XtpzSjzd> sjzdList = sjzdDao.selectByExample(sjzdExample);
		/** 补充个性化拓展的数据字典内容 **/
		XtpzSjzdGxhExample sjzdGxhExample = new XtpzSjzdGxhExample();
		sjzdGxhExample.createCriteria().andYbzdIn(columnList).andCzybmEqualTo(operator);
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
			swap.setBz(gxh.getBz());
			sjzdList.add(swap);
		}

		Iterator<XtpzSjzd> sjzdIt = sjzdList.iterator();
		// 存储每个字段的字段编码及源表字段的关系
		Map<String, String> relaMap = new HashMap<String, String>();
		columnList.clear();
		while (sjzdIt.hasNext()) {
			XtpzSjzd sjzd = sjzdIt.next();
			// 将下拉参数和源表字段的关联性保存起来，后面处理字段显示值需要用到
			relaMap.put(sjzd.getBz(), sjzd.getYbzd());
			columnList.add(sjzd.getBz());
		}

		// 找到数据集中所有字段的下拉参数值的信息
		XtpzXlcsExample xlcsExample = new XtpzXlcsExample();
		xlcsExample.createCriteria().andZdbmIn(columnList);
		xlcsExample.setOrderByClause(" zdbm asc");
		List<XtpzXlcs> xlcsList = xlcsDao.selectByExample(xlcsExample);
		Iterator<XtpzXlcs> xlcsIt = xlcsList.iterator();
		String lastZd = "", currentZd = "";
		// 将结果以Map的方式存储，例如:{"YXSCDB.KH_YDKH":{"10":"大用户","20":"中小用户"}}
		Map<String, Map<String, String>> transMap = new HashMap<String, Map<String, String>>();
		Map<String, String> temp = null;
		while (xlcsIt.hasNext()) {
			XtpzXlcs xlcs = xlcsIt.next();
			// 当前结果提取的是字段编码
			currentZd = xlcs.getZdbm();
			if (!currentZd.equals(lastZd)) {
				if (!"".equals(lastZd)) {
					// 实际存储的是字段编码对应的源表来源字段【与当前数据集的字段名一致】
					transMap.put(relaMap.get(lastZd), temp);
				}
				temp = new HashMap<String, String>();
				temp.put(xlcs.getSjz(), xlcs.getXsz());
			} else {
				temp.put(xlcs.getSjz(), xlcs.getXsz());
			}
			lastZd = currentZd;
		}
		// 实际存储的是字段编码对应的源表来源字段【与当前数据集的字段名一致】
		// 只有存在有字段存在下拉菜单映射的情况下才需要插入
		if (xlcsList.size() > 0) {
			transMap.put(relaMap.get(currentZd), temp);
		}
		/** 查询结果集数据处理并返回 */
		while (rowSet.next()) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			for (int i = 1; i <= columnNum; i++) {
				String columnName = sqlRsmd.getColumnName(i);
				// 如果该字段存在下拉映射值，则将Value替换为下拉映射的显示值
				if (transMap.containsKey(columnName)) {
					Map<String, String> valuesMap = new HashMap<String, String>();
					valuesMap = transMap.get(columnName);
					log.info(valuesMap.toString());
					dataMap.put(columnName, valuesMap.get(rowSet.getObject(i)));
				} else {
					dataMap.put(columnName, rowSet.getObject(i));
				}
			}
			result.add(dataMap);
		}
		return result;
	}

	@Override
	public List<List<Map<String, Object>>> getTableDataByConditionTransforColumnsSorted(String tableName,
			String columns, String condition, String orderByColumn, String orderByMode, String limit, String offset) {
		String selectColumns = "";
		if ("".equals(columns)) {
			selectColumns = "*";
		}
		String sql = "SELECT " + selectColumns + " FROM " + tableName;
		if (!"".equals(condition)) {
			sql += condition;
		}

		// 排序字段
		String orderColumn = "".equals(orderByColumn) ? "1" : orderByColumn;
		// 排序方式
		String orderMode = "".equals(orderByMode) ? "asc" : orderByMode;
		// 如果没有指定排序字段，则默认用结果集的第一个字段作为升序排序字段依据【解决GP每次合并查询结果后返回的数据次序不一致的问题】
		if ("1".equals(orderColumn)) {
			sql += " order by " + orderColumn + " " + orderMode + " limit " + limit + " offset " + offset;
		} else {
			sql += " order by \"" + orderColumn + "\" " + orderMode + " limit " + limit + " offset " + offset;
		}
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		SqlRowSetMetaData sqlRsmd = rowSet.getMetaData();
		int columnNum = sqlRsmd.getColumnCount();
		List<List<Map<String, Object>>> result = new ArrayList<List<Map<String, Object>>>();

		// 获取当前数据结果集的字段列表
		List<String> columnList = new ArrayList<String>();
		for (int i = 1; i <= columnNum; i++) {
			columnList.add(sqlRsmd.getColumnName(i));
		}
		/**
		 * 找出当前数据集相关字段中所有涉及下拉的字段 并对字段中的值进行下拉显示值的转换
		 */
		// 获取当前数据集中各个字段在数据字典中的配置
		XtpzSjzdExample sjzdExample = new XtpzSjzdExample();
		sjzdExample.createCriteria().andYbzdIn(columnList);
		sjzdExample.setOrderByClause(" zdbm asc");
		List<XtpzSjzd> sjzdList = sjzdDao.selectByExample(sjzdExample);
		Iterator<XtpzSjzd> sjzdIt = sjzdList.iterator();
		// 存储每个字段的字段编码及源表字段的关系
		Map<String, String> relaMap = new HashMap<String, String>();
		columnList.clear();
		while (sjzdIt.hasNext()) {
			XtpzSjzd sjzd = sjzdIt.next();
			// 将下拉参数和源表字段的关联性保存起来，后面处理字段显示值需要用到
			// relaMap.put(sjzd.getZdbm(), sjzd.getYbzd());
			// columnList.add(sjzd.getZdbm());
			relaMap.put(sjzd.getBz(), sjzd.getYbzd());
			columnList.add(sjzd.getBz());
		}
		// 找到数据集中所有字段的下拉参数值的信息
		XtpzXlcsExample xlcsExample = new XtpzXlcsExample();
		xlcsExample.createCriteria().andZdbmIn(columnList);
		xlcsExample.setOrderByClause(" zdbm asc");
		List<XtpzXlcs> xlcsList = xlcsDao.selectByExample(xlcsExample);
		Iterator<XtpzXlcs> xlcsIt = xlcsList.iterator();
		String lastZd = "", currentZd = "";
		// 将结果以Map的方式存储，例如:{"YXSCDB.KH_YDKH":{"10":"大用户","20":"中小用户"}}
		Map<String, Map<String, String>> transMap = new HashMap<String, Map<String, String>>();
		Map<String, String> temp = null;
		while (xlcsIt.hasNext()) {
			XtpzXlcs xlcs = xlcsIt.next();
			// 当前结果提取的是字段编码
			currentZd = xlcs.getZdbm();
			if (!currentZd.equals(lastZd)) {
				if (!"".equals(lastZd)) {
					// 实际存储的是字段编码对应的源表来源字段【与当前数据集的字段名一致】
					transMap.put(relaMap.get(lastZd), temp);
				}
				temp = new HashMap<String, String>();
				temp.put(xlcs.getSjz(), xlcs.getXsz());
			} else {
				temp.put(xlcs.getSjz(), xlcs.getXsz());
			}
			lastZd = currentZd;
		}
		// 实际存储的是字段编码对应的源表来源字段【与当前数据集的字段名一致】
		// 只有存在有字段存在下拉菜单映射的情况下才需要插入
		if (xlcsList.size() > 0) {
			transMap.put(relaMap.get(currentZd), temp);
		}
		/** 查询结果集数据处理并返回 */
		while (rowSet.next()) {
			List<Map<String, Object>> tempList = new ArrayList<Map<String, Object>>();
			for (int i = 1; i <= columnNum; i++) {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				String columnName = sqlRsmd.getColumnName(i);
				// 如果该字段存在下拉映射值，则将Value替换为下拉映射的显示值
				if (transMap.containsKey(columnName)) {
					Map<String, String> valuesMap = new HashMap<String, String>();
					valuesMap = transMap.get(columnName);
					dataMap.put(columnName, valuesMap.get(rowSet.getObject(i)) == null ? rowSet.getObject(i)
							: valuesMap.get(rowSet.getObject(i)));
				} else {
					dataMap.put(columnName, rowSet.getObject(i));
				}
				tempList.add(dataMap);
			}
			result.add(tempList);
		}
		return result;
	}

	@Override
	public List<List<Map<String, Object>>> getTableDataByConditionTransforColumnsSorted(String tableName,
			String columns, String condition, String orderByColumn, String orderByMode, String limit, String offset,
			String operator) {
		String selectColumns = "";
		if ("".equals(columns)) {
			selectColumns = "*";
		}
		String sql = "SELECT " + selectColumns + " FROM " + tableName;
		if (!"".equals(condition)) {
			sql += condition;
		}

		// 排序字段
		String orderColumn = "".equals(orderByColumn) ? "1" : orderByColumn;
		// 排序方式
		String orderMode = "".equals(orderByMode) ? "asc" : orderByMode;
		// 如果没有指定排序字段，则默认用结果集的第一个字段作为升序排序字段依据【解决GP每次合并查询结果后返回的数据次序不一致的问题】
		if ("1".equals(orderColumn)) {
			sql += " order by " + orderColumn + " " + orderMode + " limit " + limit + " offset " + offset;
		} else {
			sql += " order by \"" + orderColumn + "\" " + orderMode + " limit " + limit + " offset " + offset;
		}
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
		SqlRowSetMetaData sqlRsmd = rowSet.getMetaData();
		int columnNum = sqlRsmd.getColumnCount();
		List<List<Map<String, Object>>> result = new ArrayList<List<Map<String, Object>>>();

		// 获取当前数据结果集的字段列表
		List<String> columnList = new ArrayList<String>();
		for (int i = 1; i <= columnNum; i++) {
			columnList.add(sqlRsmd.getColumnName(i));
		}
		/**
		 * 找出当前数据集相关字段中所有涉及下拉的字段 并对字段中的值进行下拉显示值的转换
		 */
		// 获取当前数据集中各个字段在数据字典中的配置
		XtpzSjzdExample sjzdExample = new XtpzSjzdExample();
		sjzdExample.createCriteria().andYbzdIn(columnList);
		sjzdExample.setOrderByClause(" zdbm asc");
		List<XtpzSjzd> sjzdList = sjzdDao.selectByExample(sjzdExample);
		/** 补充个性化拓展的数据字典内容 **/
		XtpzSjzdGxhExample sjzdGxhExample = new XtpzSjzdGxhExample();
		sjzdGxhExample.createCriteria().andYbzdIn(columnList).andCzybmEqualTo(operator);
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
			swap.setBz(gxh.getBz());
			sjzdList.add(swap);
		}

		Iterator<XtpzSjzd> sjzdIt = sjzdList.iterator();
		// 存储每个字段的字段编码及源表字段的关系
		Map<String, String> relaMap = new HashMap<String, String>();
		columnList.clear();
		while (sjzdIt.hasNext()) {
			XtpzSjzd sjzd = sjzdIt.next();
			// 将下拉参数和源表字段的关联性保存起来，后面处理字段显示值需要用到
			// relaMap.put(sjzd.getZdbm(), sjzd.getYbzd());
			// columnList.add(sjzd.getZdbm());
			relaMap.put(sjzd.getBz(), sjzd.getYbzd());
			columnList.add(sjzd.getBz());
		}
		// 找到数据集中所有字段的下拉参数值的信息
		XtpzXlcsExample xlcsExample = new XtpzXlcsExample();
		xlcsExample.createCriteria().andZdbmIn(columnList);
		xlcsExample.setOrderByClause(" zdbm asc");
		List<XtpzXlcs> xlcsList = xlcsDao.selectByExample(xlcsExample);
		Iterator<XtpzXlcs> xlcsIt = xlcsList.iterator();
		String lastZd = "", currentZd = "";
		// 将结果以Map的方式存储，例如:{"YXSCDB.KH_YDKH":{"10":"大用户","20":"中小用户"}}
		Map<String, Map<String, String>> transMap = new HashMap<String, Map<String, String>>();
		Map<String, String> temp = null;
		while (xlcsIt.hasNext()) {
			XtpzXlcs xlcs = xlcsIt.next();
			// 当前结果提取的是字段编码
			currentZd = xlcs.getZdbm();
			if (!currentZd.equals(lastZd)) {
				if (!"".equals(lastZd)) {
					// 实际存储的是字段编码对应的源表来源字段【与当前数据集的字段名一致】
					transMap.put(relaMap.get(lastZd), temp);
				}
				temp = new HashMap<String, String>();
				temp.put(xlcs.getSjz(), xlcs.getXsz());
			} else {
				temp.put(xlcs.getSjz(), xlcs.getXsz());
			}
			lastZd = currentZd;
		}
		// 实际存储的是字段编码对应的源表来源字段【与当前数据集的字段名一致】
		// 只有存在有字段存在下拉菜单映射的情况下才需要插入
		if (xlcsList.size() > 0) {
			transMap.put(relaMap.get(currentZd), temp);
		}
		/** 查询结果集数据处理并返回 */
		while (rowSet.next()) {
			List<Map<String, Object>> tempList = new ArrayList<Map<String, Object>>();
			for (int i = 1; i <= columnNum; i++) {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				String columnName = sqlRsmd.getColumnName(i);
				// 如果该字段存在下拉映射值，则将Value替换为下拉映射的显示值
				if (transMap.containsKey(columnName)) {
					Map<String, String> valuesMap = new HashMap<String, String>();
					valuesMap = transMap.get(columnName);
					dataMap.put(columnName, valuesMap.get(rowSet.getObject(i)) == null ? rowSet.getObject(i)
							: valuesMap.get(rowSet.getObject(i)));
				} else {
					dataMap.put(columnName, rowSet.getObject(i));
				}
				tempList.add(dataMap);
			}
			result.add(tempList);
		}
		return result;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<XtpzSjy> getXtpzSjyInUnionMode(String queryValue, String operator, String mode) {
		String sql = "";
		String[] param = new String[2];
		param[0] = operator;
		param[1] = queryValue;
		if ("1".equals(mode)) {
			sql = "with temp as(select sjybm,sjymc,flbm from yxscdb.XTPZ_sjy union select sjybm,sjymc,flbm from yxscdb.XTPZ_sjy_gxh where czybm=?) select * from temp where sjybm=? order by 1;";
		} else if ("2".equals(mode)) {
			sql = "with temp as(select sjybm,sjymc,flbm from yxscdb.XTPZ_sjy union select sjybm,sjymc,flbm from yxscdb.XTPZ_sjy_gxh where czybm=?) select * from temp where flbm=? order by 1;";
		}
		log.info("sql:" + sql);
		@SuppressWarnings("rawtypes")
		List<XtpzSjy> list = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper(XtpzSjy.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<XtpzSjzd> getXtpzSjzdInUnionMode(String queryValue, String operator, String mode) {
		String sql = "";
		String[] param = new String[2];
		param[0] = operator;
		param[1] = queryValue;
		if ("1".equals(mode)) {
			sql = "with temp as(select zdbm,sjybm,zdmc,ybmc,ybzd,sjlx,jhbz,bz from yxscdb.XTPZ_sjzd " + "union "
					+ "select zdbm,sjybm,zdmc,ybmc,ybzd,sjlx,jhbz,bz from yxscdb.XTPZ_sjzd_gxh where czybm=?) "
					+ "select * from temp where sjybm=? order by 1;";
		} else if ("2".equals(mode)) {
			sql = "with temp as(select zdbm,sjybm,zdmc,ybmc,ybzd,sjlx,jhbz,bz from yxscdb.XTPZ_sjzd " + "union "
					+ "select zdbm,sjybm,zdmc,ybmc,ybzd,sjlx,jhbz,bz from yxscdb.XTPZ_sjzd_gxh where czybm=?) "
					+ "select * from temp where ybzd=? order by 1;";
		}
		log.info("sql:" + sql);
		@SuppressWarnings("rawtypes")
		List<XtpzSjzd> list = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper(XtpzSjzd.class));
		return list;
	}

}
