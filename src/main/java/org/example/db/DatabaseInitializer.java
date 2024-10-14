package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager; // Importation nécessaire pour DriverManager
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    // Détails de connexion à la base de données
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USERNAME = "root"; // Remplacez par votre nom d'utilisateur
    private static final String PASSWORD = "password"; // Remplacez par votre mot de passe

    public static void initialize() {
        String createDatabase = "CREATE DATABASE IF NOT EXISTS marketplace";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD); // Connexion à MySQL sans spécifier de base de données
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createDatabase);
            System.out.println("Base de données créée ou déjà existante.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTables() {
        // S'assurer de se connecter à la base de données marketplace
        String createUsersTable = "CREATE TABLE IF NOT EXISTS marketplace.users ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "username VARCHAR(255) NOT NULL,"
                + "password VARCHAR(255) NOT NULL,"
                + "email VARCHAR(255) NOT NULL,"
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

        String createProductsTable = "CREATE TABLE IF NOT EXISTS marketplace.products ("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "name VARCHAR(255) NOT NULL,"
                + "description TEXT,"
                + "price DECIMAL(10, 2) NOT NULL,"
                + "quantity INT NOT NULL,"
                + "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marketplace", USERNAME, PASSWORD); // Connexion à la base de données marketplace
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createUsersTable);
            stmt.executeUpdate(createProductsTable);
            System.out.println("Tables créées ou déjà existantes.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
