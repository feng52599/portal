package cn.edu.neusoft.example.purchase;

import cn.edu.neusoft.example.goods.Computer;
import cn.edu.neusoft.example.goods.Good;
import cn.edu.neusoft.example.goods.Graphics;
import cn.edu.neusoft.example.goods.Keyboard;

/**
 * 采购方法:提供完整的采购流程。
 * 如果指定采购的商品类，会随机出商品进行模拟使用。
 */
public class Purchase {

    public Good[][] good;

    Purchase() {
        Suppliers[] supplier = new Suppliers[5];

        // 创建二维数据g,方便下面使用
        good = new Good[3][];
        good[0] = new Keyboard[5];
        good[1] = new Computer[4];
        good[2] = new Graphics[4];

        // 随机初始化各个类的数据
        readS(supplier);
        readK(good[0], supplier);
        readC(good[1], supplier);
        readG(good[2], supplier);

        show("欢迎使用采购系统\n请按提示操作");
    }

    Purchase(Good[][] good) {
        this.good = good;
        show("欢迎使用采购系统\n请按提示操作");
    }

    public void select() {
        System.out.println("请输入需要购买的商品：");
        for (int i = 0; i < good.length; i++)
            System.out.println((i + 1) + "、" + good[i][0].name);
        try {
            int s = CInput.readInt() - 1;
            System.out.println("最便宜的型号：");
            int r = select(compare(good[s]));
            if (r != 0) {
                System.out.println();
                rank(good[s], r);
                select(good[s]);
            }
        } catch (Exception e) {
            System.out.println("\n请输入正确的序号！！\n");
            select();
        }
    }

    public void select(Good[] g) {
        System.out.println("请输入需要购买的商品：");
        for (int i = 0; i < g.length; i++)
            System.out.println((i + 1) + "、" + g[i].describe());
        try {
            int s = CInput.readInt() - 1;
            System.out.println("当前选择的是：");
            int r = select(g[s]);
            if (r != 0) {
                System.out.println();
                rank(g, r);
                select(g);
            }
        } catch (Exception e) {
            System.out.println("\n请输入正确的序号！！\n");
            select(g);
        }
    }

    public int select(Good g) {
        System.out.println(g.describe());
        System.out.println("1、购买");
        System.out.println("2、查看详细信息");
        System.out.println("3、查看全部商品（按价格升序）");
        System.out.println("4、查看全部商品（按价格降序）");

        int s = CInput.readInt("请输入您要进行的操作：");

        switch (s) {
            case 1:
                buy(g);
                break;
            case 2:
                show(g.toString());
                return select(g);
            case 3:
                return 1;
            case 4:
                return 2;
            default:
                System.out.println("\n请输入正确的序号！\n");
                return select(g);
        }
        return 1;
    }

    public void buy(Good g) {
        int n = CInput.readInt("请输入购买数量:");
        while (n <= 0) {
            System.out.println("\n请输入大于0的整数！\n");
            n = CInput.readInt("请输入购买数量:");
        }

        String s = "";
        s += g.describe() + "\n单价：" + g.price + "\t购买数量：" + n + "\n总计：" + g.price * n + "元！";
        show(s);
        System.out.println("采购成功，是否继续采购(Y/N)？");
        if (CInput.readString().equalsIgnoreCase("y"))
            select();
        else {
            show("谢谢使用！再见~");
            System.exit(0);
        }
    }

    // 价格比较。返回最便宜的商品
    public static Good compare(Good[] a) {
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].price < a[n].price)
                n = i;
        }
        return a[n];
    }

    // 价格排序。参数1代表从低到高，2代表从高到低
    public void rank(Good[] a, int order) {
        Good b;
        if (order == 1) {
            for (int i = 0; i < a.length; i++) {
                for (int o = i; o < a.length; o++) {
                    if (a[i].price > a[o].price) {
                        b = a[i];
                        a[i] = a[o];
                        a[o] = b;
                    }
                }
            }
        } else if (order == 2) {
            for (int i = 0; i < a.length; i++) {
                for (int o = i; o < a.length; o++) {
                    if (a[i].price < a[o].price) {
                        b = a[i];
                        a[i] = a[o];
                        a[o] = b;
                    }
                }
            }
        }
    }

    // 随机初始化供应商数据
    static void readS(Suppliers[] Supplier) {
        Supplier[0] = new Suppliers("HP", "大连", "84830000");
        Supplier[1] = new Suppliers("苹果", "美国", "84830001");
        Supplier[2] = new Suppliers("戴尔", "北京", "84830002");
        Supplier[3] = new Suppliers("联想", "北京", "84830003");
        Supplier[4] = new Suppliers("华硕", "台北", "84830004");
    }

    // 随机初始化键盘数据
    static void readK(Good[] Kbd, Suppliers[] suppliers) {
        String[] colours = {"黄色", "白色", "红色", "黑色", "蓝色", "绿色", "透明"};
        String[] types = {"防水型", "帅呆型", "商务型", "可爱型", "经济型"};
        for (int i = 0; i < Kbd.length; i++) {
            double price = dRandom(100) + 80;
            int number = iRandom(1000);
            String colour = colours[iRandom(7)];
            String type = types[iRandom(5)];
            Suppliers supplier = suppliers[iRandom(5)];
            Kbd[i] = new Keyboard(price, number, colour, type, supplier);
        }
    }

    // 随机初始化电脑数据
    static void readC(Good[] Com, Suppliers[] suppliers) {
        String[] colours = {"黄色", "白色", "红色", "黑色", "蓝色", "绿色", "透明"};
        String[] series = {"6930p", "Y450", "T400", "NW18", "同喜520"};
        String[] cpus = {"Core-i7", "Core-i5", "Core-i3", "AMD-5000+", "AMD-5000+超频版", "速龙-64", "龙芯3B", "赛扬4", "286"};
        for (int i = 0; i < Com.length; i++) {
            String cpu = cpus[iRandom(cpus.length)];
            String ram = (iRandom(8) + 2) / 2 + "GB";
            String hard_disk = (iRandom(7) * 80 + 80) + "GB";
            double price = dRandom(5000) + 5000;
            int number = iRandom(1000);
            String colour = colours[iRandom(7)];
            String serie = series[iRandom(5)];
            Suppliers supplier = suppliers[iRandom(5)];
            Com[i] = new Computer(cpu, ram, hard_disk, colour, serie, price, number, supplier);
        }
    }

    // 随机初始化显卡数据
    static void readG(Good[] Grp, Suppliers[] suppliers) {
        for (int i = 0; i < Grp.length; i++) {
            String monory_size = (iRandom(8) * 128 + 128) + "MB";
            double price = dRandom(500) + 499;
            int number = iRandom(1000);
            Suppliers supplier = suppliers[iRandom(5)];
            Grp[i] = new Graphics(monory_size, price, number, supplier);
        }

    }

    // 生成double类型的随机数，保留两位小数
    static double dRandom(int a) {
        double b = Math.random() * a;
        b = ((int) (b * 10)) / 10.0;
        return b;
    }

    // 生成int类型的随机数
    static int iRandom(int a) {
        return (int) (Math.random() * a);
    }

    // 显示带星号分割的文字
    void show(String s) {
        int l = s.length();
        if (l > 30)
            l = 30;
        s = "\n" + s + "\n";
        for (int i = 0; i < l * 2 - 1; i++) {
            s = "*" + s + "*";
        }
        System.out.println(s);
    }

}
