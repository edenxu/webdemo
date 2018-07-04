package cn.com.gxbolian.databank.entity;

import java.util.ArrayList;
import java.util.List;

public class XtpzSjzdGxhExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    public XtpzSjzdGxhExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andZdbmIsNull() {
            addCriterion("zdbm is null");
            return (Criteria) this;
        }

        public Criteria andZdbmIsNotNull() {
            addCriterion("zdbm is not null");
            return (Criteria) this;
        }

        public Criteria andZdbmEqualTo(String value) {
            addCriterion("zdbm =", value, "zdbm");
            return (Criteria) this;
        }

        public Criteria andZdbmNotEqualTo(String value) {
            addCriterion("zdbm <>", value, "zdbm");
            return (Criteria) this;
        }

        public Criteria andZdbmGreaterThan(String value) {
            addCriterion("zdbm >", value, "zdbm");
            return (Criteria) this;
        }

        public Criteria andZdbmGreaterThanOrEqualTo(String value) {
            addCriterion("zdbm >=", value, "zdbm");
            return (Criteria) this;
        }

        public Criteria andZdbmLessThan(String value) {
            addCriterion("zdbm <", value, "zdbm");
            return (Criteria) this;
        }

        public Criteria andZdbmLessThanOrEqualTo(String value) {
            addCriterion("zdbm <=", value, "zdbm");
            return (Criteria) this;
        }

        public Criteria andZdbmLike(String value) {
            addCriterion("zdbm like", value, "zdbm");
            return (Criteria) this;
        }

        public Criteria andZdbmNotLike(String value) {
            addCriterion("zdbm not like", value, "zdbm");
            return (Criteria) this;
        }

        public Criteria andZdbmIn(List<String> values) {
            addCriterion("zdbm in", values, "zdbm");
            return (Criteria) this;
        }

        public Criteria andZdbmNotIn(List<String> values) {
            addCriterion("zdbm not in", values, "zdbm");
            return (Criteria) this;
        }

        public Criteria andZdbmBetween(String value1, String value2) {
            addCriterion("zdbm between", value1, value2, "zdbm");
            return (Criteria) this;
        }

        public Criteria andZdbmNotBetween(String value1, String value2) {
            addCriterion("zdbm not between", value1, value2, "zdbm");
            return (Criteria) this;
        }

        public Criteria andSjybmIsNull() {
            addCriterion("sjybm is null");
            return (Criteria) this;
        }

        public Criteria andSjybmIsNotNull() {
            addCriterion("sjybm is not null");
            return (Criteria) this;
        }

        public Criteria andSjybmEqualTo(String value) {
            addCriterion("sjybm =", value, "sjybm");
            return (Criteria) this;
        }

        public Criteria andSjybmNotEqualTo(String value) {
            addCriterion("sjybm <>", value, "sjybm");
            return (Criteria) this;
        }

        public Criteria andSjybmGreaterThan(String value) {
            addCriterion("sjybm >", value, "sjybm");
            return (Criteria) this;
        }

        public Criteria andSjybmGreaterThanOrEqualTo(String value) {
            addCriterion("sjybm >=", value, "sjybm");
            return (Criteria) this;
        }

        public Criteria andSjybmLessThan(String value) {
            addCriterion("sjybm <", value, "sjybm");
            return (Criteria) this;
        }

        public Criteria andSjybmLessThanOrEqualTo(String value) {
            addCriterion("sjybm <=", value, "sjybm");
            return (Criteria) this;
        }

        public Criteria andSjybmLike(String value) {
            addCriterion("sjybm like", value, "sjybm");
            return (Criteria) this;
        }

        public Criteria andSjybmNotLike(String value) {
            addCriterion("sjybm not like", value, "sjybm");
            return (Criteria) this;
        }

        public Criteria andSjybmIn(List<String> values) {
            addCriterion("sjybm in", values, "sjybm");
            return (Criteria) this;
        }

        public Criteria andSjybmNotIn(List<String> values) {
            addCriterion("sjybm not in", values, "sjybm");
            return (Criteria) this;
        }

        public Criteria andSjybmBetween(String value1, String value2) {
            addCriterion("sjybm between", value1, value2, "sjybm");
            return (Criteria) this;
        }

        public Criteria andSjybmNotBetween(String value1, String value2) {
            addCriterion("sjybm not between", value1, value2, "sjybm");
            return (Criteria) this;
        }

        public Criteria andZdmcIsNull() {
            addCriterion("zdmc is null");
            return (Criteria) this;
        }

        public Criteria andZdmcIsNotNull() {
            addCriterion("zdmc is not null");
            return (Criteria) this;
        }

        public Criteria andZdmcEqualTo(String value) {
            addCriterion("zdmc =", value, "zdmc");
            return (Criteria) this;
        }

        public Criteria andZdmcNotEqualTo(String value) {
            addCriterion("zdmc <>", value, "zdmc");
            return (Criteria) this;
        }

        public Criteria andZdmcGreaterThan(String value) {
            addCriterion("zdmc >", value, "zdmc");
            return (Criteria) this;
        }

        public Criteria andZdmcGreaterThanOrEqualTo(String value) {
            addCriterion("zdmc >=", value, "zdmc");
            return (Criteria) this;
        }

        public Criteria andZdmcLessThan(String value) {
            addCriterion("zdmc <", value, "zdmc");
            return (Criteria) this;
        }

        public Criteria andZdmcLessThanOrEqualTo(String value) {
            addCriterion("zdmc <=", value, "zdmc");
            return (Criteria) this;
        }

        public Criteria andZdmcLike(String value) {
            addCriterion("zdmc like", value, "zdmc");
            return (Criteria) this;
        }

        public Criteria andZdmcNotLike(String value) {
            addCriterion("zdmc not like", value, "zdmc");
            return (Criteria) this;
        }

        public Criteria andZdmcIn(List<String> values) {
            addCriterion("zdmc in", values, "zdmc");
            return (Criteria) this;
        }

        public Criteria andZdmcNotIn(List<String> values) {
            addCriterion("zdmc not in", values, "zdmc");
            return (Criteria) this;
        }

        public Criteria andZdmcBetween(String value1, String value2) {
            addCriterion("zdmc between", value1, value2, "zdmc");
            return (Criteria) this;
        }

        public Criteria andZdmcNotBetween(String value1, String value2) {
            addCriterion("zdmc not between", value1, value2, "zdmc");
            return (Criteria) this;
        }

        public Criteria andYbmcIsNull() {
            addCriterion("ybmc is null");
            return (Criteria) this;
        }

        public Criteria andYbmcIsNotNull() {
            addCriterion("ybmc is not null");
            return (Criteria) this;
        }

        public Criteria andYbmcEqualTo(String value) {
            addCriterion("ybmc =", value, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbmcNotEqualTo(String value) {
            addCriterion("ybmc <>", value, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbmcGreaterThan(String value) {
            addCriterion("ybmc >", value, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbmcGreaterThanOrEqualTo(String value) {
            addCriterion("ybmc >=", value, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbmcLessThan(String value) {
            addCriterion("ybmc <", value, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbmcLessThanOrEqualTo(String value) {
            addCriterion("ybmc <=", value, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbmcLike(String value) {
            addCriterion("ybmc like", value, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbmcNotLike(String value) {
            addCriterion("ybmc not like", value, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbmcIn(List<String> values) {
            addCriterion("ybmc in", values, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbmcNotIn(List<String> values) {
            addCriterion("ybmc not in", values, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbmcBetween(String value1, String value2) {
            addCriterion("ybmc between", value1, value2, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbmcNotBetween(String value1, String value2) {
            addCriterion("ybmc not between", value1, value2, "ybmc");
            return (Criteria) this;
        }

        public Criteria andYbzdIsNull() {
            addCriterion("ybzd is null");
            return (Criteria) this;
        }

        public Criteria andYbzdIsNotNull() {
            addCriterion("ybzd is not null");
            return (Criteria) this;
        }

        public Criteria andYbzdEqualTo(String value) {
            addCriterion("ybzd =", value, "ybzd");
            return (Criteria) this;
        }

        public Criteria andYbzdNotEqualTo(String value) {
            addCriterion("ybzd <>", value, "ybzd");
            return (Criteria) this;
        }

        public Criteria andYbzdGreaterThan(String value) {
            addCriterion("ybzd >", value, "ybzd");
            return (Criteria) this;
        }

        public Criteria andYbzdGreaterThanOrEqualTo(String value) {
            addCriterion("ybzd >=", value, "ybzd");
            return (Criteria) this;
        }

        public Criteria andYbzdLessThan(String value) {
            addCriterion("ybzd <", value, "ybzd");
            return (Criteria) this;
        }

        public Criteria andYbzdLessThanOrEqualTo(String value) {
            addCriterion("ybzd <=", value, "ybzd");
            return (Criteria) this;
        }

        public Criteria andYbzdLike(String value) {
            addCriterion("ybzd like", value, "ybzd");
            return (Criteria) this;
        }

        public Criteria andYbzdNotLike(String value) {
            addCriterion("ybzd not like", value, "ybzd");
            return (Criteria) this;
        }

        public Criteria andYbzdIn(List<String> values) {
            addCriterion("ybzd in", values, "ybzd");
            return (Criteria) this;
        }

        public Criteria andYbzdNotIn(List<String> values) {
            addCriterion("ybzd not in", values, "ybzd");
            return (Criteria) this;
        }

        public Criteria andYbzdBetween(String value1, String value2) {
            addCriterion("ybzd between", value1, value2, "ybzd");
            return (Criteria) this;
        }

        public Criteria andYbzdNotBetween(String value1, String value2) {
            addCriterion("ybzd not between", value1, value2, "ybzd");
            return (Criteria) this;
        }

        public Criteria andSjlxIsNull() {
            addCriterion("sjlx is null");
            return (Criteria) this;
        }

        public Criteria andSjlxIsNotNull() {
            addCriterion("sjlx is not null");
            return (Criteria) this;
        }

        public Criteria andSjlxEqualTo(String value) {
            addCriterion("sjlx =", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxNotEqualTo(String value) {
            addCriterion("sjlx <>", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxGreaterThan(String value) {
            addCriterion("sjlx >", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxGreaterThanOrEqualTo(String value) {
            addCriterion("sjlx >=", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxLessThan(String value) {
            addCriterion("sjlx <", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxLessThanOrEqualTo(String value) {
            addCriterion("sjlx <=", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxLike(String value) {
            addCriterion("sjlx like", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxNotLike(String value) {
            addCriterion("sjlx not like", value, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxIn(List<String> values) {
            addCriterion("sjlx in", values, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxNotIn(List<String> values) {
            addCriterion("sjlx not in", values, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxBetween(String value1, String value2) {
            addCriterion("sjlx between", value1, value2, "sjlx");
            return (Criteria) this;
        }

        public Criteria andSjlxNotBetween(String value1, String value2) {
            addCriterion("sjlx not between", value1, value2, "sjlx");
            return (Criteria) this;
        }

        public Criteria andJhbzIsNull() {
            addCriterion("jhbz is null");
            return (Criteria) this;
        }

        public Criteria andJhbzIsNotNull() {
            addCriterion("jhbz is not null");
            return (Criteria) this;
        }

        public Criteria andJhbzEqualTo(String value) {
            addCriterion("jhbz =", value, "jhbz");
            return (Criteria) this;
        }

        public Criteria andJhbzNotEqualTo(String value) {
            addCriterion("jhbz <>", value, "jhbz");
            return (Criteria) this;
        }

        public Criteria andJhbzGreaterThan(String value) {
            addCriterion("jhbz >", value, "jhbz");
            return (Criteria) this;
        }

        public Criteria andJhbzGreaterThanOrEqualTo(String value) {
            addCriterion("jhbz >=", value, "jhbz");
            return (Criteria) this;
        }

        public Criteria andJhbzLessThan(String value) {
            addCriterion("jhbz <", value, "jhbz");
            return (Criteria) this;
        }

        public Criteria andJhbzLessThanOrEqualTo(String value) {
            addCriterion("jhbz <=", value, "jhbz");
            return (Criteria) this;
        }

        public Criteria andJhbzLike(String value) {
            addCriterion("jhbz like", value, "jhbz");
            return (Criteria) this;
        }

        public Criteria andJhbzNotLike(String value) {
            addCriterion("jhbz not like", value, "jhbz");
            return (Criteria) this;
        }

        public Criteria andJhbzIn(List<String> values) {
            addCriterion("jhbz in", values, "jhbz");
            return (Criteria) this;
        }

        public Criteria andJhbzNotIn(List<String> values) {
            addCriterion("jhbz not in", values, "jhbz");
            return (Criteria) this;
        }

        public Criteria andJhbzBetween(String value1, String value2) {
            addCriterion("jhbz between", value1, value2, "jhbz");
            return (Criteria) this;
        }

        public Criteria andJhbzNotBetween(String value1, String value2) {
            addCriterion("jhbz not between", value1, value2, "jhbz");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("bz is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("bz is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andCzybmIsNull() {
            addCriterion("czybm is null");
            return (Criteria) this;
        }

        public Criteria andCzybmIsNotNull() {
            addCriterion("czybm is not null");
            return (Criteria) this;
        }

        public Criteria andCzybmEqualTo(String value) {
            addCriterion("czybm =", value, "czybm");
            return (Criteria) this;
        }

        public Criteria andCzybmNotEqualTo(String value) {
            addCriterion("czybm <>", value, "czybm");
            return (Criteria) this;
        }

        public Criteria andCzybmGreaterThan(String value) {
            addCriterion("czybm >", value, "czybm");
            return (Criteria) this;
        }

        public Criteria andCzybmGreaterThanOrEqualTo(String value) {
            addCriterion("czybm >=", value, "czybm");
            return (Criteria) this;
        }

        public Criteria andCzybmLessThan(String value) {
            addCriterion("czybm <", value, "czybm");
            return (Criteria) this;
        }

        public Criteria andCzybmLessThanOrEqualTo(String value) {
            addCriterion("czybm <=", value, "czybm");
            return (Criteria) this;
        }

        public Criteria andCzybmLike(String value) {
            addCriterion("czybm like", value, "czybm");
            return (Criteria) this;
        }

        public Criteria andCzybmNotLike(String value) {
            addCriterion("czybm not like", value, "czybm");
            return (Criteria) this;
        }

        public Criteria andCzybmIn(List<String> values) {
            addCriterion("czybm in", values, "czybm");
            return (Criteria) this;
        }

        public Criteria andCzybmNotIn(List<String> values) {
            addCriterion("czybm not in", values, "czybm");
            return (Criteria) this;
        }

        public Criteria andCzybmBetween(String value1, String value2) {
            addCriterion("czybm between", value1, value2, "czybm");
            return (Criteria) this;
        }

        public Criteria andCzybmNotBetween(String value1, String value2) {
            addCriterion("czybm not between", value1, value2, "czybm");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table xtpz_sjzd_gxh
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}