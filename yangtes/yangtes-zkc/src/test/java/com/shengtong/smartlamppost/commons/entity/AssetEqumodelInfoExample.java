package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.List;

public class AssetEqumodelInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetEqumodelInfoExample() {
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

        public Criteria andEqumodelNameIsNull() {
            addCriterion("EquModel_Name is null");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameIsNotNull() {
            addCriterion("EquModel_Name is not null");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameEqualTo(String value) {
            addCriterion("EquModel_Name =", value, "equmodelName");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameNotEqualTo(String value) {
            addCriterion("EquModel_Name <>", value, "equmodelName");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameGreaterThan(String value) {
            addCriterion("EquModel_Name >", value, "equmodelName");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameGreaterThanOrEqualTo(String value) {
            addCriterion("EquModel_Name >=", value, "equmodelName");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameLessThan(String value) {
            addCriterion("EquModel_Name <", value, "equmodelName");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameLessThanOrEqualTo(String value) {
            addCriterion("EquModel_Name <=", value, "equmodelName");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameLike(String value) {
            addCriterion("EquModel_Name like", value, "equmodelName");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameNotLike(String value) {
            addCriterion("EquModel_Name not like", value, "equmodelName");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameIn(List<String> values) {
            addCriterion("EquModel_Name in", values, "equmodelName");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameNotIn(List<String> values) {
            addCriterion("EquModel_Name not in", values, "equmodelName");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameBetween(String value1, String value2) {
            addCriterion("EquModel_Name between", value1, value2, "equmodelName");
            return (Criteria) this;
        }

        public Criteria andEqumodelNameNotBetween(String value1, String value2) {
            addCriterion("EquModel_Name not between", value1, value2, "equmodelName");
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