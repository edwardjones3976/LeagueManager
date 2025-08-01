package dao;

import db.DBConnection;
import model.Team;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDAO {

    public void addTeam(Team team) throws SQLException {
        String sql = "INSERT INTO Team (TeamNumber, Name, City, ManagerName) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, team.getTeamNumber());
            stmt.setString(2, team.getName());
            stmt.setString(3, team.getCity());
            stmt.setString(4, team.getManagerName());

            stmt.executeUpdate();
        }
    }

    public List<Team> getAllTeams() throws SQLException {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM Team";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Team team = new Team();
                team.setTeamNumber(rs.getInt("TeamNumber"));
                team.setName(rs.getString("Name"));
                team.setCity(rs.getString("City"));
                team.setManagerName(rs.getString("ManagerName"));
                teams.add(team);
            }
        }

        return teams;
    }
    public void deleteTeam(int teamId) throws SQLException {
    String sql = "DELETE FROM Team WHERE TeamNumber = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, teamId);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("✅ Team deleted successfully.");
        } else {
            System.out.println("⚠️ No team found with ID: " + teamId);
        }

    }
}
public void updateTeam(Team team) throws SQLException {
    String sql = "UPDATE Team SET Name = ?, City = ?, ManagerName = ? WHERE TeamNumber = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, team.getName());
        stmt.setString(2, team.getCity());
        stmt.setString(3, team.getManagerName());
        stmt.setInt(4, team.getTeamNumber());

        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("✅ Team updated successfully.");
        } else {
            System.out.println("⚠️ No team found with ID: " + team.getTeamNumber());
        }
    }
}
}

