package doctorManagement;

import Polymorphism.Person;

import javax.print.Doc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoctorHash {
    private static String
            DOCTOR_INFORMATION = "DATABASE DOESN't EXIST",
            CODE_DUPLICATE = "DOCTOR CODE [CODE] IS DUPLICATE",
            PARAM_NULL = "PARAM DOESN'T EXIST";
    /**
     * virtual Database
     */
    private HashMap<String, Doctor> data;
    /**
     * Initial
     * @param data virtual Database
     */

    public DoctorHash(HashMap<String, Doctor> data) {
        this.data = data;
    }
    /**
     * check Availability valid (>0)
     * @param availability of doctor
     * @return number
     * @throws Exception state check
     */
    public int checkAvailability(String availability) throws Exception {
        if (availability == null)
            throw new Exception(PARAM_NULL);
        int check;
        try {
            check = Integer.parseInt(availability);
            if (check > 0) {
                return check;
            } else {
                throw new Exception("Availability must is big than zero !");
            }
        } catch (Exception e) {
            throw new Exception("Availability must is integer and big than zero !");
        }
    }
    /**
     * add new doctor into database
     * @param doctor information doctor
     * @return state add new
     * @throws Exception add new
     */
    public boolean addDoctor(Doctor doctor) throws Exception {
        if (data == null)
            throw new Exception(DOCTOR_INFORMATION);
        if (data.containsKey(doctor.getCode()))
            throw new Exception(CODE_DUPLICATE);
        if (doctor == null)
            throw new Exception(PARAM_NULL);
        this.data.put(doctor.getCode(), doctor);
        return true;
    }
    /**
     * update doctor into database
     * @param doctor information doctor
     * @return state update
     * @throws Exception update
     */
    public boolean updateDoctor(Doctor doctor) throws Exception {
        if (data == null)
            throw new Exception(DOCTOR_INFORMATION);
        if (doctor == null)
            throw new Exception(PARAM_NULL);
        this.data.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean deleteDoctor(Doctor doctor) throws Exception {
        if (data == null)
            throw new Exception(DOCTOR_INFORMATION);
        if (!data.containsKey(doctor.getCode()))
            throw new Exception("Doctor code doesn’t exist");
        if (doctor == null)
            throw new Exception(PARAM_NULL);
        this.data.remove(doctor.getCode());
        return true;
    }
    /**
     * Find doctor in database
     * @param input key find all attribute of Doctor
     * @return List Doctor
     * @throws Exception state Search
     */
    public HashMap<String, Doctor> searchDoctor(String input) throws Exception {
        if (data == null)
            throw new Exception(DOCTOR_INFORMATION);

        HashMap<String, Doctor> result = new HashMap<>();
        Set<String> keys = data.keySet();
        Iterator<String> keyIterator = keys.iterator();

        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Doctor doc = data.get(key);
            if(doc.getCode().contains(input)
                    || doc.getName().contains(input)
                    || doc.getSpecialization().contains(input)) {
                result.put(doc.getCode(), doc);
            }
        }
        return result;
    }

    public void displayAll() throws Exception{
        if (data == null)
            throw new Exception("Data is null !");

        Set<String> keys = data.keySet();
        Iterator<String> keysIterator = keys.iterator();
        while(keysIterator.hasNext()) {
//          get key from key set
            String key = keysIterator.next();
//          get value of key
            Doctor doc = this.data.get(key);
            doc.display();
        }

    }
}
