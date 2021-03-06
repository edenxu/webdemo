package cn.com.gxbolian.databank.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XtpzCxfaExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	public XtpzCxfaExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table xtpz_cxfa
	 * @mbg.generated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table xtpz_cxfa
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

		public Criteria andMcIsNull() {
			addCriterion("mc is null");
			return (Criteria) this;
		}

		public Criteria andMcIsNotNull() {
			addCriterion("mc is not null");
			return (Criteria) this;
		}

		public Criteria andMcEqualTo(String value) {
			addCriterion("mc =", value, "mc");
			return (Criteria) this;
		}

		public Criteria andMcNotEqualTo(String value) {
			addCriterion("mc <>", value, "mc");
			return (Criteria) this;
		}

		public Criteria andMcGreaterThan(String value) {
			addCriterion("mc >", value, "mc");
			return (Criteria) this;
		}

		public Criteria andMcGreaterThanOrEqualTo(String value) {
			addCriterion("mc >=", value, "mc");
			return (Criteria) this;
		}

		public Criteria andMcLessThan(String value) {
			addCriterion("mc <", value, "mc");
			return (Criteria) this;
		}

		public Criteria andMcLessThanOrEqualTo(String value) {
			addCriterion("mc <=", value, "mc");
			return (Criteria) this;
		}

		public Criteria andMcLike(String value) {
			addCriterion("mc like", value, "mc");
			return (Criteria) this;
		}

		public Criteria andMcNotLike(String value) {
			addCriterion("mc not like", value, "mc");
			return (Criteria) this;
		}

		public Criteria andMcIn(List<String> values) {
			addCriterion("mc in", values, "mc");
			return (Criteria) this;
		}

		public Criteria andMcNotIn(List<String> values) {
			addCriterion("mc not in", values, "mc");
			return (Criteria) this;
		}

		public Criteria andMcBetween(String value1, String value2) {
			addCriterion("mc between", value1, value2, "mc");
			return (Criteria) this;
		}

		public Criteria andMcNotBetween(String value1, String value2) {
			addCriterion("mc not between", value1, value2, "mc");
			return (Criteria) this;
		}

		public Criteria andMsIsNull() {
			addCriterion("ms is null");
			return (Criteria) this;
		}

		public Criteria andMsIsNotNull() {
			addCriterion("ms is not null");
			return (Criteria) this;
		}

		public Criteria andMsEqualTo(String value) {
			addCriterion("ms =", value, "ms");
			return (Criteria) this;
		}

		public Criteria andMsNotEqualTo(String value) {
			addCriterion("ms <>", value, "ms");
			return (Criteria) this;
		}

		public Criteria andMsGreaterThan(String value) {
			addCriterion("ms >", value, "ms");
			return (Criteria) this;
		}

		public Criteria andMsGreaterThanOrEqualTo(String value) {
			addCriterion("ms >=", value, "ms");
			return (Criteria) this;
		}

		public Criteria andMsLessThan(String value) {
			addCriterion("ms <", value, "ms");
			return (Criteria) this;
		}

		public Criteria andMsLessThanOrEqualTo(String value) {
			addCriterion("ms <=", value, "ms");
			return (Criteria) this;
		}

		public Criteria andMsLike(String value) {
			addCriterion("ms like", value, "ms");
			return (Criteria) this;
		}

		public Criteria andMsNotLike(String value) {
			addCriterion("ms not like", value, "ms");
			return (Criteria) this;
		}

		public Criteria andMsIn(List<String> values) {
			addCriterion("ms in", values, "ms");
			return (Criteria) this;
		}

		public Criteria andMsNotIn(List<String> values) {
			addCriterion("ms not in", values, "ms");
			return (Criteria) this;
		}

		public Criteria andMsBetween(String value1, String value2) {
			addCriterion("ms between", value1, value2, "ms");
			return (Criteria) this;
		}

		public Criteria andMsNotBetween(String value1, String value2) {
			addCriterion("ms not between", value1, value2, "ms");
			return (Criteria) this;
		}

		public Criteria andCxzdIsNull() {
			addCriterion("cxzd is null");
			return (Criteria) this;
		}

		public Criteria andCxzdIsNotNull() {
			addCriterion("cxzd is not null");
			return (Criteria) this;
		}

		public Criteria andCxzdEqualTo(String value) {
			addCriterion("cxzd =", value, "cxzd");
			return (Criteria) this;
		}

		public Criteria andCxzdNotEqualTo(String value) {
			addCriterion("cxzd <>", value, "cxzd");
			return (Criteria) this;
		}

		public Criteria andCxzdGreaterThan(String value) {
			addCriterion("cxzd >", value, "cxzd");
			return (Criteria) this;
		}

		public Criteria andCxzdGreaterThanOrEqualTo(String value) {
			addCriterion("cxzd >=", value, "cxzd");
			return (Criteria) this;
		}

		public Criteria andCxzdLessThan(String value) {
			addCriterion("cxzd <", value, "cxzd");
			return (Criteria) this;
		}

		public Criteria andCxzdLessThanOrEqualTo(String value) {
			addCriterion("cxzd <=", value, "cxzd");
			return (Criteria) this;
		}

		public Criteria andCxzdLike(String value) {
			addCriterion("cxzd like", value, "cxzd");
			return (Criteria) this;
		}

		public Criteria andCxzdNotLike(String value) {
			addCriterion("cxzd not like", value, "cxzd");
			return (Criteria) this;
		}

		public Criteria andCxzdIn(List<String> values) {
			addCriterion("cxzd in", values, "cxzd");
			return (Criteria) this;
		}

		public Criteria andCxzdNotIn(List<String> values) {
			addCriterion("cxzd not in", values, "cxzd");
			return (Criteria) this;
		}

		public Criteria andCxzdBetween(String value1, String value2) {
			addCriterion("cxzd between", value1, value2, "cxzd");
			return (Criteria) this;
		}

		public Criteria andCxzdNotBetween(String value1, String value2) {
			addCriterion("cxzd not between", value1, value2, "cxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdIsNull() {
			addCriterion("sxzd is null");
			return (Criteria) this;
		}

		public Criteria andSxzdIsNotNull() {
			addCriterion("sxzd is not null");
			return (Criteria) this;
		}

		public Criteria andSxzdEqualTo(String value) {
			addCriterion("sxzd =", value, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdNotEqualTo(String value) {
			addCriterion("sxzd <>", value, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdGreaterThan(String value) {
			addCriterion("sxzd >", value, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdGreaterThanOrEqualTo(String value) {
			addCriterion("sxzd >=", value, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdLessThan(String value) {
			addCriterion("sxzd <", value, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdLessThanOrEqualTo(String value) {
			addCriterion("sxzd <=", value, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdLike(String value) {
			addCriterion("sxzd like", value, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdNotLike(String value) {
			addCriterion("sxzd not like", value, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdIn(List<String> values) {
			addCriterion("sxzd in", values, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdNotIn(List<String> values) {
			addCriterion("sxzd not in", values, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdBetween(String value1, String value2) {
			addCriterion("sxzd between", value1, value2, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxzdNotBetween(String value1, String value2) {
			addCriterion("sxzd not between", value1, value2, "sxzd");
			return (Criteria) this;
		}

		public Criteria andSxszIsNull() {
			addCriterion("sxsz is null");
			return (Criteria) this;
		}

		public Criteria andSxszIsNotNull() {
			addCriterion("sxsz is not null");
			return (Criteria) this;
		}

		public Criteria andSxszEqualTo(String value) {
			addCriterion("sxsz =", value, "sxsz");
			return (Criteria) this;
		}

		public Criteria andSxszNotEqualTo(String value) {
			addCriterion("sxsz <>", value, "sxsz");
			return (Criteria) this;
		}

		public Criteria andSxszGreaterThan(String value) {
			addCriterion("sxsz >", value, "sxsz");
			return (Criteria) this;
		}

		public Criteria andSxszGreaterThanOrEqualTo(String value) {
			addCriterion("sxsz >=", value, "sxsz");
			return (Criteria) this;
		}

		public Criteria andSxszLessThan(String value) {
			addCriterion("sxsz <", value, "sxsz");
			return (Criteria) this;
		}

		public Criteria andSxszLessThanOrEqualTo(String value) {
			addCriterion("sxsz <=", value, "sxsz");
			return (Criteria) this;
		}

		public Criteria andSxszLike(String value) {
			addCriterion("sxsz like", value, "sxsz");
			return (Criteria) this;
		}

		public Criteria andSxszNotLike(String value) {
			addCriterion("sxsz not like", value, "sxsz");
			return (Criteria) this;
		}

		public Criteria andSxszIn(List<String> values) {
			addCriterion("sxsz in", values, "sxsz");
			return (Criteria) this;
		}

		public Criteria andSxszNotIn(List<String> values) {
			addCriterion("sxsz not in", values, "sxsz");
			return (Criteria) this;
		}

		public Criteria andSxszBetween(String value1, String value2) {
			addCriterion("sxsz between", value1, value2, "sxsz");
			return (Criteria) this;
		}

		public Criteria andSxszNotBetween(String value1, String value2) {
			addCriterion("sxsz not between", value1, value2, "sxsz");
			return (Criteria) this;
		}

		public Criteria andGjsxIsNull() {
			addCriterion("gjsx is null");
			return (Criteria) this;
		}

		public Criteria andGjsxIsNotNull() {
			addCriterion("gjsx is not null");
			return (Criteria) this;
		}

		public Criteria andGjsxEqualTo(String value) {
			addCriterion("gjsx =", value, "gjsx");
			return (Criteria) this;
		}

		public Criteria andGjsxNotEqualTo(String value) {
			addCriterion("gjsx <>", value, "gjsx");
			return (Criteria) this;
		}

		public Criteria andGjsxGreaterThan(String value) {
			addCriterion("gjsx >", value, "gjsx");
			return (Criteria) this;
		}

		public Criteria andGjsxGreaterThanOrEqualTo(String value) {
			addCriterion("gjsx >=", value, "gjsx");
			return (Criteria) this;
		}

		public Criteria andGjsxLessThan(String value) {
			addCriterion("gjsx <", value, "gjsx");
			return (Criteria) this;
		}

		public Criteria andGjsxLessThanOrEqualTo(String value) {
			addCriterion("gjsx <=", value, "gjsx");
			return (Criteria) this;
		}

		public Criteria andGjsxLike(String value) {
			addCriterion("gjsx like", value, "gjsx");
			return (Criteria) this;
		}

		public Criteria andGjsxNotLike(String value) {
			addCriterion("gjsx not like", value, "gjsx");
			return (Criteria) this;
		}

		public Criteria andGjsxIn(List<String> values) {
			addCriterion("gjsx in", values, "gjsx");
			return (Criteria) this;
		}

		public Criteria andGjsxNotIn(List<String> values) {
			addCriterion("gjsx not in", values, "gjsx");
			return (Criteria) this;
		}

		public Criteria andGjsxBetween(String value1, String value2) {
			addCriterion("gjsx between", value1, value2, "gjsx");
			return (Criteria) this;
		}

		public Criteria andGjsxNotBetween(String value1, String value2) {
			addCriterion("gjsx not between", value1, value2, "gjsx");
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

		public Criteria andCjsjIsNull() {
			addCriterion("cjsj is null");
			return (Criteria) this;
		}

		public Criteria andCjsjIsNotNull() {
			addCriterion("cjsj is not null");
			return (Criteria) this;
		}

		public Criteria andCjsjEqualTo(Date value) {
			addCriterion("cjsj =", value, "cjsj");
			return (Criteria) this;
		}

		public Criteria andCjsjNotEqualTo(Date value) {
			addCriterion("cjsj <>", value, "cjsj");
			return (Criteria) this;
		}

		public Criteria andCjsjGreaterThan(Date value) {
			addCriterion("cjsj >", value, "cjsj");
			return (Criteria) this;
		}

		public Criteria andCjsjGreaterThanOrEqualTo(Date value) {
			addCriterion("cjsj >=", value, "cjsj");
			return (Criteria) this;
		}

		public Criteria andCjsjLessThan(Date value) {
			addCriterion("cjsj <", value, "cjsj");
			return (Criteria) this;
		}

		public Criteria andCjsjLessThanOrEqualTo(Date value) {
			addCriterion("cjsj <=", value, "cjsj");
			return (Criteria) this;
		}

		public Criteria andCjsjIn(List<Date> values) {
			addCriterion("cjsj in", values, "cjsj");
			return (Criteria) this;
		}

		public Criteria andCjsjNotIn(List<Date> values) {
			addCriterion("cjsj not in", values, "cjsj");
			return (Criteria) this;
		}

		public Criteria andCjsjBetween(Date value1, Date value2) {
			addCriterion("cjsj between", value1, value2, "cjsj");
			return (Criteria) this;
		}

		public Criteria andCjsjNotBetween(Date value1, Date value2) {
			addCriterion("cjsj not between", value1, value2, "cjsj");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table xtpz_cxfa
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
     * This class corresponds to the database table xtpz_cxfa
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}