package model;

public class Player {
    private int playerID;
    private int leagueWideNumber;
    private String name;
    private int age;

    public Player() {}

    public Player(int playerID, int leagueWideNumber, String name, int age) {
        this.playerID = playerID;
        this.leagueWideNumber = leagueWideNumber;
        this.name = name;
        this.age = age;
    }

    public int getPlayerID() { return playerID; }
    public void setPlayerID(int playerID) { this.playerID = playerID; }

    public int getLeagueWideNumber() { return leagueWideNumber; }
    public void setLeagueWideNumber(int leagueWideNumber) { this.leagueWideNumber = leagueWideNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
