package cn.com.gxbolian.databank.dao;

import cn.com.gxbolian.databank.entity.XtpzBzhzjpz;
import cn.com.gxbolian.databank.entity.XtpzBzhzjpzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XtpzBzhzjpzMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz
	 * @mbg.generated
	 */
	long countByExample(XtpzBzhzjpzExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz
	 * @mbg.generated
	 */
	int deleteByExample(XtpzBzhzjpzExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz
	 * @mbg.generated
	 */
	int deleteByPrimaryKey(String lsh);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz
	 * @mbg.generated
	 */
	int insert(XtpzBzhzjpz record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz
	 * @mbg.generated
	 */
	int insertSelective(XtpzBzhzjpz record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz
	 * @mbg.generated
	 */
	List<XtpzBzhzjpz> selectByExample(XtpzBzhzjpzExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz
	 * @mbg.generated
	 */
	XtpzBzhzjpz selectByPrimaryKey(String lsh);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz
	 * @mbg.generated
	 */
	int updateByExampleSelective(@Param("record") XtpzBzhzjpz record, @Param("example") XtpzBzhzjpzExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz
	 * @mbg.generated
	 */
	int updateByExample(@Param("record") XtpzBzhzjpz record, @Param("example") XtpzBzhzjpzExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz
	 * @mbg.generated
	 */
	int updateByPrimaryKeySelective(XtpzBzhzjpz record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz
	 * @mbg.generated
	 */
	int updateByPrimaryKey(XtpzBzhzjpz record);
}