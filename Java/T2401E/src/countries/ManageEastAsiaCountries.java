package countries;

public class ManageEastAsiaCountries {
    private EastAsiaCountries[] data = new EastAsiaCountries[11];
    private int nextCountry = 0;

    public static String LIMIT_COUNTRY = "Unable to add more country!",
            NO_COUNTRY = "No Country to display!",
            NO_RESULT = "Search not found!",
            NO_DATA = "No country to search!",
            AREA_NOT_DIGIT = "Area is digit!",
            AREA_LESS_THAN_ZERO = "Area is less than zero!",
            NAME_NULL_EMPTY = "Name can't null or empty!";

    public EastAsiaCountries[] sortInformationbyAscendingOrder() throws Exception {
        if (nextCountry > 0) {
            EastAsiaCountries temp = null;
            int length = nextCountry;
            for (int i = 0; i < length; i++) {
                for (int j = 1; j < (length - i); j++) {
                    if (data[j].getCountryName().compareTo(data[j - 1].getCountryName()) > 0) {
                        temp = data[j - 1];
                        data[j - 1] = data[j];
                        data[j] = temp;
                    }
                }
            }
            EastAsiaCountries[] data = new EastAsiaCountries[length];
            for (int i = 0; i < length; i++) {
                data[i] = this.data[i];
            }
            return data;
        } else {
            throw new Exception(NO_COUNTRY);
        }
    }

    public EastAsiaCountries[] searchInformationByName(String name) throws Exception {
        if (nextCountry > 0) {
            int length = 0;
            for (int i = 0; i < nextCountry; i++) {
                if (name.equals(data[i].getCountryName())) {
                    length ++;
                }
            }
            if (length > 0) {
                EastAsiaCountries[] data = new EastAsiaCountries[length];
                int index = 0;
                for (int i = 0; i < nextCountry; i++) {
                    if (name.equals(this.data[i].getCountryName())) {
                        data[index] = this.data[i];
                        index++;
                    }
                }
            } else {
                throw new Exception(NO_RESULT);
            }
            return data;
        } else {
            throw new Exception(NO_RESULT);
        }
    }

    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception {
        if (nextCountry > 0) {
            return data[nextCountry - 1];
        } else {
            throw new Exception(NO_COUNTRY);
        }
    }

    public void addCountryInformation (EastAsiaCountries country) throws Exception {
        if (nextCountry < data.length) {
            data[nextCountry] = country;
            nextCountry++;
        } else {
            throw new Exception(LIMIT_COUNTRY);
        }

    }

    public String checkCountryName (String countryName) throws Exception {
        if (countryName == null || "".endsWith(countryName)) {
            throw new Exception(NAME_NULL_EMPTY);
        }
        return countryName;
    }

    public float checkArea(String area) throws Exception {
        float totalArea = 0;
        try {
            totalArea = Float.parseFloat(area);
            if (totalArea < 0)
                throw new Exception(AREA_LESS_THAN_ZERO);
        } catch (NumberFormatException num) {
            throw new Exception(AREA_NOT_DIGIT);
        } catch (NullPointerException np) {
            throw new Exception(AREA_NOT_DIGIT);
        }
        return totalArea;
    }



}
