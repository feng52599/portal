package cn.edu.neusoft.example.purchase;

import cn.edu.neusoft.example.goods.Computer;
import cn.edu.neusoft.example.goods.Good;
import cn.edu.neusoft.example.goods.Graphics;
import cn.edu.neusoft.example.goods.Keyboard;

/**
 * �ɹ�����:�ṩ�����Ĳɹ����̡�
 * ���ָ���ɹ�����Ʒ�࣬���������Ʒ����ģ��ʹ�á�
 */
public class Purchase {

    public Good[][] good;

    Purchase() {
        Suppliers[] supplier = new Suppliers[5];

        // ������ά����g,��������ʹ��
        good = new Good[3][];
        good[0] = new Keyboard[5];
        good[1] = new Computer[4];
        good[2] = new Graphics[4];

        // �����ʼ�������������
        readS(supplier);
        readK(good[0], supplier);
        readC(good[1], supplier);
        readG(good[2], supplier);

        show("��ӭʹ�òɹ�ϵͳ\n�밴��ʾ����");
    }

    Purchase(Good[][] good) {
        this.good = good;
        show("��ӭʹ�òɹ�ϵͳ\n�밴��ʾ����");
    }

    public void select() {
        System.out.println("��������Ҫ�������Ʒ��");
        for (int i = 0; i < good.length; i++)
            System.out.println((i + 1) + "��" + good[i][0].name);
        try {
            int s = CInput.readInt() - 1;
            System.out.println("����˵��ͺţ�");
            int r = select(compare(good[s]));
            if (r != 0) {
                System.out.println();
                rank(good[s], r);
                select(good[s]);
            }
        } catch (Exception e) {
            System.out.println("\n��������ȷ����ţ���\n");
            select();
        }
    }

    public void select(Good[] g) {
        System.out.println("��������Ҫ�������Ʒ��");
        for (int i = 0; i < g.length; i++)
            System.out.println((i + 1) + "��" + g[i].describe());
        try {
            int s = CInput.readInt() - 1;
            System.out.println("��ǰѡ����ǣ�");
            int r = select(g[s]);
            if (r != 0) {
                System.out.println();
                rank(g, r);
                select(g);
            }
        } catch (Exception e) {
            System.out.println("\n��������ȷ����ţ���\n");
            select(g);
        }
    }

    public int select(Good g) {
        System.out.println(g.describe());
        System.out.println("1������");
        System.out.println("2���鿴��ϸ��Ϣ");
        System.out.println("3���鿴ȫ����Ʒ�����۸�����");
        System.out.println("4���鿴ȫ����Ʒ�����۸���");

        int s = CInput.readInt("��������Ҫ���еĲ�����");

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
                System.out.println("\n��������ȷ����ţ�\n");
                return select(g);
        }
        return 1;
    }

    public void buy(Good g) {
        int n = CInput.readInt("�����빺������:");
        while (n <= 0) {
            System.out.println("\n���������0��������\n");
            n = CInput.readInt("�����빺������:");
        }

        String s = "";
        s += g.describe() + "\n���ۣ�" + g.price + "\t����������" + n + "\n�ܼƣ�" + g.price * n + "Ԫ��";
        show(s);
        System.out.println("�ɹ��ɹ����Ƿ�����ɹ�(Y/N)��");
        if (CInput.readString().equalsIgnoreCase("y"))
            select();
        else {
            show("ллʹ�ã��ټ�~");
            System.exit(0);
        }
    }

    // �۸�Ƚϡ���������˵���Ʒ
    public static Good compare(Good[] a) {
        int n = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i].price < a[n].price)
                n = i;
        }
        return a[n];
    }

    // �۸����򡣲���1����ӵ͵��ߣ�2����Ӹߵ���
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

    // �����ʼ����Ӧ������
    static void readS(Suppliers[] Supplier) {
        Supplier[0] = new Suppliers("HP", "����", "84830000");
        Supplier[1] = new Suppliers("ƻ��", "����", "84830001");
        Supplier[2] = new Suppliers("����", "����", "84830002");
        Supplier[3] = new Suppliers("����", "����", "84830003");
        Supplier[4] = new Suppliers("��˶", "̨��", "84830004");
    }

    // �����ʼ����������
    static void readK(Good[] Kbd, Suppliers[] suppliers) {
        String[] colours = {"��ɫ", "��ɫ", "��ɫ", "��ɫ", "��ɫ", "��ɫ", "͸��"};
        String[] types = {"��ˮ��", "˧����", "������", "�ɰ���", "������"};
        for (int i = 0; i < Kbd.length; i++) {
            double price = dRandom(100) + 80;
            int number = iRandom(1000);
            String colour = colours[iRandom(7)];
            String type = types[iRandom(5)];
            Suppliers supplier = suppliers[iRandom(5)];
            Kbd[i] = new Keyboard(price, number, colour, type, supplier);
        }
    }

    // �����ʼ����������
    static void readC(Good[] Com, Suppliers[] suppliers) {
        String[] colours = {"��ɫ", "��ɫ", "��ɫ", "��ɫ", "��ɫ", "��ɫ", "͸��"};
        String[] series = {"6930p", "Y450", "T400", "NW18", "ͬϲ520"};
        String[] cpus = {"Core-i7", "Core-i5", "Core-i3", "AMD-5000+", "AMD-5000+��Ƶ��", "����-64", "��о3B", "����4", "286"};
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

    // �����ʼ���Կ�����
    static void readG(Good[] Grp, Suppliers[] suppliers) {
        for (int i = 0; i < Grp.length; i++) {
            String monory_size = (iRandom(8) * 128 + 128) + "MB";
            double price = dRandom(500) + 499;
            int number = iRandom(1000);
            Suppliers supplier = suppliers[iRandom(5)];
            Grp[i] = new Graphics(monory_size, price, number, supplier);
        }

    }

    // ����double���͵��������������λС��
    static double dRandom(int a) {
        double b = Math.random() * a;
        b = ((int) (b * 10)) / 10.0;
        return b;
    }

    // ����int���͵������
    static int iRandom(int a) {
        return (int) (Math.random() * a);
    }

    // ��ʾ���Ǻŷָ������
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
