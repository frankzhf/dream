package com.shengtong.smartlamppost.commons.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceLampCapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceLampCapExample() {
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

        public Criteria andDeviceLampControlIdIsNull() {
            addCriterion("device_lamp_control_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdIsNotNull() {
            addCriterion("device_lamp_control_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdEqualTo(String value) {
            addCriterion("device_lamp_control_id =", value, "deviceLampControlId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdNotEqualTo(String value) {
            addCriterion("device_lamp_control_id <>", value, "deviceLampControlId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdGreaterThan(String value) {
            addCriterion("device_lamp_control_id >", value, "deviceLampControlId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_lamp_control_id >=", value, "deviceLampControlId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdLessThan(String value) {
            addCriterion("device_lamp_control_id <", value, "deviceLampControlId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdLessThanOrEqualTo(String value) {
            addCriterion("device_lamp_control_id <=", value, "deviceLampControlId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdLike(String value) {
            addCriterion("device_lamp_control_id like", value, "deviceLampControlId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdNotLike(String value) {
            addCriterion("device_lamp_control_id not like", value, "deviceLampControlId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdIn(List<String> values) {
            addCriterion("device_lamp_control_id in", values, "deviceLampControlId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdNotIn(List<String> values) {
            addCriterion("device_lamp_control_id not in", values, "deviceLampControlId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdBetween(String value1, String value2) {
            addCriterion("device_lamp_control_id between", value1, value2, "deviceLampControlId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampControlIdNotBetween(String value1, String value2) {
            addCriterion("device_lamp_control_id not between", value1, value2, "deviceLampControlId");
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

        public Criteria andLampIdIsNull() {
            addCriterion("lamp_id is null");
            return (Criteria) this;
        }

        public Criteria andLampIdIsNotNull() {
            addCriterion("lamp_id is not null");
            return (Criteria) this;
        }

        public Criteria andLampIdEqualTo(Integer value) {
            addCriterion("lamp_id =", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdNotEqualTo(Integer value) {
            addCriterion("lamp_id <>", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdGreaterThan(Integer value) {
            addCriterion("lamp_id >", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lamp_id >=", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdLessThan(Integer value) {
            addCriterion("lamp_id <", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdLessThanOrEqualTo(Integer value) {
            addCriterion("lamp_id <=", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdIn(List<Integer> values) {
            addCriterion("lamp_id in", values, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdNotIn(List<Integer> values) {
            addCriterion("lamp_id not in", values, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdBetween(Integer value1, Integer value2) {
            addCriterion("lamp_id between", value1, value2, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lamp_id not between", value1, value2, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusIsNull() {
            addCriterion("lamp_on_status is null");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusIsNotNull() {
            addCriterion("lamp_on_status is not null");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusEqualTo(String value) {
            addCriterion("lamp_on_status =", value, "lampOnStatus");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusNotEqualTo(String value) {
            addCriterion("lamp_on_status <>", value, "lampOnStatus");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusGreaterThan(String value) {
            addCriterion("lamp_on_status >", value, "lampOnStatus");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusGreaterThanOrEqualTo(String value) {
            addCriterion("lamp_on_status >=", value, "lampOnStatus");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusLessThan(String value) {
            addCriterion("lamp_on_status <", value, "lampOnStatus");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusLessThanOrEqualTo(String value) {
            addCriterion("lamp_on_status <=", value, "lampOnStatus");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusLike(String value) {
            addCriterion("lamp_on_status like", value, "lampOnStatus");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusNotLike(String value) {
            addCriterion("lamp_on_status not like", value, "lampOnStatus");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusIn(List<String> values) {
            addCriterion("lamp_on_status in", values, "lampOnStatus");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusNotIn(List<String> values) {
            addCriterion("lamp_on_status not in", values, "lampOnStatus");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusBetween(String value1, String value2) {
            addCriterion("lamp_on_status between", value1, value2, "lampOnStatus");
            return (Criteria) this;
        }

        public Criteria andLampOnStatusNotBetween(String value1, String value2) {
            addCriterion("lamp_on_status not between", value1, value2, "lampOnStatus");
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

        public Criteria andLeakageStatusIsNull() {
            addCriterion("leakage_status is null");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusIsNotNull() {
            addCriterion("leakage_status is not null");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusEqualTo(String value) {
            addCriterion("leakage_status =", value, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusNotEqualTo(String value) {
            addCriterion("leakage_status <>", value, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusGreaterThan(String value) {
            addCriterion("leakage_status >", value, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusGreaterThanOrEqualTo(String value) {
            addCriterion("leakage_status >=", value, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusLessThan(String value) {
            addCriterion("leakage_status <", value, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusLessThanOrEqualTo(String value) {
            addCriterion("leakage_status <=", value, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusLike(String value) {
            addCriterion("leakage_status like", value, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusNotLike(String value) {
            addCriterion("leakage_status not like", value, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusIn(List<String> values) {
            addCriterion("leakage_status in", values, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusNotIn(List<String> values) {
            addCriterion("leakage_status not in", values, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusBetween(String value1, String value2) {
            addCriterion("leakage_status between", value1, value2, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andLeakageStatusNotBetween(String value1, String value2) {
            addCriterion("leakage_status not between", value1, value2, "leakageStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusIsNull() {
            addCriterion("power_status is null");
            return (Criteria) this;
        }

        public Criteria andPowerStatusIsNotNull() {
            addCriterion("power_status is not null");
            return (Criteria) this;
        }

        public Criteria andPowerStatusEqualTo(String value) {
            addCriterion("power_status =", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusNotEqualTo(String value) {
            addCriterion("power_status <>", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusGreaterThan(String value) {
            addCriterion("power_status >", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusGreaterThanOrEqualTo(String value) {
            addCriterion("power_status >=", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusLessThan(String value) {
            addCriterion("power_status <", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusLessThanOrEqualTo(String value) {
            addCriterion("power_status <=", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusLike(String value) {
            addCriterion("power_status like", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusNotLike(String value) {
            addCriterion("power_status not like", value, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusIn(List<String> values) {
            addCriterion("power_status in", values, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusNotIn(List<String> values) {
            addCriterion("power_status not in", values, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusBetween(String value1, String value2) {
            addCriterion("power_status between", value1, value2, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andPowerStatusNotBetween(String value1, String value2) {
            addCriterion("power_status not between", value1, value2, "powerStatus");
            return (Criteria) this;
        }

        public Criteria andVoltageIsNull() {
            addCriterion("voltage is null");
            return (Criteria) this;
        }

        public Criteria andVoltageIsNotNull() {
            addCriterion("voltage is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageEqualTo(BigDecimal value) {
            addCriterion("voltage =", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotEqualTo(BigDecimal value) {
            addCriterion("voltage <>", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThan(BigDecimal value) {
            addCriterion("voltage >", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("voltage >=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThan(BigDecimal value) {
            addCriterion("voltage <", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("voltage <=", value, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageIn(List<BigDecimal> values) {
            addCriterion("voltage in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotIn(List<BigDecimal> values) {
            addCriterion("voltage not in", values, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("voltage between", value1, value2, "voltage");
            return (Criteria) this;
        }

        public Criteria andVoltageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("voltage not between", value1, value2, "voltage");
            return (Criteria) this;
        }

        public Criteria andPowerIsNull() {
            addCriterion("power is null");
            return (Criteria) this;
        }

        public Criteria andPowerIsNotNull() {
            addCriterion("power is not null");
            return (Criteria) this;
        }

        public Criteria andPowerEqualTo(BigDecimal value) {
            addCriterion("power =", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotEqualTo(BigDecimal value) {
            addCriterion("power <>", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThan(BigDecimal value) {
            addCriterion("power >", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("power >=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThan(BigDecimal value) {
            addCriterion("power <", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerLessThanOrEqualTo(BigDecimal value) {
            addCriterion("power <=", value, "power");
            return (Criteria) this;
        }

        public Criteria andPowerIn(List<BigDecimal> values) {
            addCriterion("power in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotIn(List<BigDecimal> values) {
            addCriterion("power not in", values, "power");
            return (Criteria) this;
        }

        public Criteria andPowerBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("power between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andPowerNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("power not between", value1, value2, "power");
            return (Criteria) this;
        }

        public Criteria andCurrentIsNull() {
            addCriterion("current is null");
            return (Criteria) this;
        }

        public Criteria andCurrentIsNotNull() {
            addCriterion("current is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentEqualTo(BigDecimal value) {
            addCriterion("current =", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotEqualTo(BigDecimal value) {
            addCriterion("current <>", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentGreaterThan(BigDecimal value) {
            addCriterion("current >", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current >=", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentLessThan(BigDecimal value) {
            addCriterion("current <", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current <=", value, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentIn(List<BigDecimal> values) {
            addCriterion("current in", values, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotIn(List<BigDecimal> values) {
            addCriterion("current not in", values, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current between", value1, value2, "current");
            return (Criteria) this;
        }

        public Criteria andCurrentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current not between", value1, value2, "current");
            return (Criteria) this;
        }

        public Criteria andElectricityIsNull() {
            addCriterion("electricity is null");
            return (Criteria) this;
        }

        public Criteria andElectricityIsNotNull() {
            addCriterion("electricity is not null");
            return (Criteria) this;
        }

        public Criteria andElectricityEqualTo(BigDecimal value) {
            addCriterion("electricity =", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotEqualTo(BigDecimal value) {
            addCriterion("electricity <>", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThan(BigDecimal value) {
            addCriterion("electricity >", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("electricity >=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThan(BigDecimal value) {
            addCriterion("electricity <", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("electricity <=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityIn(List<BigDecimal> values) {
            addCriterion("electricity in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotIn(List<BigDecimal> values) {
            addCriterion("electricity not in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electricity between", value1, value2, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("electricity not between", value1, value2, "electricity");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityIsNull() {
            addCriterion("software_electricity is null");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityIsNotNull() {
            addCriterion("software_electricity is not null");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityEqualTo(BigDecimal value) {
            addCriterion("software_electricity =", value, "softwareElectricity");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityNotEqualTo(BigDecimal value) {
            addCriterion("software_electricity <>", value, "softwareElectricity");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityGreaterThan(BigDecimal value) {
            addCriterion("software_electricity >", value, "softwareElectricity");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("software_electricity >=", value, "softwareElectricity");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityLessThan(BigDecimal value) {
            addCriterion("software_electricity <", value, "softwareElectricity");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("software_electricity <=", value, "softwareElectricity");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityIn(List<BigDecimal> values) {
            addCriterion("software_electricity in", values, "softwareElectricity");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityNotIn(List<BigDecimal> values) {
            addCriterion("software_electricity not in", values, "softwareElectricity");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("software_electricity between", value1, value2, "softwareElectricity");
            return (Criteria) this;
        }

        public Criteria andSoftwareElectricityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("software_electricity not between", value1, value2, "softwareElectricity");
            return (Criteria) this;
        }

        public Criteria andRunTimeIsNull() {
            addCriterion("run_time is null");
            return (Criteria) this;
        }

        public Criteria andRunTimeIsNotNull() {
            addCriterion("run_time is not null");
            return (Criteria) this;
        }

        public Criteria andRunTimeEqualTo(BigDecimal value) {
            addCriterion("run_time =", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeNotEqualTo(BigDecimal value) {
            addCriterion("run_time <>", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeGreaterThan(BigDecimal value) {
            addCriterion("run_time >", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("run_time >=", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeLessThan(BigDecimal value) {
            addCriterion("run_time <", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("run_time <=", value, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeIn(List<BigDecimal> values) {
            addCriterion("run_time in", values, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeNotIn(List<BigDecimal> values) {
            addCriterion("run_time not in", values, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("run_time between", value1, value2, "runTime");
            return (Criteria) this;
        }

        public Criteria andRunTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("run_time not between", value1, value2, "runTime");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeIsNull() {
            addCriterion("software_run_time is null");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeIsNotNull() {
            addCriterion("software_run_time is not null");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeEqualTo(BigDecimal value) {
            addCriterion("software_run_time =", value, "softwareRunTime");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeNotEqualTo(BigDecimal value) {
            addCriterion("software_run_time <>", value, "softwareRunTime");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeGreaterThan(BigDecimal value) {
            addCriterion("software_run_time >", value, "softwareRunTime");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("software_run_time >=", value, "softwareRunTime");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeLessThan(BigDecimal value) {
            addCriterion("software_run_time <", value, "softwareRunTime");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("software_run_time <=", value, "softwareRunTime");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeIn(List<BigDecimal> values) {
            addCriterion("software_run_time in", values, "softwareRunTime");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeNotIn(List<BigDecimal> values) {
            addCriterion("software_run_time not in", values, "softwareRunTime");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("software_run_time between", value1, value2, "softwareRunTime");
            return (Criteria) this;
        }

        public Criteria andSoftwareRunTimeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("software_run_time not between", value1, value2, "softwareRunTime");
            return (Criteria) this;
        }

        public Criteria andLampSavingIsNull() {
            addCriterion("lamp_saving is null");
            return (Criteria) this;
        }

        public Criteria andLampSavingIsNotNull() {
            addCriterion("lamp_saving is not null");
            return (Criteria) this;
        }

        public Criteria andLampSavingEqualTo(Integer value) {
            addCriterion("lamp_saving =", value, "lampSaving");
            return (Criteria) this;
        }

        public Criteria andLampSavingNotEqualTo(Integer value) {
            addCriterion("lamp_saving <>", value, "lampSaving");
            return (Criteria) this;
        }

        public Criteria andLampSavingGreaterThan(Integer value) {
            addCriterion("lamp_saving >", value, "lampSaving");
            return (Criteria) this;
        }

        public Criteria andLampSavingGreaterThanOrEqualTo(Integer value) {
            addCriterion("lamp_saving >=", value, "lampSaving");
            return (Criteria) this;
        }

        public Criteria andLampSavingLessThan(Integer value) {
            addCriterion("lamp_saving <", value, "lampSaving");
            return (Criteria) this;
        }

        public Criteria andLampSavingLessThanOrEqualTo(Integer value) {
            addCriterion("lamp_saving <=", value, "lampSaving");
            return (Criteria) this;
        }

        public Criteria andLampSavingIn(List<Integer> values) {
            addCriterion("lamp_saving in", values, "lampSaving");
            return (Criteria) this;
        }

        public Criteria andLampSavingNotIn(List<Integer> values) {
            addCriterion("lamp_saving not in", values, "lampSaving");
            return (Criteria) this;
        }

        public Criteria andLampSavingBetween(Integer value1, Integer value2) {
            addCriterion("lamp_saving between", value1, value2, "lampSaving");
            return (Criteria) this;
        }

        public Criteria andLampSavingNotBetween(Integer value1, Integer value2) {
            addCriterion("lamp_saving not between", value1, value2, "lampSaving");
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