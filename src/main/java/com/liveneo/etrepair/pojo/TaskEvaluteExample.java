package com.liveneo.etrepair.pojo;

import com.liveneo.etrepair.common.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskEvaluteExample {
    protected String         orderByClause;
    protected boolean        distinct;
    protected List<Criteria> oredCriteria;
    protected Page           page;

    public TaskEvaluteExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
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

        public Criteria andEvTimeIsNull() {
            addCriterion("ev_time is null");
            return (Criteria) this;
        }

        public Criteria andEvTimeIsNotNull() {
            addCriterion("ev_time is not null");
            return (Criteria) this;
        }

        public Criteria andEvTimeEqualTo(Date value) {
            addCriterion("ev_time =", value, "evTime");
            return (Criteria) this;
        }

        public Criteria andEvTimeNotEqualTo(Date value) {
            addCriterion("ev_time <>", value, "evTime");
            return (Criteria) this;
        }

        public Criteria andEvTimeGreaterThan(Date value) {
            addCriterion("ev_time >", value, "evTime");
            return (Criteria) this;
        }

        public Criteria andEvTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ev_time >=", value, "evTime");
            return (Criteria) this;
        }

        public Criteria andEvTimeLessThan(Date value) {
            addCriterion("ev_time <", value, "evTime");
            return (Criteria) this;
        }

        public Criteria andEvTimeLessThanOrEqualTo(Date value) {
            addCriterion("ev_time <=", value, "evTime");
            return (Criteria) this;
        }

        public Criteria andEvTimeIn(List<Date> values) {
            addCriterion("ev_time in", values, "evTime");
            return (Criteria) this;
        }

        public Criteria andEvTimeNotIn(List<Date> values) {
            addCriterion("ev_time not in", values, "evTime");
            return (Criteria) this;
        }

        public Criteria andEvTimeBetween(Date value1, Date value2) {
            addCriterion("ev_time between", value1, value2, "evTime");
            return (Criteria) this;
        }

        public Criteria andEvTimeNotBetween(Date value1, Date value2) {
            addCriterion("ev_time not between", value1, value2, "evTime");
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

        public Criteria andEvCostIsNull() {
            addCriterion("ev_cost is null");
            return (Criteria) this;
        }

        public Criteria andEvCostIsNotNull() {
            addCriterion("ev_cost is not null");
            return (Criteria) this;
        }

        public Criteria andEvCostEqualTo(Double value) {
            addCriterion("ev_cost =", value, "evCost");
            return (Criteria) this;
        }

        public Criteria andEvCostNotEqualTo(Double value) {
            addCriterion("ev_cost <>", value, "evCost");
            return (Criteria) this;
        }

        public Criteria andEvCostGreaterThan(Double value) {
            addCriterion("ev_cost >", value, "evCost");
            return (Criteria) this;
        }

        public Criteria andEvCostGreaterThanOrEqualTo(Double value) {
            addCriterion("ev_cost >=", value, "evCost");
            return (Criteria) this;
        }

        public Criteria andEvCostLessThan(Double value) {
            addCriterion("ev_cost <", value, "evCost");
            return (Criteria) this;
        }

        public Criteria andEvCostLessThanOrEqualTo(Double value) {
            addCriterion("ev_cost <=", value, "evCost");
            return (Criteria) this;
        }

        public Criteria andEvCostIn(List<Double> values) {
            addCriterion("ev_cost in", values, "evCost");
            return (Criteria) this;
        }

        public Criteria andEvCostNotIn(List<Double> values) {
            addCriterion("ev_cost not in", values, "evCost");
            return (Criteria) this;
        }

        public Criteria andEvCostBetween(Double value1, Double value2) {
            addCriterion("ev_cost between", value1, value2, "evCost");
            return (Criteria) this;
        }

        public Criteria andEvCostNotBetween(Double value1, Double value2) {
            addCriterion("ev_cost not between", value1, value2, "evCost");
            return (Criteria) this;
        }

        public Criteria andEvMemoIsNull() {
            addCriterion("ev_memo is null");
            return (Criteria) this;
        }

        public Criteria andEvMemoIsNotNull() {
            addCriterion("ev_memo is not null");
            return (Criteria) this;
        }

        public Criteria andEvMemoEqualTo(String value) {
            addCriterion("ev_memo =", value, "evMemo");
            return (Criteria) this;
        }

        public Criteria andEvMemoNotEqualTo(String value) {
            addCriterion("ev_memo <>", value, "evMemo");
            return (Criteria) this;
        }

        public Criteria andEvMemoGreaterThan(String value) {
            addCriterion("ev_memo >", value, "evMemo");
            return (Criteria) this;
        }

        public Criteria andEvMemoGreaterThanOrEqualTo(String value) {
            addCriterion("ev_memo >=", value, "evMemo");
            return (Criteria) this;
        }

        public Criteria andEvMemoLessThan(String value) {
            addCriterion("ev_memo <", value, "evMemo");
            return (Criteria) this;
        }

        public Criteria andEvMemoLessThanOrEqualTo(String value) {
            addCriterion("ev_memo <=", value, "evMemo");
            return (Criteria) this;
        }

        public Criteria andEvMemoLike(String value) {
            addCriterion("ev_memo like", value, "evMemo");
            return (Criteria) this;
        }

        public Criteria andEvMemoNotLike(String value) {
            addCriterion("ev_memo not like", value, "evMemo");
            return (Criteria) this;
        }

        public Criteria andEvMemoIn(List<String> values) {
            addCriterion("ev_memo in", values, "evMemo");
            return (Criteria) this;
        }

        public Criteria andEvMemoNotIn(List<String> values) {
            addCriterion("ev_memo not in", values, "evMemo");
            return (Criteria) this;
        }

        public Criteria andEvMemoBetween(String value1, String value2) {
            addCriterion("ev_memo between", value1, value2, "evMemo");
            return (Criteria) this;
        }

        public Criteria andEvMemoNotBetween(String value1, String value2) {
            addCriterion("ev_memo not between", value1, value2, "evMemo");
            return (Criteria) this;
        }

        public Criteria andHitsIsNull() {
            addCriterion("hits is null");
            return (Criteria) this;
        }

        public Criteria andHitsIsNotNull() {
            addCriterion("hits is not null");
            return (Criteria) this;
        }

        public Criteria andHitsEqualTo(Integer value) {
            addCriterion("hits =", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotEqualTo(Integer value) {
            addCriterion("hits <>", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsGreaterThan(Integer value) {
            addCriterion("hits >", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("hits >=", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsLessThan(Integer value) {
            addCriterion("hits <", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsLessThanOrEqualTo(Integer value) {
            addCriterion("hits <=", value, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsIn(List<Integer> values) {
            addCriterion("hits in", values, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotIn(List<Integer> values) {
            addCriterion("hits not in", values, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsBetween(Integer value1, Integer value2) {
            addCriterion("hits between", value1, value2, "hits");
            return (Criteria) this;
        }

        public Criteria andHitsNotBetween(Integer value1, Integer value2) {
            addCriterion("hits not between", value1, value2, "hits");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseIsNull() {
            addCriterion("point_of_praise is null");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseIsNotNull() {
            addCriterion("point_of_praise is not null");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseEqualTo(Integer value) {
            addCriterion("point_of_praise =", value, "pointOfPraise");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseNotEqualTo(Integer value) {
            addCriterion("point_of_praise <>", value, "pointOfPraise");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseGreaterThan(Integer value) {
            addCriterion("point_of_praise >", value, "pointOfPraise");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseGreaterThanOrEqualTo(Integer value) {
            addCriterion("point_of_praise >=", value, "pointOfPraise");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseLessThan(Integer value) {
            addCriterion("point_of_praise <", value, "pointOfPraise");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseLessThanOrEqualTo(Integer value) {
            addCriterion("point_of_praise <=", value, "pointOfPraise");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseIn(List<Integer> values) {
            addCriterion("point_of_praise in", values, "pointOfPraise");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseNotIn(List<Integer> values) {
            addCriterion("point_of_praise not in", values, "pointOfPraise");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseBetween(Integer value1, Integer value2) {
            addCriterion("point_of_praise between", value1, value2, "pointOfPraise");
            return (Criteria) this;
        }

        public Criteria andPointOfPraiseNotBetween(Integer value1, Integer value2) {
            addCriterion("point_of_praise not between", value1, value2, "pointOfPraise");
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