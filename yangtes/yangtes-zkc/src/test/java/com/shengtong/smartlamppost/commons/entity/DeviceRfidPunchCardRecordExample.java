package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceRfidPunchCardRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceRfidPunchCardRecordExample() {
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

        public Criteria andRfidReaderDeviceIdIsNull() {
            addCriterion("rfid_reader_device_id is null");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdIsNotNull() {
            addCriterion("rfid_reader_device_id is not null");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdEqualTo(String value) {
            addCriterion("rfid_reader_device_id =", value, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdNotEqualTo(String value) {
            addCriterion("rfid_reader_device_id <>", value, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdGreaterThan(String value) {
            addCriterion("rfid_reader_device_id >", value, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("rfid_reader_device_id >=", value, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdLessThan(String value) {
            addCriterion("rfid_reader_device_id <", value, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("rfid_reader_device_id <=", value, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdLike(String value) {
            addCriterion("rfid_reader_device_id like", value, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdNotLike(String value) {
            addCriterion("rfid_reader_device_id not like", value, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdIn(List<String> values) {
            addCriterion("rfid_reader_device_id in", values, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdNotIn(List<String> values) {
            addCriterion("rfid_reader_device_id not in", values, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdBetween(String value1, String value2) {
            addCriterion("rfid_reader_device_id between", value1, value2, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceIdNotBetween(String value1, String value2) {
            addCriterion("rfid_reader_device_id not between", value1, value2, "rfidReaderDeviceId");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeIsNull() {
            addCriterion("rfid_reader_device_code is null");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeIsNotNull() {
            addCriterion("rfid_reader_device_code is not null");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeEqualTo(String value) {
            addCriterion("rfid_reader_device_code =", value, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeNotEqualTo(String value) {
            addCriterion("rfid_reader_device_code <>", value, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeGreaterThan(String value) {
            addCriterion("rfid_reader_device_code >", value, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("rfid_reader_device_code >=", value, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeLessThan(String value) {
            addCriterion("rfid_reader_device_code <", value, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeLessThanOrEqualTo(String value) {
            addCriterion("rfid_reader_device_code <=", value, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeLike(String value) {
            addCriterion("rfid_reader_device_code like", value, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeNotLike(String value) {
            addCriterion("rfid_reader_device_code not like", value, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeIn(List<String> values) {
            addCriterion("rfid_reader_device_code in", values, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeNotIn(List<String> values) {
            addCriterion("rfid_reader_device_code not in", values, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeBetween(String value1, String value2) {
            addCriterion("rfid_reader_device_code between", value1, value2, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidReaderDeviceCodeNotBetween(String value1, String value2) {
            addCriterion("rfid_reader_device_code not between", value1, value2, "rfidReaderDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidIdIsNull() {
            addCriterion("rfid_id is null");
            return (Criteria) this;
        }

        public Criteria andRfidIdIsNotNull() {
            addCriterion("rfid_id is not null");
            return (Criteria) this;
        }

        public Criteria andRfidIdEqualTo(String value) {
            addCriterion("rfid_id =", value, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidIdNotEqualTo(String value) {
            addCriterion("rfid_id <>", value, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidIdGreaterThan(String value) {
            addCriterion("rfid_id >", value, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidIdGreaterThanOrEqualTo(String value) {
            addCriterion("rfid_id >=", value, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidIdLessThan(String value) {
            addCriterion("rfid_id <", value, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidIdLessThanOrEqualTo(String value) {
            addCriterion("rfid_id <=", value, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidIdLike(String value) {
            addCriterion("rfid_id like", value, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidIdNotLike(String value) {
            addCriterion("rfid_id not like", value, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidIdIn(List<String> values) {
            addCriterion("rfid_id in", values, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidIdNotIn(List<String> values) {
            addCriterion("rfid_id not in", values, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidIdBetween(String value1, String value2) {
            addCriterion("rfid_id between", value1, value2, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidIdNotBetween(String value1, String value2) {
            addCriterion("rfid_id not between", value1, value2, "rfidId");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeIsNull() {
            addCriterion("rfid_device_code is null");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeIsNotNull() {
            addCriterion("rfid_device_code is not null");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeEqualTo(String value) {
            addCriterion("rfid_device_code =", value, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeNotEqualTo(String value) {
            addCriterion("rfid_device_code <>", value, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeGreaterThan(String value) {
            addCriterion("rfid_device_code >", value, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("rfid_device_code >=", value, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeLessThan(String value) {
            addCriterion("rfid_device_code <", value, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeLessThanOrEqualTo(String value) {
            addCriterion("rfid_device_code <=", value, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeLike(String value) {
            addCriterion("rfid_device_code like", value, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeNotLike(String value) {
            addCriterion("rfid_device_code not like", value, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeIn(List<String> values) {
            addCriterion("rfid_device_code in", values, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeNotIn(List<String> values) {
            addCriterion("rfid_device_code not in", values, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeBetween(String value1, String value2) {
            addCriterion("rfid_device_code between", value1, value2, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andRfidDeviceCodeNotBetween(String value1, String value2) {
            addCriterion("rfid_device_code not between", value1, value2, "rfidDeviceCode");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationIsNull() {
            addCriterion("punch_card_location is null");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationIsNotNull() {
            addCriterion("punch_card_location is not null");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationEqualTo(String value) {
            addCriterion("punch_card_location =", value, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationNotEqualTo(String value) {
            addCriterion("punch_card_location <>", value, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationGreaterThan(String value) {
            addCriterion("punch_card_location >", value, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationGreaterThanOrEqualTo(String value) {
            addCriterion("punch_card_location >=", value, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationLessThan(String value) {
            addCriterion("punch_card_location <", value, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationLessThanOrEqualTo(String value) {
            addCriterion("punch_card_location <=", value, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationLike(String value) {
            addCriterion("punch_card_location like", value, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationNotLike(String value) {
            addCriterion("punch_card_location not like", value, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationIn(List<String> values) {
            addCriterion("punch_card_location in", values, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationNotIn(List<String> values) {
            addCriterion("punch_card_location not in", values, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationBetween(String value1, String value2) {
            addCriterion("punch_card_location between", value1, value2, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardLocationNotBetween(String value1, String value2) {
            addCriterion("punch_card_location not between", value1, value2, "punchCardLocation");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateIsNull() {
            addCriterion("punch_card_date is null");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateIsNotNull() {
            addCriterion("punch_card_date is not null");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateEqualTo(Date value) {
            addCriterion("punch_card_date =", value, "punchCardDate");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateNotEqualTo(Date value) {
            addCriterion("punch_card_date <>", value, "punchCardDate");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateGreaterThan(Date value) {
            addCriterion("punch_card_date >", value, "punchCardDate");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateGreaterThanOrEqualTo(Date value) {
            addCriterion("punch_card_date >=", value, "punchCardDate");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateLessThan(Date value) {
            addCriterion("punch_card_date <", value, "punchCardDate");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateLessThanOrEqualTo(Date value) {
            addCriterion("punch_card_date <=", value, "punchCardDate");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateIn(List<Date> values) {
            addCriterion("punch_card_date in", values, "punchCardDate");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateNotIn(List<Date> values) {
            addCriterion("punch_card_date not in", values, "punchCardDate");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateBetween(Date value1, Date value2) {
            addCriterion("punch_card_date between", value1, value2, "punchCardDate");
            return (Criteria) this;
        }

        public Criteria andPunchCardDateNotBetween(Date value1, Date value2) {
            addCriterion("punch_card_date not between", value1, value2, "punchCardDate");
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