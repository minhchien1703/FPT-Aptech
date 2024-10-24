package validate;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    String err = "";

    public String valid(String num) throws Exception {

        try {
            Integer.parseInt(num);
            Pattern patternPhone = Pattern.compile("\\d{9}");
            Matcher matcherPhone = patternPhone.matcher(num);
            if (!matcherPhone.matches()) {
                this.err = "Number phone is not Pattern to Integer! ";
            }

        } catch (Exception e) {
            this.err = "num must is number! ";
        }
        return this.err;
    }

    public void checkDate (String date) {
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dateFormat.parse(date);
            } catch (Exception e) {
                System.out.println(this.err = "Not format to date type! ");
            }
        } else {
            System.out.println(this.err = "Date is null! ");
        }
    }



}
