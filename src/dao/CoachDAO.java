package dao;

import db.DBConnection;
import model.Coach;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoachDAO {

    public void addCoach(Coach coach) throws SQLException {
        String sql = "INSERT INTO Coach (Name, TelephoneNumber, TeamNumber) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, coach.getName());
            stmt.setString(2, coach.getTelephoneNumber());
            stmt.setInt(3, coach.getTeamNumber());

            stmt.executeUpdate();
        }
    }

    public List<Coach> getAllCoaches() throws SQLException {
        List<Coach> coaches = new ArrayList<>();
        String sql = "SELECT * FROM Coach";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Coach coach = new Coach();
                coach.setCoachID(rs.getInt("CoachID"));
                coach.setName(rs.getString("Name"));
                coach.setTelephoneNumber(rs.getString("TelephoneNumber"));
                coach.setTeamNumber(rs.getInt("TeamNumber"));
                coaches.add(coach);
            }
        }
        return coaches;
    }

    public void deleteCoach(int coachID) throws SQLException {
        String sql = "DELETE FROM Coach WHERE CoachID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, coachID);
            stmt.executeUpdate();
        }
    }

    public void updateCoach(Coach coach) throws SQLException {
        String sql = "UPDATE Coach SET Name = ?, TelephoneNumber = ?, TeamNumber = ? WHERE CoachID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, coach.getName());
            stmt.setString(2, coach.getTelephoneNumber());
            stmt.setInt(3, coach.getTeamNumber());
            stmt.setInt(4, coach.getCoachID());

            stmt.executeUpdate();
        }
    }
}
