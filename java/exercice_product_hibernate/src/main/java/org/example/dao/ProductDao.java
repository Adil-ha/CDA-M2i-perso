
package org.example.dao;

import org.example.entity.Comment;
import org.example.entity.Image;
import org.example.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.List;

public class ProductDao implements IProductDao {

    private SessionFactory sessionFactory;

    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Product getProductById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Product.class, id);
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public List<Product> getAllProducts() {
        Session session = sessionFactory.openSession();
        Query<Product> query = session.createQuery("from Product", Product.class);
        List<Product> productList = query.getResultList();
        session.close();
        return productList;
    }

    @Override
    public void createProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(product);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteProduct(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.delete(product);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public List<Product> getProductsByPriceGreaterThan(double price) {
        Session session = sessionFactory.openSession();
        Query<Product> query = session.createQuery("from Product where price > :price", Product.class);
        query.setParameter("price", price);
        List<Product> productList = query.getResultList();
        session.close();
        return productList;
    }

    @Override
    public List<Product> getProductsPurchasedBetweenDates(LocalDate startDate, LocalDate endDate) {
        Session session = sessionFactory.openSession();
        Query<Product> query = session.createQuery("from Product where datePurchase between :startDate and :endDate", Product.class);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        List<Product> productList = query.getResultList();
        session.close();
        return productList;
    }

    @Override
    public List<Product> getProductsByStockLessThan(int stockThreshold) {
        Session session = sessionFactory.openSession();
        Query<Product> query = session.createQuery("from Product where stock < :stockThreshold", Product.class);
        query.setParameter("stockThreshold", stockThreshold);
        List<Product> products = query.getResultList();
        session.close();
        return products;
    }

    @Override
    public double getStockValueByBrand(String brand) {
        Session session = sessionFactory.openSession();
        Query<Double> query = session.createQuery("select sum(stock * price) from Product where brand = :brand", Double.class);
        query.setParameter("brand", brand);
        Double result = query.uniqueResult();
        session.close();
        return result;
    }

    @Override
    public double calculateAveragePrice() {
        Session session = sessionFactory.openSession();
        Query<Double> query = session.createQuery("select avg(price) from Product", Double.class);
        Double result = query.uniqueResult();
        session.close();
        return result ;
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        Session session = sessionFactory.openSession();
        Query<Product> query = session.createQuery("from Product where brand = :brand", Product.class);
        query.setParameter("brand", brand);
        List<Product> products = query.getResultList();
        session.close();
        return products;
    }

    @Override
    public void deleteProductsByBrand(String brand) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Product where brand = :brand");
        query.setParameter("brand", brand);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }


    @Override
    public void addImageToProduct(Product product, String imageUrl) {
     Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Image image = new Image();
            image.setImageUrl(imageUrl);
            image.setProduct(product);

            session.save(image);

            transaction.commit();
            session.close();

    }


    @Override
    public void addCommentToProduct(Product product, Comment comment) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        product.getComments().add(comment);

        session.update(product);
        session.save(comment);

        transaction.commit();
        session.close();
    }

    @Override
    public List<Product> getProductsByHighRating() {
        try {
            Session session = sessionFactory.openSession();
            Query<Product> query = session.createQuery("SELECT p FROM Product p JOIN p.comments c WHERE c.rating >= 4", Product.class);
            List<Product> highRatedProducts = query.getResultList();
            session.close();
            return highRatedProducts;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
