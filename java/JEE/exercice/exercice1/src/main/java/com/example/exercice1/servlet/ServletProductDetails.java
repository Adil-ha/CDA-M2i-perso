package com.example.exercice1.servlet;

import com.example.exercice1.model.Product;
import com.example.exercice1.sevice.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "productDetails", value = "/productDetails")
public class ServletProductDetails extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialisez ici votre productService, par exemple en l'instanciant
        this.productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdParam = req.getParameter("id");

        if (productIdParam != null) {

            Long productId = Long.parseLong(productIdParam);
            Product product = productService.getProductById(productId);

            req.setAttribute("product", product);

        }
        req.getRequestDispatcher("product-details.jsp");
    }
}
