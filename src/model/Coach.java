package model;

public class Coach {
    private int coachID;
    private String name;
    private String telephoneNumber;
    private int teamNumber;

    public Coach() {}

    public Coach(int coachID, String name, String telephoneNumber, int teamNumber) {
        this.coachID = coachID;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.teamNumber = teamNumber;
    }

    public int getCoachID() {
        return coachID;
    }

    public void setCoachID(int coachID) {
        this.coachID = coachID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }
}
