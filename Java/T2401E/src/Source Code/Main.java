import java.util.Scanner;

import fpt.fu.country.EastAsiaCountries;
import fpt.fu.country.ManageEastAsiaCountries;

/**
 * 
 * @author NghiaNV1
 * @version 1.0
 */
public class Main {
    /**
     * All Option of menu
     */
    private static final int INPUT_COUNTRY = 1, DISPLAY = 2,
            SEARCH_COUNTRY = 3, DISPLAY_SORT = 4, EXIT = 5;

    /**
     * 
     * @param args
     *            default
     */
    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        int choice = 0;

        while (true) {
            try {
                System.out.println("                               MENU");
                System.out
                        .println("==========================================="
                                + "===============================");
                System.out.println("1. Input the information of 11 countries "
                        + "in East Asia");
                System.out.println("2. Display the information of country "
                        + "you've just input");
                System.out.println("3. Search the information of country "
                        + "by user-entered name");
                System.out.println("4. Display the information of countries "
                        + "sorted name in ascending order  ");
                System.out.println("5. Exit ");
                System.out.println("=========================================="
                        + "================================");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your choice :");
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Data Input Mismatch !");
                continue;
            }
            Scanner sc1 = new Scanner(System.in);
            switch (choice) {
            case INPUT_COUNTRY:
                String countryCode,
                countryName,
                countryTerrain;
                float totalArea = 0;
                System.out.println("Enter code of country: ");
                countryCode = sc1.nextLine();
                while (true) {
                    System.out.println("Enter name of country: ");
                    try {
                        countryName = manager.checkCountryName(sc1.nextLine());
                        break;
                    } catch (Exception e1) {
                        System.out.println(e1.getMessage());
                    }
                }
                while (true) {
                    System.out.println("Enter total Area: ");
                    try {
                        totalArea = manager.checkArea(sc1.nextLine());
                        break;
                    } catch (Exception i) {
                        System.out.println(i.getMessage());
                    }
                }
                System.out.println("Enter terrain of country: ");
                countryTerrain = sc1.nextLine();
                try {
                    manager.addCountryInformation(new EastAsiaCountries(
                            countryCode, countryName, totalArea,
                            countryTerrain));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case DISPLAY:
                try {
                    System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s \n",
                            "ID", "Name", "Total Area", "Terrain");
                    System.out.println(manager.getRecentlyEnteredInformation()
                            .display());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case SEARCH_COUNTRY:
                try {
                    System.out
                            .println("Enter the name you want to search for: ");
                    String name = sc1.nextLine();
                    EastAsiaCountries[] list = manager
                            .searchInformationByName(name);
                    System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s \n",
                            "ID", "Name", "Total Area", "Terrain");
                    for (EastAsiaCountries eastAsiaCountries : list) {
                        System.out.println(eastAsiaCountries.display());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case DISPLAY_SORT:
                try {
                    EastAsiaCountries[] list = manager
                            .sortInformationByAscendingOrder();
                    System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s \n",
                            "ID", "Name", "Total Area", "Terrain");
                    for (EastAsiaCountries eastAsiaCountries : list) {
                        System.out.println(eastAsiaCountries.display());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case EXIT:
                System.exit(0);
            default:
                System.out.println("Invalid choice !");
                break;
            }
        }
    }
}
