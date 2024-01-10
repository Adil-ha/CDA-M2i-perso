package org.example.service;

import org.example.dao.CommandDao;
import org.example.model.Command;
import org.example.model.Product;
import org.example.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.List;

public class CommandService {

    private CommandDao commandDao;
    private ProductService productService;
    private static SessionFactory sessionFactory;

    public CommandService(){
        sessionFactory = HibernateUtil.getSessionFactory();
        commandDao = new CommandDao(sessionFactory);
        productService = new ProductService();

    }

    public void createCommand(Command command) {
        try {
            command.setOrderDate(LocalDate.now());

            double total = 0.0;
            List<Product> products = command.getProducts();
            for (Product product : products) {
                total += product.getPrice();
                product.decrementStock();
                productService.updateProduct(product);
            }

            command.setTotal(total);

            commandDao.createCommand(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Command> getAllCommands() {
        try {
            return commandDao.getAllCommands();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Command> getCommandsOfTheDay() {
        try {
            return commandDao.getCommandsOfTheDay();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
