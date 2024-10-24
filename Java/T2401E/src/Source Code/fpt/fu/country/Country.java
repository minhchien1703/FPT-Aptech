package fpt.fu.country;
/**
 * Save Information Country
 * @author NghiaNV1
 * @version 1.0
 */
public class Country {
    /**
     * Code of Country
     */
    protected String countryCode;
    /**
     * Name of Country
     */
    protected String countryName;
    /**
     * Area of Country
     */
    protected float totalArea;
    /**
     * initial
     */
    public Country() {
    }
    /**
     * initial
     * @param countryCode  Code of Country
     * @param countryName Name of Country
     * @param totalArea  Area of Country
     */
    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }
    /**
     * setter
     * @param countryCode code of country
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    /**
     * getter
     * @return CountryCode
     */
    public String getCountryCode() {
        return countryCode;
    }
    /**
     * setter
     * @param countryName Name of country
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    /**
     * getter
     * @return CountryName
     */
    public String getCountryName() {
        return countryName;
    }
    /**
     * setter
     * @param totalArea Area of country
     */
    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }
    /**
     * getter
     * @return Area
     */
    public float getTotalArea() {
        return totalArea;
    }
    /**
     * Display one country
     * @return Row country
     */
    public String display() {
        return String.format("%1$-15s %2$-15s %3$-15s", countryCode,
                countryName, totalArea);
    }
}
