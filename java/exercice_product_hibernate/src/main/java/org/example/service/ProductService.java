package org.example.service;

import org.example.dao.IProductDao;
import org.example.dao.ProductDao;
import org.example.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.List;

public class ProductService implements IProductService {

    private IProductDao productDao;
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;



    public ProductService() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        productDao = new ProductDao(sessionFactory);
    }


    @Override
    public Product getProductById(Long id) {
        try {
            return productDao.getProductById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        try {
            return productDao.getAllProducts();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void createProduct(Product product) {
        try {
            productDao.createProduct(product);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void updateProduct(Long id, String newBrand, String newReference, LocalDate newDatePurchase, Double newPrice) {
        Product existingProduct = productDao.getProductById(id);

        if (existingProduct != null) {
            existingProduct.setBrand(newBrand);
            existingProduct.setReference(newReference);
            existingProduct.setDatePurchase(newDatePurchase);
            existingProduct.setPrice(newPrice);

            try {
                productDao.updateProduct(existingProduct);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Aucun produit trouvé avec l'ID spécifié.");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            productDao.deleteProduct(id);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<Product> getProductsByPriceGreaterThan(double price) {
        try {
            return productDao.getProductsByPriceGreaterThan(price);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getProductsPurchasedBetweenDates(LocalDate startDate, LocalDate endDate) {
        try {
            return productDao.getProductsPurchasedBetweenDates(startDate, endDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> getProductsByStockLessThan(int stockThreshold) {
        try {
            return productDao.getProductsByStockLessThan(stockThreshold);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public double getStockValueByBrand(String brand) {
        try {
            return productDao.getStockValueByBrand(brand);
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    @Override
    public double calculateAveragePrice() {
        try {
            return productDao.calculateAveragePrice();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        try {
            return productDao.getProductsByBrand(brand);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteProductsByBrand(String brand) {
        try {
            productDao.deleteProductsByBrand(brand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

