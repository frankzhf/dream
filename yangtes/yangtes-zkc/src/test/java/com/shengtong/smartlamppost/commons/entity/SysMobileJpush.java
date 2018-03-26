package com.shengtong.smartlamppost.commons.entity;

import java.io.Serializable;

public class SysMobileJpush implements Serializable {
    private String userId;

    private String jpushAlias;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getJpushAlias() {
        return jpushAlias;
    }

    public void setJpushAlias(String jpushAlias) {
        this.jpushAlias = jpushAlias == null ? null : jpushAlias.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", jpushAlias=").append(jpushAlias);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}