package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.List;

public class AssetFactoryInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetFactoryInfoExample() {
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

        public Criteria andFactoryNameIsNull() {
            addCriterion("Factory_Name is null");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIsNotNull() {
            addCriterion("Factory_Name is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryNameEqualTo(String value) {
            addCriterion("Factory_Name =", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotEqualTo(String value) {
            addCriterion("Factory_Name <>", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameGreaterThan(String value) {
            addCriterion("Factory_Name >", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("Factory_Name >=", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLessThan(String value) {
            addCriterion("Factory_Name <", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLessThanOrEqualTo(String value) {
            addCriterion("Factory_Name <=", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameLike(String value) {
            addCriterion("Factory_Name like", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotLike(String value) {
            addCriterion("Factory_Name not like", value, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameIn(List<String> values) {
            addCriterion("Factory_Name in", values, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotIn(List<String> values) {
            addCriterion("Factory_Name not in", values, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameBetween(String value1, String value2) {
            addCriterion("Factory_Name between", value1, value2, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryNameNotBetween(String value1, String value2) {
            addCriterion("Factory_Name not between", value1, value2, "factoryName");
            return (Criteria) this;
        }

        public Criteria andFactoryTelIsNull() {
            addCriterion("Factory_Tel is null");
            return (Criteria) this;
        }

        public Criteria andFactoryTelIsNotNull() {
            addCriterion("Factory_Tel is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryTelEqualTo(String value) {
            addCriterion("Factory_Tel =", value, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryTelNotEqualTo(String value) {
            addCriterion("Factory_Tel <>", value, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryTelGreaterThan(String value) {
            addCriterion("Factory_Tel >", value, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryTelGreaterThanOrEqualTo(String value) {
            addCriterion("Factory_Tel >=", value, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryTelLessThan(String value) {
            addCriterion("Factory_Tel <", value, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryTelLessThanOrEqualTo(String value) {
            addCriterion("Factory_Tel <=", value, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryTelLike(String value) {
            addCriterion("Factory_Tel like", value, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryTelNotLike(String value) {
            addCriterion("Factory_Tel not like", value, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryTelIn(List<String> values) {
            addCriterion("Factory_Tel in", values, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryTelNotIn(List<String> values) {
            addCriterion("Factory_Tel not in", values, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryTelBetween(String value1, String value2) {
            addCriterion("Factory_Tel between", value1, value2, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryTelNotBetween(String value1, String value2) {
            addCriterion("Factory_Tel not between", value1, value2, "factoryTel");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrIsNull() {
            addCriterion("Factory_Addr is null");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrIsNotNull() {
            addCriterion("Factory_Addr is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrEqualTo(String value) {
            addCriterion("Factory_Addr =", value, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrNotEqualTo(String value) {
            addCriterion("Factory_Addr <>", value, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrGreaterThan(String value) {
            addCriterion("Factory_Addr >", value, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrGreaterThanOrEqualTo(String value) {
            addCriterion("Factory_Addr >=", value, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrLessThan(String value) {
            addCriterion("Factory_Addr <", value, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrLessThanOrEqualTo(String value) {
            addCriterion("Factory_Addr <=", value, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrLike(String value) {
            addCriterion("Factory_Addr like", value, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrNotLike(String value) {
            addCriterion("Factory_Addr not like", value, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrIn(List<String> values) {
            addCriterion("Factory_Addr in", values, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrNotIn(List<String> values) {
            addCriterion("Factory_Addr not in", values, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrBetween(String value1, String value2) {
            addCriterion("Factory_Addr between", value1, value2, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAddrNotBetween(String value1, String value2) {
            addCriterion("Factory_Addr not between", value1, value2, "factoryAddr");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnIsNull() {
            addCriterion("Factory_Attn is null");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnIsNotNull() {
            addCriterion("Factory_Attn is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnEqualTo(String value) {
            addCriterion("Factory_Attn =", value, "factoryAttn");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnNotEqualTo(String value) {
            addCriterion("Factory_Attn <>", value, "factoryAttn");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnGreaterThan(String value) {
            addCriterion("Factory_Attn >", value, "factoryAttn");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnGreaterThanOrEqualTo(String value) {
            addCriterion("Factory_Attn >=", value, "factoryAttn");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnLessThan(String value) {
            addCriterion("Factory_Attn <", value, "factoryAttn");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnLessThanOrEqualTo(String value) {
            addCriterion("Factory_Attn <=", value, "factoryAttn");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnLike(String value) {
            addCriterion("Factory_Attn like", value, "factoryAttn");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnNotLike(String value) {
            addCriterion("Factory_Attn not like", value, "factoryAttn");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnIn(List<String> values) {
            addCriterion("Factory_Attn in", values, "factoryAttn");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnNotIn(List<String> values) {
            addCriterion("Factory_Attn not in", values, "factoryAttn");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnBetween(String value1, String value2) {
            addCriterion("Factory_Attn between", value1, value2, "factoryAttn");
            return (Criteria) this;
        }

        public Criteria andFactoryAttnNotBetween(String value1, String value2) {
            addCriterion("Factory_Attn not between", value1, value2, "factoryAttn");
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