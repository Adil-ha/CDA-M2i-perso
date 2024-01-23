package com.example.exercice1.sevice;

import com.example.exercice1.dao.ProducDao;
import com.example.exercice1.model.Product;

import java.util.List;

public class ProductService {

    private ProducDao producDao;

    public ProductService() {
        producDao = new ProducDao();
    }

    public boolean createProduct(Product p){
        producDao.create(p);
        return true;
    }

    public Product getProductById (Long productId){
        return producDao.findById(productId);
    }

    public List<Product> getAllProducts(){
        return producDao.findAll();
    }

    public boolean deleteProduct(Long id){
        producDao.deleteProduct(id);
        return true;
    }
}
