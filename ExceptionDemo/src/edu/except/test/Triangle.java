package edu.except.test;

/**
 * @program: shopping
 * @description: TODO
 * @author: feng
 * @create: 2020-06-10 23:10
 * @version: 1.0
 */
public class Triangle {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1) {
            throw new IllegalTriangleException("不能构成三角形");
        }
        System.out.println("能构成三角形");
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        double p = (this.side1 + this.side2 + this.side3) / 2;
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    @Override
    public String toString() {
        return "Triangle:side1=" + side1 + "side2=" + side2 + "side3=" + side3;
    }
}