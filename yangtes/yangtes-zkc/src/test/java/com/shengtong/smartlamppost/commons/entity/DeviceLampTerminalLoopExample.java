package com.shengtong.smartlamppost.commons.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceLampTerminalLoopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceLampTerminalLoopExample() {
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

        public Criteria andDeviceLampTerminalIdIsNull() {
            addCriterion("device_lamp_terminal_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdIsNotNull() {
            addCriterion("device_lamp_terminal_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdEqualTo(String value) {
            addCriterion("device_lamp_terminal_id =", value, "deviceLampTerminalId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdNotEqualTo(String value) {
            addCriterion("device_lamp_terminal_id <>", value, "deviceLampTerminalId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdGreaterThan(String value) {
            addCriterion("device_lamp_terminal_id >", value, "deviceLampTerminalId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_lamp_terminal_id >=", value, "deviceLampTerminalId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdLessThan(String value) {
            addCriterion("device_lamp_terminal_id <", value, "deviceLampTerminalId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdLessThanOrEqualTo(String value) {
            addCriterion("device_lamp_terminal_id <=", value, "deviceLampTerminalId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdLike(String value) {
            addCriterion("device_lamp_terminal_id like", value, "deviceLampTerminalId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdNotLike(String value) {
            addCriterion("device_lamp_terminal_id not like", value, "deviceLampTerminalId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdIn(List<String> values) {
            addCriterion("device_lamp_terminal_id in", values, "deviceLampTerminalId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdNotIn(List<String> values) {
            addCriterion("device_lamp_terminal_id not in", values, "deviceLampTerminalId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdBetween(String value1, String value2) {
            addCriterion("device_lamp_terminal_id between", value1, value2, "deviceLampTerminalId");
            return (Criteria) this;
        }

        public Criteria andDeviceLampTerminalIdNotBetween(String value1, String value2) {
            addCriterion("device_lamp_terminal_id not between", value1, value2, "deviceLampTerminalId");
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

        public Criteria andLoopIdIsNull() {
            addCriterion("loop_id is null");
            return (Criteria) this;
        }

        public Criteria andLoopIdIsNotNull() {
            addCriterion("loop_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoopIdEqualTo(Integer value) {
            addCriterion("loop_id =", value, "loopId");
            return (Criteria) this;
        }

        public Criteria andLoopIdNotEqualTo(Integer value) {
            addCriterion("loop_id <>", value, "loopId");
            return (Criteria) this;
        }

        public Criteria andLoopIdGreaterThan(Integer value) {
            addCriterion("loop_id >", value, "loopId");
            return (Criteria) this;
        }

        public Criteria andLoopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("loop_id >=", value, "loopId");
            return (Criteria) this;
        }

        public Criteria andLoopIdLessThan(Integer value) {
            addCriterion("loop_id <", value, "loopId");
            return (Criteria) this;
        }

        public Criteria andLoopIdLessThanOrEqualTo(Integer value) {
            addCriterion("loop_id <=", value, "loopId");
            return (Criteria) this;
        }

        public Criteria andLoopIdIn(List<Integer> values) {
            addCriterion("loop_id in", values, "loopId");
            return (Criteria) this;
        }

        public Criteria andLoopIdNotIn(List<Integer> values) {
            addCriterion("loop_id not in", values, "loopId");
            return (Criteria) this;
        }

        public Criteria andLoopIdBetween(Integer value1, Integer value2) {
            addCriterion("loop_id between", value1, value2, "loopId");
            return (Criteria) this;
        }

        public Criteria andLoopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("loop_id not between", value1, value2, "loopId");
            return (Criteria) this;
        }

        public Criteria andLoopNameIsNull() {
            addCriterion("loop_name is null");
            return (Criteria) this;
        }

        public Criteria andLoopNameIsNotNull() {
            addCriterion("loop_name is not null");
            return (Criteria) this;
        }

        public Criteria andLoopNameEqualTo(String value) {
            addCriterion("loop_name =", value, "loopName");
            return (Criteria) this;
        }

        public Criteria andLoopNameNotEqualTo(String value) {
            addCriterion("loop_name <>", value, "loopName");
            return (Criteria) this;
        }

        public Criteria andLoopNameGreaterThan(String value) {
            addCriterion("loop_name >", value, "loopName");
            return (Criteria) this;
        }

        public Criteria andLoopNameGreaterThanOrEqualTo(String value) {
            addCriterion("loop_name >=", value, "loopName");
            return (Criteria) this;
        }

        public Criteria andLoopNameLessThan(String value) {
            addCriterion("loop_name <", value, "loopName");
            return (Criteria) this;
        }

        public Criteria andLoopNameLessThanOrEqualTo(String value) {
            addCriterion("loop_name <=", value, "loopName");
            return (Criteria) this;
        }

        public Criteria andLoopNameLike(String value) {
            addCriterion("loop_name like", value, "loopName");
            return (Criteria) this;
        }

        public Criteria andLoopNameNotLike(String value) {
            addCriterion("loop_name not like", value, "loopName");
            return (Criteria) this;
        }

        public Criteria andLoopNameIn(List<String> values) {
            addCriterion("loop_name in", values, "loopName");
            return (Criteria) this;
        }

        public Criteria andLoopNameNotIn(List<String> values) {
            addCriterion("loop_name not in", values, "loopName");
            return (Criteria) this;
        }

        public Criteria andLoopNameBetween(String value1, String value2) {
            addCriterion("loop_name between", value1, value2, "loopName");
            return (Criteria) this;
        }

        public Criteria andLoopNameNotBetween(String value1, String value2) {
            addCriterion("loop_name not between", value1, value2, "loopName");
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

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andFactorIsNull() {
            addCriterion("factor is null");
            return (Criteria) this;
        }

        public Criteria andFactorIsNotNull() {
            addCriterion("factor is not null");
            return (Criteria) this;
        }

        public Criteria andFactorEqualTo(String value) {
            addCriterion("factor =", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorNotEqualTo(String value) {
            addCriterion("factor <>", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorGreaterThan(String value) {
            addCriterion("factor >", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorGreaterThanOrEqualTo(String value) {
            addCriterion("factor >=", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorLessThan(String value) {
            addCriterion("factor <", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorLessThanOrEqualTo(String value) {
            addCriterion("factor <=", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorLike(String value) {
            addCriterion("factor like", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorNotLike(String value) {
            addCriterion("factor not like", value, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorIn(List<String> values) {
            addCriterion("factor in", values, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorNotIn(List<String> values) {
            addCriterion("factor not in", values, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorBetween(String value1, String value2) {
            addCriterion("factor between", value1, value2, "factor");
            return (Criteria) this;
        }

        public Criteria andFactorNotBetween(String value1, String value2) {
            addCriterion("factor not between", value1, value2, "factor");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusIsNull() {
            addCriterion("switch_input_status is null");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusIsNotNull() {
            addCriterion("switch_input_status is not null");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusEqualTo(String value) {
            addCriterion("switch_input_status =", value, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusNotEqualTo(String value) {
            addCriterion("switch_input_status <>", value, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusGreaterThan(String value) {
            addCriterion("switch_input_status >", value, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusGreaterThanOrEqualTo(String value) {
            addCriterion("switch_input_status >=", value, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusLessThan(String value) {
            addCriterion("switch_input_status <", value, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusLessThanOrEqualTo(String value) {
            addCriterion("switch_input_status <=", value, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusLike(String value) {
            addCriterion("switch_input_status like", value, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusNotLike(String value) {
            addCriterion("switch_input_status not like", value, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusIn(List<String> values) {
            addCriterion("switch_input_status in", values, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusNotIn(List<String> values) {
            addCriterion("switch_input_status not in", values, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusBetween(String value1, String value2) {
            addCriterion("switch_input_status between", value1, value2, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andSwitchInputStatusNotBetween(String value1, String value2) {
            addCriterion("switch_input_status not between", value1, value2, "switchInputStatus");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeIsNull() {
            addCriterion("voltage_over_range is null");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeIsNotNull() {
            addCriterion("voltage_over_range is not null");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeEqualTo(String value) {
            addCriterion("voltage_over_range =", value, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeNotEqualTo(String value) {
            addCriterion("voltage_over_range <>", value, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeGreaterThan(String value) {
            addCriterion("voltage_over_range >", value, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeGreaterThanOrEqualTo(String value) {
            addCriterion("voltage_over_range >=", value, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeLessThan(String value) {
            addCriterion("voltage_over_range <", value, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeLessThanOrEqualTo(String value) {
            addCriterion("voltage_over_range <=", value, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeLike(String value) {
            addCriterion("voltage_over_range like", value, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeNotLike(String value) {
            addCriterion("voltage_over_range not like", value, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeIn(List<String> values) {
            addCriterion("voltage_over_range in", values, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeNotIn(List<String> values) {
            addCriterion("voltage_over_range not in", values, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeBetween(String value1, String value2) {
            addCriterion("voltage_over_range between", value1, value2, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andVoltageOverRangeNotBetween(String value1, String value2) {
            addCriterion("voltage_over_range not between", value1, value2, "voltageOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeIsNull() {
            addCriterion("current_over_range is null");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeIsNotNull() {
            addCriterion("current_over_range is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeEqualTo(String value) {
            addCriterion("current_over_range =", value, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeNotEqualTo(String value) {
            addCriterion("current_over_range <>", value, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeGreaterThan(String value) {
            addCriterion("current_over_range >", value, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeGreaterThanOrEqualTo(String value) {
            addCriterion("current_over_range >=", value, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeLessThan(String value) {
            addCriterion("current_over_range <", value, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeLessThanOrEqualTo(String value) {
            addCriterion("current_over_range <=", value, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeLike(String value) {
            addCriterion("current_over_range like", value, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeNotLike(String value) {
            addCriterion("current_over_range not like", value, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeIn(List<String> values) {
            addCriterion("current_over_range in", values, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeNotIn(List<String> values) {
            addCriterion("current_over_range not in", values, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeBetween(String value1, String value2) {
            addCriterion("current_over_range between", value1, value2, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andCurrentOverRangeNotBetween(String value1, String value2) {
            addCriterion("current_over_range not between", value1, value2, "currentOverRange");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeIsNull() {
            addCriterion("lamp_on_time is null");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeIsNotNull() {
            addCriterion("lamp_on_time is not null");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeEqualTo(Integer value) {
            addCriterion("lamp_on_time =", value, "lampOnTime");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeNotEqualTo(Integer value) {
            addCriterion("lamp_on_time <>", value, "lampOnTime");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeGreaterThan(Integer value) {
            addCriterion("lamp_on_time >", value, "lampOnTime");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lamp_on_time >=", value, "lampOnTime");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeLessThan(Integer value) {
            addCriterion("lamp_on_time <", value, "lampOnTime");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeLessThanOrEqualTo(Integer value) {
            addCriterion("lamp_on_time <=", value, "lampOnTime");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeIn(List<Integer> values) {
            addCriterion("lamp_on_time in", values, "lampOnTime");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeNotIn(List<Integer> values) {
            addCriterion("lamp_on_time not in", values, "lampOnTime");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeBetween(Integer value1, Integer value2) {
            addCriterion("lamp_on_time between", value1, value2, "lampOnTime");
            return (Criteria) this;
        }

        public Criteria andLampOnTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("lamp_on_time not between", value1, value2, "lampOnTime");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityIsNull() {
            addCriterion("estimate_power_capacity is null");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityIsNotNull() {
            addCriterion("estimate_power_capacity is not null");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityEqualTo(Double value) {
            addCriterion("estimate_power_capacity =", value, "estimatePowerCapacity");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityNotEqualTo(Double value) {
            addCriterion("estimate_power_capacity <>", value, "estimatePowerCapacity");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityGreaterThan(Double value) {
            addCriterion("estimate_power_capacity >", value, "estimatePowerCapacity");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityGreaterThanOrEqualTo(Double value) {
            addCriterion("estimate_power_capacity >=", value, "estimatePowerCapacity");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityLessThan(Double value) {
            addCriterion("estimate_power_capacity <", value, "estimatePowerCapacity");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityLessThanOrEqualTo(Double value) {
            addCriterion("estimate_power_capacity <=", value, "estimatePowerCapacity");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityIn(List<Double> values) {
            addCriterion("estimate_power_capacity in", values, "estimatePowerCapacity");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityNotIn(List<Double> values) {
            addCriterion("estimate_power_capacity not in", values, "estimatePowerCapacity");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityBetween(Double value1, Double value2) {
            addCriterion("estimate_power_capacity between", value1, value2, "estimatePowerCapacity");
            return (Criteria) this;
        }

        public Criteria andEstimatePowerCapacityNotBetween(Double value1, Double value2) {
            addCriterion("estimate_power_capacity not between", value1, value2, "estimatePowerCapacity");
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

        public Criteria andElectricityEqualTo(Double value) {
            addCriterion("electricity =", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotEqualTo(Double value) {
            addCriterion("electricity <>", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThan(Double value) {
            addCriterion("electricity >", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityGreaterThanOrEqualTo(Double value) {
            addCriterion("electricity >=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThan(Double value) {
            addCriterion("electricity <", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityLessThanOrEqualTo(Double value) {
            addCriterion("electricity <=", value, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityIn(List<Double> values) {
            addCriterion("electricity in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotIn(List<Double> values) {
            addCriterion("electricity not in", values, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityBetween(Double value1, Double value2) {
            addCriterion("electricity between", value1, value2, "electricity");
            return (Criteria) this;
        }

        public Criteria andElectricityNotBetween(Double value1, Double value2) {
            addCriterion("electricity not between", value1, value2, "electricity");
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