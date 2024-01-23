package com.example.exercice1.servlet;

import com.example.exercice1.model.Product;
import com.example.exercice1.sevice.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="product", value="/product")
public class ServletProduct extends HttpServlet {

    private ProductService productService;

    private List<Product> productList;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
        List<Product> productList = productService.getAllProducts();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        productList = productService.getAllProducts();

        req.setAttribute("products", productList);

        req.getRequestDispatcher("/product").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String reference = req.getParameter("reference");
        String dateParam = req.getParameter("date");
        LocalDate date = LocalDate.parse(dateParam);
        Double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        Product product = new Product(brand, reference, date, price, stock);

        productService.createProduct(product);

        resp.sendRedirect("/product");
    }
}
