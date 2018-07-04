package cn.com.gxbolian.databank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.gxbolian.databank.entity.BootstrapTreeViewEntity;
import cn.com.gxbolian.databank.entity.ParamsObject;
import cn.com.gxbolian.databank.entity.XtpzSjy;
import cn.com.gxbolian.databank.entity.XtpzSjzd;
import cn.com.gxbolian.databank.entity.XtpzXlcs;
import cn.com.gxbolian.databank.entity.XtpzXlcstz;

public interface IDemoService {

	/**
	 * 获取数据域信息
	 * 
	 * @param sjy
	 * @return
	 */
	public List<XtpzSjy> getXtpzSjyListByExample(XtpzSjy sjy);

	/**
	 * 根据数据域编码获取数据字典信息
	 * 
	 * @param sjzd
	 * @return
	 */
	public List<XtpzSjzd> getXtpzSjzdListByExample(XtpzSjzd sjzd);

	/**
	 * 根据节点编号获取该节点下的树形信息
	 * 
	 * @param nodeId
	 * @return
	 */
	public String getNodeInfoForTree(String nodeId);

	/**
	 * 根据节点编号获取该节点下的树形信息
	 * 
	 * @param nodeId
	 * 
	 * @return
	 */
	public BootstrapTreeViewEntity getNodeInfoForBootstrapTreeviewEntity(String nodeId);

	/**
	 * 根据传递过来的参数动态拼装成用户所需数据集的SQL语句
	 * 
	 * @param object
	 *            包含字段、where条件、分组条件、having条件等
	 * @return 返回拼装好的SQL语句
	 */
	public String makeUpSelectSQL(ParamsObject object);

	/**
	 * 根据统计查询所涉及的数据表，自动从表结构连通图中找出覆盖这些表的最短关联关系
	 * 
	 * @param tablesArray
	 *            统计查询所涉及数据表清单
	 * @return 返回关联好的From 表清单 及 Where关联字段内容
	 */
	public String makeUpFromTablesAndColumnRelation(String[] tablesArray);

	/**
	 * 将拼凑的SQL语句查询结果写入到物理表，并将表名返回
	 * 
	 * @param sql
	 *            执行的SQL
	 * @return 返回写入数据表的表名
	 */
	public String createTableAsSelectSQL(String sql);

	/**
	 * 获取特定表的相关数据信息
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
	public Map<String, Object> getDataForBootstrapDataTable(String tableName, String columns, String condition,
			String orderByColumn, String orderByMode, String limit, String offset);

	/**
	 * 获取数据表的字段名及中文描述信息【用于动态加载前端页面Bootstrap的表头】
	 * 
	 * @param tableName
	 *            表名
	 * @return 字段信息集合
	 */
	public List<Map<String, Object>> getTableColumnNameAndDescription(String tableName);

	/**
	 * 获取数据字典中所有表的网络连通图结构
	 * 
	 * @return 所有表的网络连通图结构
	 */
	public HashMap<String, HashMap<String, Integer>> getAllConnectedGraphBySjzd();

	/**
	 * 获取下拉菜单主表数据信息
	 * 
	 * @param xlcs
	 * @return
	 */
	public List<XtpzXlcs> getXtpzXlcsListByExample(XtpzXlcs xlcs);

	/**
	 * 获取下拉菜单拓展表数据信息
	 * 
	 * @param xlcs
	 * @return
	 */
	public List<XtpzXlcstz> getXtpzXlcstzListByExample(XtpzXlcstz xlcstz);

	/**
	 * 获取特定表的相关数据信息[用于数据导出]
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
	public List<List<Map<String, Object>>> getDataForBootstrapDataTableToExport(String tableName, String columns,
			String condition, String orderByColumn, String orderByMode, String limit, String offset);

	/**
	 * 根据表名获取该数据表的总记录数
	 * 
	 * @param tableName
	 *            数据表名
	 * @return 该表的总记录数
	 */
	public long getTotoalRowcountByTableName(String tableName);

	/**
	 * 根据用户选择，将数据表加入到数据表连通图中
	 * 
	 * @param opertor
	 *            操作员ID
	 * @param resultMeta
	 *            新数据集的元数据信息
	 */
	public void insertPersonalGridInfo(String opertor, List<Map<String, Object>> resultMeta);

	/**
	 * 记录自动创建表的相关基本信息【创建人、表名、别名、有效时间，状态等】
	 * 
	 * @param tableName
	 *            表名
	 * @param tableNickName
	 *            别名
	 * @param operator
	 *            操作员
	 * @param status
	 *            状态[T:临时;N:正常在分析]
	 */
	public void insertAutoGenerateTableInfo(String tableName, String tableNickName, String operator, String status);

	/**
	 * 将用户统计结果集写入个性化数据字典
	 * 
	 * @param opertor
	 *            操作员ID
	 * @param tableName
	 *            表名
	 * @param resultMeta
	 *            结果集元数据
	 */
	public void insertPersonalDirectory(String opertor, String tableName, List<Map<String, Object>> resultMeta);

	/**
	 * 写入数据表关联信息
	 * 
	 * @param tableA
	 *            表A
	 * @param columnA
	 *            字段A
	 * @param tableB
	 *            表B
	 * @param columnB
	 *            字段B
	 * @param type
	 *            插入类型：[G:全局;P:个性化]
	 */
	public void insertTablsRelationToGrid(String tableA, String columnA, String tableB, String columnB, String type);

}
