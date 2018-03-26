package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceLampScreenFaultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceLampScreenFaultExample() {
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

        public Criteria andDeviceLedScreenIdIsNull() {
            addCriterion("device_led_screen_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdIsNotNull() {
            addCriterion("device_led_screen_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdEqualTo(String value) {
            addCriterion("device_led_screen_id =", value, "deviceLedScreenId");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdNotEqualTo(String value) {
            addCriterion("device_led_screen_id <>", value, "deviceLedScreenId");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdGreaterThan(String value) {
            addCriterion("device_led_screen_id >", value, "deviceLedScreenId");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_led_screen_id >=", value, "deviceLedScreenId");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdLessThan(String value) {
            addCriterion("device_led_screen_id <", value, "deviceLedScreenId");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdLessThanOrEqualTo(String value) {
            addCriterion("device_led_screen_id <=", value, "deviceLedScreenId");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdLike(String value) {
            addCriterion("device_led_screen_id like", value, "deviceLedScreenId");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdNotLike(String value) {
            addCriterion("device_led_screen_id not like", value, "deviceLedScreenId");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdIn(List<String> values) {
            addCriterion("device_led_screen_id in", values, "deviceLedScreenId");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdNotIn(List<String> values) {
            addCriterion("device_led_screen_id not in", values, "deviceLedScreenId");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdBetween(String value1, String value2) {
            addCriterion("device_led_screen_id between", value1, value2, "deviceLedScreenId");
            return (Criteria) this;
        }

        public Criteria andDeviceLedScreenIdNotBetween(String value1, String value2) {
            addCriterion("device_led_screen_id not between", value1, value2, "deviceLedScreenId");
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

        public Criteria andFaultLevelIsNull() {
            addCriterion("fault_level is null");
            return (Criteria) this;
        }

        public Criteria andFaultLevelIsNotNull() {
            addCriterion("fault_level is not null");
            return (Criteria) this;
        }

        public Criteria andFaultLevelEqualTo(String value) {
            addCriterion("fault_level =", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelNotEqualTo(String value) {
            addCriterion("fault_level <>", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelGreaterThan(String value) {
            addCriterion("fault_level >", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelGreaterThanOrEqualTo(String value) {
            addCriterion("fault_level >=", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelLessThan(String value) {
            addCriterion("fault_level <", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelLessThanOrEqualTo(String value) {
            addCriterion("fault_level <=", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelLike(String value) {
            addCriterion("fault_level like", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelNotLike(String value) {
            addCriterion("fault_level not like", value, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelIn(List<String> values) {
            addCriterion("fault_level in", values, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelNotIn(List<String> values) {
            addCriterion("fault_level not in", values, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelBetween(String value1, String value2) {
            addCriterion("fault_level between", value1, value2, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultLevelNotBetween(String value1, String value2) {
            addCriterion("fault_level not between", value1, value2, "faultLevel");
            return (Criteria) this;
        }

        public Criteria andFaultTypeIsNull() {
            addCriterion("fault_type is null");
            return (Criteria) this;
        }

        public Criteria andFaultTypeIsNotNull() {
            addCriterion("fault_type is not null");
            return (Criteria) this;
        }

        public Criteria andFaultTypeEqualTo(String value) {
            addCriterion("fault_type =", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotEqualTo(String value) {
            addCriterion("fault_type <>", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeGreaterThan(String value) {
            addCriterion("fault_type >", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fault_type >=", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeLessThan(String value) {
            addCriterion("fault_type <", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeLessThanOrEqualTo(String value) {
            addCriterion("fault_type <=", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeLike(String value) {
            addCriterion("fault_type like", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotLike(String value) {
            addCriterion("fault_type not like", value, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeIn(List<String> values) {
            addCriterion("fault_type in", values, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotIn(List<String> values) {
            addCriterion("fault_type not in", values, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeBetween(String value1, String value2) {
            addCriterion("fault_type between", value1, value2, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultTypeNotBetween(String value1, String value2) {
            addCriterion("fault_type not between", value1, value2, "faultType");
            return (Criteria) this;
        }

        public Criteria andFaultCodeIsNull() {
            addCriterion("fault_code is null");
            return (Criteria) this;
        }

        public Criteria andFaultCodeIsNotNull() {
            addCriterion("fault_code is not null");
            return (Criteria) this;
        }

        public Criteria andFaultCodeEqualTo(String value) {
            addCriterion("fault_code =", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotEqualTo(String value) {
            addCriterion("fault_code <>", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeGreaterThan(String value) {
            addCriterion("fault_code >", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fault_code >=", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeLessThan(String value) {
            addCriterion("fault_code <", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeLessThanOrEqualTo(String value) {
            addCriterion("fault_code <=", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeLike(String value) {
            addCriterion("fault_code like", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotLike(String value) {
            addCriterion("fault_code not like", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeIn(List<String> values) {
            addCriterion("fault_code in", values, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotIn(List<String> values) {
            addCriterion("fault_code not in", values, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeBetween(String value1, String value2) {
            addCriterion("fault_code between", value1, value2, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotBetween(String value1, String value2) {
            addCriterion("fault_code not between", value1, value2, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultDescIsNull() {
            addCriterion("fault_desc is null");
            return (Criteria) this;
        }

        public Criteria andFaultDescIsNotNull() {
            addCriterion("fault_desc is not null");
            return (Criteria) this;
        }

        public Criteria andFaultDescEqualTo(String value) {
            addCriterion("fault_desc =", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescNotEqualTo(String value) {
            addCriterion("fault_desc <>", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescGreaterThan(String value) {
            addCriterion("fault_desc >", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescGreaterThanOrEqualTo(String value) {
            addCriterion("fault_desc >=", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescLessThan(String value) {
            addCriterion("fault_desc <", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescLessThanOrEqualTo(String value) {
            addCriterion("fault_desc <=", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescLike(String value) {
            addCriterion("fault_desc like", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescNotLike(String value) {
            addCriterion("fault_desc not like", value, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescIn(List<String> values) {
            addCriterion("fault_desc in", values, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescNotIn(List<String> values) {
            addCriterion("fault_desc not in", values, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescBetween(String value1, String value2) {
            addCriterion("fault_desc between", value1, value2, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultDescNotBetween(String value1, String value2) {
            addCriterion("fault_desc not between", value1, value2, "faultDesc");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateIsNull() {
            addCriterion("fault_create_date is null");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateIsNotNull() {
            addCriterion("fault_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateEqualTo(Date value) {
            addCriterion("fault_create_date =", value, "faultCreateDate");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateNotEqualTo(Date value) {
            addCriterion("fault_create_date <>", value, "faultCreateDate");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateGreaterThan(Date value) {
            addCriterion("fault_create_date >", value, "faultCreateDate");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("fault_create_date >=", value, "faultCreateDate");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateLessThan(Date value) {
            addCriterion("fault_create_date <", value, "faultCreateDate");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("fault_create_date <=", value, "faultCreateDate");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateIn(List<Date> values) {
            addCriterion("fault_create_date in", values, "faultCreateDate");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateNotIn(List<Date> values) {
            addCriterion("fault_create_date not in", values, "faultCreateDate");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateBetween(Date value1, Date value2) {
            addCriterion("fault_create_date between", value1, value2, "faultCreateDate");
            return (Criteria) this;
        }

        public Criteria andFaultCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("fault_create_date not between", value1, value2, "faultCreateDate");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateIsNull() {
            addCriterion("fault_reslove_date is null");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateIsNotNull() {
            addCriterion("fault_reslove_date is not null");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateEqualTo(Date value) {
            addCriterion("fault_reslove_date =", value, "faultResloveDate");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateNotEqualTo(Date value) {
            addCriterion("fault_reslove_date <>", value, "faultResloveDate");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateGreaterThan(Date value) {
            addCriterion("fault_reslove_date >", value, "faultResloveDate");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("fault_reslove_date >=", value, "faultResloveDate");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateLessThan(Date value) {
            addCriterion("fault_reslove_date <", value, "faultResloveDate");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateLessThanOrEqualTo(Date value) {
            addCriterion("fault_reslove_date <=", value, "faultResloveDate");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateIn(List<Date> values) {
            addCriterion("fault_reslove_date in", values, "faultResloveDate");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateNotIn(List<Date> values) {
            addCriterion("fault_reslove_date not in", values, "faultResloveDate");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateBetween(Date value1, Date value2) {
            addCriterion("fault_reslove_date between", value1, value2, "faultResloveDate");
            return (Criteria) this;
        }

        public Criteria andFaultResloveDateNotBetween(Date value1, Date value2) {
            addCriterion("fault_reslove_date not between", value1, value2, "faultResloveDate");
            return (Criteria) this;
        }

        public Criteria andFaultStatusIsNull() {
            addCriterion("fault_status is null");
            return (Criteria) this;
        }

        public Criteria andFaultStatusIsNotNull() {
            addCriterion("fault_status is not null");
            return (Criteria) this;
        }

        public Criteria andFaultStatusEqualTo(String value) {
            addCriterion("fault_status =", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusNotEqualTo(String value) {
            addCriterion("fault_status <>", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusGreaterThan(String value) {
            addCriterion("fault_status >", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusGreaterThanOrEqualTo(String value) {
            addCriterion("fault_status >=", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusLessThan(String value) {
            addCriterion("fault_status <", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusLessThanOrEqualTo(String value) {
            addCriterion("fault_status <=", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusLike(String value) {
            addCriterion("fault_status like", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusNotLike(String value) {
            addCriterion("fault_status not like", value, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusIn(List<String> values) {
            addCriterion("fault_status in", values, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusNotIn(List<String> values) {
            addCriterion("fault_status not in", values, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusBetween(String value1, String value2) {
            addCriterion("fault_status between", value1, value2, "faultStatus");
            return (Criteria) this;
        }

        public Criteria andFaultStatusNotBetween(String value1, String value2) {
            addCriterion("fault_status not between", value1, value2, "faultStatus");
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