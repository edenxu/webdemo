package cn.com.gxbolian.databank.service;

import cn.com.gxbolian.databank.entity.XtpzCxfa;

public interface IQueryPlanService {

	/**
	 * 保存查询方案信息，包括查询字段、筛选字段、筛选条件，保存内容为HTML结果
	 * 
	 * @param queryPlan
	 *            查询方案Pojo
	 */
	public void addQueryPlan(XtpzCxfa queryPlan);

	/**
	 * 添加新的数据查询方案记录
	 * 
	 * @param queryPlan
	 * @param sjybm
	 */
	public void insertNewQeuryPlan(XtpzCxfa queryPlan, String sjybm);

	/**
	 * 根据主键获取查询方案信息
	 * 
	 * @param lsh
	 *            流水号
	 * @return 对象实体
	 */
	public XtpzCxfa getQueryPlanByPrimaryKey(String lsh);

}
