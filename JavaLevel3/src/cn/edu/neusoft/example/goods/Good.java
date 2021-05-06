package cn.edu.neusoft.example.goods;

import cn.edu.neusoft.example.purchase.Suppliers;

public class Good {
    public String name;
    public double price;
    public int number;
    public Suppliers Supplier;

    public Good(String name, double price, int number, Suppliers Supplier) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.Supplier = Supplier;
    }

    public String describe() {
        return Supplier.name;
    }

    public String toString() {
        return "产品名称：" + name + "\n产品价格：" + price + "\n库存数量：" + number;
    }

}
