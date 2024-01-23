package com.example.exercice1.servlet;

import com.example.exercice1.sevice.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deleteProduct", value = "/deleteProduct")
public class ServletDelete extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        super.init();
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdParam = req.getParameter("id");

        if (productIdParam != null) {
            Long productId = Long.parseLong(productIdParam);
            productService.deleteProduct(productId);
        }

        resp.sendRedirect("/product");
    }

}

