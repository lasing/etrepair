package com.liveneo.etrepair.pojo;

import com.liveneo.etrepair.common.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GarageReportExample {
    protected String         orderByClause;
    protected boolean        distinct;
    protected List<Criteria> oredCriteria;
    protected Page           page;

    public GarageReportExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Page getPage() {
        return page;
    }

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

        public Criteria andGarageIdIsNull() {
            addCriterion("garage_id is null");
            return (Criteria) this;
        }

        public Criteria andGarageIdIsNotNull() {
            addCriterion("garage_id is not null");
            return (Criteria) this;
        }

        public Criteria andGarageIdEqualTo(String value) {
            addCriterion("garage_id =", value, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageIdNotEqualTo(String value) {
            addCriterion("garage_id <>", value, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageIdGreaterThan(String value) {
            addCriterion("garage_id >", value, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageIdGreaterThanOrEqualTo(String value) {
            addCriterion("garage_id >=", value, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageIdLessThan(String value) {
            addCriterion("garage_id <", value, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageIdLessThanOrEqualTo(String value) {
            addCriterion("garage_id <=", value, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageIdLike(String value) {
            addCriterion("garage_id like", value, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageIdNotLike(String value) {
            addCriterion("garage_id not like", value, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageIdIn(List<String> values) {
            addCriterion("garage_id in", values, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageIdNotIn(List<String> values) {
            addCriterion("garage_id not in", values, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageIdBetween(String value1, String value2) {
            addCriterion("garage_id between", value1, value2, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageIdNotBetween(String value1, String value2) {
            addCriterion("garage_id not between", value1, value2, "garageId");
            return (Criteria) this;
        }

        public Criteria andGarageCodeIsNull() {
            addCriterion("garage_code is null");
            return (Criteria) this;
        }

        public Criteria andGarageCodeIsNotNull() {
            addCriterion("garage_code is not null");
            return (Criteria) this;
        }

        public Criteria andGarageCodeEqualTo(String value) {
            addCriterion("garage_code =", value, "garageCode");
            return (Criteria) this;
        }

        public Criteria andGarageCodeNotEqualTo(String value) {
            addCriterion("garage_code <>", value, "garageCode");
            return (Criteria) this;
        }

        public Criteria andGarageCodeGreaterThan(String value) {
            addCriterion("garage_code >", value, "garageCode");
            return (Criteria) this;
        }

        public Criteria andGarageCodeGreaterThanOrEqualTo(String value) {
            addCriterion("garage_code >=", value, "garageCode");
            return (Criteria) this;
        }

        public Criteria andGarageCodeLessThan(String value) {
            addCriterion("garage_code <", value, "garageCode");
            return (Criteria) this;
        }

        public Criteria andGarageCodeLessThanOrEqualTo(String value) {
            addCriterion("garage_code <=", value, "garageCode");
            return (Criteria) this;
        }

        public Criteria andGarageCodeLike(String value) {
            addCriterion("garage_code like", value, "garageCode");
            return (Criteria) this;
        }

        public Criteria andGarageCodeNotLike(String value) {
            addCriterion("garage_code not like", value, "garageCode");
            return (Criteria) this;
        }

        public Criteria andGarageCodeIn(List<String> values) {
            addCriterion("garage_code in", values, "garageCode");
            return (Criteria) this;
        }

        public Criteria andGarageCodeNotIn(List<String> values) {
            addCriterion("garage_code not in", values, "garageCode");
            return (Criteria) this;
        }

        public Criteria andGarageCodeBetween(String value1, String value2) {
            addCriterion("garage_code between", value1, value2, "garageCode");
            return (Criteria) this;
        }

        public Criteria andGarageCodeNotBetween(String value1, String value2) {
            addCriterion("garage_code not between", value1, value2, "garageCode");
            return (Criteria) this;
        }

        public Criteria andPaymentRateIsNull() {
            addCriterion("payment_rate is null");
            return (Criteria) this;
        }

        public Criteria andPaymentRateIsNotNull() {
            addCriterion("payment_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentRateEqualTo(Double value) {
            addCriterion("payment_rate =", value, "paymentRate");
            return (Criteria) this;
        }

        public Criteria andPaymentRateNotEqualTo(Double value) {
            addCriterion("payment_rate <>", value, "paymentRate");
            return (Criteria) this;
        }

        public Criteria andPaymentRateGreaterThan(Double value) {
            addCriterion("payment_rate >", value, "paymentRate");
            return (Criteria) this;
        }

        public Criteria andPaymentRateGreaterThanOrEqualTo(Double value) {
            addCriterion("payment_rate >=", value, "paymentRate");
            return (Criteria) this;
        }

        public Criteria andPaymentRateLessThan(Double value) {
            addCriterion("payment_rate <", value, "paymentRate");
            return (Criteria) this;
        }

        public Criteria andPaymentRateLessThanOrEqualTo(Double value) {
            addCriterion("payment_rate <=", value, "paymentRate");
            return (Criteria) this;
        }

        public Criteria andPaymentRateIn(List<Double> values) {
            addCriterion("payment_rate in", values, "paymentRate");
            return (Criteria) this;
        }

        public Criteria andPaymentRateNotIn(List<Double> values) {
            addCriterion("payment_rate not in", values, "paymentRate");
            return (Criteria) this;
        }

        public Criteria andPaymentRateBetween(Double value1, Double value2) {
            addCriterion("payment_rate between", value1, value2, "paymentRate");
            return (Criteria) this;
        }

        public Criteria andPaymentRateNotBetween(Double value1, Double value2) {
            addCriterion("payment_rate not between", value1, value2, "paymentRate");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumIsNull() {
            addCriterion("earned_premium is null");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumIsNotNull() {
            addCriterion("earned_premium is not null");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumEqualTo(Double value) {
            addCriterion("earned_premium =", value, "earnedPremium");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumNotEqualTo(Double value) {
            addCriterion("earned_premium <>", value, "earnedPremium");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumGreaterThan(Double value) {
            addCriterion("earned_premium >", value, "earnedPremium");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumGreaterThanOrEqualTo(Double value) {
            addCriterion("earned_premium >=", value, "earnedPremium");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumLessThan(Double value) {
            addCriterion("earned_premium <", value, "earnedPremium");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumLessThanOrEqualTo(Double value) {
            addCriterion("earned_premium <=", value, "earnedPremium");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumIn(List<Double> values) {
            addCriterion("earned_premium in", values, "earnedPremium");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumNotIn(List<Double> values) {
            addCriterion("earned_premium not in", values, "earnedPremium");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumBetween(Double value1, Double value2) {
            addCriterion("earned_premium between", value1, value2, "earnedPremium");
            return (Criteria) this;
        }

        public Criteria andEarnedPremiumNotBetween(Double value1, Double value2) {
            addCriterion("earned_premium not between", value1, value2, "earnedPremium");
            return (Criteria) this;
        }

        public Criteria andYearPremiumIsNull() {
            addCriterion("year_premium is null");
            return (Criteria) this;
        }

        public Criteria andYearPremiumIsNotNull() {
            addCriterion("year_premium is not null");
            return (Criteria) this;
        }

        public Criteria andYearPremiumEqualTo(Double value) {
            addCriterion("year_premium =", value, "yearPremium");
            return (Criteria) this;
        }

        public Criteria andYearPremiumNotEqualTo(Double value) {
            addCriterion("year_premium <>", value, "yearPremium");
            return (Criteria) this;
        }

        public Criteria andYearPremiumGreaterThan(Double value) {
            addCriterion("year_premium >", value, "yearPremium");
            return (Criteria) this;
        }

        public Criteria andYearPremiumGreaterThanOrEqualTo(Double value) {
            addCriterion("year_premium >=", value, "yearPremium");
            return (Criteria) this;
        }

        public Criteria andYearPremiumLessThan(Double value) {
            addCriterion("year_premium <", value, "yearPremium");
            return (Criteria) this;
        }

        public Criteria andYearPremiumLessThanOrEqualTo(Double value) {
            addCriterion("year_premium <=", value, "yearPremium");
            return (Criteria) this;
        }

        public Criteria andYearPremiumIn(List<Double> values) {
            addCriterion("year_premium in", values, "yearPremium");
            return (Criteria) this;
        }

        public Criteria andYearPremiumNotIn(List<Double> values) {
            addCriterion("year_premium not in", values, "yearPremium");
            return (Criteria) this;
        }

        public Criteria andYearPremiumBetween(Double value1, Double value2) {
            addCriterion("year_premium between", value1, value2, "yearPremium");
            return (Criteria) this;
        }

        public Criteria andYearPremiumNotBetween(Double value1, Double value2) {
            addCriterion("year_premium not between", value1, value2, "yearPremium");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountIsNull() {
            addCriterion("completion_amount is null");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountIsNotNull() {
            addCriterion("completion_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountEqualTo(Double value) {
            addCriterion("completion_amount =", value, "completionAmount");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountNotEqualTo(Double value) {
            addCriterion("completion_amount <>", value, "completionAmount");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountGreaterThan(Double value) {
            addCriterion("completion_amount >", value, "completionAmount");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("completion_amount >=", value, "completionAmount");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountLessThan(Double value) {
            addCriterion("completion_amount <", value, "completionAmount");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountLessThanOrEqualTo(Double value) {
            addCriterion("completion_amount <=", value, "completionAmount");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountIn(List<Double> values) {
            addCriterion("completion_amount in", values, "completionAmount");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountNotIn(List<Double> values) {
            addCriterion("completion_amount not in", values, "completionAmount");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountBetween(Double value1, Double value2) {
            addCriterion("completion_amount between", value1, value2, "completionAmount");
            return (Criteria) this;
        }

        public Criteria andCompletionAmountNotBetween(Double value1, Double value2) {
            addCriterion("completion_amount not between", value1, value2, "completionAmount");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String  condition;
        private Object  value;
        private Object  secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String  typeHandler;

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