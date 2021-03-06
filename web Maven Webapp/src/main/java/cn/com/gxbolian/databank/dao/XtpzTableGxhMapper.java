package cn.com.gxbolian.databank.dao;

import cn.com.gxbolian.databank.entity.XtpzTableGxh;
import cn.com.gxbolian.databank.entity.XtpzTableGxhExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XtpzTableGxhMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_table_gxh
     *
     * @mbg.generated
     */
    long countByExample(XtpzTableGxhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_table_gxh
     *
     * @mbg.generated
     */
    int deleteByExample(XtpzTableGxhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_table_gxh
     *
     * @mbg.generated
     */
    int insert(XtpzTableGxh record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_table_gxh
     *
     * @mbg.generated
     */
    int insertSelective(XtpzTableGxh record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_table_gxh
     *
     * @mbg.generated
     */
    List<XtpzTableGxh> selectByExample(XtpzTableGxhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_table_gxh
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") XtpzTableGxh record, @Param("example") XtpzTableGxhExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_table_gxh
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") XtpzTableGxh record, @Param("example") XtpzTableGxhExample example);
}