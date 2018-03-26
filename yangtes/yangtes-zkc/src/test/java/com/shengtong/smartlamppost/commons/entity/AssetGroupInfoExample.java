package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.List;

public class AssetGroupInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetGroupInfoExample() {
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

        public Criteria andGroupCodeIsNull() {
            addCriterion("Group_Code is null");
            return (Criteria) this;
        }

        public Criteria andGroupCodeIsNotNull() {
            addCriterion("Group_Code is not null");
            return (Criteria) this;
        }

        public Criteria andGroupCodeEqualTo(String value) {
            addCriterion("Group_Code =", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotEqualTo(String value) {
            addCriterion("Group_Code <>", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeGreaterThan(String value) {
            addCriterion("Group_Code >", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Group_Code >=", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLessThan(String value) {
            addCriterion("Group_Code <", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLessThanOrEqualTo(String value) {
            addCriterion("Group_Code <=", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLike(String value) {
            addCriterion("Group_Code like", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotLike(String value) {
            addCriterion("Group_Code not like", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeIn(List<String> values) {
            addCriterion("Group_Code in", values, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotIn(List<String> values) {
            addCriterion("Group_Code not in", values, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeBetween(String value1, String value2) {
            addCriterion("Group_Code between", value1, value2, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotBetween(String value1, String value2) {
            addCriterion("Group_Code not between", value1, value2, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("Group_Name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("Group_Name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("Group_Name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("Group_Name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("Group_Name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("Group_Name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("Group_Name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("Group_Name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("Group_Name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("Group_Name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("Group_Name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("Group_Name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("Group_Name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("Group_Name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdIsNull() {
            addCriterion("Parent_Group_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdIsNotNull() {
            addCriterion("Parent_Group_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdEqualTo(Integer value) {
            addCriterion("Parent_Group_ID =", value, "parentGroupId");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdNotEqualTo(Integer value) {
            addCriterion("Parent_Group_ID <>", value, "parentGroupId");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdGreaterThan(Integer value) {
            addCriterion("Parent_Group_ID >", value, "parentGroupId");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Parent_Group_ID >=", value, "parentGroupId");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdLessThan(Integer value) {
            addCriterion("Parent_Group_ID <", value, "parentGroupId");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("Parent_Group_ID <=", value, "parentGroupId");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdIn(List<Integer> values) {
            addCriterion("Parent_Group_ID in", values, "parentGroupId");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdNotIn(List<Integer> values) {
            addCriterion("Parent_Group_ID not in", values, "parentGroupId");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("Parent_Group_ID between", value1, value2, "parentGroupId");
            return (Criteria) this;
        }

        public Criteria andParentGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Parent_Group_ID not between", value1, value2, "parentGroupId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("Area_ID is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("Area_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("Area_ID =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("Area_ID <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("Area_ID >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Area_ID >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("Area_ID <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("Area_ID <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("Area_ID in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("Area_ID not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("Area_ID between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Area_ID not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeIsNull() {
            addCriterion("Is_Subnode is null");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeIsNotNull() {
            addCriterion("Is_Subnode is not null");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeEqualTo(Integer value) {
            addCriterion("Is_Subnode =", value, "isSubnode");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeNotEqualTo(Integer value) {
            addCriterion("Is_Subnode <>", value, "isSubnode");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeGreaterThan(Integer value) {
            addCriterion("Is_Subnode >", value, "isSubnode");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Is_Subnode >=", value, "isSubnode");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeLessThan(Integer value) {
            addCriterion("Is_Subnode <", value, "isSubnode");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeLessThanOrEqualTo(Integer value) {
            addCriterion("Is_Subnode <=", value, "isSubnode");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeIn(List<Integer> values) {
            addCriterion("Is_Subnode in", values, "isSubnode");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeNotIn(List<Integer> values) {
            addCriterion("Is_Subnode not in", values, "isSubnode");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeBetween(Integer value1, Integer value2) {
            addCriterion("Is_Subnode between", value1, value2, "isSubnode");
            return (Criteria) this;
        }

        public Criteria andIsSubnodeNotBetween(Integer value1, Integer value2) {
            addCriterion("Is_Subnode not between", value1, value2, "isSubnode");
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

        public Criteria andModifiedBySystemIsNull() {
            addCriterion("Modified_By_System is null");
            return (Criteria) this;
        }

        public Criteria andModifiedBySystemIsNotNull() {
            addCriterion("Modified_By_System is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedBySystemEqualTo(Integer value) {
            addCriterion("Modified_By_System =", value, "modifiedBySystem");
            return (Criteria) this;
        }

        public Criteria andModifiedBySystemNotEqualTo(Integer value) {
            addCriterion("Modified_By_System <>", value, "modifiedBySystem");
            return (Criteria) this;
        }

        public Criteria andModifiedBySystemGreaterThan(Integer value) {
            addCriterion("Modified_By_System >", value, "modifiedBySystem");
            return (Criteria) this;
        }

        public Criteria andModifiedBySystemGreaterThanOrEqualTo(Integer value) {
            addCriterion("Modified_By_System >=", value, "modifiedBySystem");
            return (Criteria) this;
        }

        public Criteria andModifiedBySystemLessThan(Integer value) {
            addCriterion("Modified_By_System <", value, "modifiedBySystem");
            return (Criteria) this;
        }

        public Criteria andModifiedBySystemLessThanOrEqualTo(Integer value) {
            addCriterion("Modified_By_System <=", value, "modifiedBySystem");
            return (Criteria) this;
        }

        public Criteria andModifiedBySystemIn(List<Integer> values) {
            addCriterion("Modified_By_System in", values, "modifiedBySystem");
            return (Criteria) this;
        }

        public Criteria andModifiedBySystemNotIn(List<Integer> values) {
            addCriterion("Modified_By_System not in", values, "modifiedBySystem");
            return (Criteria) this;
        }

        public Criteria andModifiedBySystemBetween(Integer value1, Integer value2) {
            addCriterion("Modified_By_System between", value1, value2, "modifiedBySystem");
            return (Criteria) this;
        }

        public Criteria andModifiedBySystemNotBetween(Integer value1, Integer value2) {
            addCriterion("Modified_By_System not between", value1, value2, "modifiedBySystem");
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