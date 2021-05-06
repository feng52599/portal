package cn.edu.neusoft.example.goods;

import cn.edu.neusoft.example.purchase.Suppliers;

public class Graphics extends Good {
    public String menory_size;

    public Graphics(String menory_size, double price, int number, Suppliers Supplier) {
        super("�Կ�", price, number, Supplier);
        this.menory_size = menory_size;
    }

    public String describe() {
        return super.describe() + "-" + menory_size + "-" + price + "Ԫ";
    }

    public String toString() {
        return super.toString() + "\n�Դ棺" + menory_size + "\n��Ӧ����Ϣ\n" + Supplier;
    }

}
