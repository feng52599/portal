package cn.edu.neusoft.javaclass.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.neusoft.javaclass.base.Supply;

public class InitGoods {
    public static final String TYPENAME = "typename";

    public static Map init() {
        Map m = new HashMap();
        List typelist = new ArrayList();

        // ��ʼ��computer����
        List computerlist = new ArrayList();
        Supply computers1 = new Supply("�������綫��ר����", "�й�������", "010-87654321");
        Supply computers2 = new Supply("hp���ٺ�ר����", "�й�����������", "0411-81669801");
        Computer computer11 = new Computer("Lenovo/���� YOGA710 -14ISK", 5699.00, computers1, "Ӣ�ض� ��� i5-7200U", "4G",
                "��̬256G", "��ɫ");
        Computer computer12 = new Computer("Lenovo/���� YOGA 5 Pro yoga910", 9999.00, computers1, "Ӣ�ض� ��� i5-7200U", "8G",
                "��̬512G", "�ƺ�ɫ");
        Computer computer21 = new Computer("HP/���� ��Ӱ����� Pro", 5399.00, computers2, " Ӣ�ض� ��� i5-7300HQ", "8G", "��е1TB",
                "��ɫ");
        Computer computer22 = new Computer("HP/���� Spectre Pro X360", 9399.00, computers2, "Ӣ�ض� ��� i5-7200U", "8G",
                "��̬256G", "�¹���");
        computerlist.add(computer11);
        computerlist.add(computer12);
        computerlist.add(computer21);
        computerlist.add(computer22);
        typelist.add(Computer.COMPUTER);
        m.put(Computer.COMPUTER, computerlist);

        // ��ʼ���·�����
        List clothinglist = new ArrayList();
        Supply clothings1 = new Supply("���ϴ�˹����ר����", "�й�������", "010-87654321");
        Supply clothings2 = new Supply("�Ϳ�����ר����", "�й�����������", "0411-81669801");
        Clothing clothing11 = new Clothing("2017�˶���װ", 810, clothings1, "��װ", "L-2XL", "��ɫ����ɫ");
        Clothing clothing12 = new Clothing("2017������װ", 990, clothings1, "����װ", "��L-3XL & M-2XL��", "��ɫ����ɫ");
        Clothing clothing21 = new Clothing("2017�Ĵ��˶�����Բ�����T��", 480, clothings2, "��װ", "��M-4XL��", "����ɫ����ɫ������ɫ");
        Clothing clothing22 = new Clothing("2017�ļ��ٸ��������������˶�T��", 320, clothings2, "Ůװ", "��S-3XL��", "��ɫ����ɫ��õ��ɫ");
        clothinglist.add(clothing11);
        clothinglist.add(clothing12);
        clothinglist.add(clothing21);
        clothinglist.add(clothing22);
        typelist.add(Clothing.CLOTHING);
        m.put(Clothing.CLOTHING, clothinglist);

        m.put(TYPENAME, typelist);
        return m;
    }

}
