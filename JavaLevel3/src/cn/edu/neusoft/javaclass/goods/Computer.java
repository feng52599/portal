package cn.edu.neusoft.javaclass.goods;

import cn.edu.neusoft.javaclass.base.Goods;
import cn.edu.neusoft.javaclass.base.Supply;

public class Computer extends Goods {
    public static final String COMPUTER = "����";
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
                + "\n��Ʒ���ƣ�" + this.name
                + " �۸�" + this.price
                + "\n��Ʒ��Ϣ��\n" + "CPU:"
                + this.cpu + "���ڴ�:"
                + this.ram + "��Ӳ��:" + this.hard_disk
                + "����ɫ:" + this.colour
                + super.supplydesc();
    }

}
