package connect_db.model;

public class Person {
    int personId;
    String lName;
    String fName;
    int age;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int personId, String lName, String fName, int age) {
        this.personId = personId;
        this.lName = lName;
        this.fName = fName;
        this.age = age;
    }

    public Person(String lName, String fName, int age) {
        this.personId = 0;
        this.lName = lName;
        this.fName = fName;
        this.age = age;
    }

    public void display() {
        System.out.println(this.personId + "\t" + this.lName +"\t" + this.fName + "\t" + this.age);
    }
}
