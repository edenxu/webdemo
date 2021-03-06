package cn.com.gxbolian.databank.entity;

import java.util.ArrayList;
import java.util.List;

public class XtpzSjglysGxhExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table xtpz_sjglys_gxh
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table xtpz_sjglys_gxh
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table xtpz_sjglys_gxh
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjglys_gxh
     *
     * @mbg.generated
     */
    public XtpzSjglysGxhExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjglys_gxh
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjglys_gxh
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjglys_gxh
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjglys_gxh
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjglys_gxh
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjglys_gxh
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjglys_gxh
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
     * This method corresponds to the database table xtpz_sjglys_gxh
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
     * This method corresponds to the database table xtpz_sjglys_gxh
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_sjglys_gxh
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
     * This class corresponds to the database table xtpz_sjglys_gxh
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

        public Criteria andLshIsNull() {
            addCriterion("lsh is null");
            return (Criteria) this;
        }

        public Criteria andLshIsNotNull() {
            addCriterion("lsh is not null");
            return (Criteria) this;
        }

        public Criteria andLshEqualTo(String value) {
            addCriterion("lsh =", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshNotEqualTo(String value) {
            addCriterion("lsh <>", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshGreaterThan(String value) {
            addCriterion("lsh >", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshGreaterThanOrEqualTo(String value) {
            addCriterion("lsh >=", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshLessThan(String value) {
            addCriterion("lsh <", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshLessThanOrEqualTo(String value) {
            addCriterion("lsh <=", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshLike(String value) {
            addCriterion("lsh like", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshNotLike(String value) {
            addCriterion("lsh not like", value, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshIn(List<String> values) {
            addCriterion("lsh in", values, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshNotIn(List<String> values) {
            addCriterion("lsh not in", values, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshBetween(String value1, String value2) {
            addCriterion("lsh between", value1, value2, "lsh");
            return (Criteria) this;
        }

        public Criteria andLshNotBetween(String value1, String value2) {
            addCriterion("lsh not between", value1, value2, "lsh");
            return (Criteria) this;
        }

        public Criteria andYbmcaIsNull() {
            addCriterion("ybmca is null");
            return (Criteria) this;
        }

        public Criteria andYbmcaIsNotNull() {
            addCriterion("ybmca is not null");
            return (Criteria) this;
        }

        public Criteria andYbmcaEqualTo(String value) {
            addCriterion("ybmca =", value, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbmcaNotEqualTo(String value) {
            addCriterion("ybmca <>", value, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbmcaGreaterThan(String value) {
            addCriterion("ybmca >", value, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbmcaGreaterThanOrEqualTo(String value) {
            addCriterion("ybmca >=", value, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbmcaLessThan(String value) {
            addCriterion("ybmca <", value, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbmcaLessThanOrEqualTo(String value) {
            addCriterion("ybmca <=", value, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbmcaLike(String value) {
            addCriterion("ybmca like", value, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbmcaNotLike(String value) {
            addCriterion("ybmca not like", value, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbmcaIn(List<String> values) {
            addCriterion("ybmca in", values, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbmcaNotIn(List<String> values) {
            addCriterion("ybmca not in", values, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbmcaBetween(String value1, String value2) {
            addCriterion("ybmca between", value1, value2, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbmcaNotBetween(String value1, String value2) {
            addCriterion("ybmca not between", value1, value2, "ybmca");
            return (Criteria) this;
        }

        public Criteria andYbzdaIsNull() {
            addCriterion("ybzda is null");
            return (Criteria) this;
        }

        public Criteria andYbzdaIsNotNull() {
            addCriterion("ybzda is not null");
            return (Criteria) this;
        }

        public Criteria andYbzdaEqualTo(String value) {
            addCriterion("ybzda =", value, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbzdaNotEqualTo(String value) {
            addCriterion("ybzda <>", value, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbzdaGreaterThan(String value) {
            addCriterion("ybzda >", value, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbzdaGreaterThanOrEqualTo(String value) {
            addCriterion("ybzda >=", value, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbzdaLessThan(String value) {
            addCriterion("ybzda <", value, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbzdaLessThanOrEqualTo(String value) {
            addCriterion("ybzda <=", value, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbzdaLike(String value) {
            addCriterion("ybzda like", value, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbzdaNotLike(String value) {
            addCriterion("ybzda not like", value, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbzdaIn(List<String> values) {
            addCriterion("ybzda in", values, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbzdaNotIn(List<String> values) {
            addCriterion("ybzda not in", values, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbzdaBetween(String value1, String value2) {
            addCriterion("ybzda between", value1, value2, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbzdaNotBetween(String value1, String value2) {
            addCriterion("ybzda not between", value1, value2, "ybzda");
            return (Criteria) this;
        }

        public Criteria andYbmcbIsNull() {
            addCriterion("ybmcb is null");
            return (Criteria) this;
        }

        public Criteria andYbmcbIsNotNull() {
            addCriterion("ybmcb is not null");
            return (Criteria) this;
        }

        public Criteria andYbmcbEqualTo(String value) {
            addCriterion("ybmcb =", value, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbmcbNotEqualTo(String value) {
            addCriterion("ybmcb <>", value, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbmcbGreaterThan(String value) {
            addCriterion("ybmcb >", value, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbmcbGreaterThanOrEqualTo(String value) {
            addCriterion("ybmcb >=", value, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbmcbLessThan(String value) {
            addCriterion("ybmcb <", value, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbmcbLessThanOrEqualTo(String value) {
            addCriterion("ybmcb <=", value, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbmcbLike(String value) {
            addCriterion("ybmcb like", value, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbmcbNotLike(String value) {
            addCriterion("ybmcb not like", value, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbmcbIn(List<String> values) {
            addCriterion("ybmcb in", values, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbmcbNotIn(List<String> values) {
            addCriterion("ybmcb not in", values, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbmcbBetween(String value1, String value2) {
            addCriterion("ybmcb between", value1, value2, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbmcbNotBetween(String value1, String value2) {
            addCriterion("ybmcb not between", value1, value2, "ybmcb");
            return (Criteria) this;
        }

        public Criteria andYbzdbIsNull() {
            addCriterion("ybzdb is null");
            return (Criteria) this;
        }

        public Criteria andYbzdbIsNotNull() {
            addCriterion("ybzdb is not null");
            return (Criteria) this;
        }

        public Criteria andYbzdbEqualTo(String value) {
            addCriterion("ybzdb =", value, "ybzdb");
            return (Criteria) this;
        }

        public Criteria andYbzdbNotEqualTo(String value) {
            addCriterion("ybzdb <>", value, "ybzdb");
            return (Criteria) this;
        }

        public Criteria andYbzdbGreaterThan(String value) {
            addCriterion("ybzdb >", value, "ybzdb");
            return (Criteria) this;
        }

        public Criteria andYbzdbGreaterThanOrEqualTo(String value) {
            addCriterion("ybzdb >=", value, "ybzdb");
            return (Criteria) this;
        }

        public Criteria andYbzdbLessThan(String value) {
            addCriterion("ybzdb <", value, "ybzdb");
            return (Criteria) this;
        }

        public Criteria andYbzdbLessThanOrEqualTo(String value) {
            addCriterion("ybzdb <=", value, "ybzdb");
            return (Criteria) this;
        }

        public Criteria andYbzdbLike(String value) {
            addCriterion("ybzdb like", value, "ybzdb");
            return (Criteria) this;
        }

        public Criteria andYbzdbNotLike(String value) {
            addCriterion("ybzdb not like", value, "ybzdb");
            return (Criteria) this;
        }

        public Criteria andYbzdbIn(List<String> values) {
            addCriterion("ybzdb in", values, "ybzdb");
            return (Criteria) this;
        }

        public Criteria andYbzdbNotIn(List<String> values) {
            addCriterion("ybzdb not in", values, "ybzdb");
            return (Criteria) this;
        }

        public Criteria andYbzdbBetween(String value1, String value2) {
            addCriterion("ybzdb between", value1, value2, "ybzdb");
            return (Criteria) this;
        }

        public Criteria andYbzdbNotBetween(String value1, String value2) {
            addCriterion("ybzdb not between", value1, value2, "ybzdb");
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
     * This class corresponds to the database table xtpz_sjglys_gxh
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
     * This class corresponds to the database table xtpz_sjglys_gxh
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