import controller.NationalController;
import controller.PlayerController;
import model.NationalModel;
import model.PlayerModel;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayerController playerController = new PlayerController();
        NationalController nationalController = new NationalController();
        while (true) {
            System.out.println("\n=====HERO GAME PROGRAM=====");
            System.out.println("1. Create new player.");
            System.out.println("2. Delete player.");
            System.out.println("3. Create new national.");
            System.out.println("4. Delete national.");
            System.out.println("5. Display all player.");
            System.out.println("6. Search player.");
            System.out.println("7. Display top 10 max point.");
            System.out.println("8. Exit.");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose) {
                case 1:
                    System.out.print("Enter national ID: ");
                    int nationalId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter player name: ");
                    String palyerName = scanner.nextLine();
                    System.out.print("Enter high score: ");
                    int highScore = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter level: ");
                    int level = scanner.nextInt();
                    scanner.nextLine();
                    if (playerController.createNewPlayer(new PlayerModel(nationalId, palyerName, highScore, level))) {
                        System.out.println("Insert successful!");
                    }
                    break;

                case 2:
                    System.out.println("Enter player ID: ");
                    int playerId = scanner.nextInt();
                    scanner.nextLine();
                    if (playerController.deletePlayer(playerId)) {
                        System.out.println("Delete successful!");
                    }
                    break;

                case 3:
                    System.out.print("Enter national name: ");
                    String nationalName = scanner.nextLine();
                    if (nationalController.createNewNational(new NationalModel(nationalName))) {
                        System.out.println("Insert successful!");
                    }
                    break;

                case 4:
                    System.out.println("Enter national ID: ");
                    int nId = scanner.nextInt();
                    scanner.nextLine();
                    if (nationalController.deleteNational(nId)) {
                        System.out.println("Delete successful!");
                    }
                    break;

                case 5:
                    List<PlayerModel> playerList = playerController.getAllPlayers();
                    System.out.println("\n=====List Players info=====");
                    for (PlayerModel item : playerList) {
                        item.display();
                    }
                    break;

                case 6:
                    System.out.print("Enter player name: ");
                    String playerName = scanner.nextLine();
                    PlayerModel player = playerController.findPlayer(playerName);
                    if (player != null){
                        player.display();
                    }
                    break;

                case 8:
                    System.out.println("Goodbye !");
                    return;

                default:
                    System.out.println("Please choose 1 to 8 ");
            }

        }
    }
}