package org.example.service;

import org.example.model.Product;
import org.example.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    // Méthode pour récupérer tous les produits
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getBigDecimal("price")); // Assurez-vous que cette colonne existe
                product.setQuantity(resultSet.getInt("quantity"));   // Assurez-vous que cette colonne existe
                products.add(product); // Ajoutez le produit à la liste
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Affichez les erreurs SQL
        }
        return products; // Retournez la liste de produits
    }

    // Méthode pour ajouter un produit
    public void addProduct(Product product) {
        String sql = "INSERT INTO products (name, description, price, quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setBigDecimal(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            pstmt.executeUpdate();
            System.out.println("Produit ajouté avec succès.");
        } catch (SQLException e) {
            e.printStackTrace(); // Affichez les erreurs SQL
        }
    }

    // Vous pouvez ajouter d'autres méthodes ici pour gérer les produits
}
