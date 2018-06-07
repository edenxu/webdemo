package cn.com.gxbolian.databank.dao;

import cn.com.gxbolian.databank.entity.XtpzSjy;
import cn.com.gxbolian.databank.entity.XtpzSjyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XtpzSjyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjy
	 * @mbg.generated
	 */
	long countByExample(XtpzSjyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjy
	 * @mbg.generated
	 */
	int deleteByExample(XtpzSjyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjy
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(String sjybm);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjy
	 * @mbg.generated
	 */
	int insert(XtpzSjy record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjy
	 * @mbg.generated
	 */
	int insertSelective(XtpzSjy record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjy
	 * @mbg.generated
	 */
	List<XtpzSjy> selectByExample(XtpzSjyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjy
	 * @mbg.generated
	 */
	XtpzSjy selectByPrimaryKey(String sjybm);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjy
	 * @mbg.generated
	 */
	int updateByExampleSelective(@Param("record") XtpzSjy record, @Param("example") XtpzSjyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjy
	 * @mbg.generated
	 */
	int updateByExample(@Param("record") XtpzSjy record, @Param("example") XtpzSjyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjy
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(XtpzSjy record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_sjy
	 * @mbg.generated
	 */
	int updateByPrimaryKey(XtpzSjy record);
}