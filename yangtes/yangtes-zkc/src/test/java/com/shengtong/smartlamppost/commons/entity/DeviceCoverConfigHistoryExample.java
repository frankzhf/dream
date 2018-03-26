package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceCoverConfigHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceCoverConfigHistoryExample() {
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

        public Criteria andDeviceCoverIdIsNull() {
            addCriterion("device_cover_id is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdIsNotNull() {
            addCriterion("device_cover_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdEqualTo(String value) {
            addCriterion("device_cover_id =", value, "deviceCoverId");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdNotEqualTo(String value) {
            addCriterion("device_cover_id <>", value, "deviceCoverId");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdGreaterThan(String value) {
            addCriterion("device_cover_id >", value, "deviceCoverId");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdGreaterThanOrEqualTo(String value) {
            addCriterion("device_cover_id >=", value, "deviceCoverId");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdLessThan(String value) {
            addCriterion("device_cover_id <", value, "deviceCoverId");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdLessThanOrEqualTo(String value) {
            addCriterion("device_cover_id <=", value, "deviceCoverId");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdLike(String value) {
            addCriterion("device_cover_id like", value, "deviceCoverId");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdNotLike(String value) {
            addCriterion("device_cover_id not like", value, "deviceCoverId");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdIn(List<String> values) {
            addCriterion("device_cover_id in", values, "deviceCoverId");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdNotIn(List<String> values) {
            addCriterion("device_cover_id not in", values, "deviceCoverId");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdBetween(String value1, String value2) {
            addCriterion("device_cover_id between", value1, value2, "deviceCoverId");
            return (Criteria) this;
        }

        public Criteria andDeviceCoverIdNotBetween(String value1, String value2) {
            addCriterion("device_cover_id not between", value1, value2, "deviceCoverId");
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

        public Criteria andCoverIdIsNull() {
            addCriterion("cover_id is null");
            return (Criteria) this;
        }

        public Criteria andCoverIdIsNotNull() {
            addCriterion("cover_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoverIdEqualTo(String value) {
            addCriterion("cover_id =", value, "coverId");
            return (Criteria) this;
        }

        public Criteria andCoverIdNotEqualTo(String value) {
            addCriterion("cover_id <>", value, "coverId");
            return (Criteria) this;
        }

        public Criteria andCoverIdGreaterThan(String value) {
            addCriterion("cover_id >", value, "coverId");
            return (Criteria) this;
        }

        public Criteria andCoverIdGreaterThanOrEqualTo(String value) {
            addCriterion("cover_id >=", value, "coverId");
            return (Criteria) this;
        }

        public Criteria andCoverIdLessThan(String value) {
            addCriterion("cover_id <", value, "coverId");
            return (Criteria) this;
        }

        public Criteria andCoverIdLessThanOrEqualTo(String value) {
            addCriterion("cover_id <=", value, "coverId");
            return (Criteria) this;
        }

        public Criteria andCoverIdLike(String value) {
            addCriterion("cover_id like", value, "coverId");
            return (Criteria) this;
        }

        public Criteria andCoverIdNotLike(String value) {
            addCriterion("cover_id not like", value, "coverId");
            return (Criteria) this;
        }

        public Criteria andCoverIdIn(List<String> values) {
            addCriterion("cover_id in", values, "coverId");
            return (Criteria) this;
        }

        public Criteria andCoverIdNotIn(List<String> values) {
            addCriterion("cover_id not in", values, "coverId");
            return (Criteria) this;
        }

        public Criteria andCoverIdBetween(String value1, String value2) {
            addCriterion("cover_id between", value1, value2, "coverId");
            return (Criteria) this;
        }

        public Criteria andCoverIdNotBetween(String value1, String value2) {
            addCriterion("cover_id not between", value1, value2, "coverId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdIsNull() {
            addCriterion("base_station_id is null");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdIsNotNull() {
            addCriterion("base_station_id is not null");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdEqualTo(String value) {
            addCriterion("base_station_id =", value, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdNotEqualTo(String value) {
            addCriterion("base_station_id <>", value, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdGreaterThan(String value) {
            addCriterion("base_station_id >", value, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdGreaterThanOrEqualTo(String value) {
            addCriterion("base_station_id >=", value, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdLessThan(String value) {
            addCriterion("base_station_id <", value, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdLessThanOrEqualTo(String value) {
            addCriterion("base_station_id <=", value, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdLike(String value) {
            addCriterion("base_station_id like", value, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdNotLike(String value) {
            addCriterion("base_station_id not like", value, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdIn(List<String> values) {
            addCriterion("base_station_id in", values, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdNotIn(List<String> values) {
            addCriterion("base_station_id not in", values, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdBetween(String value1, String value2) {
            addCriterion("base_station_id between", value1, value2, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andBaseStationIdNotBetween(String value1, String value2) {
            addCriterion("base_station_id not between", value1, value2, "baseStationId");
            return (Criteria) this;
        }

        public Criteria andSetupResultIsNull() {
            addCriterion("setup_result is null");
            return (Criteria) this;
        }

        public Criteria andSetupResultIsNotNull() {
            addCriterion("setup_result is not null");
            return (Criteria) this;
        }

        public Criteria andSetupResultEqualTo(String value) {
            addCriterion("setup_result =", value, "setupResult");
            return (Criteria) this;
        }

        public Criteria andSetupResultNotEqualTo(String value) {
            addCriterion("setup_result <>", value, "setupResult");
            return (Criteria) this;
        }

        public Criteria andSetupResultGreaterThan(String value) {
            addCriterion("setup_result >", value, "setupResult");
            return (Criteria) this;
        }

        public Criteria andSetupResultGreaterThanOrEqualTo(String value) {
            addCriterion("setup_result >=", value, "setupResult");
            return (Criteria) this;
        }

        public Criteria andSetupResultLessThan(String value) {
            addCriterion("setup_result <", value, "setupResult");
            return (Criteria) this;
        }

        public Criteria andSetupResultLessThanOrEqualTo(String value) {
            addCriterion("setup_result <=", value, "setupResult");
            return (Criteria) this;
        }

        public Criteria andSetupResultLike(String value) {
            addCriterion("setup_result like", value, "setupResult");
            return (Criteria) this;
        }

        public Criteria andSetupResultNotLike(String value) {
            addCriterion("setup_result not like", value, "setupResult");
            return (Criteria) this;
        }

        public Criteria andSetupResultIn(List<String> values) {
            addCriterion("setup_result in", values, "setupResult");
            return (Criteria) this;
        }

        public Criteria andSetupResultNotIn(List<String> values) {
            addCriterion("setup_result not in", values, "setupResult");
            return (Criteria) this;
        }

        public Criteria andSetupResultBetween(String value1, String value2) {
            addCriterion("setup_result between", value1, value2, "setupResult");
            return (Criteria) this;
        }

        public Criteria andSetupResultNotBetween(String value1, String value2) {
            addCriterion("setup_result not between", value1, value2, "setupResult");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdIsNull() {
            addCriterion("callback_base_station_id is null");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdIsNotNull() {
            addCriterion("callback_base_station_id is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdEqualTo(String value) {
            addCriterion("callback_base_station_id =", value, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdNotEqualTo(String value) {
            addCriterion("callback_base_station_id <>", value, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdGreaterThan(String value) {
            addCriterion("callback_base_station_id >", value, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdGreaterThanOrEqualTo(String value) {
            addCriterion("callback_base_station_id >=", value, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdLessThan(String value) {
            addCriterion("callback_base_station_id <", value, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdLessThanOrEqualTo(String value) {
            addCriterion("callback_base_station_id <=", value, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdLike(String value) {
            addCriterion("callback_base_station_id like", value, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdNotLike(String value) {
            addCriterion("callback_base_station_id not like", value, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdIn(List<String> values) {
            addCriterion("callback_base_station_id in", values, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdNotIn(List<String> values) {
            addCriterion("callback_base_station_id not in", values, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdBetween(String value1, String value2) {
            addCriterion("callback_base_station_id between", value1, value2, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackBaseStationIdNotBetween(String value1, String value2) {
            addCriterion("callback_base_station_id not between", value1, value2, "callbackBaseStationId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdIsNull() {
            addCriterion("callback_cover_id is null");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdIsNotNull() {
            addCriterion("callback_cover_id is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdEqualTo(String value) {
            addCriterion("callback_cover_id =", value, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdNotEqualTo(String value) {
            addCriterion("callback_cover_id <>", value, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdGreaterThan(String value) {
            addCriterion("callback_cover_id >", value, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdGreaterThanOrEqualTo(String value) {
            addCriterion("callback_cover_id >=", value, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdLessThan(String value) {
            addCriterion("callback_cover_id <", value, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdLessThanOrEqualTo(String value) {
            addCriterion("callback_cover_id <=", value, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdLike(String value) {
            addCriterion("callback_cover_id like", value, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdNotLike(String value) {
            addCriterion("callback_cover_id not like", value, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdIn(List<String> values) {
            addCriterion("callback_cover_id in", values, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdNotIn(List<String> values) {
            addCriterion("callback_cover_id not in", values, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdBetween(String value1, String value2) {
            addCriterion("callback_cover_id between", value1, value2, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andCallbackCoverIdNotBetween(String value1, String value2) {
            addCriterion("callback_cover_id not between", value1, value2, "callbackCoverId");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeIsNull() {
            addCriterion("hearbeat_time is null");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeIsNotNull() {
            addCriterion("hearbeat_time is not null");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeEqualTo(Integer value) {
            addCriterion("hearbeat_time =", value, "hearbeatTime");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeNotEqualTo(Integer value) {
            addCriterion("hearbeat_time <>", value, "hearbeatTime");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeGreaterThan(Integer value) {
            addCriterion("hearbeat_time >", value, "hearbeatTime");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("hearbeat_time >=", value, "hearbeatTime");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeLessThan(Integer value) {
            addCriterion("hearbeat_time <", value, "hearbeatTime");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeLessThanOrEqualTo(Integer value) {
            addCriterion("hearbeat_time <=", value, "hearbeatTime");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeIn(List<Integer> values) {
            addCriterion("hearbeat_time in", values, "hearbeatTime");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeNotIn(List<Integer> values) {
            addCriterion("hearbeat_time not in", values, "hearbeatTime");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeBetween(Integer value1, Integer value2) {
            addCriterion("hearbeat_time between", value1, value2, "hearbeatTime");
            return (Criteria) this;
        }

        public Criteria andHearbeatTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("hearbeat_time not between", value1, value2, "hearbeatTime");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdIsNull() {
            addCriterion("cover_inclination_threshold is null");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdIsNotNull() {
            addCriterion("cover_inclination_threshold is not null");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdEqualTo(Integer value) {
            addCriterion("cover_inclination_threshold =", value, "coverInclinationThreshold");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdNotEqualTo(Integer value) {
            addCriterion("cover_inclination_threshold <>", value, "coverInclinationThreshold");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdGreaterThan(Integer value) {
            addCriterion("cover_inclination_threshold >", value, "coverInclinationThreshold");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cover_inclination_threshold >=", value, "coverInclinationThreshold");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdLessThan(Integer value) {
            addCriterion("cover_inclination_threshold <", value, "coverInclinationThreshold");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("cover_inclination_threshold <=", value, "coverInclinationThreshold");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdIn(List<Integer> values) {
            addCriterion("cover_inclination_threshold in", values, "coverInclinationThreshold");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdNotIn(List<Integer> values) {
            addCriterion("cover_inclination_threshold not in", values, "coverInclinationThreshold");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdBetween(Integer value1, Integer value2) {
            addCriterion("cover_inclination_threshold between", value1, value2, "coverInclinationThreshold");
            return (Criteria) this;
        }

        public Criteria andCoverInclinationThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("cover_inclination_threshold not between", value1, value2, "coverInclinationThreshold");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationIsNull() {
            addCriterion("cover_calibration is null");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationIsNotNull() {
            addCriterion("cover_calibration is not null");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationEqualTo(Integer value) {
            addCriterion("cover_calibration =", value, "coverCalibration");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationNotEqualTo(Integer value) {
            addCriterion("cover_calibration <>", value, "coverCalibration");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationGreaterThan(Integer value) {
            addCriterion("cover_calibration >", value, "coverCalibration");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationGreaterThanOrEqualTo(Integer value) {
            addCriterion("cover_calibration >=", value, "coverCalibration");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationLessThan(Integer value) {
            addCriterion("cover_calibration <", value, "coverCalibration");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationLessThanOrEqualTo(Integer value) {
            addCriterion("cover_calibration <=", value, "coverCalibration");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationIn(List<Integer> values) {
            addCriterion("cover_calibration in", values, "coverCalibration");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationNotIn(List<Integer> values) {
            addCriterion("cover_calibration not in", values, "coverCalibration");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationBetween(Integer value1, Integer value2) {
            addCriterion("cover_calibration between", value1, value2, "coverCalibration");
            return (Criteria) this;
        }

        public Criteria andCoverCalibrationNotBetween(Integer value1, Integer value2) {
            addCriterion("cover_calibration not between", value1, value2, "coverCalibration");
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