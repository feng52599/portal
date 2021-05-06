package edu.feng.trend.pojo;

/**
 * @program: trendParentProject
 * @description: 指数数据
 * @author: feng
 * @create: 2020-05-10 22:48
 * @version: 1.0
 */


public class IndexData {
    String date;
    float closePoint;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getClosePoint() {
        return closePoint;
    }

    public void setClosePoint(float closePoint) {
        this.closePoint = closePoint;
    }
}