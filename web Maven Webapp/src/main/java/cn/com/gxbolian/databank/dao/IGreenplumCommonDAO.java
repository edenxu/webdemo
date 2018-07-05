package cn.com.gxbolian.databank.dao;

import java.util.List;
import java.util.Map;

import cn.com.gxbolian.databank.entity.XtpzSjy;
import cn.com.gxbolian.databank.entity.XtpzSjzd;

public interface IGreenplumCommonDAO {

	/**
	 * 根据SELECT类型的SQL语句，将结果写入到另外一张数据表中，并返回新表的表名
	 * 
	 * @param sql
	 *            执行查询的SQL语句
	 * @return 新生产的数据表名
	 */
	public String createTableAsSelectSQL(String sql);

	/**
	 * 获取指定表的数据行数[分页用]
	 * 
	 * @param tableName
	 *            表名
	 * @param condition
	 *            Where条件
	 * @return 数据行数
	 */
	public long getTableRowcountByCondition(String tableName, String condition);

	/**
	 * 获取特定表的相关数据信息[如需对电压等级、用户等级等存在下拉显示值的字段显示字面值，请使用getTableDataByConditionTransforColumns方法]
	 * 
	 * @param tableName
	 *            表名
	 * @param columns
	 *            字段名SQL，如: A.A,A.B,A.C
	 * @param condition
	 *            Where条件
	 * @param orderByColumn
	 *            排序字段
	 * @param orderByMode
	 *            排序模式
	 * @param limit
	 *            提取数据行数
	 * @param offset
	 *            提取数据起始位置
	 * @return 数据结果集
	 */
	public List<Map<String, Object>> getTableDataByCondition(String tableName, String columns, String condition,
			String orderByColumn, String orderByMode, String limit, String offset);

	/**
	 * 获取数据表的字段映射描述，用于前台展示
	 * 
	 * @param tableName
	 *            数据表名
	 * @return 映射结果
	 */
	public List<Map<String, Object>> getTableColumnNameAndDescription(String tableName);

	/**
	 * 获取【全局+个性化】数据表的字段映射描述，用于前台展示
	 * 
	 * @param tableName
	 *            数据表名
	 * @param operator
	 *            操作员
	 * @return 映射结果
	 */
	public List<Map<String, Object>> getTableColumnNameAndDescription(String tableName, String operator);

	/**
	 * 根据表名Drop掉存储数据的表
	 * 
	 * @param tableName
	 *            数据表名
	 */
	public void dropTemporaryTable(String tableName);

	/**
	 * 获取特定表的相关数据信息[对存在编码的字段转换成实际显示值][字段顺序为随机，不是按Select语句的顺序]
	 * [主要用于Bootstrap-table前台展示]
	 * 
	 * @param tableName
	 *            表名
	 * @param columns
	 *            字段名SQL，如: A.A,A.B,A.C
	 * @param condition
	 *            Where条件
	 * @param orderByColumn
	 *            排序字段
	 * @param orderByMode
	 *            排序模式
	 * @param limit
	 *            提取数据行数
	 * @param offset
	 *            提取数据起始位置
	 * @return 数据结果集
	 */
	public List<Map<String, Object>> getTableDataByConditionTransforColumns(String tableName, String columns,
			String condition, String orderByColumn, String orderByMode, String limit, String offset);

	public List<Map<String, Object>> getTableDataByConditionTransforColumns(String tableName, String columns,
			String condition, String orderByColumn, String orderByMode, String limit, String offset, String operator);

	/**
	 * 获取特定表的相关数据信息[对存在编码的字段转换成实际显示值][字段顺序为按Select语句的顺序] [主要用于数据导出]
	 * 
	 * @param tableName
	 *            表名
	 * @param columns
	 *            字段名SQL，如: A.A,A.B,A.C
	 * @param condition
	 *            Where条件
	 * @param orderByColumn
	 *            排序字段
	 * @param orderByMode
	 *            排序模式
	 * @param limit
	 *            提取数据行数
	 * @param offset
	 *            提取数据起始位置
	 * @return 数据结果集
	 */
	public List<List<Map<String, Object>>> getTableDataByConditionTransforColumnsSorted(String tableName,
			String columns, String condition, String orderByColumn, String orderByMode, String limit, String offset);

	public List<List<Map<String, Object>>> getTableDataByConditionTransforColumnsSorted(String tableName,
			String columns, String condition, String orderByColumn, String orderByMode, String limit, String offset,
			String operator);

	/**
	 * 从全局及个性化数据域的并集中查询数据域信息
	 * 
	 * @param sjy
	 *            查询条件封装对象
	 * @param operator
	 *            操作员
	 * @param mode
	 *            1. 根据sjybm查 2. 根据flbm查
	 * @return 结果清单
	 */
	public List<XtpzSjy> getXtpzSjyInUnionMode(String queryValue, String operator, String mode);

	/**
	 * 从全局及个性化数据字典的并集中查询数据域信息
	 * 
	 * @param sjy
	 *            查询条件封装对象
	 * @param operator
	 *            操作员
	 * @param mode
	 *            1. 根据sjybm查 2. 根据ybzd查
	 * @return 结果清单
	 */
	public List<XtpzSjzd> getXtpzSjzdInUnionMode(String queryValue, String operator, String mode);

}
