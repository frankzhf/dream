package com.shengtong.smartlamppost.commons.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceApHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceApHistoryExample() {
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

        public Criteria andDeviceApIdIsNull() {
            addCriterion("device_ap_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdIsNotNull() {
            addCriterion("device_ap_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdEqualTo(String value) {
            addCriterion("device_ap_id =", value, "deviceApId");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdNotEqualTo(String value) {
            addCriterion("device_ap_id <>", value, "deviceApId");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdGreaterThan(String value) {
            addCriterion("device_ap_id >", value, "deviceApId");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_ap_id >=", value, "deviceApId");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdLessThan(String value) {
            addCriterion("device_ap_id <", value, "deviceApId");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdLessThanOrEqualTo(String value) {
            addCriterion("device_ap_id <=", value, "deviceApId");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdLike(String value) {
            addCriterion("device_ap_id like", value, "deviceApId");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdNotLike(String value) {
            addCriterion("device_ap_id not like", value, "deviceApId");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdIn(List<String> values) {
            addCriterion("device_ap_id in", values, "deviceApId");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdNotIn(List<String> values) {
            addCriterion("device_ap_id not in", values, "deviceApId");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdBetween(String value1, String value2) {
            addCriterion("device_ap_id between", value1, value2, "deviceApId");
            return (Criteria) this;
        }

        public Criteria andDeviceApIdNotBetween(String value1, String value2) {
            addCriterion("device_ap_id not between", value1, value2, "deviceApId");
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

        public Criteria andApIdAddressIsNull() {
            addCriterion("ap_id_address is null");
            return (Criteria) this;
        }

        public Criteria andApIdAddressIsNotNull() {
            addCriterion("ap_id_address is not null");
            return (Criteria) this;
        }

        public Criteria andApIdAddressEqualTo(String value) {
            addCriterion("ap_id_address =", value, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andApIdAddressNotEqualTo(String value) {
            addCriterion("ap_id_address <>", value, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andApIdAddressGreaterThan(String value) {
            addCriterion("ap_id_address >", value, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andApIdAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ap_id_address >=", value, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andApIdAddressLessThan(String value) {
            addCriterion("ap_id_address <", value, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andApIdAddressLessThanOrEqualTo(String value) {
            addCriterion("ap_id_address <=", value, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andApIdAddressLike(String value) {
            addCriterion("ap_id_address like", value, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andApIdAddressNotLike(String value) {
            addCriterion("ap_id_address not like", value, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andApIdAddressIn(List<String> values) {
            addCriterion("ap_id_address in", values, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andApIdAddressNotIn(List<String> values) {
            addCriterion("ap_id_address not in", values, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andApIdAddressBetween(String value1, String value2) {
            addCriterion("ap_id_address between", value1, value2, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andApIdAddressNotBetween(String value1, String value2) {
            addCriterion("ap_id_address not between", value1, value2, "apIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressIsNull() {
            addCriterion("ac_id_address is null");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressIsNotNull() {
            addCriterion("ac_id_address is not null");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressEqualTo(String value) {
            addCriterion("ac_id_address =", value, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressNotEqualTo(String value) {
            addCriterion("ac_id_address <>", value, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressGreaterThan(String value) {
            addCriterion("ac_id_address >", value, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ac_id_address >=", value, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressLessThan(String value) {
            addCriterion("ac_id_address <", value, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressLessThanOrEqualTo(String value) {
            addCriterion("ac_id_address <=", value, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressLike(String value) {
            addCriterion("ac_id_address like", value, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressNotLike(String value) {
            addCriterion("ac_id_address not like", value, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressIn(List<String> values) {
            addCriterion("ac_id_address in", values, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressNotIn(List<String> values) {
            addCriterion("ac_id_address not in", values, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressBetween(String value1, String value2) {
            addCriterion("ac_id_address between", value1, value2, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andAcIdAddressNotBetween(String value1, String value2) {
            addCriterion("ac_id_address not between", value1, value2, "acIdAddress");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeIsNull() {
            addCriterion("device_ap_code is null");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeIsNotNull() {
            addCriterion("device_ap_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeEqualTo(String value) {
            addCriterion("device_ap_code =", value, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeNotEqualTo(String value) {
            addCriterion("device_ap_code <>", value, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeGreaterThan(String value) {
            addCriterion("device_ap_code >", value, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeGreaterThanOrEqualTo(String value) {
            addCriterion("device_ap_code >=", value, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeLessThan(String value) {
            addCriterion("device_ap_code <", value, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeLessThanOrEqualTo(String value) {
            addCriterion("device_ap_code <=", value, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeLike(String value) {
            addCriterion("device_ap_code like", value, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeNotLike(String value) {
            addCriterion("device_ap_code not like", value, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeIn(List<String> values) {
            addCriterion("device_ap_code in", values, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeNotIn(List<String> values) {
            addCriterion("device_ap_code not in", values, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeBetween(String value1, String value2) {
            addCriterion("device_ap_code between", value1, value2, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceApCodeNotBetween(String value1, String value2) {
            addCriterion("device_ap_code not between", value1, value2, "deviceApCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeIsNull() {
            addCriterion("device_ac_code is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeIsNotNull() {
            addCriterion("device_ac_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeEqualTo(String value) {
            addCriterion("device_ac_code =", value, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeNotEqualTo(String value) {
            addCriterion("device_ac_code <>", value, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeGreaterThan(String value) {
            addCriterion("device_ac_code >", value, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeGreaterThanOrEqualTo(String value) {
            addCriterion("device_ac_code >=", value, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeLessThan(String value) {
            addCriterion("device_ac_code <", value, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeLessThanOrEqualTo(String value) {
            addCriterion("device_ac_code <=", value, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeLike(String value) {
            addCriterion("device_ac_code like", value, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeNotLike(String value) {
            addCriterion("device_ac_code not like", value, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeIn(List<String> values) {
            addCriterion("device_ac_code in", values, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeNotIn(List<String> values) {
            addCriterion("device_ac_code not in", values, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeBetween(String value1, String value2) {
            addCriterion("device_ac_code between", value1, value2, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andDeviceAcCodeNotBetween(String value1, String value2) {
            addCriterion("device_ac_code not between", value1, value2, "deviceAcCode");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusIsNull() {
            addCriterion("ac_running_status is null");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusIsNotNull() {
            addCriterion("ac_running_status is not null");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusEqualTo(String value) {
            addCriterion("ac_running_status =", value, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusNotEqualTo(String value) {
            addCriterion("ac_running_status <>", value, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusGreaterThan(String value) {
            addCriterion("ac_running_status >", value, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ac_running_status >=", value, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusLessThan(String value) {
            addCriterion("ac_running_status <", value, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusLessThanOrEqualTo(String value) {
            addCriterion("ac_running_status <=", value, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusLike(String value) {
            addCriterion("ac_running_status like", value, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusNotLike(String value) {
            addCriterion("ac_running_status not like", value, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusIn(List<String> values) {
            addCriterion("ac_running_status in", values, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusNotIn(List<String> values) {
            addCriterion("ac_running_status not in", values, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusBetween(String value1, String value2) {
            addCriterion("ac_running_status between", value1, value2, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andAcRunningStatusNotBetween(String value1, String value2) {
            addCriterion("ac_running_status not between", value1, value2, "acRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusIsNull() {
            addCriterion("ap_running_status is null");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusIsNotNull() {
            addCriterion("ap_running_status is not null");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusEqualTo(String value) {
            addCriterion("ap_running_status =", value, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusNotEqualTo(String value) {
            addCriterion("ap_running_status <>", value, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusGreaterThan(String value) {
            addCriterion("ap_running_status >", value, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ap_running_status >=", value, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusLessThan(String value) {
            addCriterion("ap_running_status <", value, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusLessThanOrEqualTo(String value) {
            addCriterion("ap_running_status <=", value, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusLike(String value) {
            addCriterion("ap_running_status like", value, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusNotLike(String value) {
            addCriterion("ap_running_status not like", value, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusIn(List<String> values) {
            addCriterion("ap_running_status in", values, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusNotIn(List<String> values) {
            addCriterion("ap_running_status not in", values, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusBetween(String value1, String value2) {
            addCriterion("ap_running_status between", value1, value2, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andApRunningStatusNotBetween(String value1, String value2) {
            addCriterion("ap_running_status not between", value1, value2, "apRunningStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusIsNull() {
            addCriterion("device_ac_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusIsNotNull() {
            addCriterion("device_ac_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusEqualTo(String value) {
            addCriterion("device_ac_status =", value, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusNotEqualTo(String value) {
            addCriterion("device_ac_status <>", value, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusGreaterThan(String value) {
            addCriterion("device_ac_status >", value, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusGreaterThanOrEqualTo(String value) {
            addCriterion("device_ac_status >=", value, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusLessThan(String value) {
            addCriterion("device_ac_status <", value, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusLessThanOrEqualTo(String value) {
            addCriterion("device_ac_status <=", value, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusLike(String value) {
            addCriterion("device_ac_status like", value, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusNotLike(String value) {
            addCriterion("device_ac_status not like", value, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusIn(List<String> values) {
            addCriterion("device_ac_status in", values, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusNotIn(List<String> values) {
            addCriterion("device_ac_status not in", values, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusBetween(String value1, String value2) {
            addCriterion("device_ac_status between", value1, value2, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceAcStatusNotBetween(String value1, String value2) {
            addCriterion("device_ac_status not between", value1, value2, "deviceAcStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusIsNull() {
            addCriterion("device_ap_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusIsNotNull() {
            addCriterion("device_ap_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusEqualTo(String value) {
            addCriterion("device_ap_status =", value, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusNotEqualTo(String value) {
            addCriterion("device_ap_status <>", value, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusGreaterThan(String value) {
            addCriterion("device_ap_status >", value, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusGreaterThanOrEqualTo(String value) {
            addCriterion("device_ap_status >=", value, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusLessThan(String value) {
            addCriterion("device_ap_status <", value, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusLessThanOrEqualTo(String value) {
            addCriterion("device_ap_status <=", value, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusLike(String value) {
            addCriterion("device_ap_status like", value, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusNotLike(String value) {
            addCriterion("device_ap_status not like", value, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusIn(List<String> values) {
            addCriterion("device_ap_status in", values, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusNotIn(List<String> values) {
            addCriterion("device_ap_status not in", values, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusBetween(String value1, String value2) {
            addCriterion("device_ap_status between", value1, value2, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceApStatusNotBetween(String value1, String value2) {
            addCriterion("device_ap_status not between", value1, value2, "deviceApStatus");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountIsNull() {
            addCriterion("user_access_count is null");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountIsNotNull() {
            addCriterion("user_access_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountEqualTo(Integer value) {
            addCriterion("user_access_count =", value, "userAccessCount");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountNotEqualTo(Integer value) {
            addCriterion("user_access_count <>", value, "userAccessCount");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountGreaterThan(Integer value) {
            addCriterion("user_access_count >", value, "userAccessCount");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_access_count >=", value, "userAccessCount");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountLessThan(Integer value) {
            addCriterion("user_access_count <", value, "userAccessCount");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountLessThanOrEqualTo(Integer value) {
            addCriterion("user_access_count <=", value, "userAccessCount");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountIn(List<Integer> values) {
            addCriterion("user_access_count in", values, "userAccessCount");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountNotIn(List<Integer> values) {
            addCriterion("user_access_count not in", values, "userAccessCount");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountBetween(Integer value1, Integer value2) {
            addCriterion("user_access_count between", value1, value2, "userAccessCount");
            return (Criteria) this;
        }

        public Criteria andUserAccessCountNotBetween(Integer value1, Integer value2) {
            addCriterion("user_access_count not between", value1, value2, "userAccessCount");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedIsNull() {
            addCriterion("ap_send_speed is null");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedIsNotNull() {
            addCriterion("ap_send_speed is not null");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedEqualTo(BigDecimal value) {
            addCriterion("ap_send_speed =", value, "apSendSpeed");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedNotEqualTo(BigDecimal value) {
            addCriterion("ap_send_speed <>", value, "apSendSpeed");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedGreaterThan(BigDecimal value) {
            addCriterion("ap_send_speed >", value, "apSendSpeed");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ap_send_speed >=", value, "apSendSpeed");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedLessThan(BigDecimal value) {
            addCriterion("ap_send_speed <", value, "apSendSpeed");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ap_send_speed <=", value, "apSendSpeed");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedIn(List<BigDecimal> values) {
            addCriterion("ap_send_speed in", values, "apSendSpeed");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedNotIn(List<BigDecimal> values) {
            addCriterion("ap_send_speed not in", values, "apSendSpeed");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ap_send_speed between", value1, value2, "apSendSpeed");
            return (Criteria) this;
        }

        public Criteria andApSendSpeedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ap_send_speed not between", value1, value2, "apSendSpeed");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedIsNull() {
            addCriterion("ap_recv_speed is null");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedIsNotNull() {
            addCriterion("ap_recv_speed is not null");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedEqualTo(BigDecimal value) {
            addCriterion("ap_recv_speed =", value, "apRecvSpeed");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedNotEqualTo(BigDecimal value) {
            addCriterion("ap_recv_speed <>", value, "apRecvSpeed");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedGreaterThan(BigDecimal value) {
            addCriterion("ap_recv_speed >", value, "apRecvSpeed");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ap_recv_speed >=", value, "apRecvSpeed");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedLessThan(BigDecimal value) {
            addCriterion("ap_recv_speed <", value, "apRecvSpeed");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ap_recv_speed <=", value, "apRecvSpeed");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedIn(List<BigDecimal> values) {
            addCriterion("ap_recv_speed in", values, "apRecvSpeed");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedNotIn(List<BigDecimal> values) {
            addCriterion("ap_recv_speed not in", values, "apRecvSpeed");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ap_recv_speed between", value1, value2, "apRecvSpeed");
            return (Criteria) this;
        }

        public Criteria andApRecvSpeedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ap_recv_speed not between", value1, value2, "apRecvSpeed");
            return (Criteria) this;
        }

        public Criteria andCollectDateIsNull() {
            addCriterion("collect_date is null");
            return (Criteria) this;
        }

        public Criteria andCollectDateIsNotNull() {
            addCriterion("collect_date is not null");
            return (Criteria) this;
        }

        public Criteria andCollectDateEqualTo(Date value) {
            addCriterion("collect_date =", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateNotEqualTo(Date value) {
            addCriterion("collect_date <>", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateGreaterThan(Date value) {
            addCriterion("collect_date >", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateGreaterThanOrEqualTo(Date value) {
            addCriterion("collect_date >=", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateLessThan(Date value) {
            addCriterion("collect_date <", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateLessThanOrEqualTo(Date value) {
            addCriterion("collect_date <=", value, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateIn(List<Date> values) {
            addCriterion("collect_date in", values, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateNotIn(List<Date> values) {
            addCriterion("collect_date not in", values, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateBetween(Date value1, Date value2) {
            addCriterion("collect_date between", value1, value2, "collectDate");
            return (Criteria) this;
        }

        public Criteria andCollectDateNotBetween(Date value1, Date value2) {
            addCriterion("collect_date not between", value1, value2, "collectDate");
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

        public Criteria andApGroupIdIsNull() {
            addCriterion("ap_group_id is null");
            return (Criteria) this;
        }

        public Criteria andApGroupIdIsNotNull() {
            addCriterion("ap_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andApGroupIdEqualTo(String value) {
            addCriterion("ap_group_id =", value, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupIdNotEqualTo(String value) {
            addCriterion("ap_group_id <>", value, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupIdGreaterThan(String value) {
            addCriterion("ap_group_id >", value, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("ap_group_id >=", value, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupIdLessThan(String value) {
            addCriterion("ap_group_id <", value, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupIdLessThanOrEqualTo(String value) {
            addCriterion("ap_group_id <=", value, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupIdLike(String value) {
            addCriterion("ap_group_id like", value, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupIdNotLike(String value) {
            addCriterion("ap_group_id not like", value, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupIdIn(List<String> values) {
            addCriterion("ap_group_id in", values, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupIdNotIn(List<String> values) {
            addCriterion("ap_group_id not in", values, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupIdBetween(String value1, String value2) {
            addCriterion("ap_group_id between", value1, value2, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupIdNotBetween(String value1, String value2) {
            addCriterion("ap_group_id not between", value1, value2, "apGroupId");
            return (Criteria) this;
        }

        public Criteria andApGroupNameIsNull() {
            addCriterion("ap_group_name is null");
            return (Criteria) this;
        }

        public Criteria andApGroupNameIsNotNull() {
            addCriterion("ap_group_name is not null");
            return (Criteria) this;
        }

        public Criteria andApGroupNameEqualTo(String value) {
            addCriterion("ap_group_name =", value, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andApGroupNameNotEqualTo(String value) {
            addCriterion("ap_group_name <>", value, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andApGroupNameGreaterThan(String value) {
            addCriterion("ap_group_name >", value, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andApGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("ap_group_name >=", value, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andApGroupNameLessThan(String value) {
            addCriterion("ap_group_name <", value, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andApGroupNameLessThanOrEqualTo(String value) {
            addCriterion("ap_group_name <=", value, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andApGroupNameLike(String value) {
            addCriterion("ap_group_name like", value, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andApGroupNameNotLike(String value) {
            addCriterion("ap_group_name not like", value, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andApGroupNameIn(List<String> values) {
            addCriterion("ap_group_name in", values, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andApGroupNameNotIn(List<String> values) {
            addCriterion("ap_group_name not in", values, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andApGroupNameBetween(String value1, String value2) {
            addCriterion("ap_group_name between", value1, value2, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andApGroupNameNotBetween(String value1, String value2) {
            addCriterion("ap_group_name not between", value1, value2, "apGroupName");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountIsNull() {
            addCriterion("user_probe_count is null");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountIsNotNull() {
            addCriterion("user_probe_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountEqualTo(Integer value) {
            addCriterion("user_probe_count =", value, "userProbeCount");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountNotEqualTo(Integer value) {
            addCriterion("user_probe_count <>", value, "userProbeCount");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountGreaterThan(Integer value) {
            addCriterion("user_probe_count >", value, "userProbeCount");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_probe_count >=", value, "userProbeCount");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountLessThan(Integer value) {
            addCriterion("user_probe_count <", value, "userProbeCount");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountLessThanOrEqualTo(Integer value) {
            addCriterion("user_probe_count <=", value, "userProbeCount");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountIn(List<Integer> values) {
            addCriterion("user_probe_count in", values, "userProbeCount");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountNotIn(List<Integer> values) {
            addCriterion("user_probe_count not in", values, "userProbeCount");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountBetween(Integer value1, Integer value2) {
            addCriterion("user_probe_count between", value1, value2, "userProbeCount");
            return (Criteria) this;
        }

        public Criteria andUserProbeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("user_probe_count not between", value1, value2, "userProbeCount");
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