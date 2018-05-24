package com.song.beantils;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class User implements Serializable {
    private Object name;
    private String password;
    private Long iid;
    private Integer lid;

    public Long getIid() {
        return iid;
    }

    public void setIid(Long iid) {
        this.iid = iid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
