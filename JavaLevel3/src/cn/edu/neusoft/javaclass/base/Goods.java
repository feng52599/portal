package cn.edu.neusoft.javaclass.base;

public class Goods {

    public String goodstype;
    public double price;
    public Supply supply;

    public Goods(String goodstype, Supply supply) {
        this.goodstype = goodstype;
        this.supply = supply;
    }

    // ��Ʒ������Ϣ
    public String toString() {
        return "��Ʒ���ࣺ" + this.goodstype;
    }

    // ��Ӧ����Ϣ
    public String supplydesc() {
        supply = new Supply(supply.supplier, supply.address, supply.telephone);
        return supply.toString();
    }

}
