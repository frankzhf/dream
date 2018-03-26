package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.List;

public class AssetEquclassInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetEquclassInfoExample() {
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

        public Criteria andEquclassIdIsNull() {
            addCriterion("Equclass_ID is null");
            return (Criteria) this;
        }

        public Criteria andEquclassIdIsNotNull() {
            addCriterion("Equclass_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEquclassIdEqualTo(Integer value) {
            addCriterion("Equclass_ID =", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdNotEqualTo(Integer value) {
            addCriterion("Equclass_ID <>", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdGreaterThan(Integer value) {
            addCriterion("Equclass_ID >", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Equclass_ID >=", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdLessThan(Integer value) {
            addCriterion("Equclass_ID <", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdLessThanOrEqualTo(Integer value) {
            addCriterion("Equclass_ID <=", value, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdIn(List<Integer> values) {
            addCriterion("Equclass_ID in", values, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdNotIn(List<Integer> values) {
            addCriterion("Equclass_ID not in", values, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdBetween(Integer value1, Integer value2) {
            addCriterion("Equclass_ID between", value1, value2, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Equclass_ID not between", value1, value2, "equclassId");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeIsNull() {
            addCriterion("EquClass_Code is null");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeIsNotNull() {
            addCriterion("EquClass_Code is not null");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeEqualTo(String value) {
            addCriterion("EquClass_Code =", value, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeNotEqualTo(String value) {
            addCriterion("EquClass_Code <>", value, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeGreaterThan(String value) {
            addCriterion("EquClass_Code >", value, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EquClass_Code >=", value, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeLessThan(String value) {
            addCriterion("EquClass_Code <", value, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeLessThanOrEqualTo(String value) {
            addCriterion("EquClass_Code <=", value, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeLike(String value) {
            addCriterion("EquClass_Code like", value, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeNotLike(String value) {
            addCriterion("EquClass_Code not like", value, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeIn(List<String> values) {
            addCriterion("EquClass_Code in", values, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeNotIn(List<String> values) {
            addCriterion("EquClass_Code not in", values, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeBetween(String value1, String value2) {
            addCriterion("EquClass_Code between", value1, value2, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassCodeNotBetween(String value1, String value2) {
            addCriterion("EquClass_Code not between", value1, value2, "equclassCode");
            return (Criteria) this;
        }

        public Criteria andEquclassNameIsNull() {
            addCriterion("EquClass_Name is null");
            return (Criteria) this;
        }

        public Criteria andEquclassNameIsNotNull() {
            addCriterion("EquClass_Name is not null");
            return (Criteria) this;
        }

        public Criteria andEquclassNameEqualTo(String value) {
            addCriterion("EquClass_Name =", value, "equclassName");
            return (Criteria) this;
        }

        public Criteria andEquclassNameNotEqualTo(String value) {
            addCriterion("EquClass_Name <>", value, "equclassName");
            return (Criteria) this;
        }

        public Criteria andEquclassNameGreaterThan(String value) {
            addCriterion("EquClass_Name >", value, "equclassName");
            return (Criteria) this;
        }

        public Criteria andEquclassNameGreaterThanOrEqualTo(String value) {
            addCriterion("EquClass_Name >=", value, "equclassName");
            return (Criteria) this;
        }

        public Criteria andEquclassNameLessThan(String value) {
            addCriterion("EquClass_Name <", value, "equclassName");
            return (Criteria) this;
        }

        public Criteria andEquclassNameLessThanOrEqualTo(String value) {
            addCriterion("EquClass_Name <=", value, "equclassName");
            return (Criteria) this;
        }

        public Criteria andEquclassNameLike(String value) {
            addCriterion("EquClass_Name like", value, "equclassName");
            return (Criteria) this;
        }

        public Criteria andEquclassNameNotLike(String value) {
            addCriterion("EquClass_Name not like", value, "equclassName");
            return (Criteria) this;
        }

        public Criteria andEquclassNameIn(List<String> values) {
            addCriterion("EquClass_Name in", values, "equclassName");
            return (Criteria) this;
        }

        public Criteria andEquclassNameNotIn(List<String> values) {
            addCriterion("EquClass_Name not in", values, "equclassName");
            return (Criteria) this;
        }

        public Criteria andEquclassNameBetween(String value1, String value2) {
            addCriterion("EquClass_Name between", value1, value2, "equclassName");
            return (Criteria) this;
        }

        public Criteria andEquclassNameNotBetween(String value1, String value2) {
            addCriterion("EquClass_Name not between", value1, value2, "equclassName");
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