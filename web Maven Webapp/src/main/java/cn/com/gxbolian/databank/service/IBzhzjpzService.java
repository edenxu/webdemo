package cn.com.gxbolian.databank.service;

import java.util.List;

import cn.com.gxbolian.databank.entity.XtpzBzhzjpzSr;

/**
 * 标准化配置模块相关操作接口
 * 
 * @author xu_xi
 *
 */
public interface IBzhzjpzService {

	/**
	 * 根据标准化配置流水号获取相关输入列表
	 * 
	 * @param lsh
	 *            标准化配置流水号
	 * @return 指定标准化配置输入列表
	 */
	public List<XtpzBzhzjpzSr> getBzhzjpzSrQd(String lsh);

	/**
	 * 根据入参生成对应标准化组件的数据信息
	 * 
	 * @param params
	 *            入参列表
	 * @operator 操作员
	 * @return 标准化组件生成的数据集表名
	 */
	public String generateDataInSpecialPlugin(List<String> params, String operator);
}
