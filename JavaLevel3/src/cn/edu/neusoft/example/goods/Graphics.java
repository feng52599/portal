package cn.edu.neusoft.example.goods;

import cn.edu.neusoft.example.purchase.Suppliers;

public class Graphics extends Good {
    public String menory_size;

    public Graphics(String menory_size, double price, int number, Suppliers Supplier) {
        super("显卡", price, number, Supplier);
        this.menory_size = menory_size;
    }

    public String describe() {
        return super.describe() + "-" + menory_size + "-" + price + "元";
    }

    public String toString() {
        return super.toString() + "\n显存：" + menory_size + "\n供应商信息\n" + Supplier;
    }

}
