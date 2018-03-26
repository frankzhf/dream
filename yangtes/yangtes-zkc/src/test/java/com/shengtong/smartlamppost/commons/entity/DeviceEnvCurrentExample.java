package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceEnvCurrentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceEnvCurrentExample() {
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

        public Criteria andDeviceCodeIsNull() {
            addCriterion("device_code is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIsNotNull() {
            addCriterion("device_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeEqualTo(String value) {
            addCriterion("device_code =", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotEqualTo(String value) {
            addCriterion("device_code <>", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeGreaterThan(String value) {
            addCriterion("device_code >", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("device_code >=", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLessThan(String value) {
            addCriterion("device_code <", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLessThanOrEqualTo(String value) {
            addCriterion("device_code <=", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLike(String value) {
            addCriterion("device_code like", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotLike(String value) {
            addCriterion("device_code not like", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIn(List<String> values) {
            addCriterion("device_code in", values, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotIn(List<String> values) {
            addCriterion("device_code not in", values, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeBetween(String value1, String value2) {
            addCriterion("device_code between", value1, value2, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotBetween(String value1, String value2) {
            addCriterion("device_code not between", value1, value2, "deviceCode");
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

        public Criteria andEnvDnIsNull() {
            addCriterion("env_dn is null");
            return (Criteria) this;
        }

        public Criteria andEnvDnIsNotNull() {
            addCriterion("env_dn is not null");
            return (Criteria) this;
        }

        public Criteria andEnvDnEqualTo(String value) {
            addCriterion("env_dn =", value, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDnNotEqualTo(String value) {
            addCriterion("env_dn <>", value, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDnGreaterThan(String value) {
            addCriterion("env_dn >", value, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDnGreaterThanOrEqualTo(String value) {
            addCriterion("env_dn >=", value, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDnLessThan(String value) {
            addCriterion("env_dn <", value, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDnLessThanOrEqualTo(String value) {
            addCriterion("env_dn <=", value, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDnLike(String value) {
            addCriterion("env_dn like", value, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDnNotLike(String value) {
            addCriterion("env_dn not like", value, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDnIn(List<String> values) {
            addCriterion("env_dn in", values, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDnNotIn(List<String> values) {
            addCriterion("env_dn not in", values, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDnBetween(String value1, String value2) {
            addCriterion("env_dn between", value1, value2, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDnNotBetween(String value1, String value2) {
            addCriterion("env_dn not between", value1, value2, "envDn");
            return (Criteria) this;
        }

        public Criteria andEnvDmIsNull() {
            addCriterion("env_dm is null");
            return (Criteria) this;
        }

        public Criteria andEnvDmIsNotNull() {
            addCriterion("env_dm is not null");
            return (Criteria) this;
        }

        public Criteria andEnvDmEqualTo(String value) {
            addCriterion("env_dm =", value, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDmNotEqualTo(String value) {
            addCriterion("env_dm <>", value, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDmGreaterThan(String value) {
            addCriterion("env_dm >", value, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDmGreaterThanOrEqualTo(String value) {
            addCriterion("env_dm >=", value, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDmLessThan(String value) {
            addCriterion("env_dm <", value, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDmLessThanOrEqualTo(String value) {
            addCriterion("env_dm <=", value, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDmLike(String value) {
            addCriterion("env_dm like", value, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDmNotLike(String value) {
            addCriterion("env_dm not like", value, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDmIn(List<String> values) {
            addCriterion("env_dm in", values, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDmNotIn(List<String> values) {
            addCriterion("env_dm not in", values, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDmBetween(String value1, String value2) {
            addCriterion("env_dm between", value1, value2, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDmNotBetween(String value1, String value2) {
            addCriterion("env_dm not between", value1, value2, "envDm");
            return (Criteria) this;
        }

        public Criteria andEnvDxIsNull() {
            addCriterion("env_dx is null");
            return (Criteria) this;
        }

        public Criteria andEnvDxIsNotNull() {
            addCriterion("env_dx is not null");
            return (Criteria) this;
        }

        public Criteria andEnvDxEqualTo(String value) {
            addCriterion("env_dx =", value, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvDxNotEqualTo(String value) {
            addCriterion("env_dx <>", value, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvDxGreaterThan(String value) {
            addCriterion("env_dx >", value, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvDxGreaterThanOrEqualTo(String value) {
            addCriterion("env_dx >=", value, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvDxLessThan(String value) {
            addCriterion("env_dx <", value, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvDxLessThanOrEqualTo(String value) {
            addCriterion("env_dx <=", value, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvDxLike(String value) {
            addCriterion("env_dx like", value, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvDxNotLike(String value) {
            addCriterion("env_dx not like", value, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvDxIn(List<String> values) {
            addCriterion("env_dx in", values, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvDxNotIn(List<String> values) {
            addCriterion("env_dx not in", values, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvDxBetween(String value1, String value2) {
            addCriterion("env_dx between", value1, value2, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvDxNotBetween(String value1, String value2) {
            addCriterion("env_dx not between", value1, value2, "envDx");
            return (Criteria) this;
        }

        public Criteria andEnvSnIsNull() {
            addCriterion("env_sn is null");
            return (Criteria) this;
        }

        public Criteria andEnvSnIsNotNull() {
            addCriterion("env_sn is not null");
            return (Criteria) this;
        }

        public Criteria andEnvSnEqualTo(String value) {
            addCriterion("env_sn =", value, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSnNotEqualTo(String value) {
            addCriterion("env_sn <>", value, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSnGreaterThan(String value) {
            addCriterion("env_sn >", value, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSnGreaterThanOrEqualTo(String value) {
            addCriterion("env_sn >=", value, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSnLessThan(String value) {
            addCriterion("env_sn <", value, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSnLessThanOrEqualTo(String value) {
            addCriterion("env_sn <=", value, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSnLike(String value) {
            addCriterion("env_sn like", value, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSnNotLike(String value) {
            addCriterion("env_sn not like", value, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSnIn(List<String> values) {
            addCriterion("env_sn in", values, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSnNotIn(List<String> values) {
            addCriterion("env_sn not in", values, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSnBetween(String value1, String value2) {
            addCriterion("env_sn between", value1, value2, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSnNotBetween(String value1, String value2) {
            addCriterion("env_sn not between", value1, value2, "envSn");
            return (Criteria) this;
        }

        public Criteria andEnvSmIsNull() {
            addCriterion("env_sm is null");
            return (Criteria) this;
        }

        public Criteria andEnvSmIsNotNull() {
            addCriterion("env_sm is not null");
            return (Criteria) this;
        }

        public Criteria andEnvSmEqualTo(String value) {
            addCriterion("env_sm =", value, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSmNotEqualTo(String value) {
            addCriterion("env_sm <>", value, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSmGreaterThan(String value) {
            addCriterion("env_sm >", value, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSmGreaterThanOrEqualTo(String value) {
            addCriterion("env_sm >=", value, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSmLessThan(String value) {
            addCriterion("env_sm <", value, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSmLessThanOrEqualTo(String value) {
            addCriterion("env_sm <=", value, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSmLike(String value) {
            addCriterion("env_sm like", value, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSmNotLike(String value) {
            addCriterion("env_sm not like", value, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSmIn(List<String> values) {
            addCriterion("env_sm in", values, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSmNotIn(List<String> values) {
            addCriterion("env_sm not in", values, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSmBetween(String value1, String value2) {
            addCriterion("env_sm between", value1, value2, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSmNotBetween(String value1, String value2) {
            addCriterion("env_sm not between", value1, value2, "envSm");
            return (Criteria) this;
        }

        public Criteria andEnvSxIsNull() {
            addCriterion("env_sx is null");
            return (Criteria) this;
        }

        public Criteria andEnvSxIsNotNull() {
            addCriterion("env_sx is not null");
            return (Criteria) this;
        }

        public Criteria andEnvSxEqualTo(String value) {
            addCriterion("env_sx =", value, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvSxNotEqualTo(String value) {
            addCriterion("env_sx <>", value, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvSxGreaterThan(String value) {
            addCriterion("env_sx >", value, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvSxGreaterThanOrEqualTo(String value) {
            addCriterion("env_sx >=", value, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvSxLessThan(String value) {
            addCriterion("env_sx <", value, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvSxLessThanOrEqualTo(String value) {
            addCriterion("env_sx <=", value, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvSxLike(String value) {
            addCriterion("env_sx like", value, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvSxNotLike(String value) {
            addCriterion("env_sx not like", value, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvSxIn(List<String> values) {
            addCriterion("env_sx in", values, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvSxNotIn(List<String> values) {
            addCriterion("env_sx not in", values, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvSxBetween(String value1, String value2) {
            addCriterion("env_sx between", value1, value2, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvSxNotBetween(String value1, String value2) {
            addCriterion("env_sx not between", value1, value2, "envSx");
            return (Criteria) this;
        }

        public Criteria andEnvTaIsNull() {
            addCriterion("env_ta is null");
            return (Criteria) this;
        }

        public Criteria andEnvTaIsNotNull() {
            addCriterion("env_ta is not null");
            return (Criteria) this;
        }

        public Criteria andEnvTaEqualTo(String value) {
            addCriterion("env_ta =", value, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvTaNotEqualTo(String value) {
            addCriterion("env_ta <>", value, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvTaGreaterThan(String value) {
            addCriterion("env_ta >", value, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvTaGreaterThanOrEqualTo(String value) {
            addCriterion("env_ta >=", value, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvTaLessThan(String value) {
            addCriterion("env_ta <", value, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvTaLessThanOrEqualTo(String value) {
            addCriterion("env_ta <=", value, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvTaLike(String value) {
            addCriterion("env_ta like", value, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvTaNotLike(String value) {
            addCriterion("env_ta not like", value, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvTaIn(List<String> values) {
            addCriterion("env_ta in", values, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvTaNotIn(List<String> values) {
            addCriterion("env_ta not in", values, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvTaBetween(String value1, String value2) {
            addCriterion("env_ta between", value1, value2, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvTaNotBetween(String value1, String value2) {
            addCriterion("env_ta not between", value1, value2, "envTa");
            return (Criteria) this;
        }

        public Criteria andEnvUaIsNull() {
            addCriterion("env_ua is null");
            return (Criteria) this;
        }

        public Criteria andEnvUaIsNotNull() {
            addCriterion("env_ua is not null");
            return (Criteria) this;
        }

        public Criteria andEnvUaEqualTo(String value) {
            addCriterion("env_ua =", value, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvUaNotEqualTo(String value) {
            addCriterion("env_ua <>", value, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvUaGreaterThan(String value) {
            addCriterion("env_ua >", value, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvUaGreaterThanOrEqualTo(String value) {
            addCriterion("env_ua >=", value, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvUaLessThan(String value) {
            addCriterion("env_ua <", value, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvUaLessThanOrEqualTo(String value) {
            addCriterion("env_ua <=", value, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvUaLike(String value) {
            addCriterion("env_ua like", value, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvUaNotLike(String value) {
            addCriterion("env_ua not like", value, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvUaIn(List<String> values) {
            addCriterion("env_ua in", values, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvUaNotIn(List<String> values) {
            addCriterion("env_ua not in", values, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvUaBetween(String value1, String value2) {
            addCriterion("env_ua between", value1, value2, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvUaNotBetween(String value1, String value2) {
            addCriterion("env_ua not between", value1, value2, "envUa");
            return (Criteria) this;
        }

        public Criteria andEnvPaIsNull() {
            addCriterion("env_pa is null");
            return (Criteria) this;
        }

        public Criteria andEnvPaIsNotNull() {
            addCriterion("env_pa is not null");
            return (Criteria) this;
        }

        public Criteria andEnvPaEqualTo(String value) {
            addCriterion("env_pa =", value, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvPaNotEqualTo(String value) {
            addCriterion("env_pa <>", value, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvPaGreaterThan(String value) {
            addCriterion("env_pa >", value, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvPaGreaterThanOrEqualTo(String value) {
            addCriterion("env_pa >=", value, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvPaLessThan(String value) {
            addCriterion("env_pa <", value, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvPaLessThanOrEqualTo(String value) {
            addCriterion("env_pa <=", value, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvPaLike(String value) {
            addCriterion("env_pa like", value, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvPaNotLike(String value) {
            addCriterion("env_pa not like", value, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvPaIn(List<String> values) {
            addCriterion("env_pa in", values, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvPaNotIn(List<String> values) {
            addCriterion("env_pa not in", values, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvPaBetween(String value1, String value2) {
            addCriterion("env_pa between", value1, value2, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvPaNotBetween(String value1, String value2) {
            addCriterion("env_pa not between", value1, value2, "envPa");
            return (Criteria) this;
        }

        public Criteria andEnvRcIsNull() {
            addCriterion("env_rc is null");
            return (Criteria) this;
        }

        public Criteria andEnvRcIsNotNull() {
            addCriterion("env_rc is not null");
            return (Criteria) this;
        }

        public Criteria andEnvRcEqualTo(String value) {
            addCriterion("env_rc =", value, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvRcNotEqualTo(String value) {
            addCriterion("env_rc <>", value, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvRcGreaterThan(String value) {
            addCriterion("env_rc >", value, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvRcGreaterThanOrEqualTo(String value) {
            addCriterion("env_rc >=", value, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvRcLessThan(String value) {
            addCriterion("env_rc <", value, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvRcLessThanOrEqualTo(String value) {
            addCriterion("env_rc <=", value, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvRcLike(String value) {
            addCriterion("env_rc like", value, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvRcNotLike(String value) {
            addCriterion("env_rc not like", value, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvRcIn(List<String> values) {
            addCriterion("env_rc in", values, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvRcNotIn(List<String> values) {
            addCriterion("env_rc not in", values, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvRcBetween(String value1, String value2) {
            addCriterion("env_rc between", value1, value2, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvRcNotBetween(String value1, String value2) {
            addCriterion("env_rc not between", value1, value2, "envRc");
            return (Criteria) this;
        }

        public Criteria andEnvSrIsNull() {
            addCriterion("env_sr is null");
            return (Criteria) this;
        }

        public Criteria andEnvSrIsNotNull() {
            addCriterion("env_sr is not null");
            return (Criteria) this;
        }

        public Criteria andEnvSrEqualTo(String value) {
            addCriterion("env_sr =", value, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvSrNotEqualTo(String value) {
            addCriterion("env_sr <>", value, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvSrGreaterThan(String value) {
            addCriterion("env_sr >", value, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvSrGreaterThanOrEqualTo(String value) {
            addCriterion("env_sr >=", value, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvSrLessThan(String value) {
            addCriterion("env_sr <", value, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvSrLessThanOrEqualTo(String value) {
            addCriterion("env_sr <=", value, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvSrLike(String value) {
            addCriterion("env_sr like", value, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvSrNotLike(String value) {
            addCriterion("env_sr not like", value, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvSrIn(List<String> values) {
            addCriterion("env_sr in", values, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvSrNotIn(List<String> values) {
            addCriterion("env_sr not in", values, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvSrBetween(String value1, String value2) {
            addCriterion("env_sr between", value1, value2, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvSrNotBetween(String value1, String value2) {
            addCriterion("env_sr not between", value1, value2, "envSr");
            return (Criteria) this;
        }

        public Criteria andEnvUvIsNull() {
            addCriterion("env_uv is null");
            return (Criteria) this;
        }

        public Criteria andEnvUvIsNotNull() {
            addCriterion("env_uv is not null");
            return (Criteria) this;
        }

        public Criteria andEnvUvEqualTo(String value) {
            addCriterion("env_uv =", value, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvUvNotEqualTo(String value) {
            addCriterion("env_uv <>", value, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvUvGreaterThan(String value) {
            addCriterion("env_uv >", value, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvUvGreaterThanOrEqualTo(String value) {
            addCriterion("env_uv >=", value, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvUvLessThan(String value) {
            addCriterion("env_uv <", value, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvUvLessThanOrEqualTo(String value) {
            addCriterion("env_uv <=", value, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvUvLike(String value) {
            addCriterion("env_uv like", value, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvUvNotLike(String value) {
            addCriterion("env_uv not like", value, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvUvIn(List<String> values) {
            addCriterion("env_uv in", values, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvUvNotIn(List<String> values) {
            addCriterion("env_uv not in", values, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvUvBetween(String value1, String value2) {
            addCriterion("env_uv between", value1, value2, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvUvNotBetween(String value1, String value2) {
            addCriterion("env_uv not between", value1, value2, "envUv");
            return (Criteria) this;
        }

        public Criteria andEnvCoIsNull() {
            addCriterion("env_co is null");
            return (Criteria) this;
        }

        public Criteria andEnvCoIsNotNull() {
            addCriterion("env_co is not null");
            return (Criteria) this;
        }

        public Criteria andEnvCoEqualTo(String value) {
            addCriterion("env_co =", value, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvCoNotEqualTo(String value) {
            addCriterion("env_co <>", value, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvCoGreaterThan(String value) {
            addCriterion("env_co >", value, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvCoGreaterThanOrEqualTo(String value) {
            addCriterion("env_co >=", value, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvCoLessThan(String value) {
            addCriterion("env_co <", value, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvCoLessThanOrEqualTo(String value) {
            addCriterion("env_co <=", value, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvCoLike(String value) {
            addCriterion("env_co like", value, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvCoNotLike(String value) {
            addCriterion("env_co not like", value, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvCoIn(List<String> values) {
            addCriterion("env_co in", values, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvCoNotIn(List<String> values) {
            addCriterion("env_co not in", values, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvCoBetween(String value1, String value2) {
            addCriterion("env_co between", value1, value2, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvCoNotBetween(String value1, String value2) {
            addCriterion("env_co not between", value1, value2, "envCo");
            return (Criteria) this;
        }

        public Criteria andEnvSo2IsNull() {
            addCriterion("env_so2 is null");
            return (Criteria) this;
        }

        public Criteria andEnvSo2IsNotNull() {
            addCriterion("env_so2 is not null");
            return (Criteria) this;
        }

        public Criteria andEnvSo2EqualTo(String value) {
            addCriterion("env_so2 =", value, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvSo2NotEqualTo(String value) {
            addCriterion("env_so2 <>", value, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvSo2GreaterThan(String value) {
            addCriterion("env_so2 >", value, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvSo2GreaterThanOrEqualTo(String value) {
            addCriterion("env_so2 >=", value, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvSo2LessThan(String value) {
            addCriterion("env_so2 <", value, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvSo2LessThanOrEqualTo(String value) {
            addCriterion("env_so2 <=", value, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvSo2Like(String value) {
            addCriterion("env_so2 like", value, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvSo2NotLike(String value) {
            addCriterion("env_so2 not like", value, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvSo2In(List<String> values) {
            addCriterion("env_so2 in", values, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvSo2NotIn(List<String> values) {
            addCriterion("env_so2 not in", values, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvSo2Between(String value1, String value2) {
            addCriterion("env_so2 between", value1, value2, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvSo2NotBetween(String value1, String value2) {
            addCriterion("env_so2 not between", value1, value2, "envSo2");
            return (Criteria) this;
        }

        public Criteria andEnvH2sIsNull() {
            addCriterion("env_h2s is null");
            return (Criteria) this;
        }

        public Criteria andEnvH2sIsNotNull() {
            addCriterion("env_h2s is not null");
            return (Criteria) this;
        }

        public Criteria andEnvH2sEqualTo(String value) {
            addCriterion("env_h2s =", value, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvH2sNotEqualTo(String value) {
            addCriterion("env_h2s <>", value, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvH2sGreaterThan(String value) {
            addCriterion("env_h2s >", value, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvH2sGreaterThanOrEqualTo(String value) {
            addCriterion("env_h2s >=", value, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvH2sLessThan(String value) {
            addCriterion("env_h2s <", value, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvH2sLessThanOrEqualTo(String value) {
            addCriterion("env_h2s <=", value, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvH2sLike(String value) {
            addCriterion("env_h2s like", value, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvH2sNotLike(String value) {
            addCriterion("env_h2s not like", value, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvH2sIn(List<String> values) {
            addCriterion("env_h2s in", values, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvH2sNotIn(List<String> values) {
            addCriterion("env_h2s not in", values, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvH2sBetween(String value1, String value2) {
            addCriterion("env_h2s between", value1, value2, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvH2sNotBetween(String value1, String value2) {
            addCriterion("env_h2s not between", value1, value2, "envH2s");
            return (Criteria) this;
        }

        public Criteria andEnvNo2IsNull() {
            addCriterion("env_no2 is null");
            return (Criteria) this;
        }

        public Criteria andEnvNo2IsNotNull() {
            addCriterion("env_no2 is not null");
            return (Criteria) this;
        }

        public Criteria andEnvNo2EqualTo(String value) {
            addCriterion("env_no2 =", value, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvNo2NotEqualTo(String value) {
            addCriterion("env_no2 <>", value, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvNo2GreaterThan(String value) {
            addCriterion("env_no2 >", value, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvNo2GreaterThanOrEqualTo(String value) {
            addCriterion("env_no2 >=", value, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvNo2LessThan(String value) {
            addCriterion("env_no2 <", value, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvNo2LessThanOrEqualTo(String value) {
            addCriterion("env_no2 <=", value, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvNo2Like(String value) {
            addCriterion("env_no2 like", value, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvNo2NotLike(String value) {
            addCriterion("env_no2 not like", value, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvNo2In(List<String> values) {
            addCriterion("env_no2 in", values, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvNo2NotIn(List<String> values) {
            addCriterion("env_no2 not in", values, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvNo2Between(String value1, String value2) {
            addCriterion("env_no2 between", value1, value2, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvNo2NotBetween(String value1, String value2) {
            addCriterion("env_no2 not between", value1, value2, "envNo2");
            return (Criteria) this;
        }

        public Criteria andEnvO3IsNull() {
            addCriterion("env_o3 is null");
            return (Criteria) this;
        }

        public Criteria andEnvO3IsNotNull() {
            addCriterion("env_o3 is not null");
            return (Criteria) this;
        }

        public Criteria andEnvO3EqualTo(String value) {
            addCriterion("env_o3 =", value, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvO3NotEqualTo(String value) {
            addCriterion("env_o3 <>", value, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvO3GreaterThan(String value) {
            addCriterion("env_o3 >", value, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvO3GreaterThanOrEqualTo(String value) {
            addCriterion("env_o3 >=", value, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvO3LessThan(String value) {
            addCriterion("env_o3 <", value, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvO3LessThanOrEqualTo(String value) {
            addCriterion("env_o3 <=", value, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvO3Like(String value) {
            addCriterion("env_o3 like", value, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvO3NotLike(String value) {
            addCriterion("env_o3 not like", value, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvO3In(List<String> values) {
            addCriterion("env_o3 in", values, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvO3NotIn(List<String> values) {
            addCriterion("env_o3 not in", values, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvO3Between(String value1, String value2) {
            addCriterion("env_o3 between", value1, value2, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvO3NotBetween(String value1, String value2) {
            addCriterion("env_o3 not between", value1, value2, "envO3");
            return (Criteria) this;
        }

        public Criteria andEnvNoIsNull() {
            addCriterion("env_no is null");
            return (Criteria) this;
        }

        public Criteria andEnvNoIsNotNull() {
            addCriterion("env_no is not null");
            return (Criteria) this;
        }

        public Criteria andEnvNoEqualTo(String value) {
            addCriterion("env_no =", value, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNoNotEqualTo(String value) {
            addCriterion("env_no <>", value, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNoGreaterThan(String value) {
            addCriterion("env_no >", value, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNoGreaterThanOrEqualTo(String value) {
            addCriterion("env_no >=", value, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNoLessThan(String value) {
            addCriterion("env_no <", value, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNoLessThanOrEqualTo(String value) {
            addCriterion("env_no <=", value, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNoLike(String value) {
            addCriterion("env_no like", value, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNoNotLike(String value) {
            addCriterion("env_no not like", value, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNoIn(List<String> values) {
            addCriterion("env_no in", values, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNoNotIn(List<String> values) {
            addCriterion("env_no not in", values, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNoBetween(String value1, String value2) {
            addCriterion("env_no between", value1, value2, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNoNotBetween(String value1, String value2) {
            addCriterion("env_no not between", value1, value2, "envNo");
            return (Criteria) this;
        }

        public Criteria andEnvNxIsNull() {
            addCriterion("env_nx is null");
            return (Criteria) this;
        }

        public Criteria andEnvNxIsNotNull() {
            addCriterion("env_nx is not null");
            return (Criteria) this;
        }

        public Criteria andEnvNxEqualTo(String value) {
            addCriterion("env_nx =", value, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNxNotEqualTo(String value) {
            addCriterion("env_nx <>", value, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNxGreaterThan(String value) {
            addCriterion("env_nx >", value, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNxGreaterThanOrEqualTo(String value) {
            addCriterion("env_nx >=", value, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNxLessThan(String value) {
            addCriterion("env_nx <", value, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNxLessThanOrEqualTo(String value) {
            addCriterion("env_nx <=", value, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNxLike(String value) {
            addCriterion("env_nx like", value, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNxNotLike(String value) {
            addCriterion("env_nx not like", value, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNxIn(List<String> values) {
            addCriterion("env_nx in", values, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNxNotIn(List<String> values) {
            addCriterion("env_nx not in", values, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNxBetween(String value1, String value2) {
            addCriterion("env_nx between", value1, value2, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNxNotBetween(String value1, String value2) {
            addCriterion("env_nx not between", value1, value2, "envNx");
            return (Criteria) this;
        }

        public Criteria andEnvNiIsNull() {
            addCriterion("env_ni is null");
            return (Criteria) this;
        }

        public Criteria andEnvNiIsNotNull() {
            addCriterion("env_ni is not null");
            return (Criteria) this;
        }

        public Criteria andEnvNiEqualTo(String value) {
            addCriterion("env_ni =", value, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNiNotEqualTo(String value) {
            addCriterion("env_ni <>", value, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNiGreaterThan(String value) {
            addCriterion("env_ni >", value, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNiGreaterThanOrEqualTo(String value) {
            addCriterion("env_ni >=", value, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNiLessThan(String value) {
            addCriterion("env_ni <", value, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNiLessThanOrEqualTo(String value) {
            addCriterion("env_ni <=", value, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNiLike(String value) {
            addCriterion("env_ni like", value, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNiNotLike(String value) {
            addCriterion("env_ni not like", value, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNiIn(List<String> values) {
            addCriterion("env_ni in", values, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNiNotIn(List<String> values) {
            addCriterion("env_ni not in", values, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNiBetween(String value1, String value2) {
            addCriterion("env_ni between", value1, value2, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNiNotBetween(String value1, String value2) {
            addCriterion("env_ni not between", value1, value2, "envNi");
            return (Criteria) this;
        }

        public Criteria andEnvNsIsNull() {
            addCriterion("env_ns is null");
            return (Criteria) this;
        }

        public Criteria andEnvNsIsNotNull() {
            addCriterion("env_ns is not null");
            return (Criteria) this;
        }

        public Criteria andEnvNsEqualTo(String value) {
            addCriterion("env_ns =", value, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvNsNotEqualTo(String value) {
            addCriterion("env_ns <>", value, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvNsGreaterThan(String value) {
            addCriterion("env_ns >", value, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvNsGreaterThanOrEqualTo(String value) {
            addCriterion("env_ns >=", value, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvNsLessThan(String value) {
            addCriterion("env_ns <", value, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvNsLessThanOrEqualTo(String value) {
            addCriterion("env_ns <=", value, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvNsLike(String value) {
            addCriterion("env_ns like", value, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvNsNotLike(String value) {
            addCriterion("env_ns not like", value, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvNsIn(List<String> values) {
            addCriterion("env_ns in", values, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvNsNotIn(List<String> values) {
            addCriterion("env_ns not in", values, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvNsBetween(String value1, String value2) {
            addCriterion("env_ns between", value1, value2, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvNsNotBetween(String value1, String value2) {
            addCriterion("env_ns not between", value1, value2, "envNs");
            return (Criteria) this;
        }

        public Criteria andEnvPm25IsNull() {
            addCriterion("env_pm25 is null");
            return (Criteria) this;
        }

        public Criteria andEnvPm25IsNotNull() {
            addCriterion("env_pm25 is not null");
            return (Criteria) this;
        }

        public Criteria andEnvPm25EqualTo(String value) {
            addCriterion("env_pm25 =", value, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm25NotEqualTo(String value) {
            addCriterion("env_pm25 <>", value, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm25GreaterThan(String value) {
            addCriterion("env_pm25 >", value, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm25GreaterThanOrEqualTo(String value) {
            addCriterion("env_pm25 >=", value, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm25LessThan(String value) {
            addCriterion("env_pm25 <", value, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm25LessThanOrEqualTo(String value) {
            addCriterion("env_pm25 <=", value, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm25Like(String value) {
            addCriterion("env_pm25 like", value, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm25NotLike(String value) {
            addCriterion("env_pm25 not like", value, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm25In(List<String> values) {
            addCriterion("env_pm25 in", values, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm25NotIn(List<String> values) {
            addCriterion("env_pm25 not in", values, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm25Between(String value1, String value2) {
            addCriterion("env_pm25 between", value1, value2, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm25NotBetween(String value1, String value2) {
            addCriterion("env_pm25 not between", value1, value2, "envPm25");
            return (Criteria) this;
        }

        public Criteria andEnvPm10IsNull() {
            addCriterion("env_pm10 is null");
            return (Criteria) this;
        }

        public Criteria andEnvPm10IsNotNull() {
            addCriterion("env_pm10 is not null");
            return (Criteria) this;
        }

        public Criteria andEnvPm10EqualTo(String value) {
            addCriterion("env_pm10 =", value, "envPm10");
            return (Criteria) this;
        }

        public Criteria andEnvPm10NotEqualTo(String value) {
            addCriterion("env_pm10 <>", value, "envPm10");
            return (Criteria) this;
        }

        public Criteria andEnvPm10GreaterThan(String value) {
            addCriterion("env_pm10 >", value, "envPm10");
            return (Criteria) this;
        }

        public Criteria andEnvPm10GreaterThanOrEqualTo(String value) {
            addCriterion("env_pm10 >=", value, "envPm10");
            return (Criteria) this;
        }

        public Criteria andEnvPm10LessThan(String value) {
            addCriterion("env_pm10 <", value, "envPm10");
            return (Criteria) this;
        }

        public Criteria andEnvPm10LessThanOrEqualTo(String value) {
            addCriterion("env_pm10 <=", value, "envPm10");
            return (Criteria) this;
        }

        public Criteria andEnvPm10Like(String value) {
            addCriterion("env_pm10 like", value, "envPm10");
            return (Criteria) this;
        }

        public Criteria andEnvPm10NotLike(String value) {
            addCriterion("env_pm10 not like", value, "envPm10");
            return (Criteria) this;
        }

        public Criteria andEnvPm10In(List<String> values) {
            addCriterion("env_pm10 in", values, "envPm10");
            return (Criteria) this;
        }

        public Criteria andEnvPm10NotIn(List<String> values) {
            addCriterion("env_pm10 not in", values, "envPm10");
            return (Criteria) this;
        }

        public Criteria andEnvPm10Between(String value1, String value2) {
            addCriterion("env_pm10 between", value1, value2, "envPm10");
            return (Criteria) this;
        }

        public Criteria andEnvPm10NotBetween(String value1, String value2) {
            addCriterion("env_pm10 not between", value1, value2, "envPm10");
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