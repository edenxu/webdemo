package cn.com.gxbolian.databank.dao;

import cn.com.gxbolian.databank.entity.XtpzCxfa;
import cn.com.gxbolian.databank.entity.XtpzCxfaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XtpzCxfaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	long countByExample(XtpzCxfaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	int deleteByExample(XtpzCxfaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(String lsh);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	int insert(XtpzCxfa record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	int insertSelective(XtpzCxfa record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	List<XtpzCxfa> selectByExample(XtpzCxfaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	XtpzCxfa selectByPrimaryKey(String lsh);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	int updateByExampleSelective(@Param("record") XtpzCxfa record, @Param("example") XtpzCxfaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	int updateByExample(@Param("record") XtpzCxfa record, @Param("example") XtpzCxfaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(XtpzCxfa record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	int updateByPrimaryKey(XtpzCxfa record);
}