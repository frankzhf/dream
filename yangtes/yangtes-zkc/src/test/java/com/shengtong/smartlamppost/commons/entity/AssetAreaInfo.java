package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;

public class AssetAreaInfo implements Serializable {
    private Integer areaId;

    private Integer areaPid;

    private String areaCode;

    private String areaShortname;

    private String areaName;

    private String areaMergername;

    private Byte level;

    private String pinyin;

    private String telephoneCode;

    private String firstWord;

    private String gisPosX;

    private String gisPosY;

    private String supplement;

    private static final long serialVersionUID = 1L;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getAreaPid() {
        return areaPid;
    }

    public void setAreaPid(Integer areaPid) {
        this.areaPid = areaPid;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaShortname() {
        return areaShortname;
    }

    public void setAreaShortname(String areaShortname) {
        this.areaShortname = areaShortname == null ? null : areaShortname.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaMergername() {
        return areaMergername;
    }

    public void setAreaMergername(String areaMergername) {
        this.areaMergername = areaMergername == null ? null : areaMergername.trim();
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getTelephoneCode() {
        return telephoneCode;
    }

    public void setTelephoneCode(String telephoneCode) {
        this.telephoneCode = telephoneCode == null ? null : telephoneCode.trim();
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord == null ? null : firstWord.trim();
    }

    public String getGisPosX() {
        return gisPosX;
    }

    public void setGisPosX(String gisPosX) {
        this.gisPosX = gisPosX == null ? null : gisPosX.trim();
    }

    public String getGisPosY() {
        return gisPosY;
    }

    public void setGisPosY(String gisPosY) {
        this.gisPosY = gisPosY == null ? null : gisPosY.trim();
    }

    public String getSupplement() {
        return supplement;
    }

    public void setSupplement(String supplement) {
        this.supplement = supplement == null ? null : supplement.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", areaId=").append(areaId);
        sb.append(", areaPid=").append(areaPid);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", areaShortname=").append(areaShortname);
        sb.append(", areaName=").append(areaName);
        sb.append(", areaMergername=").append(areaMergername);
        sb.append(", level=").append(level);
        sb.append(", pinyin=").append(pinyin);
        sb.append(", telephoneCode=").append(telephoneCode);
        sb.append(", firstWord=").append(firstWord);
        sb.append(", gisPosX=").append(gisPosX);
        sb.append(", gisPosY=").append(gisPosY);
        sb.append(", supplement=").append(supplement);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}