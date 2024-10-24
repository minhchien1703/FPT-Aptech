package Assignment3;

import java.util.Scanner;

public class Rectangle extends Shape{
    double width;
    double lenght;

    public Rectangle() {

    }

    public Rectangle(double width, double lenght) {
        this.width = width;
        this.lenght = lenght;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter width: ");
        setWidth(sc.nextDouble());
        System.out.print("Enter length: ");
        setLenght(sc.nextDouble());
    }

    public double getArea() {
        return this.lenght * this.lenght;
    }

    public double getPerimeter() {
        return (this.lenght + this.lenght) * 2;
    }
}
