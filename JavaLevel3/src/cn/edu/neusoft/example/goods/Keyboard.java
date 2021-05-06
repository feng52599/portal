package cn.edu.neusoft.example.goods;

import cn.edu.neusoft.example.purchase.Suppliers;

public class Keyboard extends Good {
    public String colour, type;

    public Keyboard(double price, int number, String colour, String type, Suppliers Supplier) {
        super("����", price, number, Supplier);
        this.colour = colour;
        this.type = type;

    }

    public String describe() {
        return super.describe() + "-" + type + "-" + price + "Ԫ" + "-" + colour;
    }

    public String toString() {
        return super.toString() + "\n��ɫ��" + colour + "\n���ͣ�" + type + "\n��Ӧ����Ϣ\n" + Supplier;
    }

}
