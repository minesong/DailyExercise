package com.song.abstracttest;

/**
 * @author songchengxiang<songchengxiang @ corp.netease.com>
 * @Title: Son
 * @Description: TODO
 * @date 2018/7/18
 */
public class Son extends Parents{
    public static void main(String[] args) {
        Son son =  new Son();
        son.getAge();
        son.getBirth();
        son.getName();
        son.getWherr();
        System.out.println("------------------");
        GrandParents g = new Son();
        g.getAge();
        g.getBirth();
        g.getName();
        g.getWherr();
    }
    @Override
    public void getBirth() {
        System.out.println("Son:getBirth");
    }
    @Override
    public void getAge() {
        System.out.println("Son:getAge");
    }
}
