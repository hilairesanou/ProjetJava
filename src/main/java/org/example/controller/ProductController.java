package org.example.controller;

import jakarta.servlet.ServletException; // Changement ici
import jakarta.servlet.annotation.WebServlet; // Changement ici
import jakarta.servlet.http.HttpServlet; // Changement ici
import jakarta.servlet.http.HttpServletRequest; // Changement ici
import jakarta.servlet.http.HttpServletResponse; // Changement ici
import java.io.IOException;
import java.io.PrintWriter;
import org.example.service.ProductService;
import org.example.model.Product;

import java.util.List;

@WebServlet("/products")
public class ProductController extends HttpServlet {

    private ProductService productService;

    public ProductController() {
        this.productService = new ProductService(); // Initialisation du service
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupérer tous les produits
        List<Product> products = productService.getAllProducts();

        // Configurer la réponse
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Écrire la réponse dans le corps
        PrintWriter out = resp.getWriter();
        out.write("["); // Début de la liste JSON
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            out.write("{");
            out.write("\"id\":" + product.getId() + ",");
            out.write("\"name\":\"" + product.getName() + "\",");
            out.write("\"description\":\"" + product.getDescription() + "\",");
            out.write("\"price\":" + product.getPrice() + ",");
            out.write("\"quantity\":" + product.getQuantity());
            out.write("}");
            if (i < products.size() - 1) {
                out.write(","); // Ajouter une virgule entre les objets JSON
            }
        }
        out.write("]"); // Fin de la liste JSON
        out.flush(); // Envoyer la réponse
    }

    // Ajoutez d'autres méthodes pour gérer les produits (POST, PUT, DELETE)
}
