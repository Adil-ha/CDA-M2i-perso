package com.example.exercice1.servlet;

import com.example.exercice1.model.Product;
import com.example.exercice1.sevice.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;

@WebServlet(name = "updateProduct", value = "/updateProduct")
public class ServletUpdate extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdParam = req.getParameter("id");

        if (productIdParam != null) {
            Long productId = Long.parseLong(productIdParam);
            Product productToUpdate = productService.getProductById(productId);

            if (productToUpdate != null) {
                req.setAttribute("productToUpdate", productToUpdate);
                req.getRequestDispatcher("product-form.jsp").forward(req, resp);
                return;
            }
        }

        resp.sendRedirect("product");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long productId = Long.parseLong(req.getParameter("id"));
            Product productToUpdate = productService.getProductById(productId);

            if (productToUpdate == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
                return;
            }

            String brand = req.getParameter("brand");
            String reference = req.getParameter("reference");
            String dateParam = req.getParameter("date");


            LocalDate  date = LocalDate.parse(dateParam);


            productToUpdate.setDatePurchase(date);

            String priceParam = req.getParameter("price");

                    Double price = Double.parseDouble(priceParam);
                    productToUpdate.setPrice(price);


            String stockParam = req.getParameter("stock");


                    int stock = Integer.parseInt(stockParam);
                    productToUpdate.setStock(stock);


            String uploadPath = getServletContext().getRealPath("/") + "images";

            File file = new File(uploadPath);

            if (!file.exists()) {
                file.mkdir();
            }

            Part image = req.getPart("image");
            String fileName = image.getSubmittedFileName();

            image.write(uploadPath + File.separator + fileName);
            productToUpdate.setImagePath(fileName);

            productToUpdate.setBrand(brand);
            productToUpdate.setReference(reference);



            productService.updateProduct(productToUpdate);

            resp.sendRedirect("product");
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Une erreur interne s'est produite");
        }
    }

}

