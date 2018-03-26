package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.List;

public class AssetLampInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetLampInfoExample() {
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

        public Criteria andLampCodeIsNull() {
            addCriterion("Lamp_Code is null");
            return (Criteria) this;
        }

        public Criteria andLampCodeIsNotNull() {
            addCriterion("Lamp_Code is not null");
            return (Criteria) this;
        }

        public Criteria andLampCodeEqualTo(String value) {
            addCriterion("Lamp_Code =", value, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampCodeNotEqualTo(String value) {
            addCriterion("Lamp_Code <>", value, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampCodeGreaterThan(String value) {
            addCriterion("Lamp_Code >", value, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Lamp_Code >=", value, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampCodeLessThan(String value) {
            addCriterion("Lamp_Code <", value, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampCodeLessThanOrEqualTo(String value) {
            addCriterion("Lamp_Code <=", value, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampCodeLike(String value) {
            addCriterion("Lamp_Code like", value, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampCodeNotLike(String value) {
            addCriterion("Lamp_Code not like", value, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampCodeIn(List<String> values) {
            addCriterion("Lamp_Code in", values, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampCodeNotIn(List<String> values) {
            addCriterion("Lamp_Code not in", values, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampCodeBetween(String value1, String value2) {
            addCriterion("Lamp_Code between", value1, value2, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampCodeNotBetween(String value1, String value2) {
            addCriterion("Lamp_Code not between", value1, value2, "lampCode");
            return (Criteria) this;
        }

        public Criteria andLampNameIsNull() {
            addCriterion("Lamp_Name is null");
            return (Criteria) this;
        }

        public Criteria andLampNameIsNotNull() {
            addCriterion("Lamp_Name is not null");
            return (Criteria) this;
        }

        public Criteria andLampNameEqualTo(String value) {
            addCriterion("Lamp_Name =", value, "lampName");
            return (Criteria) this;
        }

        public Criteria andLampNameNotEqualTo(String value) {
            addCriterion("Lamp_Name <>", value, "lampName");
            return (Criteria) this;
        }

        public Criteria andLampNameGreaterThan(String value) {
            addCriterion("Lamp_Name >", value, "lampName");
            return (Criteria) this;
        }

        public Criteria andLampNameGreaterThanOrEqualTo(String value) {
            addCriterion("Lamp_Name >=", value, "lampName");
            return (Criteria) this;
        }

        public Criteria andLampNameLessThan(String value) {
            addCriterion("Lamp_Name <", value, "lampName");
            return (Criteria) this;
        }

        public Criteria andLampNameLessThanOrEqualTo(String value) {
            addCriterion("Lamp_Name <=", value, "lampName");
            return (Criteria) this;
        }

        public Criteria andLampNameLike(String value) {
            addCriterion("Lamp_Name like", value, "lampName");
            return (Criteria) this;
        }

        public Criteria andLampNameNotLike(String value) {
            addCriterion("Lamp_Name not like", value, "lampName");
            return (Criteria) this;
        }

        public Criteria andLampNameIn(List<String> values) {
            addCriterion("Lamp_Name in", values, "lampName");
            return (Criteria) this;
        }

        public Criteria andLampNameNotIn(List<String> values) {
            addCriterion("Lamp_Name not in", values, "lampName");
            return (Criteria) this;
        }

        public Criteria andLampNameBetween(String value1, String value2) {
            addCriterion("Lamp_Name between", value1, value2, "lampName");
            return (Criteria) this;
        }

        public Criteria andLampNameNotBetween(String value1, String value2) {
            addCriterion("Lamp_Name not between", value1, value2, "lampName");
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

        public Criteria andLampAddrIsNull() {
            addCriterion("Lamp_Addr is null");
            return (Criteria) this;
        }

        public Criteria andLampAddrIsNotNull() {
            addCriterion("Lamp_Addr is not null");
            return (Criteria) this;
        }

        public Criteria andLampAddrEqualTo(String value) {
            addCriterion("Lamp_Addr =", value, "lampAddr");
            return (Criteria) this;
        }

        public Criteria andLampAddrNotEqualTo(String value) {
            addCriterion("Lamp_Addr <>", value, "lampAddr");
            return (Criteria) this;
        }

        public Criteria andLampAddrGreaterThan(String value) {
            addCriterion("Lamp_Addr >", value, "lampAddr");
            return (Criteria) this;
        }

        public Criteria andLampAddrGreaterThanOrEqualTo(String value) {
            addCriterion("Lamp_Addr >=", value, "lampAddr");
            return (Criteria) this;
        }

        public Criteria andLampAddrLessThan(String value) {
            addCriterion("Lamp_Addr <", value, "lampAddr");
            return (Criteria) this;
        }

        public Criteria andLampAddrLessThanOrEqualTo(String value) {
            addCriterion("Lamp_Addr <=", value, "lampAddr");
            return (Criteria) this;
        }

        public Criteria andLampAddrLike(String value) {
            addCriterion("Lamp_Addr like", value, "lampAddr");
            return (Criteria) this;
        }

        public Criteria andLampAddrNotLike(String value) {
            addCriterion("Lamp_Addr not like", value, "lampAddr");
            return (Criteria) this;
        }

        public Criteria andLampAddrIn(List<String> values) {
            addCriterion("Lamp_Addr in", values, "lampAddr");
            return (Criteria) this;
        }

        public Criteria andLampAddrNotIn(List<String> values) {
            addCriterion("Lamp_Addr not in", values, "lampAddr");
            return (Criteria) this;
        }

        public Criteria andLampAddrBetween(String value1, String value2) {
            addCriterion("Lamp_Addr between", value1, value2, "lampAddr");
            return (Criteria) this;
        }

        public Criteria andLampAddrNotBetween(String value1, String value2) {
            addCriterion("Lamp_Addr not between", value1, value2, "lampAddr");
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