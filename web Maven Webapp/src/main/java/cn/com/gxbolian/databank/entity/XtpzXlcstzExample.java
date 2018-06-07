package cn.com.gxbolian.databank.entity;

import java.util.ArrayList;
import java.util.List;

public class XtpzXlcstzExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table xtpz_xlcstz
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table xtpz_xlcstz
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table xtpz_xlcstz
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_xlcstz
     *
     * @mbg.generated
     */
    public XtpzXlcstzExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_xlcstz
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_xlcstz
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_xlcstz
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_xlcstz
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_xlcstz
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_xlcstz
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_xlcstz
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
     * This method corresponds to the database table xtpz_xlcstz
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
     * This method corresponds to the database table xtpz_xlcstz
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table xtpz_xlcstz
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
     * This class corresponds to the database table xtpz_xlcstz
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

        public Criteria andZblshIsNull() {
            addCriterion("zblsh is null");
            return (Criteria) this;
        }

        public Criteria andZblshIsNotNull() {
            addCriterion("zblsh is not null");
            return (Criteria) this;
        }

        public Criteria andZblshEqualTo(String value) {
            addCriterion("zblsh =", value, "zblsh");
            return (Criteria) this;
        }

        public Criteria andZblshNotEqualTo(String value) {
            addCriterion("zblsh <>", value, "zblsh");
            return (Criteria) this;
        }

        public Criteria andZblshGreaterThan(String value) {
            addCriterion("zblsh >", value, "zblsh");
            return (Criteria) this;
        }

        public Criteria andZblshGreaterThanOrEqualTo(String value) {
            addCriterion("zblsh >=", value, "zblsh");
            return (Criteria) this;
        }

        public Criteria andZblshLessThan(String value) {
            addCriterion("zblsh <", value, "zblsh");
            return (Criteria) this;
        }

        public Criteria andZblshLessThanOrEqualTo(String value) {
            addCriterion("zblsh <=", value, "zblsh");
            return (Criteria) this;
        }

        public Criteria andZblshLike(String value) {
            addCriterion("zblsh like", value, "zblsh");
            return (Criteria) this;
        }

        public Criteria andZblshNotLike(String value) {
            addCriterion("zblsh not like", value, "zblsh");
            return (Criteria) this;
        }

        public Criteria andZblshIn(List<String> values) {
            addCriterion("zblsh in", values, "zblsh");
            return (Criteria) this;
        }

        public Criteria andZblshNotIn(List<String> values) {
            addCriterion("zblsh not in", values, "zblsh");
            return (Criteria) this;
        }

        public Criteria andZblshBetween(String value1, String value2) {
            addCriterion("zblsh between", value1, value2, "zblsh");
            return (Criteria) this;
        }

        public Criteria andZblshNotBetween(String value1, String value2) {
            addCriterion("zblsh not between", value1, value2, "zblsh");
            return (Criteria) this;
        }

        public Criteria andXszIsNull() {
            addCriterion("xsz is null");
            return (Criteria) this;
        }

        public Criteria andXszIsNotNull() {
            addCriterion("xsz is not null");
            return (Criteria) this;
        }

        public Criteria andXszEqualTo(String value) {
            addCriterion("xsz =", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszNotEqualTo(String value) {
            addCriterion("xsz <>", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszGreaterThan(String value) {
            addCriterion("xsz >", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszGreaterThanOrEqualTo(String value) {
            addCriterion("xsz >=", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszLessThan(String value) {
            addCriterion("xsz <", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszLessThanOrEqualTo(String value) {
            addCriterion("xsz <=", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszLike(String value) {
            addCriterion("xsz like", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszNotLike(String value) {
            addCriterion("xsz not like", value, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszIn(List<String> values) {
            addCriterion("xsz in", values, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszNotIn(List<String> values) {
            addCriterion("xsz not in", values, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszBetween(String value1, String value2) {
            addCriterion("xsz between", value1, value2, "xsz");
            return (Criteria) this;
        }

        public Criteria andXszNotBetween(String value1, String value2) {
            addCriterion("xsz not between", value1, value2, "xsz");
            return (Criteria) this;
        }

        public Criteria andSjzIsNull() {
            addCriterion("sjz is null");
            return (Criteria) this;
        }

        public Criteria andSjzIsNotNull() {
            addCriterion("sjz is not null");
            return (Criteria) this;
        }

        public Criteria andSjzEqualTo(String value) {
            addCriterion("sjz =", value, "sjz");
            return (Criteria) this;
        }

        public Criteria andSjzNotEqualTo(String value) {
            addCriterion("sjz <>", value, "sjz");
            return (Criteria) this;
        }

        public Criteria andSjzGreaterThan(String value) {
            addCriterion("sjz >", value, "sjz");
            return (Criteria) this;
        }

        public Criteria andSjzGreaterThanOrEqualTo(String value) {
            addCriterion("sjz >=", value, "sjz");
            return (Criteria) this;
        }

        public Criteria andSjzLessThan(String value) {
            addCriterion("sjz <", value, "sjz");
            return (Criteria) this;
        }

        public Criteria andSjzLessThanOrEqualTo(String value) {
            addCriterion("sjz <=", value, "sjz");
            return (Criteria) this;
        }

        public Criteria andSjzLike(String value) {
            addCriterion("sjz like", value, "sjz");
            return (Criteria) this;
        }

        public Criteria andSjzNotLike(String value) {
            addCriterion("sjz not like", value, "sjz");
            return (Criteria) this;
        }

        public Criteria andSjzIn(List<String> values) {
            addCriterion("sjz in", values, "sjz");
            return (Criteria) this;
        }

        public Criteria andSjzNotIn(List<String> values) {
            addCriterion("sjz not in", values, "sjz");
            return (Criteria) this;
        }

        public Criteria andSjzBetween(String value1, String value2) {
            addCriterion("sjz between", value1, value2, "sjz");
            return (Criteria) this;
        }

        public Criteria andSjzNotBetween(String value1, String value2) {
            addCriterion("sjz not between", value1, value2, "sjz");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table xtpz_xlcstz
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
     * This class corresponds to the database table xtpz_xlcstz
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