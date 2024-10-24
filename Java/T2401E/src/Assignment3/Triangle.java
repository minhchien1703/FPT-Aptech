package Assignment3;

import java.util.Scanner;

public class Triangle extends Shape {
    double sizeA, sizeB, sizeC;

    public Triangle() {

    }

    public Triangle(double sizeA, double sizeB, double sizeC) {
        this.sizeA = sizeA;
        this.sizeB = sizeB;
        this.sizeC = sizeC;
    }

    public double getSizeA() {
        return sizeA;
    }

    public void setSizeA(double sizeA) {
        this.sizeA = sizeA;
    }

    public double getSizeB() {
        return sizeB;
    }

    public void setSizeB(double sizeB) {
        this.sizeB = sizeB;
    }

    public double getSizeC() {
        return sizeC;
    }

    public void setSizeC(double sizeC) {
        this.sizeC = sizeC;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size A of the triangle: ");
        sizeA = sc.nextDouble();
        System.out.print("Enter the size B of the triangle: ");
        sizeB = sc.nextDouble();
        System.out.print("Enter the size C of the triangle: ");
        sizeC = sc.nextDouble();
    }

    @Override
    public double getArea() {
        return sizeA * sizeB * sizeC;
    }

    public double getPerimeter() {
        return 2 * sizeA + 2 * sizeB + 2 * sizeC;
    }
}
