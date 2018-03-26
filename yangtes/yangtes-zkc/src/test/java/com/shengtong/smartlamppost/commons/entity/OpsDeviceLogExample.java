package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpsDeviceLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OpsDeviceLogExample() {
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

        public Criteria andDeviceNameIsNull() {
            addCriterion("device_name is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIsNotNull() {
            addCriterion("device_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNameEqualTo(String value) {
            addCriterion("device_name =", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotEqualTo(String value) {
            addCriterion("device_name <>", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThan(String value) {
            addCriterion("device_name >", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameGreaterThanOrEqualTo(String value) {
            addCriterion("device_name >=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThan(String value) {
            addCriterion("device_name <", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLessThanOrEqualTo(String value) {
            addCriterion("device_name <=", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameLike(String value) {
            addCriterion("device_name like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotLike(String value) {
            addCriterion("device_name not like", value, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameIn(List<String> values) {
            addCriterion("device_name in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotIn(List<String> values) {
            addCriterion("device_name not in", values, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameBetween(String value1, String value2) {
            addCriterion("device_name between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andDeviceNameNotBetween(String value1, String value2) {
            addCriterion("device_name not between", value1, value2, "deviceName");
            return (Criteria) this;
        }

        public Criteria andOpsTimeIsNull() {
            addCriterion("ops_time is null");
            return (Criteria) this;
        }

        public Criteria andOpsTimeIsNotNull() {
            addCriterion("ops_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpsTimeEqualTo(Date value) {
            addCriterion("ops_time =", value, "opsTime");
            return (Criteria) this;
        }

        public Criteria andOpsTimeNotEqualTo(Date value) {
            addCriterion("ops_time <>", value, "opsTime");
            return (Criteria) this;
        }

        public Criteria andOpsTimeGreaterThan(Date value) {
            addCriterion("ops_time >", value, "opsTime");
            return (Criteria) this;
        }

        public Criteria andOpsTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ops_time >=", value, "opsTime");
            return (Criteria) this;
        }

        public Criteria andOpsTimeLessThan(Date value) {
            addCriterion("ops_time <", value, "opsTime");
            return (Criteria) this;
        }

        public Criteria andOpsTimeLessThanOrEqualTo(Date value) {
            addCriterion("ops_time <=", value, "opsTime");
            return (Criteria) this;
        }

        public Criteria andOpsTimeIn(List<Date> values) {
            addCriterion("ops_time in", values, "opsTime");
            return (Criteria) this;
        }

        public Criteria andOpsTimeNotIn(List<Date> values) {
            addCriterion("ops_time not in", values, "opsTime");
            return (Criteria) this;
        }

        public Criteria andOpsTimeBetween(Date value1, Date value2) {
            addCriterion("ops_time between", value1, value2, "opsTime");
            return (Criteria) this;
        }

        public Criteria andOpsTimeNotBetween(Date value1, Date value2) {
            addCriterion("ops_time not between", value1, value2, "opsTime");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpIsNull() {
            addCriterion("ops_client_ip is null");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpIsNotNull() {
            addCriterion("ops_client_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpEqualTo(String value) {
            addCriterion("ops_client_ip =", value, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpNotEqualTo(String value) {
            addCriterion("ops_client_ip <>", value, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpGreaterThan(String value) {
            addCriterion("ops_client_ip >", value, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpGreaterThanOrEqualTo(String value) {
            addCriterion("ops_client_ip >=", value, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpLessThan(String value) {
            addCriterion("ops_client_ip <", value, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpLessThanOrEqualTo(String value) {
            addCriterion("ops_client_ip <=", value, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpLike(String value) {
            addCriterion("ops_client_ip like", value, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpNotLike(String value) {
            addCriterion("ops_client_ip not like", value, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpIn(List<String> values) {
            addCriterion("ops_client_ip in", values, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpNotIn(List<String> values) {
            addCriterion("ops_client_ip not in", values, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpBetween(String value1, String value2) {
            addCriterion("ops_client_ip between", value1, value2, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsClientIpNotBetween(String value1, String value2) {
            addCriterion("ops_client_ip not between", value1, value2, "opsClientIp");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdIsNull() {
            addCriterion("ops_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdIsNotNull() {
            addCriterion("ops_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdEqualTo(String value) {
            addCriterion("ops_user_id =", value, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdNotEqualTo(String value) {
            addCriterion("ops_user_id <>", value, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdGreaterThan(String value) {
            addCriterion("ops_user_id >", value, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("ops_user_id >=", value, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdLessThan(String value) {
            addCriterion("ops_user_id <", value, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdLessThanOrEqualTo(String value) {
            addCriterion("ops_user_id <=", value, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdLike(String value) {
            addCriterion("ops_user_id like", value, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdNotLike(String value) {
            addCriterion("ops_user_id not like", value, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdIn(List<String> values) {
            addCriterion("ops_user_id in", values, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdNotIn(List<String> values) {
            addCriterion("ops_user_id not in", values, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdBetween(String value1, String value2) {
            addCriterion("ops_user_id between", value1, value2, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserIdNotBetween(String value1, String value2) {
            addCriterion("ops_user_id not between", value1, value2, "opsUserId");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameIsNull() {
            addCriterion("ops_user_name is null");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameIsNotNull() {
            addCriterion("ops_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameEqualTo(String value) {
            addCriterion("ops_user_name =", value, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameNotEqualTo(String value) {
            addCriterion("ops_user_name <>", value, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameGreaterThan(String value) {
            addCriterion("ops_user_name >", value, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("ops_user_name >=", value, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameLessThan(String value) {
            addCriterion("ops_user_name <", value, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameLessThanOrEqualTo(String value) {
            addCriterion("ops_user_name <=", value, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameLike(String value) {
            addCriterion("ops_user_name like", value, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameNotLike(String value) {
            addCriterion("ops_user_name not like", value, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameIn(List<String> values) {
            addCriterion("ops_user_name in", values, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameNotIn(List<String> values) {
            addCriterion("ops_user_name not in", values, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameBetween(String value1, String value2) {
            addCriterion("ops_user_name between", value1, value2, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsUserNameNotBetween(String value1, String value2) {
            addCriterion("ops_user_name not between", value1, value2, "opsUserName");
            return (Criteria) this;
        }

        public Criteria andOpsContentIsNull() {
            addCriterion("ops_content is null");
            return (Criteria) this;
        }

        public Criteria andOpsContentIsNotNull() {
            addCriterion("ops_content is not null");
            return (Criteria) this;
        }

        public Criteria andOpsContentEqualTo(String value) {
            addCriterion("ops_content =", value, "opsContent");
            return (Criteria) this;
        }

        public Criteria andOpsContentNotEqualTo(String value) {
            addCriterion("ops_content <>", value, "opsContent");
            return (Criteria) this;
        }

        public Criteria andOpsContentGreaterThan(String value) {
            addCriterion("ops_content >", value, "opsContent");
            return (Criteria) this;
        }

        public Criteria andOpsContentGreaterThanOrEqualTo(String value) {
            addCriterion("ops_content >=", value, "opsContent");
            return (Criteria) this;
        }

        public Criteria andOpsContentLessThan(String value) {
            addCriterion("ops_content <", value, "opsContent");
            return (Criteria) this;
        }

        public Criteria andOpsContentLessThanOrEqualTo(String value) {
            addCriterion("ops_content <=", value, "opsContent");
            return (Criteria) this;
        }

        public Criteria andOpsContentLike(String value) {
            addCriterion("ops_content like", value, "opsContent");
            return (Criteria) this;
        }

        public Criteria andOpsContentNotLike(String value) {
            addCriterion("ops_content not like", value, "opsContent");
            return (Criteria) this;
        }

        public Criteria andOpsContentIn(List<String> values) {
            addCriterion("ops_content in", values, "opsContent");
            return (Criteria) this;
        }

        public Criteria andOpsContentNotIn(List<String> values) {
            addCriterion("ops_content not in", values, "opsContent");
            return (Criteria) this;
        }

        public Criteria andOpsContentBetween(String value1, String value2) {
            addCriterion("ops_content between", value1, value2, "opsContent");
            return (Criteria) this;
        }

        public Criteria andOpsContentNotBetween(String value1, String value2) {
            addCriterion("ops_content not between", value1, value2, "opsContent");
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