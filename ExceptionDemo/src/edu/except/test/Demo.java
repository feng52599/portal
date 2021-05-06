package edu.except.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: shopping
 * @description: TODO
 * @author: feng
 * @create: 2020-06-10 23:22
 * @version: 1.0
 */
public class Demo {
    public static void main(String[] args) {
        int[] array = new int[3];
        System.out.println("请输入三角形的三条边");
        Scanner in = new Scanner(System.in);
        try {
            for (int i = 0; i < 3; i++) {
                if (in.hasNextInt())
                    array[i] = in.nextInt();
            }
            Arrays.sort(array);
            Triangle triangle = new Triangle(array[0], array[1], array[2]);
            System.out.println("side1 = " + triangle.getSide1());
            System.out.println("side2 = " + triangle.getSide2());
            System.out.println("side3 = " + triangle.getSide3());
            System.out.println("triangle.toString" + triangle.toString());
            System.out.println(triangle.getArea());
        } catch (IllegalTriangleException e) {
            System.out.println("异常信息为： " + e.getMessage());
        }
    }
}