package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.List;

public class AssetEqusectionInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetEqusectionInfoExample() {
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

        public Criteria andEqusectionCodeIsNull() {
            addCriterion("EquSection_Code is null");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeIsNotNull() {
            addCriterion("EquSection_Code is not null");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeEqualTo(String value) {
            addCriterion("EquSection_Code =", value, "equsectionCode");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeNotEqualTo(String value) {
            addCriterion("EquSection_Code <>", value, "equsectionCode");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeGreaterThan(String value) {
            addCriterion("EquSection_Code >", value, "equsectionCode");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EquSection_Code >=", value, "equsectionCode");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeLessThan(String value) {
            addCriterion("EquSection_Code <", value, "equsectionCode");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeLessThanOrEqualTo(String value) {
            addCriterion("EquSection_Code <=", value, "equsectionCode");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeLike(String value) {
            addCriterion("EquSection_Code like", value, "equsectionCode");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeNotLike(String value) {
            addCriterion("EquSection_Code not like", value, "equsectionCode");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeIn(List<String> values) {
            addCriterion("EquSection_Code in", values, "equsectionCode");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeNotIn(List<String> values) {
            addCriterion("EquSection_Code not in", values, "equsectionCode");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeBetween(String value1, String value2) {
            addCriterion("EquSection_Code between", value1, value2, "equsectionCode");
            return (Criteria) this;
        }

        public Criteria andEqusectionCodeNotBetween(String value1, String value2) {
            addCriterion("EquSection_Code not between", value1, value2, "equsectionCode");
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

        public Criteria andEqusectionNameIsNull() {
            addCriterion("EquSection_Name is null");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameIsNotNull() {
            addCriterion("EquSection_Name is not null");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameEqualTo(String value) {
            addCriterion("EquSection_Name =", value, "equsectionName");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameNotEqualTo(String value) {
            addCriterion("EquSection_Name <>", value, "equsectionName");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameGreaterThan(String value) {
            addCriterion("EquSection_Name >", value, "equsectionName");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameGreaterThanOrEqualTo(String value) {
            addCriterion("EquSection_Name >=", value, "equsectionName");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameLessThan(String value) {
            addCriterion("EquSection_Name <", value, "equsectionName");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameLessThanOrEqualTo(String value) {
            addCriterion("EquSection_Name <=", value, "equsectionName");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameLike(String value) {
            addCriterion("EquSection_Name like", value, "equsectionName");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameNotLike(String value) {
            addCriterion("EquSection_Name not like", value, "equsectionName");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameIn(List<String> values) {
            addCriterion("EquSection_Name in", values, "equsectionName");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameNotIn(List<String> values) {
            addCriterion("EquSection_Name not in", values, "equsectionName");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameBetween(String value1, String value2) {
            addCriterion("EquSection_Name between", value1, value2, "equsectionName");
            return (Criteria) this;
        }

        public Criteria andEqusectionNameNotBetween(String value1, String value2) {
            addCriterion("EquSection_Name not between", value1, value2, "equsectionName");
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