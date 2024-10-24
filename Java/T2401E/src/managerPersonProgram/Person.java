package managerPersonProgram;

public class Person {
    /**
     * This is variable name of Person
     */
    private String name;
    /**
     * This is variable address of Person
     */
    private String address;
    /**
     * This is variable salary of Person
     */
    private double salary;

    /**
     * This is Default Constructor
     */
    public Person() {
    }

    /**
     * This is Parameterized Constructor
     *
     * @param name    of Person
     * @param address of Person
     * @param salary  of Person
     */
    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    /**
     * This is properties getName
     *
     * @return String name;
     */
    public String getName() {
        return name;
    }

    /**
     * This is properties setName
     *
     * @param name of Person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This is properties getAddress
     *
     * @return String address
     */
    public String getAddress() {
        return address;
    }

    /**
     * This is properties setAddress
     *
     * @param address of Person
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This is properties getSalary
     *
     * @return double Salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * This is properties setSalary
     *
     * @param salary of Person
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
