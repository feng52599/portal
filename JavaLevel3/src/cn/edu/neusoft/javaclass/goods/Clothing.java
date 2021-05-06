package cn.edu.neusoft.javaclass.goods;

import cn.edu.neusoft.javaclass.base.Goods;
import cn.edu.neusoft.javaclass.base.Supply;

public class Clothing extends Goods {
    public static final String CLOTHING = "�·�";
    public String name, sex, size, colour;

    public Clothing(String name, double price, Supply supply, String sex, String size, String colour) {
        super(CLOTHING, supply);
        this.name = name;
        super.price = price;
        this.sex = sex;
        this.size = size;
        this.colour = colour;
    }

    public String toString() {
        return super.toString() + "\n��Ʒ���ƣ�" + this.name + " �۸�" + this.price + "\n��Ʒ��Ϣ��\n" + "����:" + this.sex + "����ɫ:"
                + this.colour + "���ͺ�:" + this.size + super.supplydesc();
    }

}
