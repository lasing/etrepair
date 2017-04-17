package com.liveneo.etrepair.pojo;

import com.liveneo.etrepair.common.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScoreDetailExample {
    protected String         orderByClause;
    protected boolean        distinct;
    protected List<Criteria> oredCriteria;
    protected Page           page;

    public ScoreDetailExample() {
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

        public Criteria andScoreDetailIdIsNull() {
            addCriterion("score_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdIsNotNull() {
            addCriterion("score_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdEqualTo(String value) {
            addCriterion("score_detail_id =", value, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdNotEqualTo(String value) {
            addCriterion("score_detail_id <>", value, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdGreaterThan(String value) {
            addCriterion("score_detail_id >", value, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("score_detail_id >=", value, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdLessThan(String value) {
            addCriterion("score_detail_id <", value, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdLessThanOrEqualTo(String value) {
            addCriterion("score_detail_id <=", value, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdLike(String value) {
            addCriterion("score_detail_id like", value, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdNotLike(String value) {
            addCriterion("score_detail_id not like", value, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdIn(List<String> values) {
            addCriterion("score_detail_id in", values, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdNotIn(List<String> values) {
            addCriterion("score_detail_id not in", values, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdBetween(String value1, String value2) {
            addCriterion("score_detail_id between", value1, value2, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andScoreDetailIdNotBetween(String value1, String value2) {
            addCriterion("score_detail_id not between", value1, value2, "scoreDetailId");
            return (Criteria) this;
        }

        public Criteria andEvIdIsNull() {
            addCriterion("ev_id is null");
            return (Criteria) this;
        }

        public Criteria andEvIdIsNotNull() {
            addCriterion("ev_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvIdEqualTo(String value) {
            addCriterion("ev_id =", value, "evId");
            return (Criteria) this;
        }

        public Criteria andEvIdNotEqualTo(String value) {
            addCriterion("ev_id <>", value, "evId");
            return (Criteria) this;
        }

        public Criteria andEvIdGreaterThan(String value) {
            addCriterion("ev_id >", value, "evId");
            return (Criteria) this;
        }

        public Criteria andEvIdGreaterThanOrEqualTo(String value) {
            addCriterion("ev_id >=", value, "evId");
            return (Criteria) this;
        }

        public Criteria andEvIdLessThan(String value) {
            addCriterion("ev_id <", value, "evId");
            return (Criteria) this;
        }

        public Criteria andEvIdLessThanOrEqualTo(String value) {
            addCriterion("ev_id <=", value, "evId");
            return (Criteria) this;
        }

        public Criteria andEvIdLike(String value) {
            addCriterion("ev_id like", value, "evId");
            return (Criteria) this;
        }

        public Criteria andEvIdNotLike(String value) {
            addCriterion("ev_id not like", value, "evId");
            return (Criteria) this;
        }

        public Criteria andEvIdIn(List<String> values) {
            addCriterion("ev_id in", values, "evId");
            return (Criteria) this;
        }

        public Criteria andEvIdNotIn(List<String> values) {
            addCriterion("ev_id not in", values, "evId");
            return (Criteria) this;
        }

        public Criteria andEvIdBetween(String value1, String value2) {
            addCriterion("ev_id between", value1, value2, "evId");
            return (Criteria) this;
        }

        public Criteria andEvIdNotBetween(String value1, String value2) {
            addCriterion("ev_id not between", value1, value2, "evId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdIsNull() {
            addCriterion("ev_item_id is null");
            return (Criteria) this;
        }

        public Criteria andEvItemIdIsNotNull() {
            addCriterion("ev_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvItemIdEqualTo(String value) {
            addCriterion("ev_item_id =", value, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdNotEqualTo(String value) {
            addCriterion("ev_item_id <>", value, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdGreaterThan(String value) {
            addCriterion("ev_item_id >", value, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("ev_item_id >=", value, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdLessThan(String value) {
            addCriterion("ev_item_id <", value, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdLessThanOrEqualTo(String value) {
            addCriterion("ev_item_id <=", value, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdLike(String value) {
            addCriterion("ev_item_id like", value, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdNotLike(String value) {
            addCriterion("ev_item_id not like", value, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdIn(List<String> values) {
            addCriterion("ev_item_id in", values, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdNotIn(List<String> values) {
            addCriterion("ev_item_id not in", values, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdBetween(String value1, String value2) {
            addCriterion("ev_item_id between", value1, value2, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvItemIdNotBetween(String value1, String value2) {
            addCriterion("ev_item_id not between", value1, value2, "evItemId");
            return (Criteria) this;
        }

        public Criteria andEvScoreIsNull() {
            addCriterion("ev_score is null");
            return (Criteria) this;
        }

        public Criteria andEvScoreIsNotNull() {
            addCriterion("ev_score is not null");
            return (Criteria) this;
        }

        public Criteria andEvScoreEqualTo(Byte value) {
            addCriterion("ev_score =", value, "evScore");
            return (Criteria) this;
        }

        public Criteria andEvScoreNotEqualTo(Byte value) {
            addCriterion("ev_score <>", value, "evScore");
            return (Criteria) this;
        }

        public Criteria andEvScoreGreaterThan(Byte value) {
            addCriterion("ev_score >", value, "evScore");
            return (Criteria) this;
        }

        public Criteria andEvScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("ev_score >=", value, "evScore");
            return (Criteria) this;
        }

        public Criteria andEvScoreLessThan(Byte value) {
            addCriterion("ev_score <", value, "evScore");
            return (Criteria) this;
        }

        public Criteria andEvScoreLessThanOrEqualTo(Byte value) {
            addCriterion("ev_score <=", value, "evScore");
            return (Criteria) this;
        }

        public Criteria andEvScoreIn(List<Byte> values) {
            addCriterion("ev_score in", values, "evScore");
            return (Criteria) this;
        }

        public Criteria andEvScoreNotIn(List<Byte> values) {
            addCriterion("ev_score not in", values, "evScore");
            return (Criteria) this;
        }

        public Criteria andEvScoreBetween(Byte value1, Byte value2) {
            addCriterion("ev_score between", value1, value2, "evScore");
            return (Criteria) this;
        }

        public Criteria andEvScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("ev_score not between", value1, value2, "evScore");
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