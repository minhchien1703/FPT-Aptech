package Assignment3;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        Shape circle = new Circle();
        Shape triangle = new Triangle();

        rectangle.input();
        circle.input();
        triangle.input();

        System.out.println("---RECTANGLE---");
        System.out.println("Area: " + rectangle.getArea());
        System.out.println("Perimeter: " + rectangle.getPerimeter());

        System.out.println("---CIRCLE---");
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());

        System.out.println("---TRIANGLE---");
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());



    }

}
