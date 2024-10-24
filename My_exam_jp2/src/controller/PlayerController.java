package controller;

import dao.PlayerDao;
import model.PlayerModel;

import java.util.List;

public class PlayerController {
    PlayerDao playerDao = new PlayerDao();

    public Boolean createNewPlayer(PlayerModel player) {
        return playerDao.insertNewPlayer(player);
    }

    public List<PlayerModel> getAllPlayers() {
        return playerDao.getAllPlayers();
    }

    public Boolean deletePlayer(int id) {
        return playerDao.deletePlayerById(id);
    }

    public PlayerModel findPlayer(String name) {
        return playerDao.getPlayerByName(name);
    }

}
