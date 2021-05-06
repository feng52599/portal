package cn.edu.neusoft.javaclass.goods;

import cn.edu.neusoft.javaclass.base.Goods;
import cn.edu.neusoft.javaclass.base.Supply;

public class Clothing extends Goods {
    public static final String CLOTHING = "衣服";
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
        return super.toString() + "\n产品名称：" + this.name + " 价格：" + this.price + "\n产品信息：\n" + "类型:" + this.sex + "，颜色:"
                + this.colour + "，型号:" + this.size + super.supplydesc();
    }

}
