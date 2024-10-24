package model;

public class PlayerModel {
    int playerId;
    int nationalId;
    String playerName;
    int HighScore;
    int level;

    public PlayerModel() {}

    public PlayerModel(int nationalId, String playerName, int highScore, int level) {
        this.nationalId = nationalId;
        this.playerName = playerName;
        this.HighScore = highScore;
        this.level = level;
    }

    public PlayerModel(int playerId, int nationalId, String playerName, int highScore, int level) {
        this.playerId = playerId;
        this.nationalId = nationalId;
        this.playerName = playerName;
        this.HighScore = highScore;
        this.level = level;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHighScore() {
        return HighScore;
    }

    public void setHighScore(int highScore) {
        HighScore = highScore;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void display() {
        System.out.println(this.playerId + "\t" + this.nationalId +"\t" + this.playerName + "\t" + this.HighScore + "\t" + this.level);
    }
}
