package doctorManagement;

public class Doctor {
    /**
     * Information code name specialization of Doctor
     */
    private String code, name, specialization;
    /**
     * availability of doctor
     */
    private int availability;
    /**
     * Initial
     *
     */
    public Doctor() {
    }
    /**
     * Initial
     * @param code of doctor
     */
    public Doctor(String code) {
        this.code = code;
    }
    /**
     * Initial
     * @param code of doctor
     * @param name of doctor
     * @param specialization of doctor
     * @param availability of doctor
     */
    public Doctor(String code, String name, String specialization,
                  int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }
    /**
     * getter
     * @return code
     */
    public String getCode() {
        return code;
    }
    /**
     * setter
     * @param code of doctor
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * getter
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * setter
     * @param name of doctor
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * getter
     * @return specialization
     */
    public String getSpecialization() {
        return specialization;
    }
    /**
     * setter
     * @param specialization of doctor
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    /**
     * getter
     * @return availability
     */
    public int getAvailability() {
        return availability;
    }
    /**
     * setter
     * @param availability of doctor
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }
    public void display() {
        System.out.printf("%-5s%-20s%-20s%-20s%n", code, name,
                specialization, availability);
    }
}
