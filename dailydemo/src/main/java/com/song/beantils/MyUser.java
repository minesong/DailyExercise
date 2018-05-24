package com.song.beantils;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

//在分布式环境下，当进行远程通信时，无论是何种类型的数据，都会以二进制的形式在网络上进行传送。序列化是一种将对象，以一连串的字节描述的过程，用于解决在对对象流进行读写时所引发的问题。
public class MyUser implements Serializable{
    private String name;
    private String password;
    private Integer iid;
    private Long lid;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}

