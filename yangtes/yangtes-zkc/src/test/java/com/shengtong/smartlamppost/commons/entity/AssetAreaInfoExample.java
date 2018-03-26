package com.shengtong.smartlamppost.commons.entity;

import java.util.ArrayList;
import java.util.List;

public class AssetAreaInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssetAreaInfoExample() {
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

        public Criteria andAreaPidIsNull() {
            addCriterion("Area_Pid is null");
            return (Criteria) this;
        }

        public Criteria andAreaPidIsNotNull() {
            addCriterion("Area_Pid is not null");
            return (Criteria) this;
        }

        public Criteria andAreaPidEqualTo(Integer value) {
            addCriterion("Area_Pid =", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidNotEqualTo(Integer value) {
            addCriterion("Area_Pid <>", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidGreaterThan(Integer value) {
            addCriterion("Area_Pid >", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("Area_Pid >=", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidLessThan(Integer value) {
            addCriterion("Area_Pid <", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidLessThanOrEqualTo(Integer value) {
            addCriterion("Area_Pid <=", value, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidIn(List<Integer> values) {
            addCriterion("Area_Pid in", values, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidNotIn(List<Integer> values) {
            addCriterion("Area_Pid not in", values, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidBetween(Integer value1, Integer value2) {
            addCriterion("Area_Pid between", value1, value2, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaPidNotBetween(Integer value1, Integer value2) {
            addCriterion("Area_Pid not between", value1, value2, "areaPid");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("Area_Code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("Area_Code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("Area_Code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("Area_Code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("Area_Code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Area_Code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("Area_Code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("Area_Code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("Area_Code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("Area_Code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("Area_Code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("Area_Code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("Area_Code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("Area_Code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameIsNull() {
            addCriterion("Area_Shortname is null");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameIsNotNull() {
            addCriterion("Area_Shortname is not null");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameEqualTo(String value) {
            addCriterion("Area_Shortname =", value, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameNotEqualTo(String value) {
            addCriterion("Area_Shortname <>", value, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameGreaterThan(String value) {
            addCriterion("Area_Shortname >", value, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameGreaterThanOrEqualTo(String value) {
            addCriterion("Area_Shortname >=", value, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameLessThan(String value) {
            addCriterion("Area_Shortname <", value, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameLessThanOrEqualTo(String value) {
            addCriterion("Area_Shortname <=", value, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameLike(String value) {
            addCriterion("Area_Shortname like", value, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameNotLike(String value) {
            addCriterion("Area_Shortname not like", value, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameIn(List<String> values) {
            addCriterion("Area_Shortname in", values, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameNotIn(List<String> values) {
            addCriterion("Area_Shortname not in", values, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameBetween(String value1, String value2) {
            addCriterion("Area_Shortname between", value1, value2, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaShortnameNotBetween(String value1, String value2) {
            addCriterion("Area_Shortname not between", value1, value2, "areaShortname");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNull() {
            addCriterion("Area_Name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("Area_Name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("Area_Name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("Area_Name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("Area_Name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("Area_Name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("Area_Name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("Area_Name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("Area_Name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("Area_Name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("Area_Name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("Area_Name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("Area_Name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("Area_Name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameIsNull() {
            addCriterion("Area_MergerName is null");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameIsNotNull() {
            addCriterion("Area_MergerName is not null");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameEqualTo(String value) {
            addCriterion("Area_MergerName =", value, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameNotEqualTo(String value) {
            addCriterion("Area_MergerName <>", value, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameGreaterThan(String value) {
            addCriterion("Area_MergerName >", value, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameGreaterThanOrEqualTo(String value) {
            addCriterion("Area_MergerName >=", value, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameLessThan(String value) {
            addCriterion("Area_MergerName <", value, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameLessThanOrEqualTo(String value) {
            addCriterion("Area_MergerName <=", value, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameLike(String value) {
            addCriterion("Area_MergerName like", value, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameNotLike(String value) {
            addCriterion("Area_MergerName not like", value, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameIn(List<String> values) {
            addCriterion("Area_MergerName in", values, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameNotIn(List<String> values) {
            addCriterion("Area_MergerName not in", values, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameBetween(String value1, String value2) {
            addCriterion("Area_MergerName between", value1, value2, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andAreaMergernameNotBetween(String value1, String value2) {
            addCriterion("Area_MergerName not between", value1, value2, "areaMergername");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("Level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("Level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Byte value) {
            addCriterion("Level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Byte value) {
            addCriterion("Level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Byte value) {
            addCriterion("Level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("Level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Byte value) {
            addCriterion("Level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Byte value) {
            addCriterion("Level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Byte> values) {
            addCriterion("Level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Byte> values) {
            addCriterion("Level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Byte value1, Byte value2) {
            addCriterion("Level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("Level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNull() {
            addCriterion("PinYin is null");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNotNull() {
            addCriterion("PinYin is not null");
            return (Criteria) this;
        }

        public Criteria andPinyinEqualTo(String value) {
            addCriterion("PinYin =", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotEqualTo(String value) {
            addCriterion("PinYin <>", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThan(String value) {
            addCriterion("PinYin >", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("PinYin >=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThan(String value) {
            addCriterion("PinYin <", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThanOrEqualTo(String value) {
            addCriterion("PinYin <=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLike(String value) {
            addCriterion("PinYin like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotLike(String value) {
            addCriterion("PinYin not like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinIn(List<String> values) {
            addCriterion("PinYin in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotIn(List<String> values) {
            addCriterion("PinYin not in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinBetween(String value1, String value2) {
            addCriterion("PinYin between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotBetween(String value1, String value2) {
            addCriterion("PinYin not between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeIsNull() {
            addCriterion("Telephone_Code is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeIsNotNull() {
            addCriterion("Telephone_Code is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeEqualTo(String value) {
            addCriterion("Telephone_Code =", value, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeNotEqualTo(String value) {
            addCriterion("Telephone_Code <>", value, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeGreaterThan(String value) {
            addCriterion("Telephone_Code >", value, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeGreaterThanOrEqualTo(String value) {
            addCriterion("Telephone_Code >=", value, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeLessThan(String value) {
            addCriterion("Telephone_Code <", value, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeLessThanOrEqualTo(String value) {
            addCriterion("Telephone_Code <=", value, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeLike(String value) {
            addCriterion("Telephone_Code like", value, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeNotLike(String value) {
            addCriterion("Telephone_Code not like", value, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeIn(List<String> values) {
            addCriterion("Telephone_Code in", values, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeNotIn(List<String> values) {
            addCriterion("Telephone_Code not in", values, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeBetween(String value1, String value2) {
            addCriterion("Telephone_Code between", value1, value2, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andTelephoneCodeNotBetween(String value1, String value2) {
            addCriterion("Telephone_Code not between", value1, value2, "telephoneCode");
            return (Criteria) this;
        }

        public Criteria andFirstWordIsNull() {
            addCriterion("First_Word is null");
            return (Criteria) this;
        }

        public Criteria andFirstWordIsNotNull() {
            addCriterion("First_Word is not null");
            return (Criteria) this;
        }

        public Criteria andFirstWordEqualTo(String value) {
            addCriterion("First_Word =", value, "firstWord");
            return (Criteria) this;
        }

        public Criteria andFirstWordNotEqualTo(String value) {
            addCriterion("First_Word <>", value, "firstWord");
            return (Criteria) this;
        }

        public Criteria andFirstWordGreaterThan(String value) {
            addCriterion("First_Word >", value, "firstWord");
            return (Criteria) this;
        }

        public Criteria andFirstWordGreaterThanOrEqualTo(String value) {
            addCriterion("First_Word >=", value, "firstWord");
            return (Criteria) this;
        }

        public Criteria andFirstWordLessThan(String value) {
            addCriterion("First_Word <", value, "firstWord");
            return (Criteria) this;
        }

        public Criteria andFirstWordLessThanOrEqualTo(String value) {
            addCriterion("First_Word <=", value, "firstWord");
            return (Criteria) this;
        }

        public Criteria andFirstWordLike(String value) {
            addCriterion("First_Word like", value, "firstWord");
            return (Criteria) this;
        }

        public Criteria andFirstWordNotLike(String value) {
            addCriterion("First_Word not like", value, "firstWord");
            return (Criteria) this;
        }

        public Criteria andFirstWordIn(List<String> values) {
            addCriterion("First_Word in", values, "firstWord");
            return (Criteria) this;
        }

        public Criteria andFirstWordNotIn(List<String> values) {
            addCriterion("First_Word not in", values, "firstWord");
            return (Criteria) this;
        }

        public Criteria andFirstWordBetween(String value1, String value2) {
            addCriterion("First_Word between", value1, value2, "firstWord");
            return (Criteria) this;
        }

        public Criteria andFirstWordNotBetween(String value1, String value2) {
            addCriterion("First_Word not between", value1, value2, "firstWord");
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