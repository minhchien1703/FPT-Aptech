package exam_jv1;

public class FootballPlayer implements HomoSapien{

    public String name;
    public int shirtNumber;
    public String position;
    public int height;
    public int weight;
    public int age;

    public FootballPlayer(String name, int shirtNumber, String position, int height, int weight, int age) {
        this.name = name;
        this.shirtNumber = shirtNumber;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void shoot() {
        System.out.println("\n"+name + " is shooting a ball."+"\n");
    }

    public void pass() {
        System.out.println("\n"+name + " is passing to Messi."+"\n");
    }


    public void display() {
        System.out.printf("%-20s %-5s %-20s %-5s %-5s %-5s %n", name, shirtNumber,
                position, height, weight, age);
    }
}
