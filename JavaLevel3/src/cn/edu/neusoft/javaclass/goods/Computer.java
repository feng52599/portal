package cn.edu.neusoft.javaclass.goods;

import cn.edu.neusoft.javaclass.base.Goods;
import cn.edu.neusoft.javaclass.base.Supply;

public class Computer extends Goods {
    public static final String COMPUTER = "电脑";
    public String name, cpu, ram, hard_disk, colour;

    public Computer(String name, double price, Supply supply, String cpu, String ram, String hard_disk,
                    String colour) {
        super(COMPUTER, supply);
        this.name = name;
        super.price = price;
        this.cpu = cpu;
        this.ram = ram;
        this.hard_disk = hard_disk;
        this.colour = colour;
    }


    public String toString() {
        return super.toString()
                + "\n产品名称：" + this.name
                + " 价格：" + this.price
                + "\n产品信息：\n" + "CPU:"
                + this.cpu + "，内存:"
                + this.ram + "，硬盘:" + this.hard_disk
                + "，颜色:" + this.colour
                + super.supplydesc();
    }

}
