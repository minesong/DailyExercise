package com.song.list;

import com.alibaba.fastjson.JSON;
import com.beust.jcommander.internal.Maps;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by scx on 2019/5/31.
 */
public class ResponseApi implements Serializable {
    private Integer code;
    private Map<String, Object> body;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, Object> getBody() {
        return body == null ? Maps.newHashMap() : body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }

    public static void main(String[] args) throws IOException {
        ResponseApi api = new ResponseApi();
        String str = JSON.toJSONString(api);
        System.out.println(str);
    }
}
