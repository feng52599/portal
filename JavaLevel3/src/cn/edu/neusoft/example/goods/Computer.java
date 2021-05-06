package cn.edu.neusoft.example.goods;

import cn.edu.neusoft.example.purchase.Suppliers;

public class Computer extends Good {

    public String cpu, ram, hard_disk, colour, series;

    public Computer(String cpu, String ram, String hard_disk, String colour, String series, double price, int number,
                    Suppliers Supplier) {
        super("����", price, number, Supplier);
        this.cpu = cpu;
        this.ram = ram;
        this.hard_disk = hard_disk;
        this.colour = colour;
        this.series = series;
    }

    public String describe() {
        return super.describe() + "-" + series + "-" + price + "Ԫ" + "-" + colour;
    }

    public String toString() {
        return super.toString() + "\n�������ͺţ�" + cpu + "\n�ڴ棺" + ram + "\nӲ�̣�" + hard_disk + "\n��Ʒ�ͺţ�" + series + "\n��ɫ��"
                + colour + "\n��Ӧ����Ϣ\n" + Supplier;
    }
}
