package edu.feng.trend.pojo;

/**
 * @program: trendParentProject
 * @description: 放置指数代码 如指数名+指数代码
 * @author: feng
 * @create: 2020-05-10 18:31
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
