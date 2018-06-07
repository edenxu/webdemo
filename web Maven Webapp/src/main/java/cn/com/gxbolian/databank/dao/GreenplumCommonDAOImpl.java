package cn.com.gxbolian.databank.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Repository;

import cn.com.gxbolian.databank.entity.XtpzSjzd;
import cn.com.gxbolian.databank.entity.XtpzSjzdExample;
import cn.com.gxbolian.databank.util.IdWorker;

@Repository
public class GreenplumCommonDAOImpl implements IGreenplumCommonDAO {
	protected final Logger log = LogManager.getLogger(GreenplumCommonDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private XtpzSjzdMapper sjzdDao;

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

}
