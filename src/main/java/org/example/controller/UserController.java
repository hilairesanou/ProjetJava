package org.example.controller;

import jakarta.servlet.ServletException; // Changement ici
import jakarta.servlet.annotation.WebServlet; // Changement ici
import jakarta.servlet.http.HttpServlet; // Changement ici
import jakarta.servlet.http.HttpServletRequest; // Changement ici
import jakarta.servlet.http.HttpServletResponse; // Changement ici
import java.io.IOException;

@WebServlet("/users")
public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Logique pour récupérer tous les utilisateurs
        // Renvoyer une réponse appropriée
    }

    // Autres méthodes pour gérer les utilisateurs (POST, PUT, DELETE)
}
