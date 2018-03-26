package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceLampControlExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceLampControlExample() {
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

        public Criteria andConcentratorIdIsNull() {
            addCriterion("concentrator_id is null");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdIsNotNull() {
            addCriterion("concentrator_id is not null");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdEqualTo(String value) {
            addCriterion("concentrator_id =", value, "concentratorId");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdNotEqualTo(String value) {
            addCriterion("concentrator_id <>", value, "concentratorId");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdGreaterThan(String value) {
            addCriterion("concentrator_id >", value, "concentratorId");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdGreaterThanOrEqualTo(String value) {
            addCriterion("concentrator_id >=", value, "concentratorId");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdLessThan(String value) {
            addCriterion("concentrator_id <", value, "concentratorId");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdLessThanOrEqualTo(String value) {
            addCriterion("concentrator_id <=", value, "concentratorId");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdLike(String value) {
            addCriterion("concentrator_id like", value, "concentratorId");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdNotLike(String value) {
            addCriterion("concentrator_id not like", value, "concentratorId");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdIn(List<String> values) {
            addCriterion("concentrator_id in", values, "concentratorId");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdNotIn(List<String> values) {
            addCriterion("concentrator_id not in", values, "concentratorId");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdBetween(String value1, String value2) {
            addCriterion("concentrator_id between", value1, value2, "concentratorId");
            return (Criteria) this;
        }

        public Criteria andConcentratorIdNotBetween(String value1, String value2) {
            addCriterion("concentrator_id not between", value1, value2, "concentratorId");
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

        public Criteria andDeviceLogicalAddrIsNull() {
            addCriterion("device_logical_addr is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrIsNotNull() {
            addCriterion("device_logical_addr is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrEqualTo(String value) {
            addCriterion("device_logical_addr =", value, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrNotEqualTo(String value) {
            addCriterion("device_logical_addr <>", value, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrGreaterThan(String value) {
            addCriterion("device_logical_addr >", value, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrGreaterThanOrEqualTo(String value) {
            addCriterion("device_logical_addr >=", value, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrLessThan(String value) {
            addCriterion("device_logical_addr <", value, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrLessThanOrEqualTo(String value) {
            addCriterion("device_logical_addr <=", value, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrLike(String value) {
            addCriterion("device_logical_addr like", value, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrNotLike(String value) {
            addCriterion("device_logical_addr not like", value, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrIn(List<String> values) {
            addCriterion("device_logical_addr in", values, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrNotIn(List<String> values) {
            addCriterion("device_logical_addr not in", values, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrBetween(String value1, String value2) {
            addCriterion("device_logical_addr between", value1, value2, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDeviceLogicalAddrNotBetween(String value1, String value2) {
            addCriterion("device_logical_addr not between", value1, value2, "deviceLogicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrIsNull() {
            addCriterion("device_physical_addr is null");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrIsNotNull() {
            addCriterion("device_physical_addr is not null");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrEqualTo(String value) {
            addCriterion("device_physical_addr =", value, "devicePhysicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrNotEqualTo(String value) {
            addCriterion("device_physical_addr <>", value, "devicePhysicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrGreaterThan(String value) {
            addCriterion("device_physical_addr >", value, "devicePhysicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrGreaterThanOrEqualTo(String value) {
            addCriterion("device_physical_addr >=", value, "devicePhysicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrLessThan(String value) {
            addCriterion("device_physical_addr <", value, "devicePhysicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrLessThanOrEqualTo(String value) {
            addCriterion("device_physical_addr <=", value, "devicePhysicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrLike(String value) {
            addCriterion("device_physical_addr like", value, "devicePhysicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrNotLike(String value) {
            addCriterion("device_physical_addr not like", value, "devicePhysicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrIn(List<String> values) {
            addCriterion("device_physical_addr in", values, "devicePhysicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrNotIn(List<String> values) {
            addCriterion("device_physical_addr not in", values, "devicePhysicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrBetween(String value1, String value2) {
            addCriterion("device_physical_addr between", value1, value2, "devicePhysicalAddr");
            return (Criteria) this;
        }

        public Criteria andDevicePhysicalAddrNotBetween(String value1, String value2) {
            addCriterion("device_physical_addr not between", value1, value2, "devicePhysicalAddr");
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

        public Criteria andParameterErrorStatusIsNull() {
            addCriterion("parameter_error_status is null");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusIsNotNull() {
            addCriterion("parameter_error_status is not null");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusEqualTo(String value) {
            addCriterion("parameter_error_status =", value, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusNotEqualTo(String value) {
            addCriterion("parameter_error_status <>", value, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusGreaterThan(String value) {
            addCriterion("parameter_error_status >", value, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusGreaterThanOrEqualTo(String value) {
            addCriterion("parameter_error_status >=", value, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusLessThan(String value) {
            addCriterion("parameter_error_status <", value, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusLessThanOrEqualTo(String value) {
            addCriterion("parameter_error_status <=", value, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusLike(String value) {
            addCriterion("parameter_error_status like", value, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusNotLike(String value) {
            addCriterion("parameter_error_status not like", value, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusIn(List<String> values) {
            addCriterion("parameter_error_status in", values, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusNotIn(List<String> values) {
            addCriterion("parameter_error_status not in", values, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusBetween(String value1, String value2) {
            addCriterion("parameter_error_status between", value1, value2, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andParameterErrorStatusNotBetween(String value1, String value2) {
            addCriterion("parameter_error_status not between", value1, value2, "parameterErrorStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusIsNull() {
            addCriterion("running_status is null");
            return (Criteria) this;
        }

        public Criteria andRunningStatusIsNotNull() {
            addCriterion("running_status is not null");
            return (Criteria) this;
        }

        public Criteria andRunningStatusEqualTo(String value) {
            addCriterion("running_status =", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusNotEqualTo(String value) {
            addCriterion("running_status <>", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusGreaterThan(String value) {
            addCriterion("running_status >", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusGreaterThanOrEqualTo(String value) {
            addCriterion("running_status >=", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusLessThan(String value) {
            addCriterion("running_status <", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusLessThanOrEqualTo(String value) {
            addCriterion("running_status <=", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusLike(String value) {
            addCriterion("running_status like", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusNotLike(String value) {
            addCriterion("running_status not like", value, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusIn(List<String> values) {
            addCriterion("running_status in", values, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusNotIn(List<String> values) {
            addCriterion("running_status not in", values, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusBetween(String value1, String value2) {
            addCriterion("running_status between", value1, value2, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andRunningStatusNotBetween(String value1, String value2) {
            addCriterion("running_status not between", value1, value2, "runningStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusIsNull() {
            addCriterion("eeprom_status is null");
            return (Criteria) this;
        }

        public Criteria andEepromStatusIsNotNull() {
            addCriterion("eeprom_status is not null");
            return (Criteria) this;
        }

        public Criteria andEepromStatusEqualTo(String value) {
            addCriterion("eeprom_status =", value, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusNotEqualTo(String value) {
            addCriterion("eeprom_status <>", value, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusGreaterThan(String value) {
            addCriterion("eeprom_status >", value, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusGreaterThanOrEqualTo(String value) {
            addCriterion("eeprom_status >=", value, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusLessThan(String value) {
            addCriterion("eeprom_status <", value, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusLessThanOrEqualTo(String value) {
            addCriterion("eeprom_status <=", value, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusLike(String value) {
            addCriterion("eeprom_status like", value, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusNotLike(String value) {
            addCriterion("eeprom_status not like", value, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusIn(List<String> values) {
            addCriterion("eeprom_status in", values, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusNotIn(List<String> values) {
            addCriterion("eeprom_status not in", values, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusBetween(String value1, String value2) {
            addCriterion("eeprom_status between", value1, value2, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andEepromStatusNotBetween(String value1, String value2) {
            addCriterion("eeprom_status not between", value1, value2, "eepromStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusIsNull() {
            addCriterion("alert_status is null");
            return (Criteria) this;
        }

        public Criteria andAlertStatusIsNotNull() {
            addCriterion("alert_status is not null");
            return (Criteria) this;
        }

        public Criteria andAlertStatusEqualTo(String value) {
            addCriterion("alert_status =", value, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusNotEqualTo(String value) {
            addCriterion("alert_status <>", value, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusGreaterThan(String value) {
            addCriterion("alert_status >", value, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusGreaterThanOrEqualTo(String value) {
            addCriterion("alert_status >=", value, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusLessThan(String value) {
            addCriterion("alert_status <", value, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusLessThanOrEqualTo(String value) {
            addCriterion("alert_status <=", value, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusLike(String value) {
            addCriterion("alert_status like", value, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusNotLike(String value) {
            addCriterion("alert_status not like", value, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusIn(List<String> values) {
            addCriterion("alert_status in", values, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusNotIn(List<String> values) {
            addCriterion("alert_status not in", values, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusBetween(String value1, String value2) {
            addCriterion("alert_status between", value1, value2, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andAlertStatusNotBetween(String value1, String value2) {
            addCriterion("alert_status not between", value1, value2, "alertStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusIsNull() {
            addCriterion("work_parameter_status is null");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusIsNotNull() {
            addCriterion("work_parameter_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusEqualTo(String value) {
            addCriterion("work_parameter_status =", value, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusNotEqualTo(String value) {
            addCriterion("work_parameter_status <>", value, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusGreaterThan(String value) {
            addCriterion("work_parameter_status >", value, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusGreaterThanOrEqualTo(String value) {
            addCriterion("work_parameter_status >=", value, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusLessThan(String value) {
            addCriterion("work_parameter_status <", value, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusLessThanOrEqualTo(String value) {
            addCriterion("work_parameter_status <=", value, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusLike(String value) {
            addCriterion("work_parameter_status like", value, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusNotLike(String value) {
            addCriterion("work_parameter_status not like", value, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusIn(List<String> values) {
            addCriterion("work_parameter_status in", values, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusNotIn(List<String> values) {
            addCriterion("work_parameter_status not in", values, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusBetween(String value1, String value2) {
            addCriterion("work_parameter_status between", value1, value2, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andWorkParameterStatusNotBetween(String value1, String value2) {
            addCriterion("work_parameter_status not between", value1, value2, "workParameterStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusIsNull() {
            addCriterion("correct_status is null");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusIsNotNull() {
            addCriterion("correct_status is not null");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusEqualTo(String value) {
            addCriterion("correct_status =", value, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusNotEqualTo(String value) {
            addCriterion("correct_status <>", value, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusGreaterThan(String value) {
            addCriterion("correct_status >", value, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusGreaterThanOrEqualTo(String value) {
            addCriterion("correct_status >=", value, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusLessThan(String value) {
            addCriterion("correct_status <", value, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusLessThanOrEqualTo(String value) {
            addCriterion("correct_status <=", value, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusLike(String value) {
            addCriterion("correct_status like", value, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusNotLike(String value) {
            addCriterion("correct_status not like", value, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusIn(List<String> values) {
            addCriterion("correct_status in", values, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusNotIn(List<String> values) {
            addCriterion("correct_status not in", values, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusBetween(String value1, String value2) {
            addCriterion("correct_status between", value1, value2, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andCorrectStatusNotBetween(String value1, String value2) {
            addCriterion("correct_status not between", value1, value2, "correctStatus");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(Integer value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(Integer value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(Integer value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(Integer value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(Integer value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(Integer value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<Integer> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<Integer> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(Integer value1, Integer value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(Integer value1, Integer value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
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

        public Criteria andDtCacheIsNull() {
            addCriterion("dt_cache is null");
            return (Criteria) this;
        }

        public Criteria andDtCacheIsNotNull() {
            addCriterion("dt_cache is not null");
            return (Criteria) this;
        }

        public Criteria andDtCacheEqualTo(Date value) {
            addCriterion("dt_cache =", value, "dtCache");
            return (Criteria) this;
        }

        public Criteria andDtCacheNotEqualTo(Date value) {
            addCriterion("dt_cache <>", value, "dtCache");
            return (Criteria) this;
        }

        public Criteria andDtCacheGreaterThan(Date value) {
            addCriterion("dt_cache >", value, "dtCache");
            return (Criteria) this;
        }

        public Criteria andDtCacheGreaterThanOrEqualTo(Date value) {
            addCriterion("dt_cache >=", value, "dtCache");
            return (Criteria) this;
        }

        public Criteria andDtCacheLessThan(Date value) {
            addCriterion("dt_cache <", value, "dtCache");
            return (Criteria) this;
        }

        public Criteria andDtCacheLessThanOrEqualTo(Date value) {
            addCriterion("dt_cache <=", value, "dtCache");
            return (Criteria) this;
        }

        public Criteria andDtCacheIn(List<Date> values) {
            addCriterion("dt_cache in", values, "dtCache");
            return (Criteria) this;
        }

        public Criteria andDtCacheNotIn(List<Date> values) {
            addCriterion("dt_cache not in", values, "dtCache");
            return (Criteria) this;
        }

        public Criteria andDtCacheBetween(Date value1, Date value2) {
            addCriterion("dt_cache between", value1, value2, "dtCache");
            return (Criteria) this;
        }

        public Criteria andDtCacheNotBetween(Date value1, Date value2) {
            addCriterion("dt_cache not between", value1, value2, "dtCache");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusIsNull() {
            addCriterion("offstream_status is null");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusIsNotNull() {
            addCriterion("offstream_status is not null");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusEqualTo(String value) {
            addCriterion("offstream_status =", value, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusNotEqualTo(String value) {
            addCriterion("offstream_status <>", value, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusGreaterThan(String value) {
            addCriterion("offstream_status >", value, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusGreaterThanOrEqualTo(String value) {
            addCriterion("offstream_status >=", value, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusLessThan(String value) {
            addCriterion("offstream_status <", value, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusLessThanOrEqualTo(String value) {
            addCriterion("offstream_status <=", value, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusLike(String value) {
            addCriterion("offstream_status like", value, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusNotLike(String value) {
            addCriterion("offstream_status not like", value, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusIn(List<String> values) {
            addCriterion("offstream_status in", values, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusNotIn(List<String> values) {
            addCriterion("offstream_status not in", values, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusBetween(String value1, String value2) {
            addCriterion("offstream_status between", value1, value2, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andOffstreamStatusNotBetween(String value1, String value2) {
            addCriterion("offstream_status not between", value1, value2, "offstreamStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNull() {
            addCriterion("device_status is null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIsNotNull() {
            addCriterion("device_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusEqualTo(String value) {
            addCriterion("device_status =", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotEqualTo(String value) {
            addCriterion("device_status <>", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThan(String value) {
            addCriterion("device_status >", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusGreaterThanOrEqualTo(String value) {
            addCriterion("device_status >=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThan(String value) {
            addCriterion("device_status <", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLessThanOrEqualTo(String value) {
            addCriterion("device_status <=", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusLike(String value) {
            addCriterion("device_status like", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotLike(String value) {
            addCriterion("device_status not like", value, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusIn(List<String> values) {
            addCriterion("device_status in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotIn(List<String> values) {
            addCriterion("device_status not in", values, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusBetween(String value1, String value2) {
            addCriterion("device_status between", value1, value2, "deviceStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceStatusNotBetween(String value1, String value2) {
            addCriterion("device_status not between", value1, value2, "deviceStatus");
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