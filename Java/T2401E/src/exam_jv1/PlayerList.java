package exam_jv1;

import java.util.ArrayList;

public class PlayerList{

    private ArrayList<FootballPlayer> data;

    public PlayerList(ArrayList<FootballPlayer> data){
        this.data = data;
    }

    public boolean createPlayer(FootballPlayer player) throws Exception {
        if (data == null)
            throw new Exception("Data is null !");

        data.add(player);
        return true;
    }

    public FootballPlayer checkInformationPlayer(int num) throws Exception{
        if (data == null)
            throw new Exception("Data is null !");

        for (FootballPlayer player : data) {
            if (player.getShirtNumber() == num) {
                return player;
            }
        }
        throw new Exception("Player with shirt number " + num + " not found !");
    }

    public void displayAll() {
        System.out.println("     Name       Shirt number  Position        heigth weight age");
        for (FootballPlayer player : data) {
            player.display();
        }
    }


}
