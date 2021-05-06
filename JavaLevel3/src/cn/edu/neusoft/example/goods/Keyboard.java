package cn.edu.neusoft.example.goods;

import cn.edu.neusoft.example.purchase.Suppliers;

public class Keyboard extends Good {
    public String colour, type;

    public Keyboard(double price, int number, String colour, String type, Suppliers Supplier) {
        super("键盘", price, number, Supplier);
        this.colour = colour;
        this.type = type;

    }

    public String describe() {
        return super.describe() + "-" + type + "-" + price + "元" + "-" + colour;
    }

    public String toString() {
        return super.toString() + "\n颜色：" + colour + "\n类型：" + type + "\n供应商信息\n" + Supplier;
    }

}
