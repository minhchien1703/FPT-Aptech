package connect_db.model;

public class PersonDTO {
    int personID;
    String lName;
    int orderNumber;

    public PersonDTO() {}

    public PersonDTO (int personID, String lName, int orderNumber) {
        this.personID = personID;
        this.lName = lName;
        this.orderNumber = orderNumber;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void display() {
        System.out.println(this.personID + "\t" + this.lName +"\t" + this.orderNumber);
    }
}
