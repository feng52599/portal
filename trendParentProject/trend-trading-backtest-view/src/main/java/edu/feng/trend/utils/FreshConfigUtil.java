package edu.feng.trend.utils;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;

/**
 * @program: trendParentProject
 * @description: TODO
 * @author: feng
 * @create: 2020-05-13 09:21
 * @version: 1.0
 */
public class FreshConfigUtil {
    public static void main(String[] args) {
        HashMap<String, String> hearders = new HashMap<>();
        hearders.put("Content-Type", "application/json; charset=utf-8");
        System.out.println("因为要去git获取，还要刷新index-config-server, 会比较卡，所以一般会要好几秒才能完成，请耐心等待");
        String result = HttpUtil.createPost("http://localhost:8041/actuator/bus-refresh").addHeaders(hearders).execute().body();
        System.out.println("result:" + result);
        System.out.println("refresh完成");
    }
}