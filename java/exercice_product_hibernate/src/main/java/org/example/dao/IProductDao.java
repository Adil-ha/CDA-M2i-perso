package org.example.dao;

import org.example.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface IProductDao {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    void createProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long id);

    List<Product> getProductsByPriceGreaterThan(double price);

    List<Product> getProductsPurchasedBetweenDates(LocalDate startDate, LocalDate endDate);
    List<Product> getProductsByStockLessThan(int stockThreshold);

    double getStockValueByBrand(String brand);
    double calculateAveragePrice();
    List<Product> getProductsByBrand(String brand);
    void deleteProductsByBrand(String brand);

}

