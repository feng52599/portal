package cn.edu.neusoft.javaclass.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        System.out.println("����������ʵ��");
        //����һ��������5����������
        int[] a = new int[5];
        //ѭ����0-4������ַ��뵽����[0]-[4]����ռ���
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        //ѭ��������[0]-[4]����ռ��������Ӧ������
        for (int j = 0; j < a.length; j++) {
            System.out.println(a[j]);
        }

        System.out.println("������list���Ϻ�ʵ��");
        //����һ��List���϶���Ϊ�˴��5����������
        List list = new ArrayList();
        //ѭ����0-4������ַ��뵽���ϵĿռ���
        for (int i = 0; i < list.size(); i++) {
            list.add(i);
        }
        //ѭ���Ӽ��ϵĿռ��������Ӧ���������
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
