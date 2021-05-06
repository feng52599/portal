package edu.feng.trend.pojo;

/**
 * @program: trendParentProject
 * @description: TODO
 * @author: feng
 * @create: 2020-05-12 16:42
 * @version: 1.0
 */
public class Trade {
    private String buyDate;
    private String sellDate;
    private float buyClosePoint;
    private float sellClosePoint;
    private float rate;

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getSellDate() {
        return sellDate;
    }

    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    public float getBuyClosePoint() {
        return buyClosePoint;
    }

    public void setBuyClosePoint(float buyClosePoint) {
        this.buyClosePoint = buyClosePoint;
    }

    public float getSellClosePoint() {
        return sellClosePoint;
    }

    public void setSellClosePoint(float sellClosePoint) {
        this.sellClosePoint = sellClosePoint;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}