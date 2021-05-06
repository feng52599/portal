package cn.edu.neusoft.javaclass.purchase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.neusoft.javaclass.base.CInput;
import cn.edu.neusoft.javaclass.base.Goods;
import cn.edu.neusoft.javaclass.goods.InitGoods;

public class Purchase {

    public Map m = new HashMap();
    public List typelist = new ArrayList();
    public static final String DESC = "desc";
    public static final String ASC = "asc";
    public List goodslist = new ArrayList();

    public Purchase() {
        m = InitGoods.init();
        typelist = (List) m.get(InitGoods.TYPENAME);
        show("��ӭʹ�òɹ�ϵͳ\n�밴��ʾ����");
    }

    // ����ϵͳ��ӭ����
    public void show(String s) {
        int l = s.length();
        if (l > 30)
            l = 30;
        s = "\n" + s + "\n";
        for (int i = 0; i < l * 2 - 1; i++) {
            s = "*" + s + "*";
        }
        System.out.println(s);
    }

    // ����ָ���ʾ
    public void show() {
        String s = "";
        for (int i = 0; i < 30; i++) {
            s = "*" + s;
        }
        System.out.println(s);
    }

    public void dowith() {

        System.out.println("��Ʒ�������£�");
        for (int i = 0; i < typelist.size(); i++) {
            System.out.println((i + 1) + "��" + typelist.get(i));
            goodslist.add(i, (List) m.get(typelist.get(i)));
        }

        try {
            show();
            int type = CInput.readInt("��ѡ����Ʒ���ࣺ") - 1;
            selecttype(type);
            display(type);
        } catch (Exception e) {
            System.out.println("\n��������ȷ����ţ���\n");
            dowith();
        }
    }

    public void selecttype(int type) {
        if (type > goodslist.size() - 1 || type < 0) {
            System.out.println("\n��������ȷ����ţ���\n");
            dowith();
        } else {
            List list = new ArrayList();
            list = (List) goodslist.get(type);
            for (int i = 0; i < list.size(); i++) {
                System.out.println("��Ʒ������ţ�" + (i + 1));
                System.out.println(list.get(i));
                show();
            }
        }
    }

    public void display(int type) {
        int s = CInput.readInt("��������Ʒ�������:") - 1;
        dowith(s, type);
    }

    public void dowith(int s, int type) {
        buy((List) goodslist.get(type), s, type);
    }

    public void buy(List list, int i, int type) {
        int n = CInput.readInt("�����빺������:");
        while (n <= 0) {
            System.out.println("\n���������0��������\n");
            n = CInput.readInt("�����빺������:");
        }
        Goods g = (Goods) list.get(i);
        System.out.println("������Ʒ��ϸ��Ϣ���£�");
        show();
        System.out.println(list.get(i));
        System.out.println("�ܼ۸�" + (g.price * n) + ",��������" + n);
        System.out.println();

        System.out.println("�ɹ��ɹ����Ƿ�����ɹ�(Y/N)��");
        if (CInput.readString().equalsIgnoreCase("y"))
            selecttype(type);
        else {
            show("ллʹ�ã��ټ�~");
            System.exit(0);
        }
    }


}
