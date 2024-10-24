package countries;

import java.util.Scanner;

public class Main {

    private static final int
            INPUT_COUNTRY = 1,
            DISPLAY = 2,
            SEARCH_COUNTRY = 3,
            DISPLAY_SORT = 4,
            EXIT = 5;

    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        int choose;

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
            } catch (NumberFormatException e) {
                System.out.println("Data input fails!");
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter choose 1 to 5:");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case INPUT_COUNTRY:
                    String countryCode, countryName, countryTerrain;
                    float totalArea = 0;
                    System.out.println("Enter code of country:");
                    countryCode = scanner.nextLine();
                    while(true) {
                        System.out.println("Enter country name:");
                        try {
                            countryName = manager.checkCountryName(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    while (true) {
                        System.out.println("Enter total Area:");
                        try {
                            totalArea = manager.checkArea(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println("Enter terrain of country:");
                    countryTerrain = scanner.nextLine();
                    try {
                        manager.addCountryInformation(new EastAsiaCountries(
                                countryCode,
                                countryName,
                                totalArea,
                                countryTerrain));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    case DISPLAY:
                        try {
                            System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s \n",
                                    "ID", "Name", "Total Area", "Terrain");
                            System.out.println(manager.getRecentlyEnteredInformation().display());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                        case SEARCH_COUNTRY:
                            try {
                                System.out.println("Enter the name you want to search for:");
                                String name = scanner.nextLine();
                                EastAsiaCountries[] List = manager.searchInformationByName(name);
                                System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s \n",
                                        "ID", "Name", "Total Area", "Terrain");
                                for (EastAsiaCountries e : List) {
                                    System.out.println(e.display());
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                case DISPLAY_SORT:
                    try {
                        EastAsiaCountries[] list = manager.sortInformationbyAscendingOrder();
                        System.out.format("%1$-15s %2$-15s %3$-15s %4$-15s \n",
                                "ID", "Name", "Total Area", "Terrain");
                        for (EastAsiaCountries countrie : list) {
                            System.out.println(countrie.display());
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case EXIT:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choose!");
                    break;

            }
        }

    }
}
