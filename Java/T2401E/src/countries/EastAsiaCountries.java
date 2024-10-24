package countries;

public class EastAsiaCountries extends Country{
    private String countryTerrain;

    public EastAsiaCountries(
            String countryCode,
            String countryName,
            float totalArea,
            String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }


    public String display() {
        return super.display() + String.format("%1$-15s \n", countryTerrain);
    }


}
