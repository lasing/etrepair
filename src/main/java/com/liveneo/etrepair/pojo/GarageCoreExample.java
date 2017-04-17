package com.liveneo.etrepair.pojo;

import com.liveneo.etrepair.common.Page;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GarageCoreExample {
    protected String         orderByClause;
    protected boolean        distinct;
    protected List<Criteria> oredCriteria;
    protected Page           page;

    public GarageCoreExample() {
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

        public Criteria andGarageAbbrIsNull() {
            addCriterion("garage_abbr is null");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrIsNotNull() {
            addCriterion("garage_abbr is not null");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrEqualTo(String value) {
            addCriterion("garage_abbr =", value, "garageAbbr");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrNotEqualTo(String value) {
            addCriterion("garage_abbr <>", value, "garageAbbr");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrGreaterThan(String value) {
            addCriterion("garage_abbr >", value, "garageAbbr");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("garage_abbr >=", value, "garageAbbr");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrLessThan(String value) {
            addCriterion("garage_abbr <", value, "garageAbbr");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrLessThanOrEqualTo(String value) {
            addCriterion("garage_abbr <=", value, "garageAbbr");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrLike(String value) {
            addCriterion("garage_abbr like", value, "garageAbbr");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrNotLike(String value) {
            addCriterion("garage_abbr not like", value, "garageAbbr");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrIn(List<String> values) {
            addCriterion("garage_abbr in", values, "garageAbbr");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrNotIn(List<String> values) {
            addCriterion("garage_abbr not in", values, "garageAbbr");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrBetween(String value1, String value2) {
            addCriterion("garage_abbr between", value1, value2, "garageAbbr");
            return (Criteria) this;
        }

        public Criteria andGarageAbbrNotBetween(String value1, String value2) {
            addCriterion("garage_abbr not between", value1, value2, "garageAbbr");
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

        public Criteria andIndustryOrgCodeIsNull() {
            addCriterion("industry_org_code is null");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeIsNotNull() {
            addCriterion("industry_org_code is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeEqualTo(String value) {
            addCriterion("industry_org_code =", value, "industryOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeNotEqualTo(String value) {
            addCriterion("industry_org_code <>", value, "industryOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeGreaterThan(String value) {
            addCriterion("industry_org_code >", value, "industryOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("industry_org_code >=", value, "industryOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeLessThan(String value) {
            addCriterion("industry_org_code <", value, "industryOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("industry_org_code <=", value, "industryOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeLike(String value) {
            addCriterion("industry_org_code like", value, "industryOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeNotLike(String value) {
            addCriterion("industry_org_code not like", value, "industryOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeIn(List<String> values) {
            addCriterion("industry_org_code in", values, "industryOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeNotIn(List<String> values) {
            addCriterion("industry_org_code not in", values, "industryOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeBetween(String value1, String value2) {
            addCriterion("industry_org_code between", value1, value2, "industryOrgCode");
            return (Criteria) this;
        }

        public Criteria andIndustryOrgCodeNotBetween(String value1, String value2) {
            addCriterion("industry_org_code not between", value1, value2, "industryOrgCode");
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

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andRepairLevelIsNull() {
            addCriterion("repair_level is null");
            return (Criteria) this;
        }

        public Criteria andRepairLevelIsNotNull() {
            addCriterion("repair_level is not null");
            return (Criteria) this;
        }

        public Criteria andRepairLevelEqualTo(String value) {
            addCriterion("repair_level =", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelNotEqualTo(String value) {
            addCriterion("repair_level <>", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelGreaterThan(String value) {
            addCriterion("repair_level >", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelGreaterThanOrEqualTo(String value) {
            addCriterion("repair_level >=", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelLessThan(String value) {
            addCriterion("repair_level <", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelLessThanOrEqualTo(String value) {
            addCriterion("repair_level <=", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelLike(String value) {
            addCriterion("repair_level like", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelNotLike(String value) {
            addCriterion("repair_level not like", value, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelIn(List<String> values) {
            addCriterion("repair_level in", values, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelNotIn(List<String> values) {
            addCriterion("repair_level not in", values, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelBetween(String value1, String value2) {
            addCriterion("repair_level between", value1, value2, "repairLevel");
            return (Criteria) this;
        }

        public Criteria andRepairLevelNotBetween(String value1, String value2) {
            addCriterion("repair_level not between", value1, value2, "repairLevel");
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

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagIsNull() {
            addCriterion("direct_pay_flag is null");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagIsNotNull() {
            addCriterion("direct_pay_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagEqualTo(String value) {
            addCriterion("direct_pay_flag =", value, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagNotEqualTo(String value) {
            addCriterion("direct_pay_flag <>", value, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagGreaterThan(String value) {
            addCriterion("direct_pay_flag >", value, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagGreaterThanOrEqualTo(String value) {
            addCriterion("direct_pay_flag >=", value, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagLessThan(String value) {
            addCriterion("direct_pay_flag <", value, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagLessThanOrEqualTo(String value) {
            addCriterion("direct_pay_flag <=", value, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagLike(String value) {
            addCriterion("direct_pay_flag like", value, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagNotLike(String value) {
            addCriterion("direct_pay_flag not like", value, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagIn(List<String> values) {
            addCriterion("direct_pay_flag in", values, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagNotIn(List<String> values) {
            addCriterion("direct_pay_flag not in", values, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagBetween(String value1, String value2) {
            addCriterion("direct_pay_flag between", value1, value2, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andDirectPayFlagNotBetween(String value1, String value2) {
            addCriterion("direct_pay_flag not between", value1, value2, "directPayFlag");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateIsNull() {
            addCriterion("part_discount_rate is null");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateIsNotNull() {
            addCriterion("part_discount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateEqualTo(Float value) {
            addCriterion("part_discount_rate =", value, "partDiscountRate");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateNotEqualTo(Float value) {
            addCriterion("part_discount_rate <>", value, "partDiscountRate");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateGreaterThan(Float value) {
            addCriterion("part_discount_rate >", value, "partDiscountRate");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateGreaterThanOrEqualTo(Float value) {
            addCriterion("part_discount_rate >=", value, "partDiscountRate");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateLessThan(Float value) {
            addCriterion("part_discount_rate <", value, "partDiscountRate");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateLessThanOrEqualTo(Float value) {
            addCriterion("part_discount_rate <=", value, "partDiscountRate");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateIn(List<Float> values) {
            addCriterion("part_discount_rate in", values, "partDiscountRate");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateNotIn(List<Float> values) {
            addCriterion("part_discount_rate not in", values, "partDiscountRate");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateBetween(Float value1, Float value2) {
            addCriterion("part_discount_rate between", value1, value2, "partDiscountRate");
            return (Criteria) this;
        }

        public Criteria andPartDiscountRateNotBetween(Float value1, Float value2) {
            addCriterion("part_discount_rate not between", value1, value2, "partDiscountRate");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourIsNull() {
            addCriterion("paint_facman_hour is null");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourIsNotNull() {
            addCriterion("paint_facman_hour is not null");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourEqualTo(Float value) {
            addCriterion("paint_facman_hour =", value, "paintFacmanHour");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourNotEqualTo(Float value) {
            addCriterion("paint_facman_hour <>", value, "paintFacmanHour");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourGreaterThan(Float value) {
            addCriterion("paint_facman_hour >", value, "paintFacmanHour");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourGreaterThanOrEqualTo(Float value) {
            addCriterion("paint_facman_hour >=", value, "paintFacmanHour");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourLessThan(Float value) {
            addCriterion("paint_facman_hour <", value, "paintFacmanHour");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourLessThanOrEqualTo(Float value) {
            addCriterion("paint_facman_hour <=", value, "paintFacmanHour");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourIn(List<Float> values) {
            addCriterion("paint_facman_hour in", values, "paintFacmanHour");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourNotIn(List<Float> values) {
            addCriterion("paint_facman_hour not in", values, "paintFacmanHour");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourBetween(Float value1, Float value2) {
            addCriterion("paint_facman_hour between", value1, value2, "paintFacmanHour");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanHourNotBetween(Float value1, Float value2) {
            addCriterion("paint_facman_hour not between", value1, value2, "paintFacmanHour");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourIsNull() {
            addCriterion("repair_facman_hour is null");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourIsNotNull() {
            addCriterion("repair_facman_hour is not null");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourEqualTo(Float value) {
            addCriterion("repair_facman_hour =", value, "repairFacmanHour");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourNotEqualTo(Float value) {
            addCriterion("repair_facman_hour <>", value, "repairFacmanHour");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourGreaterThan(Float value) {
            addCriterion("repair_facman_hour >", value, "repairFacmanHour");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourGreaterThanOrEqualTo(Float value) {
            addCriterion("repair_facman_hour >=", value, "repairFacmanHour");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourLessThan(Float value) {
            addCriterion("repair_facman_hour <", value, "repairFacmanHour");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourLessThanOrEqualTo(Float value) {
            addCriterion("repair_facman_hour <=", value, "repairFacmanHour");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourIn(List<Float> values) {
            addCriterion("repair_facman_hour in", values, "repairFacmanHour");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourNotIn(List<Float> values) {
            addCriterion("repair_facman_hour not in", values, "repairFacmanHour");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourBetween(Float value1, Float value2) {
            addCriterion("repair_facman_hour between", value1, value2, "repairFacmanHour");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanHourNotBetween(Float value1, Float value2) {
            addCriterion("repair_facman_hour not between", value1, value2, "repairFacmanHour");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourIsNull() {
            addCriterion("assembly_facman_hour is null");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourIsNotNull() {
            addCriterion("assembly_facman_hour is not null");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourEqualTo(Float value) {
            addCriterion("assembly_facman_hour =", value, "assemblyFacmanHour");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourNotEqualTo(Float value) {
            addCriterion("assembly_facman_hour <>", value, "assemblyFacmanHour");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourGreaterThan(Float value) {
            addCriterion("assembly_facman_hour >", value, "assemblyFacmanHour");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourGreaterThanOrEqualTo(Float value) {
            addCriterion("assembly_facman_hour >=", value, "assemblyFacmanHour");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourLessThan(Float value) {
            addCriterion("assembly_facman_hour <", value, "assemblyFacmanHour");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourLessThanOrEqualTo(Float value) {
            addCriterion("assembly_facman_hour <=", value, "assemblyFacmanHour");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourIn(List<Float> values) {
            addCriterion("assembly_facman_hour in", values, "assemblyFacmanHour");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourNotIn(List<Float> values) {
            addCriterion("assembly_facman_hour not in", values, "assemblyFacmanHour");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourBetween(Float value1, Float value2) {
            addCriterion("assembly_facman_hour between", value1, value2, "assemblyFacmanHour");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanHourNotBetween(Float value1, Float value2) {
            addCriterion("assembly_facman_hour not between", value1, value2, "assemblyFacmanHour");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardIsNull() {
            addCriterion("discount_standard is null");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardIsNotNull() {
            addCriterion("discount_standard is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardEqualTo(Float value) {
            addCriterion("discount_standard =", value, "discountStandard");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardNotEqualTo(Float value) {
            addCriterion("discount_standard <>", value, "discountStandard");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardGreaterThan(Float value) {
            addCriterion("discount_standard >", value, "discountStandard");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardGreaterThanOrEqualTo(Float value) {
            addCriterion("discount_standard >=", value, "discountStandard");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardLessThan(Float value) {
            addCriterion("discount_standard <", value, "discountStandard");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardLessThanOrEqualTo(Float value) {
            addCriterion("discount_standard <=", value, "discountStandard");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardIn(List<Float> values) {
            addCriterion("discount_standard in", values, "discountStandard");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardNotIn(List<Float> values) {
            addCriterion("discount_standard not in", values, "discountStandard");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardBetween(Float value1, Float value2) {
            addCriterion("discount_standard between", value1, value2, "discountStandard");
            return (Criteria) this;
        }

        public Criteria andDiscountStandardNotBetween(Float value1, Float value2) {
            addCriterion("discount_standard not between", value1, value2, "discountStandard");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountIsNull() {
            addCriterion("repair_facman_discount is null");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountIsNotNull() {
            addCriterion("repair_facman_discount is not null");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountEqualTo(Float value) {
            addCriterion("repair_facman_discount =", value, "repairFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountNotEqualTo(Float value) {
            addCriterion("repair_facman_discount <>", value, "repairFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountGreaterThan(Float value) {
            addCriterion("repair_facman_discount >", value, "repairFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("repair_facman_discount >=", value, "repairFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountLessThan(Float value) {
            addCriterion("repair_facman_discount <", value, "repairFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountLessThanOrEqualTo(Float value) {
            addCriterion("repair_facman_discount <=", value, "repairFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountIn(List<Float> values) {
            addCriterion("repair_facman_discount in", values, "repairFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountNotIn(List<Float> values) {
            addCriterion("repair_facman_discount not in", values, "repairFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountBetween(Float value1, Float value2) {
            addCriterion("repair_facman_discount between", value1, value2, "repairFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andRepairFacmanDiscountNotBetween(Float value1, Float value2) {
            addCriterion("repair_facman_discount not between", value1, value2, "repairFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountIsNull() {
            addCriterion("paint_facman_discount is null");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountIsNotNull() {
            addCriterion("paint_facman_discount is not null");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountEqualTo(Float value) {
            addCriterion("paint_facman_discount =", value, "paintFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountNotEqualTo(Float value) {
            addCriterion("paint_facman_discount <>", value, "paintFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountGreaterThan(Float value) {
            addCriterion("paint_facman_discount >", value, "paintFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("paint_facman_discount >=", value, "paintFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountLessThan(Float value) {
            addCriterion("paint_facman_discount <", value, "paintFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountLessThanOrEqualTo(Float value) {
            addCriterion("paint_facman_discount <=", value, "paintFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountIn(List<Float> values) {
            addCriterion("paint_facman_discount in", values, "paintFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountNotIn(List<Float> values) {
            addCriterion("paint_facman_discount not in", values, "paintFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountBetween(Float value1, Float value2) {
            addCriterion("paint_facman_discount between", value1, value2, "paintFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andPaintFacmanDiscountNotBetween(Float value1, Float value2) {
            addCriterion("paint_facman_discount not between", value1, value2, "paintFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountIsNull() {
            addCriterion("assembly_facman_discount is null");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountIsNotNull() {
            addCriterion("assembly_facman_discount is not null");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountEqualTo(Float value) {
            addCriterion("assembly_facman_discount =", value, "assemblyFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountNotEqualTo(Float value) {
            addCriterion("assembly_facman_discount <>", value, "assemblyFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountGreaterThan(Float value) {
            addCriterion("assembly_facman_discount >", value, "assemblyFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("assembly_facman_discount >=", value, "assemblyFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountLessThan(Float value) {
            addCriterion("assembly_facman_discount <", value, "assemblyFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountLessThanOrEqualTo(Float value) {
            addCriterion("assembly_facman_discount <=", value, "assemblyFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountIn(List<Float> values) {
            addCriterion("assembly_facman_discount in", values, "assemblyFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountNotIn(List<Float> values) {
            addCriterion("assembly_facman_discount not in", values, "assemblyFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountBetween(Float value1, Float value2) {
            addCriterion("assembly_facman_discount between", value1, value2, "assemblyFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andAssemblyFacmanDiscountNotBetween(Float value1, Float value2) {
            addCriterion("assembly_facman_discount not between", value1, value2, "assemblyFacmanDiscount");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountIsNull() {
            addCriterion("machine_repair_discount is null");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountIsNotNull() {
            addCriterion("machine_repair_discount is not null");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountEqualTo(Float value) {
            addCriterion("machine_repair_discount =", value, "machineRepairDiscount");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountNotEqualTo(Float value) {
            addCriterion("machine_repair_discount <>", value, "machineRepairDiscount");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountGreaterThan(Float value) {
            addCriterion("machine_repair_discount >", value, "machineRepairDiscount");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("machine_repair_discount >=", value, "machineRepairDiscount");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountLessThan(Float value) {
            addCriterion("machine_repair_discount <", value, "machineRepairDiscount");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountLessThanOrEqualTo(Float value) {
            addCriterion("machine_repair_discount <=", value, "machineRepairDiscount");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountIn(List<Float> values) {
            addCriterion("machine_repair_discount in", values, "machineRepairDiscount");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountNotIn(List<Float> values) {
            addCriterion("machine_repair_discount not in", values, "machineRepairDiscount");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountBetween(Float value1, Float value2) {
            addCriterion("machine_repair_discount between", value1, value2, "machineRepairDiscount");
            return (Criteria) this;
        }

        public Criteria andMachineRepairDiscountNotBetween(Float value1, Float value2) {
            addCriterion("machine_repair_discount not between", value1, value2, "machineRepairDiscount");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountIsNull() {
            addCriterion("electrican_discount is null");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountIsNotNull() {
            addCriterion("electrican_discount is not null");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountEqualTo(Float value) {
            addCriterion("electrican_discount =", value, "electricanDiscount");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountNotEqualTo(Float value) {
            addCriterion("electrican_discount <>", value, "electricanDiscount");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountGreaterThan(Float value) {
            addCriterion("electrican_discount >", value, "electricanDiscount");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountGreaterThanOrEqualTo(Float value) {
            addCriterion("electrican_discount >=", value, "electricanDiscount");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountLessThan(Float value) {
            addCriterion("electrican_discount <", value, "electricanDiscount");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountLessThanOrEqualTo(Float value) {
            addCriterion("electrican_discount <=", value, "electricanDiscount");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountIn(List<Float> values) {
            addCriterion("electrican_discount in", values, "electricanDiscount");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountNotIn(List<Float> values) {
            addCriterion("electrican_discount not in", values, "electricanDiscount");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountBetween(Float value1, Float value2) {
            addCriterion("electrican_discount between", value1, value2, "electricanDiscount");
            return (Criteria) this;
        }

        public Criteria andElectricanDiscountNotBetween(Float value1, Float value2) {
            addCriterion("electrican_discount not between", value1, value2, "electricanDiscount");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioIsNull() {
            addCriterion("eval_float_ratio is null");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioIsNotNull() {
            addCriterion("eval_float_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioEqualTo(Float value) {
            addCriterion("eval_float_ratio =", value, "evalFloatRatio");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioNotEqualTo(Float value) {
            addCriterion("eval_float_ratio <>", value, "evalFloatRatio");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioGreaterThan(Float value) {
            addCriterion("eval_float_ratio >", value, "evalFloatRatio");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioGreaterThanOrEqualTo(Float value) {
            addCriterion("eval_float_ratio >=", value, "evalFloatRatio");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioLessThan(Float value) {
            addCriterion("eval_float_ratio <", value, "evalFloatRatio");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioLessThanOrEqualTo(Float value) {
            addCriterion("eval_float_ratio <=", value, "evalFloatRatio");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioIn(List<Float> values) {
            addCriterion("eval_float_ratio in", values, "evalFloatRatio");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioNotIn(List<Float> values) {
            addCriterion("eval_float_ratio not in", values, "evalFloatRatio");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioBetween(Float value1, Float value2) {
            addCriterion("eval_float_ratio between", value1, value2, "evalFloatRatio");
            return (Criteria) this;
        }

        public Criteria andEvalFloatRatioNotBetween(Float value1, Float value2) {
            addCriterion("eval_float_ratio not between", value1, value2, "evalFloatRatio");
            return (Criteria) this;
        }

        public Criteria andAuditRatioIsNull() {
            addCriterion("audit_ratio is null");
            return (Criteria) this;
        }

        public Criteria andAuditRatioIsNotNull() {
            addCriterion("audit_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andAuditRatioEqualTo(Float value) {
            addCriterion("audit_ratio =", value, "auditRatio");
            return (Criteria) this;
        }

        public Criteria andAuditRatioNotEqualTo(Float value) {
            addCriterion("audit_ratio <>", value, "auditRatio");
            return (Criteria) this;
        }

        public Criteria andAuditRatioGreaterThan(Float value) {
            addCriterion("audit_ratio >", value, "auditRatio");
            return (Criteria) this;
        }

        public Criteria andAuditRatioGreaterThanOrEqualTo(Float value) {
            addCriterion("audit_ratio >=", value, "auditRatio");
            return (Criteria) this;
        }

        public Criteria andAuditRatioLessThan(Float value) {
            addCriterion("audit_ratio <", value, "auditRatio");
            return (Criteria) this;
        }

        public Criteria andAuditRatioLessThanOrEqualTo(Float value) {
            addCriterion("audit_ratio <=", value, "auditRatio");
            return (Criteria) this;
        }

        public Criteria andAuditRatioIn(List<Float> values) {
            addCriterion("audit_ratio in", values, "auditRatio");
            return (Criteria) this;
        }

        public Criteria andAuditRatioNotIn(List<Float> values) {
            addCriterion("audit_ratio not in", values, "auditRatio");
            return (Criteria) this;
        }

        public Criteria andAuditRatioBetween(Float value1, Float value2) {
            addCriterion("audit_ratio between", value1, value2, "auditRatio");
            return (Criteria) this;
        }

        public Criteria andAuditRatioNotBetween(Float value1, Float value2) {
            addCriterion("audit_ratio not between", value1, value2, "auditRatio");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexIsNull() {
            addCriterion("compensate_index is null");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexIsNotNull() {
            addCriterion("compensate_index is not null");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexEqualTo(Float value) {
            addCriterion("compensate_index =", value, "compensateIndex");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexNotEqualTo(Float value) {
            addCriterion("compensate_index <>", value, "compensateIndex");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexGreaterThan(Float value) {
            addCriterion("compensate_index >", value, "compensateIndex");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexGreaterThanOrEqualTo(Float value) {
            addCriterion("compensate_index >=", value, "compensateIndex");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexLessThan(Float value) {
            addCriterion("compensate_index <", value, "compensateIndex");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexLessThanOrEqualTo(Float value) {
            addCriterion("compensate_index <=", value, "compensateIndex");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexIn(List<Float> values) {
            addCriterion("compensate_index in", values, "compensateIndex");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexNotIn(List<Float> values) {
            addCriterion("compensate_index not in", values, "compensateIndex");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexBetween(Float value1, Float value2) {
            addCriterion("compensate_index between", value1, value2, "compensateIndex");
            return (Criteria) this;
        }

        public Criteria andCompensateIndexNotBetween(Float value1, Float value2) {
            addCriterion("compensate_index not between", value1, value2, "compensateIndex");
            return (Criteria) this;
        }

        public Criteria andContractDateIsNull() {
            addCriterion("contract_date is null");
            return (Criteria) this;
        }

        public Criteria andContractDateIsNotNull() {
            addCriterion("contract_date is not null");
            return (Criteria) this;
        }

        public Criteria andContractDateEqualTo(Date value) {
            addCriterion("contract_date =", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotEqualTo(Date value) {
            addCriterion("contract_date <>", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateGreaterThan(Date value) {
            addCriterion("contract_date >", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateGreaterThanOrEqualTo(Date value) {
            addCriterion("contract_date >=", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateLessThan(Date value) {
            addCriterion("contract_date <", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateLessThanOrEqualTo(Date value) {
            addCriterion("contract_date <=", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateIn(List<Date> values) {
            addCriterion("contract_date in", values, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotIn(List<Date> values) {
            addCriterion("contract_date not in", values, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateBetween(Date value1, Date value2) {
            addCriterion("contract_date between", value1, value2, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotBetween(Date value1, Date value2) {
            addCriterion("contract_date not between", value1, value2, "contractDate");
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

        public Criteria andCptFlagIsNull() {
            addCriterion("cpt_flag is null");
            return (Criteria) this;
        }

        public Criteria andCptFlagIsNotNull() {
            addCriterion("cpt_flag is not null");
            return (Criteria) this;
        }

        public Criteria andCptFlagEqualTo(String value) {
            addCriterion("cpt_flag =", value, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andCptFlagNotEqualTo(String value) {
            addCriterion("cpt_flag <>", value, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andCptFlagGreaterThan(String value) {
            addCriterion("cpt_flag >", value, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andCptFlagGreaterThanOrEqualTo(String value) {
            addCriterion("cpt_flag >=", value, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andCptFlagLessThan(String value) {
            addCriterion("cpt_flag <", value, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andCptFlagLessThanOrEqualTo(String value) {
            addCriterion("cpt_flag <=", value, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andCptFlagLike(String value) {
            addCriterion("cpt_flag like", value, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andCptFlagNotLike(String value) {
            addCriterion("cpt_flag not like", value, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andCptFlagIn(List<String> values) {
            addCriterion("cpt_flag in", values, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andCptFlagNotIn(List<String> values) {
            addCriterion("cpt_flag not in", values, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andCptFlagBetween(String value1, String value2) {
            addCriterion("cpt_flag between", value1, value2, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andCptFlagNotBetween(String value1, String value2) {
            addCriterion("cpt_flag not between", value1, value2, "cptFlag");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeIsNull() {
            addCriterion("price_4s_code is null");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeIsNotNull() {
            addCriterion("price_4s_code is not null");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeEqualTo(String value) {
            addCriterion("price_4s_code =", value, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeNotEqualTo(String value) {
            addCriterion("price_4s_code <>", value, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeGreaterThan(String value) {
            addCriterion("price_4s_code >", value, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeGreaterThanOrEqualTo(String value) {
            addCriterion("price_4s_code >=", value, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeLessThan(String value) {
            addCriterion("price_4s_code <", value, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeLessThanOrEqualTo(String value) {
            addCriterion("price_4s_code <=", value, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeLike(String value) {
            addCriterion("price_4s_code like", value, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeNotLike(String value) {
            addCriterion("price_4s_code not like", value, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeIn(List<String> values) {
            addCriterion("price_4s_code in", values, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeNotIn(List<String> values) {
            addCriterion("price_4s_code not in", values, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeBetween(String value1, String value2) {
            addCriterion("price_4s_code between", value1, value2, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPrice4sCodeNotBetween(String value1, String value2) {
            addCriterion("price_4s_code not between", value1, value2, "price4sCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeIsNull() {
            addCriterion("price_agreement_code is null");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeIsNotNull() {
            addCriterion("price_agreement_code is not null");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeEqualTo(String value) {
            addCriterion("price_agreement_code =", value, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeNotEqualTo(String value) {
            addCriterion("price_agreement_code <>", value, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeGreaterThan(String value) {
            addCriterion("price_agreement_code >", value, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeGreaterThanOrEqualTo(String value) {
            addCriterion("price_agreement_code >=", value, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeLessThan(String value) {
            addCriterion("price_agreement_code <", value, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeLessThanOrEqualTo(String value) {
            addCriterion("price_agreement_code <=", value, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeLike(String value) {
            addCriterion("price_agreement_code like", value, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeNotLike(String value) {
            addCriterion("price_agreement_code not like", value, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeIn(List<String> values) {
            addCriterion("price_agreement_code in", values, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeNotIn(List<String> values) {
            addCriterion("price_agreement_code not in", values, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeBetween(String value1, String value2) {
            addCriterion("price_agreement_code between", value1, value2, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceAgreementCodeNotBetween(String value1, String value2) {
            addCriterion("price_agreement_code not between", value1, value2, "priceAgreementCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeIsNull() {
            addCriterion("price_mark_code is null");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeIsNotNull() {
            addCriterion("price_mark_code is not null");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeEqualTo(String value) {
            addCriterion("price_mark_code =", value, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeNotEqualTo(String value) {
            addCriterion("price_mark_code <>", value, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeGreaterThan(String value) {
            addCriterion("price_mark_code >", value, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeGreaterThanOrEqualTo(String value) {
            addCriterion("price_mark_code >=", value, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeLessThan(String value) {
            addCriterion("price_mark_code <", value, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeLessThanOrEqualTo(String value) {
            addCriterion("price_mark_code <=", value, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeLike(String value) {
            addCriterion("price_mark_code like", value, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeNotLike(String value) {
            addCriterion("price_mark_code not like", value, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeIn(List<String> values) {
            addCriterion("price_mark_code in", values, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeNotIn(List<String> values) {
            addCriterion("price_mark_code not in", values, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeBetween(String value1, String value2) {
            addCriterion("price_mark_code between", value1, value2, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceMarkCodeNotBetween(String value1, String value2) {
            addCriterion("price_mark_code not between", value1, value2, "priceMarkCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeIsNull() {
            addCriterion("price_tryout_code is null");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeIsNotNull() {
            addCriterion("price_tryout_code is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeEqualTo(String value) {
            addCriterion("price_tryout_code =", value, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeNotEqualTo(String value) {
            addCriterion("price_tryout_code <>", value, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeGreaterThan(String value) {
            addCriterion("price_tryout_code >", value, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeGreaterThanOrEqualTo(String value) {
            addCriterion("price_tryout_code >=", value, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeLessThan(String value) {
            addCriterion("price_tryout_code <", value, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeLessThanOrEqualTo(String value) {
            addCriterion("price_tryout_code <=", value, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeLike(String value) {
            addCriterion("price_tryout_code like", value, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeNotLike(String value) {
            addCriterion("price_tryout_code not like", value, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeIn(List<String> values) {
            addCriterion("price_tryout_code in", values, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeNotIn(List<String> values) {
            addCriterion("price_tryout_code not in", values, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeBetween(String value1, String value2) {
            addCriterion("price_tryout_code between", value1, value2, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPriceTryoutCodeNotBetween(String value1, String value2) {
            addCriterion("price_tryout_code not between", value1, value2, "priceTryoutCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeIsNull() {
            addCriterion("platform_org_code is null");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeIsNotNull() {
            addCriterion("platform_org_code is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeEqualTo(String value) {
            addCriterion("platform_org_code =", value, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeNotEqualTo(String value) {
            addCriterion("platform_org_code <>", value, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeGreaterThan(String value) {
            addCriterion("platform_org_code >", value, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("platform_org_code >=", value, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeLessThan(String value) {
            addCriterion("platform_org_code <", value, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("platform_org_code <=", value, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeLike(String value) {
            addCriterion("platform_org_code like", value, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeNotLike(String value) {
            addCriterion("platform_org_code not like", value, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeIn(List<String> values) {
            addCriterion("platform_org_code in", values, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeNotIn(List<String> values) {
            addCriterion("platform_org_code not in", values, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeBetween(String value1, String value2) {
            addCriterion("platform_org_code between", value1, value2, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andPlatformOrgCodeNotBetween(String value1, String value2) {
            addCriterion("platform_org_code not between", value1, value2, "platformOrgCode");
            return (Criteria) this;
        }

        public Criteria andVideoFlagIsNull() {
            addCriterion("video_flag is null");
            return (Criteria) this;
        }

        public Criteria andVideoFlagIsNotNull() {
            addCriterion("video_flag is not null");
            return (Criteria) this;
        }

        public Criteria andVideoFlagEqualTo(String value) {
            addCriterion("video_flag =", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagNotEqualTo(String value) {
            addCriterion("video_flag <>", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagGreaterThan(String value) {
            addCriterion("video_flag >", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagGreaterThanOrEqualTo(String value) {
            addCriterion("video_flag >=", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagLessThan(String value) {
            addCriterion("video_flag <", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagLessThanOrEqualTo(String value) {
            addCriterion("video_flag <=", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagLike(String value) {
            addCriterion("video_flag like", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagNotLike(String value) {
            addCriterion("video_flag not like", value, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagIn(List<String> values) {
            addCriterion("video_flag in", values, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagNotIn(List<String> values) {
            addCriterion("video_flag not in", values, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagBetween(String value1, String value2) {
            addCriterion("video_flag between", value1, value2, "videoFlag");
            return (Criteria) this;
        }

        public Criteria andVideoFlagNotBetween(String value1, String value2) {
            addCriterion("video_flag not between", value1, value2, "videoFlag");
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

        public Criteria andRepairScopeIsNull() {
            addCriterion("repair_scope is null");
            return (Criteria) this;
        }

        public Criteria andRepairScopeIsNotNull() {
            addCriterion("repair_scope is not null");
            return (Criteria) this;
        }

        public Criteria andRepairScopeEqualTo(String value) {
            addCriterion("repair_scope =", value, "repairScope");
            return (Criteria) this;
        }

        public Criteria andRepairScopeNotEqualTo(String value) {
            addCriterion("repair_scope <>", value, "repairScope");
            return (Criteria) this;
        }

        public Criteria andRepairScopeGreaterThan(String value) {
            addCriterion("repair_scope >", value, "repairScope");
            return (Criteria) this;
        }

        public Criteria andRepairScopeGreaterThanOrEqualTo(String value) {
            addCriterion("repair_scope >=", value, "repairScope");
            return (Criteria) this;
        }

        public Criteria andRepairScopeLessThan(String value) {
            addCriterion("repair_scope <", value, "repairScope");
            return (Criteria) this;
        }

        public Criteria andRepairScopeLessThanOrEqualTo(String value) {
            addCriterion("repair_scope <=", value, "repairScope");
            return (Criteria) this;
        }

        public Criteria andRepairScopeLike(String value) {
            addCriterion("repair_scope like", value, "repairScope");
            return (Criteria) this;
        }

        public Criteria andRepairScopeNotLike(String value) {
            addCriterion("repair_scope not like", value, "repairScope");
            return (Criteria) this;
        }

        public Criteria andRepairScopeIn(List<String> values) {
            addCriterion("repair_scope in", values, "repairScope");
            return (Criteria) this;
        }

        public Criteria andRepairScopeNotIn(List<String> values) {
            addCriterion("repair_scope not in", values, "repairScope");
            return (Criteria) this;
        }

        public Criteria andRepairScopeBetween(String value1, String value2) {
            addCriterion("repair_scope between", value1, value2, "repairScope");
            return (Criteria) this;
        }

        public Criteria andRepairScopeNotBetween(String value1, String value2) {
            addCriterion("repair_scope not between", value1, value2, "repairScope");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandIsNull() {
            addCriterion("specialized_brand is null");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandIsNotNull() {
            addCriterion("specialized_brand is not null");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandEqualTo(String value) {
            addCriterion("specialized_brand =", value, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandNotEqualTo(String value) {
            addCriterion("specialized_brand <>", value, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandGreaterThan(String value) {
            addCriterion("specialized_brand >", value, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandGreaterThanOrEqualTo(String value) {
            addCriterion("specialized_brand >=", value, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandLessThan(String value) {
            addCriterion("specialized_brand <", value, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandLessThanOrEqualTo(String value) {
            addCriterion("specialized_brand <=", value, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandLike(String value) {
            addCriterion("specialized_brand like", value, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandNotLike(String value) {
            addCriterion("specialized_brand not like", value, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandIn(List<String> values) {
            addCriterion("specialized_brand in", values, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandNotIn(List<String> values) {
            addCriterion("specialized_brand not in", values, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandBetween(String value1, String value2) {
            addCriterion("specialized_brand between", value1, value2, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andSpecializedBrandNotBetween(String value1, String value2) {
            addCriterion("specialized_brand not between", value1, value2, "specializedBrand");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionIsNull() {
            addCriterion("audit_opinion is null");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionIsNotNull() {
            addCriterion("audit_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionEqualTo(String value) {
            addCriterion("audit_opinion =", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotEqualTo(String value) {
            addCriterion("audit_opinion <>", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionGreaterThan(String value) {
            addCriterion("audit_opinion >", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("audit_opinion >=", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionLessThan(String value) {
            addCriterion("audit_opinion <", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionLessThanOrEqualTo(String value) {
            addCriterion("audit_opinion <=", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionLike(String value) {
            addCriterion("audit_opinion like", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotLike(String value) {
            addCriterion("audit_opinion not like", value, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionIn(List<String> values) {
            addCriterion("audit_opinion in", values, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotIn(List<String> values) {
            addCriterion("audit_opinion not in", values, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionBetween(String value1, String value2) {
            addCriterion("audit_opinion between", value1, value2, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andAuditOpinionNotBetween(String value1, String value2) {
            addCriterion("audit_opinion not between", value1, value2, "auditOpinion");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAccountcodeIsNull() {
            addCriterion("accountCode is null");
            return (Criteria) this;
        }

        public Criteria andAccountcodeIsNotNull() {
            addCriterion("accountCode is not null");
            return (Criteria) this;
        }

        public Criteria andAccountcodeEqualTo(String value) {
            addCriterion("accountCode =", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeNotEqualTo(String value) {
            addCriterion("accountCode <>", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeGreaterThan(String value) {
            addCriterion("accountCode >", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeGreaterThanOrEqualTo(String value) {
            addCriterion("accountCode >=", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeLessThan(String value) {
            addCriterion("accountCode <", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeLessThanOrEqualTo(String value) {
            addCriterion("accountCode <=", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeLike(String value) {
            addCriterion("accountCode like", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeNotLike(String value) {
            addCriterion("accountCode not like", value, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeIn(List<String> values) {
            addCriterion("accountCode in", values, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeNotIn(List<String> values) {
            addCriterion("accountCode not in", values, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeBetween(String value1, String value2) {
            addCriterion("accountCode between", value1, value2, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountcodeNotBetween(String value1, String value2) {
            addCriterion("accountCode not between", value1, value2, "accountcode");
            return (Criteria) this;
        }

        public Criteria andAccountnameIsNull() {
            addCriterion("accountName is null");
            return (Criteria) this;
        }

        public Criteria andAccountnameIsNotNull() {
            addCriterion("accountName is not null");
            return (Criteria) this;
        }

        public Criteria andAccountnameEqualTo(String value) {
            addCriterion("accountName =", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotEqualTo(String value) {
            addCriterion("accountName <>", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameGreaterThan(String value) {
            addCriterion("accountName >", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameGreaterThanOrEqualTo(String value) {
            addCriterion("accountName >=", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameLessThan(String value) {
            addCriterion("accountName <", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameLessThanOrEqualTo(String value) {
            addCriterion("accountName <=", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameLike(String value) {
            addCriterion("accountName like", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotLike(String value) {
            addCriterion("accountName not like", value, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameIn(List<String> values) {
            addCriterion("accountName in", values, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotIn(List<String> values) {
            addCriterion("accountName not in", values, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameBetween(String value1, String value2) {
            addCriterion("accountName between", value1, value2, "accountname");
            return (Criteria) this;
        }

        public Criteria andAccountnameNotBetween(String value1, String value2) {
            addCriterion("accountName not between", value1, value2, "accountname");
            return (Criteria) this;
        }

        public Criteria andBanknameIsNull() {
            addCriterion("bankName is null");
            return (Criteria) this;
        }

        public Criteria andBanknameIsNotNull() {
            addCriterion("bankName is not null");
            return (Criteria) this;
        }

        public Criteria andBanknameEqualTo(String value) {
            addCriterion("bankName =", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotEqualTo(String value) {
            addCriterion("bankName <>", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameGreaterThan(String value) {
            addCriterion("bankName >", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameGreaterThanOrEqualTo(String value) {
            addCriterion("bankName >=", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLessThan(String value) {
            addCriterion("bankName <", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLessThanOrEqualTo(String value) {
            addCriterion("bankName <=", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameLike(String value) {
            addCriterion("bankName like", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotLike(String value) {
            addCriterion("bankName not like", value, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameIn(List<String> values) {
            addCriterion("bankName in", values, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotIn(List<String> values) {
            addCriterion("bankName not in", values, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameBetween(String value1, String value2) {
            addCriterion("bankName between", value1, value2, "bankname");
            return (Criteria) this;
        }

        public Criteria andBanknameNotBetween(String value1, String value2) {
            addCriterion("bankName not between", value1, value2, "bankname");
            return (Criteria) this;
        }

        public Criteria andCitycodeIsNull() {
            addCriterion("cityCode is null");
            return (Criteria) this;
        }

        public Criteria andCitycodeIsNotNull() {
            addCriterion("cityCode is not null");
            return (Criteria) this;
        }

        public Criteria andCitycodeEqualTo(String value) {
            addCriterion("cityCode =", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotEqualTo(String value) {
            addCriterion("cityCode <>", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThan(String value) {
            addCriterion("cityCode >", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeGreaterThanOrEqualTo(String value) {
            addCriterion("cityCode >=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThan(String value) {
            addCriterion("cityCode <", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLessThanOrEqualTo(String value) {
            addCriterion("cityCode <=", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeLike(String value) {
            addCriterion("cityCode like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotLike(String value) {
            addCriterion("cityCode not like", value, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeIn(List<String> values) {
            addCriterion("cityCode in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotIn(List<String> values) {
            addCriterion("cityCode not in", values, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeBetween(String value1, String value2) {
            addCriterion("cityCode between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andCitycodeNotBetween(String value1, String value2) {
            addCriterion("cityCode not between", value1, value2, "citycode");
            return (Criteria) this;
        }

        public Criteria andTowncodeIsNull() {
            addCriterion("townCode is null");
            return (Criteria) this;
        }

        public Criteria andTowncodeIsNotNull() {
            addCriterion("townCode is not null");
            return (Criteria) this;
        }

        public Criteria andTowncodeEqualTo(String value) {
            addCriterion("townCode =", value, "towncode");
            return (Criteria) this;
        }

        public Criteria andTowncodeNotEqualTo(String value) {
            addCriterion("townCode <>", value, "towncode");
            return (Criteria) this;
        }

        public Criteria andTowncodeGreaterThan(String value) {
            addCriterion("townCode >", value, "towncode");
            return (Criteria) this;
        }

        public Criteria andTowncodeGreaterThanOrEqualTo(String value) {
            addCriterion("townCode >=", value, "towncode");
            return (Criteria) this;
        }

        public Criteria andTowncodeLessThan(String value) {
            addCriterion("townCode <", value, "towncode");
            return (Criteria) this;
        }

        public Criteria andTowncodeLessThanOrEqualTo(String value) {
            addCriterion("townCode <=", value, "towncode");
            return (Criteria) this;
        }

        public Criteria andTowncodeLike(String value) {
            addCriterion("townCode like", value, "towncode");
            return (Criteria) this;
        }

        public Criteria andTowncodeNotLike(String value) {
            addCriterion("townCode not like", value, "towncode");
            return (Criteria) this;
        }

        public Criteria andTowncodeIn(List<String> values) {
            addCriterion("townCode in", values, "towncode");
            return (Criteria) this;
        }

        public Criteria andTowncodeNotIn(List<String> values) {
            addCriterion("townCode not in", values, "towncode");
            return (Criteria) this;
        }

        public Criteria andTowncodeBetween(String value1, String value2) {
            addCriterion("townCode between", value1, value2, "towncode");
            return (Criteria) this;
        }

        public Criteria andTowncodeNotBetween(String value1, String value2) {
            addCriterion("townCode not between", value1, value2, "towncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeIsNull() {
            addCriterion("regionCode is null");
            return (Criteria) this;
        }

        public Criteria andRegioncodeIsNotNull() {
            addCriterion("regionCode is not null");
            return (Criteria) this;
        }

        public Criteria andRegioncodeEqualTo(String value) {
            addCriterion("regionCode =", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotEqualTo(String value) {
            addCriterion("regionCode <>", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeGreaterThan(String value) {
            addCriterion("regionCode >", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeGreaterThanOrEqualTo(String value) {
            addCriterion("regionCode >=", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeLessThan(String value) {
            addCriterion("regionCode <", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeLessThanOrEqualTo(String value) {
            addCriterion("regionCode <=", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeLike(String value) {
            addCriterion("regionCode like", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotLike(String value) {
            addCriterion("regionCode not like", value, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeIn(List<String> values) {
            addCriterion("regionCode in", values, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotIn(List<String> values) {
            addCriterion("regionCode not in", values, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeBetween(String value1, String value2) {
            addCriterion("regionCode between", value1, value2, "regioncode");
            return (Criteria) this;
        }

        public Criteria andRegioncodeNotBetween(String value1, String value2) {
            addCriterion("regionCode not between", value1, value2, "regioncode");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNull() {
            addCriterion("cityName is null");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNotNull() {
            addCriterion("cityName is not null");
            return (Criteria) this;
        }

        public Criteria andCitynameEqualTo(String value) {
            addCriterion("cityName =", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotEqualTo(String value) {
            addCriterion("cityName <>", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThan(String value) {
            addCriterion("cityName >", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThanOrEqualTo(String value) {
            addCriterion("cityName >=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThan(String value) {
            addCriterion("cityName <", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThanOrEqualTo(String value) {
            addCriterion("cityName <=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLike(String value) {
            addCriterion("cityName like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotLike(String value) {
            addCriterion("cityName not like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameIn(List<String> values) {
            addCriterion("cityName in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotIn(List<String> values) {
            addCriterion("cityName not in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameBetween(String value1, String value2) {
            addCriterion("cityName between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotBetween(String value1, String value2) {
            addCriterion("cityName not between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andTownnameIsNull() {
            addCriterion("townName is null");
            return (Criteria) this;
        }

        public Criteria andTownnameIsNotNull() {
            addCriterion("townName is not null");
            return (Criteria) this;
        }

        public Criteria andTownnameEqualTo(String value) {
            addCriterion("townName =", value, "townname");
            return (Criteria) this;
        }

        public Criteria andTownnameNotEqualTo(String value) {
            addCriterion("townName <>", value, "townname");
            return (Criteria) this;
        }

        public Criteria andTownnameGreaterThan(String value) {
            addCriterion("townName >", value, "townname");
            return (Criteria) this;
        }

        public Criteria andTownnameGreaterThanOrEqualTo(String value) {
            addCriterion("townName >=", value, "townname");
            return (Criteria) this;
        }

        public Criteria andTownnameLessThan(String value) {
            addCriterion("townName <", value, "townname");
            return (Criteria) this;
        }

        public Criteria andTownnameLessThanOrEqualTo(String value) {
            addCriterion("townName <=", value, "townname");
            return (Criteria) this;
        }

        public Criteria andTownnameLike(String value) {
            addCriterion("townName like", value, "townname");
            return (Criteria) this;
        }

        public Criteria andTownnameNotLike(String value) {
            addCriterion("townName not like", value, "townname");
            return (Criteria) this;
        }

        public Criteria andTownnameIn(List<String> values) {
            addCriterion("townName in", values, "townname");
            return (Criteria) this;
        }

        public Criteria andTownnameNotIn(List<String> values) {
            addCriterion("townName not in", values, "townname");
            return (Criteria) this;
        }

        public Criteria andTownnameBetween(String value1, String value2) {
            addCriterion("townName between", value1, value2, "townname");
            return (Criteria) this;
        }

        public Criteria andTownnameNotBetween(String value1, String value2) {
            addCriterion("townName not between", value1, value2, "townname");
            return (Criteria) this;
        }

        public Criteria andRegionnameIsNull() {
            addCriterion("regionName is null");
            return (Criteria) this;
        }

        public Criteria andRegionnameIsNotNull() {
            addCriterion("regionName is not null");
            return (Criteria) this;
        }

        public Criteria andRegionnameEqualTo(String value) {
            addCriterion("regionName =", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotEqualTo(String value) {
            addCriterion("regionName <>", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameGreaterThan(String value) {
            addCriterion("regionName >", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameGreaterThanOrEqualTo(String value) {
            addCriterion("regionName >=", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameLessThan(String value) {
            addCriterion("regionName <", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameLessThanOrEqualTo(String value) {
            addCriterion("regionName <=", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameLike(String value) {
            addCriterion("regionName like", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotLike(String value) {
            addCriterion("regionName not like", value, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameIn(List<String> values) {
            addCriterion("regionName in", values, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotIn(List<String> values) {
            addCriterion("regionName not in", values, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameBetween(String value1, String value2) {
            addCriterion("regionName between", value1, value2, "regionname");
            return (Criteria) this;
        }

        public Criteria andRegionnameNotBetween(String value1, String value2) {
            addCriterion("regionName not between", value1, value2, "regionname");
            return (Criteria) this;
        }

        public Criteria andBrandcodeIsNull() {
            addCriterion("brandCode is null");
            return (Criteria) this;
        }

        public Criteria andBrandcodeIsNotNull() {
            addCriterion("brandCode is not null");
            return (Criteria) this;
        }

        public Criteria andBrandcodeEqualTo(String value) {
            addCriterion("brandCode =", value, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandcodeNotEqualTo(String value) {
            addCriterion("brandCode <>", value, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandcodeGreaterThan(String value) {
            addCriterion("brandCode >", value, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandcodeGreaterThanOrEqualTo(String value) {
            addCriterion("brandCode >=", value, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandcodeLessThan(String value) {
            addCriterion("brandCode <", value, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandcodeLessThanOrEqualTo(String value) {
            addCriterion("brandCode <=", value, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandcodeLike(String value) {
            addCriterion("brandCode like", value, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandcodeNotLike(String value) {
            addCriterion("brandCode not like", value, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandcodeIn(List<String> values) {
            addCriterion("brandCode in", values, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandcodeNotIn(List<String> values) {
            addCriterion("brandCode not in", values, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandcodeBetween(String value1, String value2) {
            addCriterion("brandCode between", value1, value2, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandcodeNotBetween(String value1, String value2) {
            addCriterion("brandCode not between", value1, value2, "brandcode");
            return (Criteria) this;
        }

        public Criteria andBrandnameIsNull() {
            addCriterion("brandName is null");
            return (Criteria) this;
        }

        public Criteria andBrandnameIsNotNull() {
            addCriterion("brandName is not null");
            return (Criteria) this;
        }

        public Criteria andBrandnameEqualTo(String value) {
            addCriterion("brandName =", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotEqualTo(String value) {
            addCriterion("brandName <>", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameGreaterThan(String value) {
            addCriterion("brandName >", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameGreaterThanOrEqualTo(String value) {
            addCriterion("brandName >=", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLessThan(String value) {
            addCriterion("brandName <", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLessThanOrEqualTo(String value) {
            addCriterion("brandName <=", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameLike(String value) {
            addCriterion("brandName like", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotLike(String value) {
            addCriterion("brandName not like", value, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameIn(List<String> values) {
            addCriterion("brandName in", values, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotIn(List<String> values) {
            addCriterion("brandName not in", values, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameBetween(String value1, String value2) {
            addCriterion("brandName between", value1, value2, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandnameNotBetween(String value1, String value2) {
            addCriterion("brandName not between", value1, value2, "brandname");
            return (Criteria) this;
        }

        public Criteria andBrandpercentIsNull() {
            addCriterion("brandPercent is null");
            return (Criteria) this;
        }

        public Criteria andBrandpercentIsNotNull() {
            addCriterion("brandPercent is not null");
            return (Criteria) this;
        }

        public Criteria andBrandpercentEqualTo(Float value) {
            addCriterion("brandPercent =", value, "brandpercent");
            return (Criteria) this;
        }

        public Criteria andBrandpercentNotEqualTo(Float value) {
            addCriterion("brandPercent <>", value, "brandpercent");
            return (Criteria) this;
        }

        public Criteria andBrandpercentGreaterThan(Float value) {
            addCriterion("brandPercent >", value, "brandpercent");
            return (Criteria) this;
        }

        public Criteria andBrandpercentGreaterThanOrEqualTo(Float value) {
            addCriterion("brandPercent >=", value, "brandpercent");
            return (Criteria) this;
        }

        public Criteria andBrandpercentLessThan(Float value) {
            addCriterion("brandPercent <", value, "brandpercent");
            return (Criteria) this;
        }

        public Criteria andBrandpercentLessThanOrEqualTo(Float value) {
            addCriterion("brandPercent <=", value, "brandpercent");
            return (Criteria) this;
        }

        public Criteria andBrandpercentIn(List<Float> values) {
            addCriterion("brandPercent in", values, "brandpercent");
            return (Criteria) this;
        }

        public Criteria andBrandpercentNotIn(List<Float> values) {
            addCriterion("brandPercent not in", values, "brandpercent");
            return (Criteria) this;
        }

        public Criteria andBrandpercentBetween(Float value1, Float value2) {
            addCriterion("brandPercent between", value1, value2, "brandpercent");
            return (Criteria) this;
        }

        public Criteria andBrandpercentNotBetween(Float value1, Float value2) {
            addCriterion("brandPercent not between", value1, value2, "brandpercent");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeIsNull() {
            addCriterion("atticePointCode is null");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeIsNotNull() {
            addCriterion("atticePointCode is not null");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeEqualTo(String value) {
            addCriterion("atticePointCode =", value, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeNotEqualTo(String value) {
            addCriterion("atticePointCode <>", value, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeGreaterThan(String value) {
            addCriterion("atticePointCode >", value, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeGreaterThanOrEqualTo(String value) {
            addCriterion("atticePointCode >=", value, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeLessThan(String value) {
            addCriterion("atticePointCode <", value, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeLessThanOrEqualTo(String value) {
            addCriterion("atticePointCode <=", value, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeLike(String value) {
            addCriterion("atticePointCode like", value, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeNotLike(String value) {
            addCriterion("atticePointCode not like", value, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeIn(List<String> values) {
            addCriterion("atticePointCode in", values, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeNotIn(List<String> values) {
            addCriterion("atticePointCode not in", values, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeBetween(String value1, String value2) {
            addCriterion("atticePointCode between", value1, value2, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointcodeNotBetween(String value1, String value2) {
            addCriterion("atticePointCode not between", value1, value2, "atticepointcode");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameIsNull() {
            addCriterion("atticePointName is null");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameIsNotNull() {
            addCriterion("atticePointName is not null");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameEqualTo(String value) {
            addCriterion("atticePointName =", value, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameNotEqualTo(String value) {
            addCriterion("atticePointName <>", value, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameGreaterThan(String value) {
            addCriterion("atticePointName >", value, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameGreaterThanOrEqualTo(String value) {
            addCriterion("atticePointName >=", value, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameLessThan(String value) {
            addCriterion("atticePointName <", value, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameLessThanOrEqualTo(String value) {
            addCriterion("atticePointName <=", value, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameLike(String value) {
            addCriterion("atticePointName like", value, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameNotLike(String value) {
            addCriterion("atticePointName not like", value, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameIn(List<String> values) {
            addCriterion("atticePointName in", values, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameNotIn(List<String> values) {
            addCriterion("atticePointName not in", values, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameBetween(String value1, String value2) {
            addCriterion("atticePointName between", value1, value2, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andAtticepointnameNotBetween(String value1, String value2) {
            addCriterion("atticePointName not between", value1, value2, "atticepointname");
            return (Criteria) this;
        }

        public Criteria andPartspercentIsNull() {
            addCriterion("partsPercent is null");
            return (Criteria) this;
        }

        public Criteria andPartspercentIsNotNull() {
            addCriterion("partsPercent is not null");
            return (Criteria) this;
        }

        public Criteria andPartspercentEqualTo(Float value) {
            addCriterion("partsPercent =", value, "partspercent");
            return (Criteria) this;
        }

        public Criteria andPartspercentNotEqualTo(Float value) {
            addCriterion("partsPercent <>", value, "partspercent");
            return (Criteria) this;
        }

        public Criteria andPartspercentGreaterThan(Float value) {
            addCriterion("partsPercent >", value, "partspercent");
            return (Criteria) this;
        }

        public Criteria andPartspercentGreaterThanOrEqualTo(Float value) {
            addCriterion("partsPercent >=", value, "partspercent");
            return (Criteria) this;
        }

        public Criteria andPartspercentLessThan(Float value) {
            addCriterion("partsPercent <", value, "partspercent");
            return (Criteria) this;
        }

        public Criteria andPartspercentLessThanOrEqualTo(Float value) {
            addCriterion("partsPercent <=", value, "partspercent");
            return (Criteria) this;
        }

        public Criteria andPartspercentIn(List<Float> values) {
            addCriterion("partsPercent in", values, "partspercent");
            return (Criteria) this;
        }

        public Criteria andPartspercentNotIn(List<Float> values) {
            addCriterion("partsPercent not in", values, "partspercent");
            return (Criteria) this;
        }

        public Criteria andPartspercentBetween(Float value1, Float value2) {
            addCriterion("partsPercent between", value1, value2, "partspercent");
            return (Criteria) this;
        }

        public Criteria andPartspercentNotBetween(Float value1, Float value2) {
            addCriterion("partsPercent not between", value1, value2, "partspercent");
            return (Criteria) this;
        }

        public Criteria andVerifyflagIsNull() {
            addCriterion("verifyFlag is null");
            return (Criteria) this;
        }

        public Criteria andVerifyflagIsNotNull() {
            addCriterion("verifyFlag is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyflagEqualTo(String value) {
            addCriterion("verifyFlag =", value, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifyflagNotEqualTo(String value) {
            addCriterion("verifyFlag <>", value, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifyflagGreaterThan(String value) {
            addCriterion("verifyFlag >", value, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifyflagGreaterThanOrEqualTo(String value) {
            addCriterion("verifyFlag >=", value, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifyflagLessThan(String value) {
            addCriterion("verifyFlag <", value, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifyflagLessThanOrEqualTo(String value) {
            addCriterion("verifyFlag <=", value, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifyflagLike(String value) {
            addCriterion("verifyFlag like", value, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifyflagNotLike(String value) {
            addCriterion("verifyFlag not like", value, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifyflagIn(List<String> values) {
            addCriterion("verifyFlag in", values, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifyflagNotIn(List<String> values) {
            addCriterion("verifyFlag not in", values, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifyflagBetween(String value1, String value2) {
            addCriterion("verifyFlag between", value1, value2, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifyflagNotBetween(String value1, String value2) {
            addCriterion("verifyFlag not between", value1, value2, "verifyflag");
            return (Criteria) this;
        }

        public Criteria andVerifybyIsNull() {
            addCriterion("verifyBy is null");
            return (Criteria) this;
        }

        public Criteria andVerifybyIsNotNull() {
            addCriterion("verifyBy is not null");
            return (Criteria) this;
        }

        public Criteria andVerifybyEqualTo(String value) {
            addCriterion("verifyBy =", value, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifybyNotEqualTo(String value) {
            addCriterion("verifyBy <>", value, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifybyGreaterThan(String value) {
            addCriterion("verifyBy >", value, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifybyGreaterThanOrEqualTo(String value) {
            addCriterion("verifyBy >=", value, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifybyLessThan(String value) {
            addCriterion("verifyBy <", value, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifybyLessThanOrEqualTo(String value) {
            addCriterion("verifyBy <=", value, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifybyLike(String value) {
            addCriterion("verifyBy like", value, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifybyNotLike(String value) {
            addCriterion("verifyBy not like", value, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifybyIn(List<String> values) {
            addCriterion("verifyBy in", values, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifybyNotIn(List<String> values) {
            addCriterion("verifyBy not in", values, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifybyBetween(String value1, String value2) {
            addCriterion("verifyBy between", value1, value2, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifybyNotBetween(String value1, String value2) {
            addCriterion("verifyBy not between", value1, value2, "verifyby");
            return (Criteria) this;
        }

        public Criteria andVerifydateIsNull() {
            addCriterion("verifyDate is null");
            return (Criteria) this;
        }

        public Criteria andVerifydateIsNotNull() {
            addCriterion("verifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andVerifydateEqualTo(Date value) {
            addCriterion("verifyDate =", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateNotEqualTo(Date value) {
            addCriterion("verifyDate <>", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateGreaterThan(Date value) {
            addCriterion("verifyDate >", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateGreaterThanOrEqualTo(Date value) {
            addCriterion("verifyDate >=", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateLessThan(Date value) {
            addCriterion("verifyDate <", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateLessThanOrEqualTo(Date value) {
            addCriterion("verifyDate <=", value, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateIn(List<Date> values) {
            addCriterion("verifyDate in", values, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateNotIn(List<Date> values) {
            addCriterion("verifyDate not in", values, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateBetween(Date value1, Date value2) {
            addCriterion("verifyDate between", value1, value2, "verifydate");
            return (Criteria) this;
        }

        public Criteria andVerifydateNotBetween(Date value1, Date value2) {
            addCriterion("verifyDate not between", value1, value2, "verifydate");
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