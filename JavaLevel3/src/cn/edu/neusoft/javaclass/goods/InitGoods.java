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

        // 初始化computer数据
        List computerlist = new ArrayList();
        Supply computers1 = new Supply("联想天晴东方专卖店", "中国北京市", "010-87654321");
        Supply computers2 = new Supply("hp兴荣和专卖店", "中国辽宁大连市", "0411-81669801");
        Computer computer11 = new Computer("Lenovo/联想 YOGA710 -14ISK", 5699.00, computers1, "英特尔 酷睿 i5-7200U", "4G",
                "固态256G", "银色");
        Computer computer12 = new Computer("Lenovo/联想 YOGA 5 Pro yoga910", 9999.00, computers1, "英特尔 酷睿 i5-7200U", "8G",
                "固态512G", "酒红色");
        Computer computer21 = new Computer("HP/惠普 暗影精灵Ⅱ Pro", 5399.00, computers2, " 英特尔 酷睿 i5-7300HQ", "8G", "机械1TB",
                "黑色");
        Computer computer22 = new Computer("HP/惠普 Spectre Pro X360", 9399.00, computers2, "英特尔 酷睿 i5-7200U", "8G",
                "固态256G", "月光银");
        computerlist.add(computer11);
        computerlist.add(computer12);
        computerlist.add(computer21);
        computerlist.add(computer22);
        typelist.add(Computer.COMPUTER);
        m.put(Computer.COMPUTER, computerlist);

        // 初始化衣服数据
        List clothinglist = new ArrayList();
        Supply clothings1 = new Supply("阿迪达斯东城专卖店", "中国北京市", "010-87654321");
        Supply clothings2 = new Supply("耐克西城专卖店", "中国辽宁大连市", "0411-81669801");
        Clothing clothing11 = new Clothing("2017运动套装", 810, clothings1, "男装", "L-2XL", "黑色、白色");
        Clothing clothing12 = new Clothing("2017情侣套装", 990, clothings1, "情侣装", "（L-3XL & M-2XL）", "橘色、灰色");
        Clothing clothing21 = new Clothing("2017夏春运动休闲圆领短袖T恤", 480, clothings2, "男装", "（M-4XL）", "暗红色、黑色、深蓝色");
        Clothing clothing22 = new Clothing("2017夏季速干体恤半袖上衣运动T恤", 320, clothings2, "女装", "（S-3XL）", "橘色、绿色、玫红色");
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
