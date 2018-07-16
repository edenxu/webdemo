package cn.com.gxbolian.databank.entity;

import java.util.ArrayList;
import java.util.List;

public class XtpzBzhzjpzScExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	public XtpzBzhzjpzScExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz_sc
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_bzhzjpz_sc
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table xtpz_bzhzjpz_sc
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

		public Criteria andBzhlshIsNull() {
			addCriterion("bzhlsh is null");
			return (Criteria) this;
		}

		public Criteria andBzhlshIsNotNull() {
			addCriterion("bzhlsh is not null");
			return (Criteria) this;
		}

		public Criteria andBzhlshEqualTo(String value) {
			addCriterion("bzhlsh =", value, "bzhlsh");
			return (Criteria) this;
		}

		public Criteria andBzhlshNotEqualTo(String value) {
			addCriterion("bzhlsh <>", value, "bzhlsh");
			return (Criteria) this;
		}

		public Criteria andBzhlshGreaterThan(String value) {
			addCriterion("bzhlsh >", value, "bzhlsh");
			return (Criteria) this;
		}

		public Criteria andBzhlshGreaterThanOrEqualTo(String value) {
			addCriterion("bzhlsh >=", value, "bzhlsh");
			return (Criteria) this;
		}

		public Criteria andBzhlshLessThan(String value) {
			addCriterion("bzhlsh <", value, "bzhlsh");
			return (Criteria) this;
		}

		public Criteria andBzhlshLessThanOrEqualTo(String value) {
			addCriterion("bzhlsh <=", value, "bzhlsh");
			return (Criteria) this;
		}

		public Criteria andBzhlshLike(String value) {
			addCriterion("bzhlsh like", value, "bzhlsh");
			return (Criteria) this;
		}

		public Criteria andBzhlshNotLike(String value) {
			addCriterion("bzhlsh not like", value, "bzhlsh");
			return (Criteria) this;
		}

		public Criteria andBzhlshIn(List<String> values) {
			addCriterion("bzhlsh in", values, "bzhlsh");
			return (Criteria) this;
		}

		public Criteria andBzhlshNotIn(List<String> values) {
			addCriterion("bzhlsh not in", values, "bzhlsh");
			return (Criteria) this;
		}

		public Criteria andBzhlshBetween(String value1, String value2) {
			addCriterion("bzhlsh between", value1, value2, "bzhlsh");
			return (Criteria) this;
		}

		public Criteria andBzhlshNotBetween(String value1, String value2) {
			addCriterion("bzhlsh not between", value1, value2, "bzhlsh");
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

		public Criteria andXlzdbmIsNull() {
			addCriterion("xlzdbm is null");
			return (Criteria) this;
		}

		public Criteria andXlzdbmIsNotNull() {
			addCriterion("xlzdbm is not null");
			return (Criteria) this;
		}

		public Criteria andXlzdbmEqualTo(String value) {
			addCriterion("xlzdbm =", value, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andXlzdbmNotEqualTo(String value) {
			addCriterion("xlzdbm <>", value, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andXlzdbmGreaterThan(String value) {
			addCriterion("xlzdbm >", value, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andXlzdbmGreaterThanOrEqualTo(String value) {
			addCriterion("xlzdbm >=", value, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andXlzdbmLessThan(String value) {
			addCriterion("xlzdbm <", value, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andXlzdbmLessThanOrEqualTo(String value) {
			addCriterion("xlzdbm <=", value, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andXlzdbmLike(String value) {
			addCriterion("xlzdbm like", value, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andXlzdbmNotLike(String value) {
			addCriterion("xlzdbm not like", value, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andXlzdbmIn(List<String> values) {
			addCriterion("xlzdbm in", values, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andXlzdbmNotIn(List<String> values) {
			addCriterion("xlzdbm not in", values, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andXlzdbmBetween(String value1, String value2) {
			addCriterion("xlzdbm between", value1, value2, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andXlzdbmNotBetween(String value1, String value2) {
			addCriterion("xlzdbm not between", value1, value2, "xlzdbm");
			return (Criteria) this;
		}

		public Criteria andZjbzIsNull() {
			addCriterion("zjbz is null");
			return (Criteria) this;
		}

		public Criteria andZjbzIsNotNull() {
			addCriterion("zjbz is not null");
			return (Criteria) this;
		}

		public Criteria andZjbzEqualTo(String value) {
			addCriterion("zjbz =", value, "zjbz");
			return (Criteria) this;
		}

		public Criteria andZjbzNotEqualTo(String value) {
			addCriterion("zjbz <>", value, "zjbz");
			return (Criteria) this;
		}

		public Criteria andZjbzGreaterThan(String value) {
			addCriterion("zjbz >", value, "zjbz");
			return (Criteria) this;
		}

		public Criteria andZjbzGreaterThanOrEqualTo(String value) {
			addCriterion("zjbz >=", value, "zjbz");
			return (Criteria) this;
		}

		public Criteria andZjbzLessThan(String value) {
			addCriterion("zjbz <", value, "zjbz");
			return (Criteria) this;
		}

		public Criteria andZjbzLessThanOrEqualTo(String value) {
			addCriterion("zjbz <=", value, "zjbz");
			return (Criteria) this;
		}

		public Criteria andZjbzLike(String value) {
			addCriterion("zjbz like", value, "zjbz");
			return (Criteria) this;
		}

		public Criteria andZjbzNotLike(String value) {
			addCriterion("zjbz not like", value, "zjbz");
			return (Criteria) this;
		}

		public Criteria andZjbzIn(List<String> values) {
			addCriterion("zjbz in", values, "zjbz");
			return (Criteria) this;
		}

		public Criteria andZjbzNotIn(List<String> values) {
			addCriterion("zjbz not in", values, "zjbz");
			return (Criteria) this;
		}

		public Criteria andZjbzBetween(String value1, String value2) {
			addCriterion("zjbz between", value1, value2, "zjbz");
			return (Criteria) this;
		}

		public Criteria andZjbzNotBetween(String value1, String value2) {
			addCriterion("zjbz not between", value1, value2, "zjbz");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table xtpz_bzhzjpz_sc
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table xtpz_bzhzjpz_sc
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}