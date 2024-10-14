package org.example;

import org.example.controller.UserController;
import org.example.controller.ProductController;
import org.example.db.DatabaseInitializer; // Ajoutez cette ligne


import jakarta.servlet.ServletException; // Changement ici
import jakarta.servlet.annotation.WebServlet; // Changement ici
import jakarta.servlet.http.HttpServlet; // Changement ici

@WebServlet(urlPatterns = "/*")
public class Main extends HttpServlet {
    public static void main(String[] args) {
        // Initialisation de la base de données et création des tables
        DatabaseInitializer.initialize();
        DatabaseInitializer.createTables();
        System.out.println("Application démarrée.");
        // Point d'entrée de l'application
        System.out.println("Marketplace Application is running...");
    }
}
