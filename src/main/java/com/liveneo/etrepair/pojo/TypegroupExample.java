package com.liveneo.etrepair.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.liveneo.etrepair.common.Page;

public class TypegroupExample {
    protected String         orderByClause;
    protected boolean        distinct;
    protected List<Criteria> oredCriteria;
    protected Page           page;

    public TypegroupExample() {
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

        public Criteria andTypeGroupIdIsNull() {
            addCriterion("type_group_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdIsNotNull() {
            addCriterion("type_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdEqualTo(String value) {
            addCriterion("type_group_id =", value, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdNotEqualTo(String value) {
            addCriterion("type_group_id <>", value, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdGreaterThan(String value) {
            addCriterion("type_group_id >", value, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_group_id >=", value, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdLessThan(String value) {
            addCriterion("type_group_id <", value, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdLessThanOrEqualTo(String value) {
            addCriterion("type_group_id <=", value, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdLike(String value) {
            addCriterion("type_group_id like", value, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdNotLike(String value) {
            addCriterion("type_group_id not like", value, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdIn(List<String> values) {
            addCriterion("type_group_id in", values, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdNotIn(List<String> values) {
            addCriterion("type_group_id not in", values, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdBetween(String value1, String value2) {
            addCriterion("type_group_id between", value1, value2, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupIdNotBetween(String value1, String value2) {
            addCriterion("type_group_id not between", value1, value2, "typeGroupId");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeIsNull() {
            addCriterion("type_group_code is null");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeIsNotNull() {
            addCriterion("type_group_code is not null");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeEqualTo(String value) {
            addCriterion("type_group_code =", value, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeNotEqualTo(String value) {
            addCriterion("type_group_code <>", value, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeGreaterThan(String value) {
            addCriterion("type_group_code >", value, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeGreaterThanOrEqualTo(String value) {
            addCriterion("type_group_code >=", value, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeLessThan(String value) {
            addCriterion("type_group_code <", value, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeLessThanOrEqualTo(String value) {
            addCriterion("type_group_code <=", value, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeLike(String value) {
            addCriterion("type_group_code like", value, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeNotLike(String value) {
            addCriterion("type_group_code not like", value, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeIn(List<String> values) {
            addCriterion("type_group_code in", values, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeNotIn(List<String> values) {
            addCriterion("type_group_code not in", values, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeBetween(String value1, String value2) {
            addCriterion("type_group_code between", value1, value2, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupCodeNotBetween(String value1, String value2) {
            addCriterion("type_group_code not between", value1, value2, "typeGroupCode");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameIsNull() {
            addCriterion("type_group_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameIsNotNull() {
            addCriterion("type_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameEqualTo(String value) {
            addCriterion("type_group_name =", value, "typeGroupName");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameNotEqualTo(String value) {
            addCriterion("type_group_name <>", value, "typeGroupName");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameGreaterThan(String value) {
            addCriterion("type_group_name >", value, "typeGroupName");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_group_name >=", value, "typeGroupName");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameLessThan(String value) {
            addCriterion("type_group_name <", value, "typeGroupName");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameLessThanOrEqualTo(String value) {
            addCriterion("type_group_name <=", value, "typeGroupName");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameLike(String value) {
            addCriterion("type_group_name like", value, "typeGroupName");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameNotLike(String value) {
            addCriterion("type_group_name not like", value, "typeGroupName");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameIn(List<String> values) {
            addCriterion("type_group_name in", values, "typeGroupName");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameNotIn(List<String> values) {
            addCriterion("type_group_name not in", values, "typeGroupName");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameBetween(String value1, String value2) {
            addCriterion("type_group_name between", value1, value2, "typeGroupName");
            return (Criteria) this;
        }

        public Criteria andTypeGroupNameNotBetween(String value1, String value2) {
            addCriterion("type_group_name not between", value1, value2, "typeGroupName");
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