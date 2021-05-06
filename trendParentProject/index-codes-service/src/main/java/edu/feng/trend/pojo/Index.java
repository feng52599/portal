package edu.feng.trend.pojo;

import java.io.Serializable;

/**
 * @program: trendParentProject
 * @description: 放置指数代码 如指数名+指数代码
 * @author: feng
 * @create: 2020-05-10 18:31
 */
public class Index implements Serializable {
    String code;
    String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}