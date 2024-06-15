package com.app.sportsconnect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CricketApp {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sportsconnect?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";

    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            while (true) {
                System.out.println("1. Insert Data");
                System.out.println("2. Retrieve Data");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertData(conn, scanner);
                        break;
                    case 2:
                        retrieveData(conn);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter matchId: ");
        int matchId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter team1Name: ");
        String team1Name = scanner.nextLine();
        System.out.print("Enter team2Name: ");
        String team2Name = scanner.nextLine();
        System.out.print("Enter tossWonBy: ");
        String tossWonBy = scanner.nextLine();
        System.out.print("Enter optionSelected: ");
        String optionSelected = scanner.nextLine();
        System.out.print("Enter matchDate (YYYY-MM-DD): ");
        String matchDate = scanner.nextLine();
        System.out.print("Enter innings1Score (runs/wickets): ");
        String innings1Score = scanner.nextLine();
        System.out.print("Enter innings2Score (runs/wickets): ");
        String innings2Score = scanner.nextLine();
        System.out.print("Enter matchType: ");
        String matchType = scanner.nextLine();

        String query = "INSERT INTO cricket (matchId, team1Name, team2Name, tossWonBy, optionSelected, matchDate, innings1Score, innings2Score, matchType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, matchId);
            stmt.setString(2, team1Name);
            stmt.setString(3, team2Name);
            stmt.setString(4, tossWonBy);
            stmt.setString(5, optionSelected);
            stmt.setDate(6, Date.valueOf(matchDate));
            stmt.setString(7, innings1Score);
            stmt.setString(8, innings2Score);
            stmt.setString(9, matchType);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data.");
            }
        }
    }

    private static void retrieveData(Connection conn) throws SQLException {
        String query = "SELECT * FROM cricket";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("matchId: " + rs.getInt("matchId"));
                System.out.println("team1Name: " + rs.getString("team1Name"));
                System.out.println("team2Name: " + rs.getString("team2Name"));
                System.out.println("tossWonBy: " + rs.getString("tossWonBy"));
                System.out.println("optionSelected: " + rs.getString("optionSelected"));
                System.out.println("matchDate: " + rs.getDate("matchDate"));
                System.out.println("innings1Score: " + rs.getString("innings1Score"));
                System.out.println("innings2Score: " + rs.getString("innings2Score"));
                System.out.println("matchType: " + rs.getString("matchType"));
                System.out.println("-------------------------------");
            }
        }
    }
}
