package demo;

import java.util.Scanner;

public class car {
    String color;
    int speed;

    public void display() {
        System.out.println("Color: " + color);
        System.out.println("Speed: " + speed + " km/h");
    }

    public void inputData() {
        Scanner input =  new Scanner(System.in);
        System.out.println("==Just enter color and speed==");
        System.out.println("Enter color: ");
        this.color = input.next();
        System.out.println("Enter speed: ");
        this.speed = input.nextInt();
    }

    public car(String color, int speed ) {
        this.color = color;
        this.speed = speed;
    }

    public car() {
        this.color = "";
        this.speed = 0;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
