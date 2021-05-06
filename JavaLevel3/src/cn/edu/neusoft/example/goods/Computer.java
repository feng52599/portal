package cn.edu.neusoft.example.goods;

import cn.edu.neusoft.example.purchase.Suppliers;

public class Computer extends Good {

    public String cpu, ram, hard_disk, colour, series;

    public Computer(String cpu, String ram, String hard_disk, String colour, String series, double price, int number,
                    Suppliers Supplier) {
        super("电脑", price, number, Supplier);
        this.cpu = cpu;
        this.ram = ram;
        this.hard_disk = hard_disk;
        this.colour = colour;
        this.series = series;
    }

    public String describe() {
        return super.describe() + "-" + series + "-" + price + "元" + "-" + colour;
    }

    public String toString() {
        return super.toString() + "\n处理器型号：" + cpu + "\n内存：" + ram + "\n硬盘：" + hard_disk + "\n产品型号：" + series + "\n颜色："
                + colour + "\n供应商信息\n" + Supplier;
    }
}
