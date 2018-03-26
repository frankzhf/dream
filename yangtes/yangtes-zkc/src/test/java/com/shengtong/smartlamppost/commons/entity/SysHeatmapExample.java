package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysHeatmapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysHeatmapExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBranchIdIsNull() {
            addCriterion("branch_id is null");
            return (Criteria) this;
        }

        public Criteria andBranchIdIsNotNull() {
            addCriterion("branch_id is not null");
            return (Criteria) this;
        }

        public Criteria andBranchIdEqualTo(String value) {
            addCriterion("branch_id =", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdNotEqualTo(String value) {
            addCriterion("branch_id <>", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdGreaterThan(String value) {
            addCriterion("branch_id >", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdGreaterThanOrEqualTo(String value) {
            addCriterion("branch_id >=", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdLessThan(String value) {
            addCriterion("branch_id <", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdLessThanOrEqualTo(String value) {
            addCriterion("branch_id <=", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdLike(String value) {
            addCriterion("branch_id like", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdNotLike(String value) {
            addCriterion("branch_id not like", value, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdIn(List<String> values) {
            addCriterion("branch_id in", values, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdNotIn(List<String> values) {
            addCriterion("branch_id not in", values, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdBetween(String value1, String value2) {
            addCriterion("branch_id between", value1, value2, "branchId");
            return (Criteria) this;
        }

        public Criteria andBranchIdNotBetween(String value1, String value2) {
            addCriterion("branch_id not between", value1, value2, "branchId");
            return (Criteria) this;
        }

        public Criteria andParameterCodeIsNull() {
            addCriterion("parameter_code is null");
            return (Criteria) this;
        }

        public Criteria andParameterCodeIsNotNull() {
            addCriterion("parameter_code is not null");
            return (Criteria) this;
        }

        public Criteria andParameterCodeEqualTo(String value) {
            addCriterion("parameter_code =", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotEqualTo(String value) {
            addCriterion("parameter_code <>", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeGreaterThan(String value) {
            addCriterion("parameter_code >", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_code >=", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeLessThan(String value) {
            addCriterion("parameter_code <", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeLessThanOrEqualTo(String value) {
            addCriterion("parameter_code <=", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeLike(String value) {
            addCriterion("parameter_code like", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotLike(String value) {
            addCriterion("parameter_code not like", value, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeIn(List<String> values) {
            addCriterion("parameter_code in", values, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotIn(List<String> values) {
            addCriterion("parameter_code not in", values, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeBetween(String value1, String value2) {
            addCriterion("parameter_code between", value1, value2, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterCodeNotBetween(String value1, String value2) {
            addCriterion("parameter_code not between", value1, value2, "parameterCode");
            return (Criteria) this;
        }

        public Criteria andParameterDescIsNull() {
            addCriterion("parameter_desc is null");
            return (Criteria) this;
        }

        public Criteria andParameterDescIsNotNull() {
            addCriterion("parameter_desc is not null");
            return (Criteria) this;
        }

        public Criteria andParameterDescEqualTo(String value) {
            addCriterion("parameter_desc =", value, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterDescNotEqualTo(String value) {
            addCriterion("parameter_desc <>", value, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterDescGreaterThan(String value) {
            addCriterion("parameter_desc >", value, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterDescGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_desc >=", value, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterDescLessThan(String value) {
            addCriterion("parameter_desc <", value, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterDescLessThanOrEqualTo(String value) {
            addCriterion("parameter_desc <=", value, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterDescLike(String value) {
            addCriterion("parameter_desc like", value, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterDescNotLike(String value) {
            addCriterion("parameter_desc not like", value, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterDescIn(List<String> values) {
            addCriterion("parameter_desc in", values, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterDescNotIn(List<String> values) {
            addCriterion("parameter_desc not in", values, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterDescBetween(String value1, String value2) {
            addCriterion("parameter_desc between", value1, value2, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterDescNotBetween(String value1, String value2) {
            addCriterion("parameter_desc not between", value1, value2, "parameterDesc");
            return (Criteria) this;
        }

        public Criteria andParameterUnitIsNull() {
            addCriterion("parameter_unit is null");
            return (Criteria) this;
        }

        public Criteria andParameterUnitIsNotNull() {
            addCriterion("parameter_unit is not null");
            return (Criteria) this;
        }

        public Criteria andParameterUnitEqualTo(String value) {
            addCriterion("parameter_unit =", value, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andParameterUnitNotEqualTo(String value) {
            addCriterion("parameter_unit <>", value, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andParameterUnitGreaterThan(String value) {
            addCriterion("parameter_unit >", value, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andParameterUnitGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_unit >=", value, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andParameterUnitLessThan(String value) {
            addCriterion("parameter_unit <", value, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andParameterUnitLessThanOrEqualTo(String value) {
            addCriterion("parameter_unit <=", value, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andParameterUnitLike(String value) {
            addCriterion("parameter_unit like", value, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andParameterUnitNotLike(String value) {
            addCriterion("parameter_unit not like", value, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andParameterUnitIn(List<String> values) {
            addCriterion("parameter_unit in", values, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andParameterUnitNotIn(List<String> values) {
            addCriterion("parameter_unit not in", values, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andParameterUnitBetween(String value1, String value2) {
            addCriterion("parameter_unit between", value1, value2, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andParameterUnitNotBetween(String value1, String value2) {
            addCriterion("parameter_unit not between", value1, value2, "parameterUnit");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1IsNull() {
            addCriterion("area_max_value1 is null");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1IsNotNull() {
            addCriterion("area_max_value1 is not null");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1EqualTo(String value) {
            addCriterion("area_max_value1 =", value, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1NotEqualTo(String value) {
            addCriterion("area_max_value1 <>", value, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1GreaterThan(String value) {
            addCriterion("area_max_value1 >", value, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1GreaterThanOrEqualTo(String value) {
            addCriterion("area_max_value1 >=", value, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1LessThan(String value) {
            addCriterion("area_max_value1 <", value, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1LessThanOrEqualTo(String value) {
            addCriterion("area_max_value1 <=", value, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1Like(String value) {
            addCriterion("area_max_value1 like", value, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1NotLike(String value) {
            addCriterion("area_max_value1 not like", value, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1In(List<String> values) {
            addCriterion("area_max_value1 in", values, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1NotIn(List<String> values) {
            addCriterion("area_max_value1 not in", values, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1Between(String value1, String value2) {
            addCriterion("area_max_value1 between", value1, value2, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue1NotBetween(String value1, String value2) {
            addCriterion("area_max_value1 not between", value1, value2, "areaMaxValue1");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2IsNull() {
            addCriterion("area_max_value2 is null");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2IsNotNull() {
            addCriterion("area_max_value2 is not null");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2EqualTo(String value) {
            addCriterion("area_max_value2 =", value, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2NotEqualTo(String value) {
            addCriterion("area_max_value2 <>", value, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2GreaterThan(String value) {
            addCriterion("area_max_value2 >", value, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2GreaterThanOrEqualTo(String value) {
            addCriterion("area_max_value2 >=", value, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2LessThan(String value) {
            addCriterion("area_max_value2 <", value, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2LessThanOrEqualTo(String value) {
            addCriterion("area_max_value2 <=", value, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2Like(String value) {
            addCriterion("area_max_value2 like", value, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2NotLike(String value) {
            addCriterion("area_max_value2 not like", value, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2In(List<String> values) {
            addCriterion("area_max_value2 in", values, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2NotIn(List<String> values) {
            addCriterion("area_max_value2 not in", values, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2Between(String value1, String value2) {
            addCriterion("area_max_value2 between", value1, value2, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue2NotBetween(String value1, String value2) {
            addCriterion("area_max_value2 not between", value1, value2, "areaMaxValue2");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3IsNull() {
            addCriterion("area_max_value3 is null");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3IsNotNull() {
            addCriterion("area_max_value3 is not null");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3EqualTo(String value) {
            addCriterion("area_max_value3 =", value, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3NotEqualTo(String value) {
            addCriterion("area_max_value3 <>", value, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3GreaterThan(String value) {
            addCriterion("area_max_value3 >", value, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3GreaterThanOrEqualTo(String value) {
            addCriterion("area_max_value3 >=", value, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3LessThan(String value) {
            addCriterion("area_max_value3 <", value, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3LessThanOrEqualTo(String value) {
            addCriterion("area_max_value3 <=", value, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3Like(String value) {
            addCriterion("area_max_value3 like", value, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3NotLike(String value) {
            addCriterion("area_max_value3 not like", value, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3In(List<String> values) {
            addCriterion("area_max_value3 in", values, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3NotIn(List<String> values) {
            addCriterion("area_max_value3 not in", values, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3Between(String value1, String value2) {
            addCriterion("area_max_value3 between", value1, value2, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue3NotBetween(String value1, String value2) {
            addCriterion("area_max_value3 not between", value1, value2, "areaMaxValue3");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4IsNull() {
            addCriterion("area_max_value4 is null");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4IsNotNull() {
            addCriterion("area_max_value4 is not null");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4EqualTo(String value) {
            addCriterion("area_max_value4 =", value, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4NotEqualTo(String value) {
            addCriterion("area_max_value4 <>", value, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4GreaterThan(String value) {
            addCriterion("area_max_value4 >", value, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4GreaterThanOrEqualTo(String value) {
            addCriterion("area_max_value4 >=", value, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4LessThan(String value) {
            addCriterion("area_max_value4 <", value, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4LessThanOrEqualTo(String value) {
            addCriterion("area_max_value4 <=", value, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4Like(String value) {
            addCriterion("area_max_value4 like", value, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4NotLike(String value) {
            addCriterion("area_max_value4 not like", value, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4In(List<String> values) {
            addCriterion("area_max_value4 in", values, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4NotIn(List<String> values) {
            addCriterion("area_max_value4 not in", values, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4Between(String value1, String value2) {
            addCriterion("area_max_value4 between", value1, value2, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue4NotBetween(String value1, String value2) {
            addCriterion("area_max_value4 not between", value1, value2, "areaMaxValue4");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5IsNull() {
            addCriterion("area_max_value5 is null");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5IsNotNull() {
            addCriterion("area_max_value5 is not null");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5EqualTo(String value) {
            addCriterion("area_max_value5 =", value, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5NotEqualTo(String value) {
            addCriterion("area_max_value5 <>", value, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5GreaterThan(String value) {
            addCriterion("area_max_value5 >", value, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5GreaterThanOrEqualTo(String value) {
            addCriterion("area_max_value5 >=", value, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5LessThan(String value) {
            addCriterion("area_max_value5 <", value, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5LessThanOrEqualTo(String value) {
            addCriterion("area_max_value5 <=", value, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5Like(String value) {
            addCriterion("area_max_value5 like", value, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5NotLike(String value) {
            addCriterion("area_max_value5 not like", value, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5In(List<String> values) {
            addCriterion("area_max_value5 in", values, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5NotIn(List<String> values) {
            addCriterion("area_max_value5 not in", values, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5Between(String value1, String value2) {
            addCriterion("area_max_value5 between", value1, value2, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andAreaMaxValue5NotBetween(String value1, String value2) {
            addCriterion("area_max_value5 not between", value1, value2, "areaMaxValue5");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("del_flag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("del_flag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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