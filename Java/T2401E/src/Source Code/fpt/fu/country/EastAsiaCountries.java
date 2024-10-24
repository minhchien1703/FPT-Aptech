package fpt.fu.country;
/**
 * Save Information East Asia Countries
 * @author NghiaNV1
 * @version 1.0
 */
public class EastAsiaCountries extends Country {
    /**
     * Terrain of country
     */
    private String countryTerrain;
    /**
     * initial
     */
    public EastAsiaCountries() {
    }
    /**
     * initial
     * @param countryCode  Code of Country
     * @param countryName Name of Country
     * @param totalArea  Area of Country
     * @param countryTerrain Terrain of Country
     */
    public EastAsiaCountries(String countryCode, String countryName,
            float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    /**
     * get String display of Country Information
     * @return Row Country
     */
    public String display() {
        return super.display()
                + String.format("%1$-15s \n", countryTerrain);
    }
}
