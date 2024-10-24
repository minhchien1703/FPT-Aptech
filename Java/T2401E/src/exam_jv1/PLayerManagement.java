package exam_jv1;

import java.util.ArrayList;
import java.util.Scanner;

public class PLayerManagement {
    ArrayList<FootballPlayer> list;
    FootballPlayer player;
    PlayerList playerList;

    public PLayerManagement(){
        list = new ArrayList<>();
        FootballPlayer player1 = new FootballPlayer("Cristiano Ronaldo", 7, "Center Forward", 185, 80, 39);
        FootballPlayer player2 = new FootballPlayer("Lionel Messi", 10, "midfielder", 169, 78, 38);
        FootballPlayer player3 = new FootballPlayer("Bruno Fernandes", 8, "midfielder", 170, 77, 34);
        FootballPlayer player4 = new FootballPlayer("David Beckham", 9, "midfielder", 183, 80, 45);
        FootballPlayer player5 = new FootballPlayer("Andres Iniesta", 6, "midfielder", 173, 80, 48);
        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);
        list.add(player5);
        playerList = new PlayerList(list);

        playerList.displayAll();
    }

    public void actions() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Player.");
            System.out.println("2. Check information and skill Football player.");
            System.out.println("3. Exit.");

            System.out.print("Enter choose:");
            int choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                        System.out.print("Enter name:");
                        String name = scanner.nextLine();
                        System.out.print("Enter shirt number:");
                        int shirtNumber = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter position:");
                        String position = scanner.nextLine();
                        System.out.print("Enter height:");
                        int height = scanner.nextInt();
                        System.out.print("Enter weight:");
                        int weight = scanner.nextInt();
                        System.out.print("Enter age:");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        player = new FootballPlayer(name, shirtNumber, position, height, weight, age);
                        try {
                            boolean check = playerList.createPlayer(player);
                            if (check) {
                                System.out.println("Add player success.");
                            }
                            playerList.displayAll();
                        }catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    break;
                case 2:
                    System.out.print("Please choose shirt number:");
                    int playerNo = scanner.nextInt();
                    try {
                        player = playerList.checkInformationPlayer(playerNo);
                        if (player != null) {
                            player.display();
                            while (true) {
                                System.out.println("1. Skill shoot.");
                                System.out.println("2. Skill pass.");
                                System.out.println("3. Exit checking player.");
                                System.out.print("Enter choose:");
                                choose = scanner.nextInt();
                                System.out.println("\n");
                                if (choose == 1) {
                                    player.shoot();
                                } else if (choose == 2) {
                                    player.pass();
                                } else if (choose == 3) {
                                    break;
                                } else {
                                    System.out.println("Please choose 1 to 2 !");
                                }
                            }
                        }
                        playerList.displayAll();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 3:
                    System.out.println("Exit success.");
                    return;
                default:
                    System.err.println("Please choose 1 to 3 !");

            }
        }
    }
}
