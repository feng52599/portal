package cn.edu.neusoft.javaclass.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        System.out.println("以下是数组实现");
        //创建一个数组存放5个整型数字
        int[] a = new int[5];
        //循环把0-4五个数字放入到数组[0]-[4]五个空间里
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        //循环从数组[0]-[4]五个空间里，读出相应的数字
        for (int j = 0; j < a.length; j++) {
            System.out.println(a[j]);
        }

        System.out.println("以下是list集合合实现");
        //创建一个List集合对象，为了存放5个整型数字
        List list = new ArrayList();
        //循环把0-4五个数字放入到集合的空间里
        for (int i = 0; i < list.size(); i++) {
            list.add(i);
        }
        //循环从集合的空间里，读出相应的五个数字
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
