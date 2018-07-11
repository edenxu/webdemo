package cn.com.gxbolian.databank.dao;

import cn.com.gxbolian.databank.entity.XtpzSjzdGxh;
import cn.com.gxbolian.databank.entity.XtpzSjzdGxhExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XtpzSjzdGxhMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjzd_gxh
	 * @mbg.generated
	 */
	long countByExample(XtpzSjzdGxhExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjzd_gxh
	 * @mbg.generated
	 */
	int deleteByExample(XtpzSjzdGxhExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjzd_gxh
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(String zdbm);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjzd_gxh
	 * @mbg.generated
	 */
	int insert(XtpzSjzdGxh record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjzd_gxh
	 * @mbg.generated
	 */
	int insertSelective(XtpzSjzdGxh record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjzd_gxh
	 * @mbg.generated
	 */
	List<XtpzSjzdGxh> selectByExample(XtpzSjzdGxhExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjzd_gxh
	 * @mbg.generated
	 */
	XtpzSjzdGxh selectByPrimaryKey(String zdbm);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjzd_gxh
	 * @mbg.generated
	 */
	int updateByExampleSelective(@Param("record") XtpzSjzdGxh record, @Param("example") XtpzSjzdGxhExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjzd_gxh
	 * @mbg.generated
	 */
	int updateByExample(@Param("record") XtpzSjzdGxh record, @Param("example") XtpzSjzdGxhExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjzd_gxh
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(XtpzSjzdGxh record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjzd_gxh
	 * @mbg.generated
	 */
	int updateByPrimaryKey(XtpzSjzdGxh record);
}