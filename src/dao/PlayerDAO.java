package dao;

import db.DBConnection;
import model.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {

    public void addPlayer(Player player) throws SQLException {
        String sql = "INSERT INTO Player (LeagueWideNumber, Name, Age) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, player.getLeagueWideNumber());
            stmt.setString(2, player.getName());
            stmt.setInt(3, player.getAge());

            stmt.executeUpdate();
        }
    }

    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM Player";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Player player = new Player();
                player.setPlayerID(rs.getInt("PlayerID"));
                player.setLeagueWideNumber(rs.getInt("LeagueWideNumber"));
                player.setName(rs.getString("Name"));
                player.setAge(rs.getInt("Age"));
                players.add(player);
            }
        }
        return players;
    }

    public void deletePlayer(int playerID) throws SQLException {
        String sql = "DELETE FROM Player WHERE PlayerID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, playerID);
            stmt.executeUpdate();
        }
    }

    public void updatePlayer(Player player) throws SQLException {
        String sql = "UPDATE Player SET LeagueWideNumber = ?, Name = ?, Age = ? WHERE PlayerID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, player.getLeagueWideNumber());
            stmt.setString(2, player.getName());
            stmt.setInt(3, player.getAge());
            stmt.setInt(4, player.getPlayerID());

            stmt.executeUpdate();
        }
    }
}
