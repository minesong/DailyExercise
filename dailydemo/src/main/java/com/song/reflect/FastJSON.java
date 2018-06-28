package com.song.reflect;

import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by songchengxiang on 2018/5/30.
 */
public class FastJSON {
    public static void main(String[] args) {
        FastJSON fastJSON = new FastJSON();
        fastJSON.setSong("s");
        fastJSON.setCheng(123);
        List<Parent> parents = new ArrayList<>();
        Parent parent = new Parent();
        parent.setPname("pname");
        parent.setPid(666);
        parents.add(parent);
        parents.add(parent);
        fastJSON.setParentList(parents);
        String json = JSON.toJSONString(fastJSON);
        System.out.println(json);
        JSONObject jsonObject = JSON.parseObject(json);
        FastJSON fastJSON1 = JSON.parseObject(json, FastJSON.class);
        System.out.println();
    }
    private String song;
    private Integer cheng;
    private List<Parent> parentList;

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Integer getCheng() {
        return cheng;
    }

    public void setCheng(Integer cheng) {
        this.cheng = cheng;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }
}
