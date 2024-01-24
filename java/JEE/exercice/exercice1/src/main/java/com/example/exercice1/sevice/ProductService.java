package com.example.exercice1.sevice;

import com.example.exercice1.dao.ProducDao;
import com.example.exercice1.model.Product;

import java.util.List;

public class ProductService {

    private ProducDao producDao;

    public ProductService() {
        producDao = new ProducDao();
    }

    public boolean createProduct(Product p) {
        try {
            producDao.create(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Product getProductById(Long productId) {
        try {
            return producDao.findById(productId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> getAllProducts() {
        try {
            return producDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteProduct(Long id) {
        try {
            producDao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateProduct(Product updatedProduct) {

        Product existingProduct = getProductById(updatedProduct.getIdProduct());

        if (existingProduct != null) {

            return producDao.update(updatedProduct);
        } else {

            return false;
        }
    }
}

