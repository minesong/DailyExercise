package com.song.reflect;

public class Parent {
    private Integer pid;
    protected String pname;
    public String ppassword;
    String pemail ="123";
    public void see(){
        System.out.println("parent");
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPpassword() {
        return ppassword;
    }

    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }
    public void test() {
        System.out.println(pemail);
    }
}
