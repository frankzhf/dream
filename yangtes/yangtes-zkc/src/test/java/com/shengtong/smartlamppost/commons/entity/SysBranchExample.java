package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysBranchExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysBranchExample() {
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

        public Criteria andBranchCodeIsNull() {
            addCriterion("branch_code is null");
            return (Criteria) this;
        }

        public Criteria andBranchCodeIsNotNull() {
            addCriterion("branch_code is not null");
            return (Criteria) this;
        }

        public Criteria andBranchCodeEqualTo(String value) {
            addCriterion("branch_code =", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeNotEqualTo(String value) {
            addCriterion("branch_code <>", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeGreaterThan(String value) {
            addCriterion("branch_code >", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeGreaterThanOrEqualTo(String value) {
            addCriterion("branch_code >=", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeLessThan(String value) {
            addCriterion("branch_code <", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeLessThanOrEqualTo(String value) {
            addCriterion("branch_code <=", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeLike(String value) {
            addCriterion("branch_code like", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeNotLike(String value) {
            addCriterion("branch_code not like", value, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeIn(List<String> values) {
            addCriterion("branch_code in", values, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeNotIn(List<String> values) {
            addCriterion("branch_code not in", values, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeBetween(String value1, String value2) {
            addCriterion("branch_code between", value1, value2, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchCodeNotBetween(String value1, String value2) {
            addCriterion("branch_code not between", value1, value2, "branchCode");
            return (Criteria) this;
        }

        public Criteria andBranchNameIsNull() {
            addCriterion("branch_name is null");
            return (Criteria) this;
        }

        public Criteria andBranchNameIsNotNull() {
            addCriterion("branch_name is not null");
            return (Criteria) this;
        }

        public Criteria andBranchNameEqualTo(String value) {
            addCriterion("branch_name =", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotEqualTo(String value) {
            addCriterion("branch_name <>", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameGreaterThan(String value) {
            addCriterion("branch_name >", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameGreaterThanOrEqualTo(String value) {
            addCriterion("branch_name >=", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLessThan(String value) {
            addCriterion("branch_name <", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLessThanOrEqualTo(String value) {
            addCriterion("branch_name <=", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameLike(String value) {
            addCriterion("branch_name like", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotLike(String value) {
            addCriterion("branch_name not like", value, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameIn(List<String> values) {
            addCriterion("branch_name in", values, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotIn(List<String> values) {
            addCriterion("branch_name not in", values, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameBetween(String value1, String value2) {
            addCriterion("branch_name between", value1, value2, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchNameNotBetween(String value1, String value2) {
            addCriterion("branch_name not between", value1, value2, "branchName");
            return (Criteria) this;
        }

        public Criteria andBranchAddrIsNull() {
            addCriterion("branch_addr is null");
            return (Criteria) this;
        }

        public Criteria andBranchAddrIsNotNull() {
            addCriterion("branch_addr is not null");
            return (Criteria) this;
        }

        public Criteria andBranchAddrEqualTo(String value) {
            addCriterion("branch_addr =", value, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchAddrNotEqualTo(String value) {
            addCriterion("branch_addr <>", value, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchAddrGreaterThan(String value) {
            addCriterion("branch_addr >", value, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchAddrGreaterThanOrEqualTo(String value) {
            addCriterion("branch_addr >=", value, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchAddrLessThan(String value) {
            addCriterion("branch_addr <", value, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchAddrLessThanOrEqualTo(String value) {
            addCriterion("branch_addr <=", value, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchAddrLike(String value) {
            addCriterion("branch_addr like", value, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchAddrNotLike(String value) {
            addCriterion("branch_addr not like", value, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchAddrIn(List<String> values) {
            addCriterion("branch_addr in", values, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchAddrNotIn(List<String> values) {
            addCriterion("branch_addr not in", values, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchAddrBetween(String value1, String value2) {
            addCriterion("branch_addr between", value1, value2, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchAddrNotBetween(String value1, String value2) {
            addCriterion("branch_addr not between", value1, value2, "branchAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrIsNull() {
            addCriterion("branch_interface_addr is null");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrIsNotNull() {
            addCriterion("branch_interface_addr is not null");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrEqualTo(String value) {
            addCriterion("branch_interface_addr =", value, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrNotEqualTo(String value) {
            addCriterion("branch_interface_addr <>", value, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrGreaterThan(String value) {
            addCriterion("branch_interface_addr >", value, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrGreaterThanOrEqualTo(String value) {
            addCriterion("branch_interface_addr >=", value, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrLessThan(String value) {
            addCriterion("branch_interface_addr <", value, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrLessThanOrEqualTo(String value) {
            addCriterion("branch_interface_addr <=", value, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrLike(String value) {
            addCriterion("branch_interface_addr like", value, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrNotLike(String value) {
            addCriterion("branch_interface_addr not like", value, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrIn(List<String> values) {
            addCriterion("branch_interface_addr in", values, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrNotIn(List<String> values) {
            addCriterion("branch_interface_addr not in", values, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrBetween(String value1, String value2) {
            addCriterion("branch_interface_addr between", value1, value2, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceAddrNotBetween(String value1, String value2) {
            addCriterion("branch_interface_addr not between", value1, value2, "branchInterfaceAddr");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyIsNull() {
            addCriterion("branch_interface_key is null");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyIsNotNull() {
            addCriterion("branch_interface_key is not null");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyEqualTo(String value) {
            addCriterion("branch_interface_key =", value, "branchInterfaceKey");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyNotEqualTo(String value) {
            addCriterion("branch_interface_key <>", value, "branchInterfaceKey");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyGreaterThan(String value) {
            addCriterion("branch_interface_key >", value, "branchInterfaceKey");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyGreaterThanOrEqualTo(String value) {
            addCriterion("branch_interface_key >=", value, "branchInterfaceKey");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyLessThan(String value) {
            addCriterion("branch_interface_key <", value, "branchInterfaceKey");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyLessThanOrEqualTo(String value) {
            addCriterion("branch_interface_key <=", value, "branchInterfaceKey");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyLike(String value) {
            addCriterion("branch_interface_key like", value, "branchInterfaceKey");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyNotLike(String value) {
            addCriterion("branch_interface_key not like", value, "branchInterfaceKey");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyIn(List<String> values) {
            addCriterion("branch_interface_key in", values, "branchInterfaceKey");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyNotIn(List<String> values) {
            addCriterion("branch_interface_key not in", values, "branchInterfaceKey");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyBetween(String value1, String value2) {
            addCriterion("branch_interface_key between", value1, value2, "branchInterfaceKey");
            return (Criteria) this;
        }

        public Criteria andBranchInterfaceKeyNotBetween(String value1, String value2) {
            addCriterion("branch_interface_key not between", value1, value2, "branchInterfaceKey");
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

        public Criteria andLampServiceUrlIsNull() {
            addCriterion("lamp_service_url is null");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlIsNotNull() {
            addCriterion("lamp_service_url is not null");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlEqualTo(String value) {
            addCriterion("lamp_service_url =", value, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlNotEqualTo(String value) {
            addCriterion("lamp_service_url <>", value, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlGreaterThan(String value) {
            addCriterion("lamp_service_url >", value, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("lamp_service_url >=", value, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlLessThan(String value) {
            addCriterion("lamp_service_url <", value, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlLessThanOrEqualTo(String value) {
            addCriterion("lamp_service_url <=", value, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlLike(String value) {
            addCriterion("lamp_service_url like", value, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlNotLike(String value) {
            addCriterion("lamp_service_url not like", value, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlIn(List<String> values) {
            addCriterion("lamp_service_url in", values, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlNotIn(List<String> values) {
            addCriterion("lamp_service_url not in", values, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlBetween(String value1, String value2) {
            addCriterion("lamp_service_url between", value1, value2, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andLampServiceUrlNotBetween(String value1, String value2) {
            addCriterion("lamp_service_url not between", value1, value2, "lampServiceUrl");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andBranchSortIsNull() {
            addCriterion("branch_sort is null");
            return (Criteria) this;
        }

        public Criteria andBranchSortIsNotNull() {
            addCriterion("branch_sort is not null");
            return (Criteria) this;
        }

        public Criteria andBranchSortEqualTo(Integer value) {
            addCriterion("branch_sort =", value, "branchSort");
            return (Criteria) this;
        }

        public Criteria andBranchSortNotEqualTo(Integer value) {
            addCriterion("branch_sort <>", value, "branchSort");
            return (Criteria) this;
        }

        public Criteria andBranchSortGreaterThan(Integer value) {
            addCriterion("branch_sort >", value, "branchSort");
            return (Criteria) this;
        }

        public Criteria andBranchSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("branch_sort >=", value, "branchSort");
            return (Criteria) this;
        }

        public Criteria andBranchSortLessThan(Integer value) {
            addCriterion("branch_sort <", value, "branchSort");
            return (Criteria) this;
        }

        public Criteria andBranchSortLessThanOrEqualTo(Integer value) {
            addCriterion("branch_sort <=", value, "branchSort");
            return (Criteria) this;
        }

        public Criteria andBranchSortIn(List<Integer> values) {
            addCriterion("branch_sort in", values, "branchSort");
            return (Criteria) this;
        }

        public Criteria andBranchSortNotIn(List<Integer> values) {
            addCriterion("branch_sort not in", values, "branchSort");
            return (Criteria) this;
        }

        public Criteria andBranchSortBetween(Integer value1, Integer value2) {
            addCriterion("branch_sort between", value1, value2, "branchSort");
            return (Criteria) this;
        }

        public Criteria andBranchSortNotBetween(Integer value1, Integer value2) {
            addCriterion("branch_sort not between", value1, value2, "branchSort");
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