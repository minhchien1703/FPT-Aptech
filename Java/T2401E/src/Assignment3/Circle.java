package Assignment3;

import java.util.Scanner;

public class Circle extends Shape {
    double radius;


    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        radius = sc.nextDouble();
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public  double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
