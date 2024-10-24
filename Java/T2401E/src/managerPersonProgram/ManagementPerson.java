package managerPersonProgram;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Student Name
 * @version 1.0
 */
public class ManagementPerson {
    private static String
            SALARY_NOT_THAN_ZERO = "Salary is greate Than Zero",
            INPUT_SALARY = "You must input salary",
            INPUT_DIGIDT = "You must input digidt";

    /**
     * This is method used to input information of Person
     * 
     * @param name
     *            of Person
     * @param address
     *            of Person
     * @param sSalary
     *            of Person
     * @return person
     * @throws Exception "Salary is greater than zero"
     *                   "You must input Salary."
     *                   "You must input digit.
     */
    public Person inputPersonInfo(String name, String address, String sSalary)
            throws Exception {
        double dSalary;
        try {
            if (sSalary != null && !sSalary.isEmpty()) {
                dSalary = Double.parseDouble(sSalary);
                if (dSalary > 0) {
                    return new Person(name, address, dSalary);
                } else {
                    throw new Exception(SALARY_NOT_THAN_ZERO);
                }
            } else {
                throw new Exception(INPUT_SALARY);
            }
        } catch (Exception e) {
            throw new Exception(INPUT_DIGIDT);
        }
    }

    /**
     * This is method used to display information of Person you have entered.
     * 
     * @param person
     *            Object
     */
    public void displayPersonInfo(Person person) {
        System.out.println("Name: " + person.getName());
        System.out.println("Address: " + person.getAddress());
        System.out.println("Salary: " + person.getSalary() + "\n");
    }

    /**
     * This is method used to sort Person entered by gradually increased of
     * Salary.
     * 
     * @param persons
     *            of Array Person
     * @return Person Object
     * @throws Exception "Can't Sort Person" 
     */
    public Person[] sortBySalary(Person[] persons) throws Exception {
        if (persons == null || persons.length == 0) {
            throw new Exception("Can't sort, the person array is empty or null.");
        }
//      collections.sort(persons);
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });
        return persons;
    }
}
