package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.List;

public class AssetEquipmentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetEquipmentInfoExample() {
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

        public Criteria andEquipmentIdIsNull() {
            addCriterion("Equipment_ID is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIsNotNull() {
            addCriterion("Equipment_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdEqualTo(Integer value) {
            addCriterion("Equipment_ID =", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotEqualTo(Integer value) {
            addCriterion("Equipment_ID <>", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThan(Integer value) {
            addCriterion("Equipment_ID >", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Equipment_ID >=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThan(Integer value) {
            addCriterion("Equipment_ID <", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("Equipment_ID <=", value, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdIn(List<Integer> values) {
            addCriterion("Equipment_ID in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotIn(List<Integer> values) {
            addCriterion("Equipment_ID not in", values, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdBetween(Integer value1, Integer value2) {
            addCriterion("Equipment_ID between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Equipment_ID not between", value1, value2, "equipmentId");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIsNull() {
            addCriterion("Equipment_Code is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIsNotNull() {
            addCriterion("Equipment_Code is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeEqualTo(String value) {
            addCriterion("Equipment_Code =", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotEqualTo(String value) {
            addCriterion("Equipment_Code <>", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeGreaterThan(String value) {
            addCriterion("Equipment_Code >", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Equipment_Code >=", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLessThan(String value) {
            addCriterion("Equipment_Code <", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLessThanOrEqualTo(String value) {
            addCriterion("Equipment_Code <=", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeLike(String value) {
            addCriterion("Equipment_Code like", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotLike(String value) {
            addCriterion("Equipment_Code not like", value, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeIn(List<String> values) {
            addCriterion("Equipment_Code in", values, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotIn(List<String> values) {
            addCriterion("Equipment_Code not in", values, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeBetween(String value1, String value2) {
            addCriterion("Equipment_Code between", value1, value2, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentCodeNotBetween(String value1, String value2) {
            addCriterion("Equipment_Code not between", value1, value2, "equipmentCode");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNull() {
            addCriterion("Equipment_Name is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNotNull() {
            addCriterion("Equipment_Name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameEqualTo(String value) {
            addCriterion("Equipment_Name =", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotEqualTo(String value) {
            addCriterion("Equipment_Name <>", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThan(String value) {
            addCriterion("Equipment_Name >", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("Equipment_Name >=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThan(String value) {
            addCriterion("Equipment_Name <", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThanOrEqualTo(String value) {
            addCriterion("Equipment_Name <=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLike(String value) {
            addCriterion("Equipment_Name like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotLike(String value) {
            addCriterion("Equipment_Name not like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIn(List<String> values) {
            addCriterion("Equipment_Name in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotIn(List<String> values) {
            addCriterion("Equipment_Name not in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameBetween(String value1, String value2) {
            addCriterion("Equipment_Name between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotBetween(String value1, String value2) {
            addCriterion("Equipment_Name not between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andLampIdIsNull() {
            addCriterion("Lamp_ID is null");
            return (Criteria) this;
        }

        public Criteria andLampIdIsNotNull() {
            addCriterion("Lamp_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLampIdEqualTo(Integer value) {
            addCriterion("Lamp_ID =", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdNotEqualTo(Integer value) {
            addCriterion("Lamp_ID <>", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdGreaterThan(Integer value) {
            addCriterion("Lamp_ID >", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Lamp_ID >=", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdLessThan(Integer value) {
            addCriterion("Lamp_ID <", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdLessThanOrEqualTo(Integer value) {
            addCriterion("Lamp_ID <=", value, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdIn(List<Integer> values) {
            addCriterion("Lamp_ID in", values, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdNotIn(List<Integer> values) {
            addCriterion("Lamp_ID not in", values, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdBetween(Integer value1, Integer value2) {
            addCriterion("Lamp_ID between", value1, value2, "lampId");
            return (Criteria) this;
        }

        public Criteria andLampIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Lamp_ID not between", value1, value2, "lampId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdIsNull() {
            addCriterion("EquClass_ID is null");
            return (Criteria) this;
        }

        public Criteria andEquclassIdIsNotNull() {
            addCriterion("EquClass_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEquclassIdEqualTo(Integer value) {
            addCriterion("EquClass_ID =", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdNotEqualTo(Integer value) {
            addCriterion("EquClass_ID <>", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdGreaterThan(Integer value) {
            addCriterion("EquClass_ID >", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("EquClass_ID >=", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdLessThan(Integer value) {
            addCriterion("EquClass_ID <", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdLessThanOrEqualTo(Integer value) {
            addCriterion("EquClass_ID <=", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdIn(List<Integer> values) {
            addCriterion("EquClass_ID in", values, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdNotIn(List<Integer> values) {
            addCriterion("EquClass_ID not in", values, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdBetween(Integer value1, Integer value2) {
            addCriterion("EquClass_ID between", value1, value2, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("EquClass_ID not between", value1, value2, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdIsNull() {
            addCriterion("EquSection_ID is null");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdIsNotNull() {
            addCriterion("EquSection_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdEqualTo(Integer value) {
            addCriterion("EquSection_ID =", value, "equsectionId");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdNotEqualTo(Integer value) {
            addCriterion("EquSection_ID <>", value, "equsectionId");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdGreaterThan(Integer value) {
            addCriterion("EquSection_ID >", value, "equsectionId");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("EquSection_ID >=", value, "equsectionId");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdLessThan(Integer value) {
            addCriterion("EquSection_ID <", value, "equsectionId");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdLessThanOrEqualTo(Integer value) {
            addCriterion("EquSection_ID <=", value, "equsectionId");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdIn(List<Integer> values) {
            addCriterion("EquSection_ID in", values, "equsectionId");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdNotIn(List<Integer> values) {
            addCriterion("EquSection_ID not in", values, "equsectionId");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdBetween(Integer value1, Integer value2) {
            addCriterion("EquSection_ID between", value1, value2, "equsectionId");
            return (Criteria) this;
        }

        public Criteria andEqusectionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("EquSection_ID not between", value1, value2, "equsectionId");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdIsNull() {
            addCriterion("EquModel_ID is null");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdIsNotNull() {
            addCriterion("EquModel_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdEqualTo(Integer value) {
            addCriterion("EquModel_ID =", value, "equmodelId");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdNotEqualTo(Integer value) {
            addCriterion("EquModel_ID <>", value, "equmodelId");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdGreaterThan(Integer value) {
            addCriterion("EquModel_ID >", value, "equmodelId");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("EquModel_ID >=", value, "equmodelId");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdLessThan(Integer value) {
            addCriterion("EquModel_ID <", value, "equmodelId");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdLessThanOrEqualTo(Integer value) {
            addCriterion("EquModel_ID <=", value, "equmodelId");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdIn(List<Integer> values) {
            addCriterion("EquModel_ID in", values, "equmodelId");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdNotIn(List<Integer> values) {
            addCriterion("EquModel_ID not in", values, "equmodelId");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdBetween(Integer value1, Integer value2) {
            addCriterion("EquModel_ID between", value1, value2, "equmodelId");
            return (Criteria) this;
        }

        public Criteria andEqumodelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("EquModel_ID not between", value1, value2, "equmodelId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("Group_ID is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("Group_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("Group_ID =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("Group_ID <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("Group_ID >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Group_ID >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("Group_ID <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("Group_ID <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("Group_ID in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("Group_ID not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("Group_ID between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Group_ID not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpIsNull() {
            addCriterion("Equipment_IP is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpIsNotNull() {
            addCriterion("Equipment_IP is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpEqualTo(String value) {
            addCriterion("Equipment_IP =", value, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpNotEqualTo(String value) {
            addCriterion("Equipment_IP <>", value, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpGreaterThan(String value) {
            addCriterion("Equipment_IP >", value, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpGreaterThanOrEqualTo(String value) {
            addCriterion("Equipment_IP >=", value, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpLessThan(String value) {
            addCriterion("Equipment_IP <", value, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpLessThanOrEqualTo(String value) {
            addCriterion("Equipment_IP <=", value, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpLike(String value) {
            addCriterion("Equipment_IP like", value, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpNotLike(String value) {
            addCriterion("Equipment_IP not like", value, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpIn(List<String> values) {
            addCriterion("Equipment_IP in", values, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpNotIn(List<String> values) {
            addCriterion("Equipment_IP not in", values, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpBetween(String value1, String value2) {
            addCriterion("Equipment_IP between", value1, value2, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentIpNotBetween(String value1, String value2) {
            addCriterion("Equipment_IP not between", value1, value2, "equipmentIp");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortIsNull() {
            addCriterion("Equipment_Port is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortIsNotNull() {
            addCriterion("Equipment_Port is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortEqualTo(String value) {
            addCriterion("Equipment_Port =", value, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortNotEqualTo(String value) {
            addCriterion("Equipment_Port <>", value, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortGreaterThan(String value) {
            addCriterion("Equipment_Port >", value, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortGreaterThanOrEqualTo(String value) {
            addCriterion("Equipment_Port >=", value, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortLessThan(String value) {
            addCriterion("Equipment_Port <", value, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortLessThanOrEqualTo(String value) {
            addCriterion("Equipment_Port <=", value, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortLike(String value) {
            addCriterion("Equipment_Port like", value, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortNotLike(String value) {
            addCriterion("Equipment_Port not like", value, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortIn(List<String> values) {
            addCriterion("Equipment_Port in", values, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortNotIn(List<String> values) {
            addCriterion("Equipment_Port not in", values, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortBetween(String value1, String value2) {
            addCriterion("Equipment_Port between", value1, value2, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andEquipmentPortNotBetween(String value1, String value2) {
            addCriterion("Equipment_Port not between", value1, value2, "equipmentPort");
            return (Criteria) this;
        }

        public Criteria andMacAddrIsNull() {
            addCriterion("MAC_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andMacAddrIsNotNull() {
            addCriterion("MAC_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andMacAddrEqualTo(String value) {
            addCriterion("MAC_ADDR =", value, "macAddr");
            return (Criteria) this;
        }

        public Criteria andMacAddrNotEqualTo(String value) {
            addCriterion("MAC_ADDR <>", value, "macAddr");
            return (Criteria) this;
        }

        public Criteria andMacAddrGreaterThan(String value) {
            addCriterion("MAC_ADDR >", value, "macAddr");
            return (Criteria) this;
        }

        public Criteria andMacAddrGreaterThanOrEqualTo(String value) {
            addCriterion("MAC_ADDR >=", value, "macAddr");
            return (Criteria) this;
        }

        public Criteria andMacAddrLessThan(String value) {
            addCriterion("MAC_ADDR <", value, "macAddr");
            return (Criteria) this;
        }

        public Criteria andMacAddrLessThanOrEqualTo(String value) {
            addCriterion("MAC_ADDR <=", value, "macAddr");
            return (Criteria) this;
        }

        public Criteria andMacAddrLike(String value) {
            addCriterion("MAC_ADDR like", value, "macAddr");
            return (Criteria) this;
        }

        public Criteria andMacAddrNotLike(String value) {
            addCriterion("MAC_ADDR not like", value, "macAddr");
            return (Criteria) this;
        }

        public Criteria andMacAddrIn(List<String> values) {
            addCriterion("MAC_ADDR in", values, "macAddr");
            return (Criteria) this;
        }

        public Criteria andMacAddrNotIn(List<String> values) {
            addCriterion("MAC_ADDR not in", values, "macAddr");
            return (Criteria) this;
        }

        public Criteria andMacAddrBetween(String value1, String value2) {
            addCriterion("MAC_ADDR between", value1, value2, "macAddr");
            return (Criteria) this;
        }

        public Criteria andMacAddrNotBetween(String value1, String value2) {
            addCriterion("MAC_ADDR not between", value1, value2, "macAddr");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("SN is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("SN is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("SN =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("SN <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("SN >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("SN >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("SN <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("SN <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("SN like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("SN not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("SN in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("SN not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("SN between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("SN not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andFactoryIdIsNull() {
            addCriterion("Factory_ID is null");
            return (Criteria) this;
        }

        public Criteria andFactoryIdIsNotNull() {
            addCriterion("Factory_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryIdEqualTo(Integer value) {
            addCriterion("Factory_ID =", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotEqualTo(Integer value) {
            addCriterion("Factory_ID <>", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdGreaterThan(Integer value) {
            addCriterion("Factory_ID >", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Factory_ID >=", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdLessThan(Integer value) {
            addCriterion("Factory_ID <", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("Factory_ID <=", value, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdIn(List<Integer> values) {
            addCriterion("Factory_ID in", values, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotIn(List<Integer> values) {
            addCriterion("Factory_ID not in", values, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdBetween(Integer value1, Integer value2) {
            addCriterion("Factory_ID between", value1, value2, "factoryId");
            return (Criteria) this;
        }

        public Criteria andFactoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Factory_ID not between", value1, value2, "factoryId");
            return (Criteria) this;
        }

        public Criteria andDateFactoryIsNull() {
            addCriterion("Date_Factory is null");
            return (Criteria) this;
        }

        public Criteria andDateFactoryIsNotNull() {
            addCriterion("Date_Factory is not null");
            return (Criteria) this;
        }

        public Criteria andDateFactoryEqualTo(Long value) {
            addCriterion("Date_Factory =", value, "dateFactory");
            return (Criteria) this;
        }

        public Criteria andDateFactoryNotEqualTo(Long value) {
            addCriterion("Date_Factory <>", value, "dateFactory");
            return (Criteria) this;
        }

        public Criteria andDateFactoryGreaterThan(Long value) {
            addCriterion("Date_Factory >", value, "dateFactory");
            return (Criteria) this;
        }

        public Criteria andDateFactoryGreaterThanOrEqualTo(Long value) {
            addCriterion("Date_Factory >=", value, "dateFactory");
            return (Criteria) this;
        }

        public Criteria andDateFactoryLessThan(Long value) {
            addCriterion("Date_Factory <", value, "dateFactory");
            return (Criteria) this;
        }

        public Criteria andDateFactoryLessThanOrEqualTo(Long value) {
            addCriterion("Date_Factory <=", value, "dateFactory");
            return (Criteria) this;
        }

        public Criteria andDateFactoryIn(List<Long> values) {
            addCriterion("Date_Factory in", values, "dateFactory");
            return (Criteria) this;
        }

        public Criteria andDateFactoryNotIn(List<Long> values) {
            addCriterion("Date_Factory not in", values, "dateFactory");
            return (Criteria) this;
        }

        public Criteria andDateFactoryBetween(Long value1, Long value2) {
            addCriterion("Date_Factory between", value1, value2, "dateFactory");
            return (Criteria) this;
        }

        public Criteria andDateFactoryNotBetween(Long value1, Long value2) {
            addCriterion("Date_Factory not between", value1, value2, "dateFactory");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameIsNull() {
            addCriterion("Equipment_Login_Name is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameIsNotNull() {
            addCriterion("Equipment_Login_Name is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameEqualTo(String value) {
            addCriterion("Equipment_Login_Name =", value, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameNotEqualTo(String value) {
            addCriterion("Equipment_Login_Name <>", value, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameGreaterThan(String value) {
            addCriterion("Equipment_Login_Name >", value, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("Equipment_Login_Name >=", value, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameLessThan(String value) {
            addCriterion("Equipment_Login_Name <", value, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameLessThanOrEqualTo(String value) {
            addCriterion("Equipment_Login_Name <=", value, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameLike(String value) {
            addCriterion("Equipment_Login_Name like", value, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameNotLike(String value) {
            addCriterion("Equipment_Login_Name not like", value, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameIn(List<String> values) {
            addCriterion("Equipment_Login_Name in", values, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameNotIn(List<String> values) {
            addCriterion("Equipment_Login_Name not in", values, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameBetween(String value1, String value2) {
            addCriterion("Equipment_Login_Name between", value1, value2, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginNameNotBetween(String value1, String value2) {
            addCriterion("Equipment_Login_Name not between", value1, value2, "equipmentLoginName");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordIsNull() {
            addCriterion("Equipment_Login_Password is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordIsNotNull() {
            addCriterion("Equipment_Login_Password is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordEqualTo(String value) {
            addCriterion("Equipment_Login_Password =", value, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordNotEqualTo(String value) {
            addCriterion("Equipment_Login_Password <>", value, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordGreaterThan(String value) {
            addCriterion("Equipment_Login_Password >", value, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("Equipment_Login_Password >=", value, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordLessThan(String value) {
            addCriterion("Equipment_Login_Password <", value, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordLessThanOrEqualTo(String value) {
            addCriterion("Equipment_Login_Password <=", value, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordLike(String value) {
            addCriterion("Equipment_Login_Password like", value, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordNotLike(String value) {
            addCriterion("Equipment_Login_Password not like", value, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordIn(List<String> values) {
            addCriterion("Equipment_Login_Password in", values, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordNotIn(List<String> values) {
            addCriterion("Equipment_Login_Password not in", values, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordBetween(String value1, String value2) {
            addCriterion("Equipment_Login_Password between", value1, value2, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andEquipmentLoginPasswordNotBetween(String value1, String value2) {
            addCriterion("Equipment_Login_Password not between", value1, value2, "equipmentLoginPassword");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIsNull() {
            addCriterion("Date_Created is null");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIsNotNull() {
            addCriterion("Date_Created is not null");
            return (Criteria) this;
        }

        public Criteria andDateCreatedEqualTo(Long value) {
            addCriterion("Date_Created =", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotEqualTo(Long value) {
            addCriterion("Date_Created <>", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedGreaterThan(Long value) {
            addCriterion("Date_Created >", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedGreaterThanOrEqualTo(Long value) {
            addCriterion("Date_Created >=", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedLessThan(Long value) {
            addCriterion("Date_Created <", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedLessThanOrEqualTo(Long value) {
            addCriterion("Date_Created <=", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIn(List<Long> values) {
            addCriterion("Date_Created in", values, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotIn(List<Long> values) {
            addCriterion("Date_Created not in", values, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedBetween(Long value1, Long value2) {
            addCriterion("Date_Created between", value1, value2, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotBetween(Long value1, Long value2) {
            addCriterion("Date_Created not between", value1, value2, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateModifiedIsNull() {
            addCriterion("Date_Modified is null");
            return (Criteria) this;
        }

        public Criteria andDateModifiedIsNotNull() {
            addCriterion("Date_Modified is not null");
            return (Criteria) this;
        }

        public Criteria andDateModifiedEqualTo(Long value) {
            addCriterion("Date_Modified =", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedNotEqualTo(Long value) {
            addCriterion("Date_Modified <>", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedGreaterThan(Long value) {
            addCriterion("Date_Modified >", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedGreaterThanOrEqualTo(Long value) {
            addCriterion("Date_Modified >=", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedLessThan(Long value) {
            addCriterion("Date_Modified <", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedLessThanOrEqualTo(Long value) {
            addCriterion("Date_Modified <=", value, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedIn(List<Long> values) {
            addCriterion("Date_Modified in", values, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedNotIn(List<Long> values) {
            addCriterion("Date_Modified not in", values, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedBetween(Long value1, Long value2) {
            addCriterion("Date_Modified between", value1, value2, "dateModified");
            return (Criteria) this;
        }

        public Criteria andDateModifiedNotBetween(Long value1, Long value2) {
            addCriterion("Date_Modified not between", value1, value2, "dateModified");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("Created_By is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("Created_By is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("Created_By =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("Created_By <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("Created_By >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("Created_By >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("Created_By <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("Created_By <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("Created_By like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("Created_By not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("Created_By in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("Created_By not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("Created_By between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("Created_By not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByIsNull() {
            addCriterion("Modified_By is null");
            return (Criteria) this;
        }

        public Criteria andModifiedByIsNotNull() {
            addCriterion("Modified_By is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedByEqualTo(String value) {
            addCriterion("Modified_By =", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotEqualTo(String value) {
            addCriterion("Modified_By <>", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByGreaterThan(String value) {
            addCriterion("Modified_By >", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByGreaterThanOrEqualTo(String value) {
            addCriterion("Modified_By >=", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLessThan(String value) {
            addCriterion("Modified_By <", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLessThanOrEqualTo(String value) {
            addCriterion("Modified_By <=", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByLike(String value) {
            addCriterion("Modified_By like", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotLike(String value) {
            addCriterion("Modified_By not like", value, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByIn(List<String> values) {
            addCriterion("Modified_By in", values, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotIn(List<String> values) {
            addCriterion("Modified_By not in", values, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByBetween(String value1, String value2) {
            addCriterion("Modified_By between", value1, value2, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andModifiedByNotBetween(String value1, String value2) {
            addCriterion("Modified_By not between", value1, value2, "modifiedBy");
            return (Criteria) this;
        }

        public Criteria andIsAvailableIsNull() {
            addCriterion("Is_Available is null");
            return (Criteria) this;
        }

        public Criteria andIsAvailableIsNotNull() {
            addCriterion("Is_Available is not null");
            return (Criteria) this;
        }

        public Criteria andIsAvailableEqualTo(Integer value) {
            addCriterion("Is_Available =", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableNotEqualTo(Integer value) {
            addCriterion("Is_Available <>", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableGreaterThan(Integer value) {
            addCriterion("Is_Available >", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableGreaterThanOrEqualTo(Integer value) {
            addCriterion("Is_Available >=", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableLessThan(Integer value) {
            addCriterion("Is_Available <", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableLessThanOrEqualTo(Integer value) {
            addCriterion("Is_Available <=", value, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableIn(List<Integer> values) {
            addCriterion("Is_Available in", values, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableNotIn(List<Integer> values) {
            addCriterion("Is_Available not in", values, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableBetween(Integer value1, Integer value2) {
            addCriterion("Is_Available between", value1, value2, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andIsAvailableNotBetween(Integer value1, Integer value2) {
            addCriterion("Is_Available not between", value1, value2, "isAvailable");
            return (Criteria) this;
        }

        public Criteria andSupplementIsNull() {
            addCriterion("Supplement is null");
            return (Criteria) this;
        }

        public Criteria andSupplementIsNotNull() {
            addCriterion("Supplement is not null");
            return (Criteria) this;
        }

        public Criteria andSupplementEqualTo(String value) {
            addCriterion("Supplement =", value, "supplement");
            return (Criteria) this;
        }

        public Criteria andSupplementNotEqualTo(String value) {
            addCriterion("Supplement <>", value, "supplement");
            return (Criteria) this;
        }

        public Criteria andSupplementGreaterThan(String value) {
            addCriterion("Supplement >", value, "supplement");
            return (Criteria) this;
        }

        public Criteria andSupplementGreaterThanOrEqualTo(String value) {
            addCriterion("Supplement >=", value, "supplement");
            return (Criteria) this;
        }

        public Criteria andSupplementLessThan(String value) {
            addCriterion("Supplement <", value, "supplement");
            return (Criteria) this;
        }

        public Criteria andSupplementLessThanOrEqualTo(String value) {
            addCriterion("Supplement <=", value, "supplement");
            return (Criteria) this;
        }

        public Criteria andSupplementLike(String value) {
            addCriterion("Supplement like", value, "supplement");
            return (Criteria) this;
        }

        public Criteria andSupplementNotLike(String value) {
            addCriterion("Supplement not like", value, "supplement");
            return (Criteria) this;
        }

        public Criteria andSupplementIn(List<String> values) {
            addCriterion("Supplement in", values, "supplement");
            return (Criteria) this;
        }

        public Criteria andSupplementNotIn(List<String> values) {
            addCriterion("Supplement not in", values, "supplement");
            return (Criteria) this;
        }

        public Criteria andSupplementBetween(String value1, String value2) {
            addCriterion("Supplement between", value1, value2, "supplement");
            return (Criteria) this;
        }

        public Criteria andSupplementNotBetween(String value1, String value2) {
            addCriterion("Supplement not between", value1, value2, "supplement");
            return (Criteria) this;
        }

        public Criteria andServiceIpIsNull() {
            addCriterion("Service_IP is null");
            return (Criteria) this;
        }

        public Criteria andServiceIpIsNotNull() {
            addCriterion("Service_IP is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIpEqualTo(String value) {
            addCriterion("Service_IP =", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotEqualTo(String value) {
            addCriterion("Service_IP <>", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpGreaterThan(String value) {
            addCriterion("Service_IP >", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpGreaterThanOrEqualTo(String value) {
            addCriterion("Service_IP >=", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLessThan(String value) {
            addCriterion("Service_IP <", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLessThanOrEqualTo(String value) {
            addCriterion("Service_IP <=", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpLike(String value) {
            addCriterion("Service_IP like", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotLike(String value) {
            addCriterion("Service_IP not like", value, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpIn(List<String> values) {
            addCriterion("Service_IP in", values, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotIn(List<String> values) {
            addCriterion("Service_IP not in", values, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpBetween(String value1, String value2) {
            addCriterion("Service_IP between", value1, value2, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServiceIpNotBetween(String value1, String value2) {
            addCriterion("Service_IP not between", value1, value2, "serviceIp");
            return (Criteria) this;
        }

        public Criteria andServicePortIsNull() {
            addCriterion("Service_Port is null");
            return (Criteria) this;
        }

        public Criteria andServicePortIsNotNull() {
            addCriterion("Service_Port is not null");
            return (Criteria) this;
        }

        public Criteria andServicePortEqualTo(String value) {
            addCriterion("Service_Port =", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotEqualTo(String value) {
            addCriterion("Service_Port <>", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortGreaterThan(String value) {
            addCriterion("Service_Port >", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortGreaterThanOrEqualTo(String value) {
            addCriterion("Service_Port >=", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLessThan(String value) {
            addCriterion("Service_Port <", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLessThanOrEqualTo(String value) {
            addCriterion("Service_Port <=", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortLike(String value) {
            addCriterion("Service_Port like", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotLike(String value) {
            addCriterion("Service_Port not like", value, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortIn(List<String> values) {
            addCriterion("Service_Port in", values, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotIn(List<String> values) {
            addCriterion("Service_Port not in", values, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortBetween(String value1, String value2) {
            addCriterion("Service_Port between", value1, value2, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServicePortNotBetween(String value1, String value2) {
            addCriterion("Service_Port not between", value1, value2, "servicePort");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameIsNull() {
            addCriterion("Service_Login_Name is null");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameIsNotNull() {
            addCriterion("Service_Login_Name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameEqualTo(String value) {
            addCriterion("Service_Login_Name =", value, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameNotEqualTo(String value) {
            addCriterion("Service_Login_Name <>", value, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameGreaterThan(String value) {
            addCriterion("Service_Login_Name >", value, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("Service_Login_Name >=", value, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameLessThan(String value) {
            addCriterion("Service_Login_Name <", value, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameLessThanOrEqualTo(String value) {
            addCriterion("Service_Login_Name <=", value, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameLike(String value) {
            addCriterion("Service_Login_Name like", value, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameNotLike(String value) {
            addCriterion("Service_Login_Name not like", value, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameIn(List<String> values) {
            addCriterion("Service_Login_Name in", values, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameNotIn(List<String> values) {
            addCriterion("Service_Login_Name not in", values, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameBetween(String value1, String value2) {
            addCriterion("Service_Login_Name between", value1, value2, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginNameNotBetween(String value1, String value2) {
            addCriterion("Service_Login_Name not between", value1, value2, "serviceLoginName");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordIsNull() {
            addCriterion("Service_Login_Password is null");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordIsNotNull() {
            addCriterion("Service_Login_Password is not null");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordEqualTo(String value) {
            addCriterion("Service_Login_Password =", value, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordNotEqualTo(String value) {
            addCriterion("Service_Login_Password <>", value, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordGreaterThan(String value) {
            addCriterion("Service_Login_Password >", value, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("Service_Login_Password >=", value, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordLessThan(String value) {
            addCriterion("Service_Login_Password <", value, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordLessThanOrEqualTo(String value) {
            addCriterion("Service_Login_Password <=", value, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordLike(String value) {
            addCriterion("Service_Login_Password like", value, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordNotLike(String value) {
            addCriterion("Service_Login_Password not like", value, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordIn(List<String> values) {
            addCriterion("Service_Login_Password in", values, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordNotIn(List<String> values) {
            addCriterion("Service_Login_Password not in", values, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordBetween(String value1, String value2) {
            addCriterion("Service_Login_Password between", value1, value2, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andServiceLoginPasswordNotBetween(String value1, String value2) {
            addCriterion("Service_Login_Password not between", value1, value2, "serviceLoginPassword");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumIsNull() {
            addCriterion("ControlCard_serialNum is null");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumIsNotNull() {
            addCriterion("ControlCard_serialNum is not null");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumEqualTo(String value) {
            addCriterion("ControlCard_serialNum =", value, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumNotEqualTo(String value) {
            addCriterion("ControlCard_serialNum <>", value, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumGreaterThan(String value) {
            addCriterion("ControlCard_serialNum >", value, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumGreaterThanOrEqualTo(String value) {
            addCriterion("ControlCard_serialNum >=", value, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumLessThan(String value) {
            addCriterion("ControlCard_serialNum <", value, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumLessThanOrEqualTo(String value) {
            addCriterion("ControlCard_serialNum <=", value, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumLike(String value) {
            addCriterion("ControlCard_serialNum like", value, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumNotLike(String value) {
            addCriterion("ControlCard_serialNum not like", value, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumIn(List<String> values) {
            addCriterion("ControlCard_serialNum in", values, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumNotIn(List<String> values) {
            addCriterion("ControlCard_serialNum not in", values, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumBetween(String value1, String value2) {
            addCriterion("ControlCard_serialNum between", value1, value2, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andControlcardSerialnumNotBetween(String value1, String value2) {
            addCriterion("ControlCard_serialNum not between", value1, value2, "controlcardSerialnum");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdIsNull() {
            addCriterion("Related_Equipment_ID is null");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdIsNotNull() {
            addCriterion("Related_Equipment_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdEqualTo(Integer value) {
            addCriterion("Related_Equipment_ID =", value, "relatedEquipmentId");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdNotEqualTo(Integer value) {
            addCriterion("Related_Equipment_ID <>", value, "relatedEquipmentId");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdGreaterThan(Integer value) {
            addCriterion("Related_Equipment_ID >", value, "relatedEquipmentId");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Related_Equipment_ID >=", value, "relatedEquipmentId");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdLessThan(Integer value) {
            addCriterion("Related_Equipment_ID <", value, "relatedEquipmentId");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("Related_Equipment_ID <=", value, "relatedEquipmentId");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdIn(List<Integer> values) {
            addCriterion("Related_Equipment_ID in", values, "relatedEquipmentId");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdNotIn(List<Integer> values) {
            addCriterion("Related_Equipment_ID not in", values, "relatedEquipmentId");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdBetween(Integer value1, Integer value2) {
            addCriterion("Related_Equipment_ID between", value1, value2, "relatedEquipmentId");
            return (Criteria) this;
        }

        public Criteria andRelatedEquipmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Related_Equipment_ID not between", value1, value2, "relatedEquipmentId");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskIsNull() {
            addCriterion("Subnet_Mask is null");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskIsNotNull() {
            addCriterion("Subnet_Mask is not null");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskEqualTo(String value) {
            addCriterion("Subnet_Mask =", value, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskNotEqualTo(String value) {
            addCriterion("Subnet_Mask <>", value, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskGreaterThan(String value) {
            addCriterion("Subnet_Mask >", value, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskGreaterThanOrEqualTo(String value) {
            addCriterion("Subnet_Mask >=", value, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskLessThan(String value) {
            addCriterion("Subnet_Mask <", value, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskLessThanOrEqualTo(String value) {
            addCriterion("Subnet_Mask <=", value, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskLike(String value) {
            addCriterion("Subnet_Mask like", value, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskNotLike(String value) {
            addCriterion("Subnet_Mask not like", value, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskIn(List<String> values) {
            addCriterion("Subnet_Mask in", values, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskNotIn(List<String> values) {
            addCriterion("Subnet_Mask not in", values, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskBetween(String value1, String value2) {
            addCriterion("Subnet_Mask between", value1, value2, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andSubnetMaskNotBetween(String value1, String value2) {
            addCriterion("Subnet_Mask not between", value1, value2, "subnetMask");
            return (Criteria) this;
        }

        public Criteria andGatewayIsNull() {
            addCriterion("Gateway is null");
            return (Criteria) this;
        }

        public Criteria andGatewayIsNotNull() {
            addCriterion("Gateway is not null");
            return (Criteria) this;
        }

        public Criteria andGatewayEqualTo(String value) {
            addCriterion("Gateway =", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotEqualTo(String value) {
            addCriterion("Gateway <>", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayGreaterThan(String value) {
            addCriterion("Gateway >", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayGreaterThanOrEqualTo(String value) {
            addCriterion("Gateway >=", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayLessThan(String value) {
            addCriterion("Gateway <", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayLessThanOrEqualTo(String value) {
            addCriterion("Gateway <=", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayLike(String value) {
            addCriterion("Gateway like", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotLike(String value) {
            addCriterion("Gateway not like", value, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayIn(List<String> values) {
            addCriterion("Gateway in", values, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotIn(List<String> values) {
            addCriterion("Gateway not in", values, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayBetween(String value1, String value2) {
            addCriterion("Gateway between", value1, value2, "gateway");
            return (Criteria) this;
        }

        public Criteria andGatewayNotBetween(String value1, String value2) {
            addCriterion("Gateway not between", value1, value2, "gateway");
            return (Criteria) this;
        }

        public Criteria andDnsIsNull() {
            addCriterion("DNS is null");
            return (Criteria) this;
        }

        public Criteria andDnsIsNotNull() {
            addCriterion("DNS is not null");
            return (Criteria) this;
        }

        public Criteria andDnsEqualTo(String value) {
            addCriterion("DNS =", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotEqualTo(String value) {
            addCriterion("DNS <>", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsGreaterThan(String value) {
            addCriterion("DNS >", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsGreaterThanOrEqualTo(String value) {
            addCriterion("DNS >=", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLessThan(String value) {
            addCriterion("DNS <", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLessThanOrEqualTo(String value) {
            addCriterion("DNS <=", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsLike(String value) {
            addCriterion("DNS like", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotLike(String value) {
            addCriterion("DNS not like", value, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsIn(List<String> values) {
            addCriterion("DNS in", values, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotIn(List<String> values) {
            addCriterion("DNS not in", values, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsBetween(String value1, String value2) {
            addCriterion("DNS between", value1, value2, "dns");
            return (Criteria) this;
        }

        public Criteria andDnsNotBetween(String value1, String value2) {
            addCriterion("DNS not between", value1, value2, "dns");
            return (Criteria) this;
        }

        public Criteria andGisPosXIsNull() {
            addCriterion("Gis_Pos_X is null");
            return (Criteria) this;
        }

        public Criteria andGisPosXIsNotNull() {
            addCriterion("Gis_Pos_X is not null");
            return (Criteria) this;
        }

        public Criteria andGisPosXEqualTo(String value) {
            addCriterion("Gis_Pos_X =", value, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosXNotEqualTo(String value) {
            addCriterion("Gis_Pos_X <>", value, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosXGreaterThan(String value) {
            addCriterion("Gis_Pos_X >", value, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosXGreaterThanOrEqualTo(String value) {
            addCriterion("Gis_Pos_X >=", value, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosXLessThan(String value) {
            addCriterion("Gis_Pos_X <", value, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosXLessThanOrEqualTo(String value) {
            addCriterion("Gis_Pos_X <=", value, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosXLike(String value) {
            addCriterion("Gis_Pos_X like", value, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosXNotLike(String value) {
            addCriterion("Gis_Pos_X not like", value, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosXIn(List<String> values) {
            addCriterion("Gis_Pos_X in", values, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosXNotIn(List<String> values) {
            addCriterion("Gis_Pos_X not in", values, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosXBetween(String value1, String value2) {
            addCriterion("Gis_Pos_X between", value1, value2, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosXNotBetween(String value1, String value2) {
            addCriterion("Gis_Pos_X not between", value1, value2, "gisPosX");
            return (Criteria) this;
        }

        public Criteria andGisPosYIsNull() {
            addCriterion("Gis_Pos_Y is null");
            return (Criteria) this;
        }

        public Criteria andGisPosYIsNotNull() {
            addCriterion("Gis_Pos_Y is not null");
            return (Criteria) this;
        }

        public Criteria andGisPosYEqualTo(String value) {
            addCriterion("Gis_Pos_Y =", value, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andGisPosYNotEqualTo(String value) {
            addCriterion("Gis_Pos_Y <>", value, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andGisPosYGreaterThan(String value) {
            addCriterion("Gis_Pos_Y >", value, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andGisPosYGreaterThanOrEqualTo(String value) {
            addCriterion("Gis_Pos_Y >=", value, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andGisPosYLessThan(String value) {
            addCriterion("Gis_Pos_Y <", value, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andGisPosYLessThanOrEqualTo(String value) {
            addCriterion("Gis_Pos_Y <=", value, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andGisPosYLike(String value) {
            addCriterion("Gis_Pos_Y like", value, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andGisPosYNotLike(String value) {
            addCriterion("Gis_Pos_Y not like", value, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andGisPosYIn(List<String> values) {
            addCriterion("Gis_Pos_Y in", values, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andGisPosYNotIn(List<String> values) {
            addCriterion("Gis_Pos_Y not in", values, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andGisPosYBetween(String value1, String value2) {
            addCriterion("Gis_Pos_Y between", value1, value2, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andGisPosYNotBetween(String value1, String value2) {
            addCriterion("Gis_Pos_Y not between", value1, value2, "gisPosY");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrIsNull() {
            addCriterion("Equipment_Addr is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrIsNotNull() {
            addCriterion("Equipment_Addr is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrEqualTo(String value) {
            addCriterion("Equipment_Addr =", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrNotEqualTo(String value) {
            addCriterion("Equipment_Addr <>", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrGreaterThan(String value) {
            addCriterion("Equipment_Addr >", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrGreaterThanOrEqualTo(String value) {
            addCriterion("Equipment_Addr >=", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrLessThan(String value) {
            addCriterion("Equipment_Addr <", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrLessThanOrEqualTo(String value) {
            addCriterion("Equipment_Addr <=", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrLike(String value) {
            addCriterion("Equipment_Addr like", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrNotLike(String value) {
            addCriterion("Equipment_Addr not like", value, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrIn(List<String> values) {
            addCriterion("Equipment_Addr in", values, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrNotIn(List<String> values) {
            addCriterion("Equipment_Addr not in", values, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrBetween(String value1, String value2) {
            addCriterion("Equipment_Addr between", value1, value2, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andEquipmentAddrNotBetween(String value1, String value2) {
            addCriterion("Equipment_Addr not between", value1, value2, "equipmentAddr");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeIsNull() {
            addCriterion("Business_Code is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeIsNotNull() {
            addCriterion("Business_Code is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeEqualTo(String value) {
            addCriterion("Business_Code =", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeNotEqualTo(String value) {
            addCriterion("Business_Code <>", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeGreaterThan(String value) {
            addCriterion("Business_Code >", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Business_Code >=", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeLessThan(String value) {
            addCriterion("Business_Code <", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeLessThanOrEqualTo(String value) {
            addCriterion("Business_Code <=", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeLike(String value) {
            addCriterion("Business_Code like", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeNotLike(String value) {
            addCriterion("Business_Code not like", value, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeIn(List<String> values) {
            addCriterion("Business_Code in", values, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeNotIn(List<String> values) {
            addCriterion("Business_Code not in", values, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeBetween(String value1, String value2) {
            addCriterion("Business_Code between", value1, value2, "businessCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCodeNotBetween(String value1, String value2) {
            addCriterion("Business_Code not between", value1, value2, "businessCode");
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