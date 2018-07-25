package com.song.abstracttest;

/**
 * @author songchengxiang<songchengxiang @ corp.netease.com>
 * @Title: Parents
 * @Description: TODO
 * @date 2018/7/18
 */
public abstract class Parents extends GrandParents {
    @Override
    public void getName() {
        System.out.println("Parents:getName");
    }

    @Override
    public void getAge() {
        System.out.println("Parents:getAge");
    }

}
