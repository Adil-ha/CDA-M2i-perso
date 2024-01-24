package com.example.exercice1.servlet;

import com.example.exercice1.model.Product;
import com.example.exercice1.sevice.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@WebServlet(name="product", value="/product")
@MultipartConfig(maxFileSize = 1024*1024*10)
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
        String action = req.getParameter("action");

        if ("logout".equals(action)) {
            HttpSession session = req.getSession();
            session.removeAttribute("authenticatedUser");
            resp.sendRedirect("product");
            return;
        }

        productList = productService.getAllProducts();
        HttpSession session = req.getSession();
        boolean isAuthenticated = session.getAttribute("authenticatedUser") != null;

        req.setAttribute("isAuthenticated", isAuthenticated);
        req.setAttribute("products", productList);

        req.getRequestDispatcher("product-list.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String reference = req.getParameter("reference");
        String dateParam = req.getParameter("date");
        LocalDate date = LocalDate.parse(dateParam);
        Double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));


        String uploadPath = getServletContext().getRealPath("/") + "images";

        File file = new File(uploadPath);

        if(!file.exists()){
            file.mkdir();
        }

        Part image = req.getPart("image");
        String fileName = image.getSubmittedFileName();

        image.write(uploadPath + File.separator + fileName);

        Product product = new Product(brand, reference, date, price, stock, fileName);

        productService.createProduct(product);

        resp.sendRedirect("product");
    }
}
