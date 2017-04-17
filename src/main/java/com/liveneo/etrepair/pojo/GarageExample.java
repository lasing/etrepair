package com.liveneo.etrepair.pojo;

import com.liveneo.etrepair.common.Page;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GarageExample {
    protected String         orderByClause;
    protected boolean        distinct;
    protected List<Criteria> oredCriteria;
    protected Page           page;

    public GarageExample() {
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNull() {
            addCriterion("company_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("company_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("company_code =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("company_code <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("company_code >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_code >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("company_code <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("company_code <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("company_code like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("company_code not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("company_code in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("company_code not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("company_code between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("company_code not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andPointNumberIsNull() {
            addCriterion("point_number is null");
            return (Criteria) this;
        }

        public Criteria andPointNumberIsNotNull() {
            addCriterion("point_number is not null");
            return (Criteria) this;
        }

        public Criteria andPointNumberEqualTo(String value) {
            addCriterion("point_number =", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberNotEqualTo(String value) {
            addCriterion("point_number <>", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberGreaterThan(String value) {
            addCriterion("point_number >", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberGreaterThanOrEqualTo(String value) {
            addCriterion("point_number >=", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberLessThan(String value) {
            addCriterion("point_number <", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberLessThanOrEqualTo(String value) {
            addCriterion("point_number <=", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberLike(String value) {
            addCriterion("point_number like", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberNotLike(String value) {
            addCriterion("point_number not like", value, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberIn(List<String> values) {
            addCriterion("point_number in", values, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberNotIn(List<String> values) {
            addCriterion("point_number not in", values, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberBetween(String value1, String value2) {
            addCriterion("point_number between", value1, value2, "pointNumber");
            return (Criteria) this;
        }

        public Criteria andPointNumberNotBetween(String value1, String value2) {
            addCriterion("point_number not between", value1, value2, "pointNumber");
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

        public Criteria andGarageNameIsNull() {
            addCriterion("garage_name is null");
            return (Criteria) this;
        }

        public Criteria andGarageNameIsNotNull() {
            addCriterion("garage_name is not null");
            return (Criteria) this;
        }

        public Criteria andGarageNameEqualTo(String value) {
            addCriterion("garage_name =", value, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameNotEqualTo(String value) {
            addCriterion("garage_name <>", value, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameGreaterThan(String value) {
            addCriterion("garage_name >", value, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameGreaterThanOrEqualTo(String value) {
            addCriterion("garage_name >=", value, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameLessThan(String value) {
            addCriterion("garage_name <", value, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameLessThanOrEqualTo(String value) {
            addCriterion("garage_name <=", value, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameLike(String value) {
            addCriterion("garage_name like", value, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameNotLike(String value) {
            addCriterion("garage_name not like", value, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameIn(List<String> values) {
            addCriterion("garage_name in", values, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameNotIn(List<String> values) {
            addCriterion("garage_name not in", values, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameBetween(String value1, String value2) {
            addCriterion("garage_name between", value1, value2, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameNotBetween(String value1, String value2) {
            addCriterion("garage_name not between", value1, value2, "garageName");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbIsNull() {
            addCriterion("garage_name_abb is null");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbIsNotNull() {
            addCriterion("garage_name_abb is not null");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbEqualTo(String value) {
            addCriterion("garage_name_abb =", value, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbNotEqualTo(String value) {
            addCriterion("garage_name_abb <>", value, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbGreaterThan(String value) {
            addCriterion("garage_name_abb >", value, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbGreaterThanOrEqualTo(String value) {
            addCriterion("garage_name_abb >=", value, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbLessThan(String value) {
            addCriterion("garage_name_abb <", value, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbLessThanOrEqualTo(String value) {
            addCriterion("garage_name_abb <=", value, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbLike(String value) {
            addCriterion("garage_name_abb like", value, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbNotLike(String value) {
            addCriterion("garage_name_abb not like", value, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbIn(List<String> values) {
            addCriterion("garage_name_abb in", values, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbNotIn(List<String> values) {
            addCriterion("garage_name_abb not in", values, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbBetween(String value1, String value2) {
            addCriterion("garage_name_abb between", value1, value2, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageNameAbbNotBetween(String value1, String value2) {
            addCriterion("garage_name_abb not between", value1, value2, "garageNameAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrIsNull() {
            addCriterion("garage_addr is null");
            return (Criteria) this;
        }

        public Criteria andGarageAddrIsNotNull() {
            addCriterion("garage_addr is not null");
            return (Criteria) this;
        }

        public Criteria andGarageAddrEqualTo(String value) {
            addCriterion("garage_addr =", value, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrNotEqualTo(String value) {
            addCriterion("garage_addr <>", value, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrGreaterThan(String value) {
            addCriterion("garage_addr >", value, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrGreaterThanOrEqualTo(String value) {
            addCriterion("garage_addr >=", value, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrLessThan(String value) {
            addCriterion("garage_addr <", value, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrLessThanOrEqualTo(String value) {
            addCriterion("garage_addr <=", value, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrLike(String value) {
            addCriterion("garage_addr like", value, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrNotLike(String value) {
            addCriterion("garage_addr not like", value, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrIn(List<String> values) {
            addCriterion("garage_addr in", values, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrNotIn(List<String> values) {
            addCriterion("garage_addr not in", values, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrBetween(String value1, String value2) {
            addCriterion("garage_addr between", value1, value2, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrNotBetween(String value1, String value2) {
            addCriterion("garage_addr not between", value1, value2, "garageAddr");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbIsNull() {
            addCriterion("garage_addr_abb is null");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbIsNotNull() {
            addCriterion("garage_addr_abb is not null");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbEqualTo(String value) {
            addCriterion("garage_addr_abb =", value, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbNotEqualTo(String value) {
            addCriterion("garage_addr_abb <>", value, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbGreaterThan(String value) {
            addCriterion("garage_addr_abb >", value, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbGreaterThanOrEqualTo(String value) {
            addCriterion("garage_addr_abb >=", value, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbLessThan(String value) {
            addCriterion("garage_addr_abb <", value, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbLessThanOrEqualTo(String value) {
            addCriterion("garage_addr_abb <=", value, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbLike(String value) {
            addCriterion("garage_addr_abb like", value, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbNotLike(String value) {
            addCriterion("garage_addr_abb not like", value, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbIn(List<String> values) {
            addCriterion("garage_addr_abb in", values, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbNotIn(List<String> values) {
            addCriterion("garage_addr_abb not in", values, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbBetween(String value1, String value2) {
            addCriterion("garage_addr_abb between", value1, value2, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andGarageAddrAbbNotBetween(String value1, String value2) {
            addCriterion("garage_addr_abb not between", value1, value2, "garageAddrAbb");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIsNull() {
            addCriterion("category_code is null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIsNotNull() {
            addCriterion("category_code is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeEqualTo(String value) {
            addCriterion("category_code =", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotEqualTo(String value) {
            addCriterion("category_code <>", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThan(String value) {
            addCriterion("category_code >", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("category_code >=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThan(String value) {
            addCriterion("category_code <", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThanOrEqualTo(String value) {
            addCriterion("category_code <=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLike(String value) {
            addCriterion("category_code like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotLike(String value) {
            addCriterion("category_code not like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIn(List<String> values) {
            addCriterion("category_code in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotIn(List<String> values) {
            addCriterion("category_code not in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeBetween(String value1, String value2) {
            addCriterion("category_code between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotBetween(String value1, String value2) {
            addCriterion("category_code not between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andRepairTelIsNull() {
            addCriterion("repair_tel is null");
            return (Criteria) this;
        }

        public Criteria andRepairTelIsNotNull() {
            addCriterion("repair_tel is not null");
            return (Criteria) this;
        }

        public Criteria andRepairTelEqualTo(String value) {
            addCriterion("repair_tel =", value, "repairTel");
            return (Criteria) this;
        }

        public Criteria andRepairTelNotEqualTo(String value) {
            addCriterion("repair_tel <>", value, "repairTel");
            return (Criteria) this;
        }

        public Criteria andRepairTelGreaterThan(String value) {
            addCriterion("repair_tel >", value, "repairTel");
            return (Criteria) this;
        }

        public Criteria andRepairTelGreaterThanOrEqualTo(String value) {
            addCriterion("repair_tel >=", value, "repairTel");
            return (Criteria) this;
        }

        public Criteria andRepairTelLessThan(String value) {
            addCriterion("repair_tel <", value, "repairTel");
            return (Criteria) this;
        }

        public Criteria andRepairTelLessThanOrEqualTo(String value) {
            addCriterion("repair_tel <=", value, "repairTel");
            return (Criteria) this;
        }

        public Criteria andRepairTelLike(String value) {
            addCriterion("repair_tel like", value, "repairTel");
            return (Criteria) this;
        }

        public Criteria andRepairTelNotLike(String value) {
            addCriterion("repair_tel not like", value, "repairTel");
            return (Criteria) this;
        }

        public Criteria andRepairTelIn(List<String> values) {
            addCriterion("repair_tel in", values, "repairTel");
            return (Criteria) this;
        }

        public Criteria andRepairTelNotIn(List<String> values) {
            addCriterion("repair_tel not in", values, "repairTel");
            return (Criteria) this;
        }

        public Criteria andRepairTelBetween(String value1, String value2) {
            addCriterion("repair_tel between", value1, value2, "repairTel");
            return (Criteria) this;
        }

        public Criteria andRepairTelNotBetween(String value1, String value2) {
            addCriterion("repair_tel not between", value1, value2, "repairTel");
            return (Criteria) this;
        }

        public Criteria andExpDateIsNull() {
            addCriterion("exp_date is null");
            return (Criteria) this;
        }

        public Criteria andExpDateIsNotNull() {
            addCriterion("exp_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpDateEqualTo(Date value) {
            addCriterion("exp_date =", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotEqualTo(Date value) {
            addCriterion("exp_date <>", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateGreaterThan(Date value) {
            addCriterion("exp_date >", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateGreaterThanOrEqualTo(Date value) {
            addCriterion("exp_date >=", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateLessThan(Date value) {
            addCriterion("exp_date <", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateLessThanOrEqualTo(Date value) {
            addCriterion("exp_date <=", value, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateIn(List<Date> values) {
            addCriterion("exp_date in", values, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotIn(List<Date> values) {
            addCriterion("exp_date not in", values, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateBetween(Date value1, Date value2) {
            addCriterion("exp_date between", value1, value2, "expDate");
            return (Criteria) this;
        }

        public Criteria andExpDateNotBetween(Date value1, Date value2) {
            addCriterion("exp_date not between", value1, value2, "expDate");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureIsNull() {
            addCriterion("service_feature is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureIsNotNull() {
            addCriterion("service_feature is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureEqualTo(String value) {
            addCriterion("service_feature =", value, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureNotEqualTo(String value) {
            addCriterion("service_feature <>", value, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureGreaterThan(String value) {
            addCriterion("service_feature >", value, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureGreaterThanOrEqualTo(String value) {
            addCriterion("service_feature >=", value, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureLessThan(String value) {
            addCriterion("service_feature <", value, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureLessThanOrEqualTo(String value) {
            addCriterion("service_feature <=", value, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureLike(String value) {
            addCriterion("service_feature like", value, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureNotLike(String value) {
            addCriterion("service_feature not like", value, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureIn(List<String> values) {
            addCriterion("service_feature in", values, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureNotIn(List<String> values) {
            addCriterion("service_feature not in", values, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureBetween(String value1, String value2) {
            addCriterion("service_feature between", value1, value2, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andServiceFeatureNotBetween(String value1, String value2) {
            addCriterion("service_feature not between", value1, value2, "serviceFeature");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagIsNull() {
            addCriterion("repair_4s_flag is null");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagIsNotNull() {
            addCriterion("repair_4s_flag is not null");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagEqualTo(String value) {
            addCriterion("repair_4s_flag =", value, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagNotEqualTo(String value) {
            addCriterion("repair_4s_flag <>", value, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagGreaterThan(String value) {
            addCriterion("repair_4s_flag >", value, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagGreaterThanOrEqualTo(String value) {
            addCriterion("repair_4s_flag >=", value, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagLessThan(String value) {
            addCriterion("repair_4s_flag <", value, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagLessThanOrEqualTo(String value) {
            addCriterion("repair_4s_flag <=", value, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagLike(String value) {
            addCriterion("repair_4s_flag like", value, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagNotLike(String value) {
            addCriterion("repair_4s_flag not like", value, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagIn(List<String> values) {
            addCriterion("repair_4s_flag in", values, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagNotIn(List<String> values) {
            addCriterion("repair_4s_flag not in", values, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagBetween(String value1, String value2) {
            addCriterion("repair_4s_flag between", value1, value2, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andRepair4sFlagNotBetween(String value1, String value2) {
            addCriterion("repair_4s_flag not between", value1, value2, "repair4sFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagIsNull() {
            addCriterion("outside_flag is null");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagIsNotNull() {
            addCriterion("outside_flag is not null");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagEqualTo(String value) {
            addCriterion("outside_flag =", value, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagNotEqualTo(String value) {
            addCriterion("outside_flag <>", value, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagGreaterThan(String value) {
            addCriterion("outside_flag >", value, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagGreaterThanOrEqualTo(String value) {
            addCriterion("outside_flag >=", value, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagLessThan(String value) {
            addCriterion("outside_flag <", value, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagLessThanOrEqualTo(String value) {
            addCriterion("outside_flag <=", value, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagLike(String value) {
            addCriterion("outside_flag like", value, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagNotLike(String value) {
            addCriterion("outside_flag not like", value, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagIn(List<String> values) {
            addCriterion("outside_flag in", values, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagNotIn(List<String> values) {
            addCriterion("outside_flag not in", values, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagBetween(String value1, String value2) {
            addCriterion("outside_flag between", value1, value2, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andOutsideFlagNotBetween(String value1, String value2) {
            addCriterion("outside_flag not between", value1, value2, "outsideFlag");
            return (Criteria) this;
        }

        public Criteria andTasklimitIsNull() {
            addCriterion("tasklimit is null");
            return (Criteria) this;
        }

        public Criteria andTasklimitIsNotNull() {
            addCriterion("tasklimit is not null");
            return (Criteria) this;
        }

        public Criteria andTasklimitEqualTo(Integer value) {
            addCriterion("tasklimit =", value, "tasklimit");
            return (Criteria) this;
        }

        public Criteria andTasklimitNotEqualTo(Integer value) {
            addCriterion("tasklimit <>", value, "tasklimit");
            return (Criteria) this;
        }

        public Criteria andTasklimitGreaterThan(Integer value) {
            addCriterion("tasklimit >", value, "tasklimit");
            return (Criteria) this;
        }

        public Criteria andTasklimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("tasklimit >=", value, "tasklimit");
            return (Criteria) this;
        }

        public Criteria andTasklimitLessThan(Integer value) {
            addCriterion("tasklimit <", value, "tasklimit");
            return (Criteria) this;
        }

        public Criteria andTasklimitLessThanOrEqualTo(Integer value) {
            addCriterion("tasklimit <=", value, "tasklimit");
            return (Criteria) this;
        }

        public Criteria andTasklimitIn(List<Integer> values) {
            addCriterion("tasklimit in", values, "tasklimit");
            return (Criteria) this;
        }

        public Criteria andTasklimitNotIn(List<Integer> values) {
            addCriterion("tasklimit not in", values, "tasklimit");
            return (Criteria) this;
        }

        public Criteria andTasklimitBetween(Integer value1, Integer value2) {
            addCriterion("tasklimit between", value1, value2, "tasklimit");
            return (Criteria) this;
        }

        public Criteria andTasklimitNotBetween(Integer value1, Integer value2) {
            addCriterion("tasklimit not between", value1, value2, "tasklimit");
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

        public Criteria andGarageScoreIsNull() {
            addCriterion("garage_score is null");
            return (Criteria) this;
        }

        public Criteria andGarageScoreIsNotNull() {
            addCriterion("garage_score is not null");
            return (Criteria) this;
        }

        public Criteria andGarageScoreEqualTo(Byte value) {
            addCriterion("garage_score =", value, "garageScore");
            return (Criteria) this;
        }

        public Criteria andGarageScoreNotEqualTo(Byte value) {
            addCriterion("garage_score <>", value, "garageScore");
            return (Criteria) this;
        }

        public Criteria andGarageScoreGreaterThan(Byte value) {
            addCriterion("garage_score >", value, "garageScore");
            return (Criteria) this;
        }

        public Criteria andGarageScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("garage_score >=", value, "garageScore");
            return (Criteria) this;
        }

        public Criteria andGarageScoreLessThan(Byte value) {
            addCriterion("garage_score <", value, "garageScore");
            return (Criteria) this;
        }

        public Criteria andGarageScoreLessThanOrEqualTo(Byte value) {
            addCriterion("garage_score <=", value, "garageScore");
            return (Criteria) this;
        }

        public Criteria andGarageScoreIn(List<Byte> values) {
            addCriterion("garage_score in", values, "garageScore");
            return (Criteria) this;
        }

        public Criteria andGarageScoreNotIn(List<Byte> values) {
            addCriterion("garage_score not in", values, "garageScore");
            return (Criteria) this;
        }

        public Criteria andGarageScoreBetween(Byte value1, Byte value2) {
            addCriterion("garage_score between", value1, value2, "garageScore");
            return (Criteria) this;
        }

        public Criteria andGarageScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("garage_score not between", value1, value2, "garageScore");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNull() {
            addCriterion("is_enable is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(String value) {
            addCriterion("is_enable =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(String value) {
            addCriterion("is_enable <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(String value) {
            addCriterion("is_enable >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(String value) {
            addCriterion("is_enable >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(String value) {
            addCriterion("is_enable <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(String value) {
            addCriterion("is_enable <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLike(String value) {
            addCriterion("is_enable like", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotLike(String value) {
            addCriterion("is_enable not like", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(List<String> values) {
            addCriterion("is_enable in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(List<String> values) {
            addCriterion("is_enable not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(String value1, String value2) {
            addCriterion("is_enable between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(String value1, String value2) {
            addCriterion("is_enable not between", value1, value2, "isEnable");
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