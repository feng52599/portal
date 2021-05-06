package cn.edu.neusoft.javaclass.base;

public class Goods {

    public String goodstype;
    public double price;
    public Supply supply;

    public Goods(String goodstype, Supply supply) {
        this.goodstype = goodstype;
        this.supply = supply;
    }

    // 商品基本信息
    public String toString() {
        return "商品种类：" + this.goodstype;
    }

    // 供应商信息
    public String supplydesc() {
        supply = new Supply(supply.supplier, supply.address, supply.telephone);
        return supply.toString();
    }

}
