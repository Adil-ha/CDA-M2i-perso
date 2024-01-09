package org.example.util;

import org.example.dao.IProductDao;
import org.example.dao.ProductDao;
import org.example.model.Product;
import org.example.service.IProductService;
import org.example.service.ProductService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Ihm {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    private Scanner scanner;

    private String choice;

    private IProductDao productDao;
    private IProductService productService;

    public Ihm() {
        initializeSessionFactory();
        this.productDao = new ProductDao(sessionFactory);
        this.productService = new ProductService(productDao);
        this.scanner = new Scanner(System.in);
    }

    private void initializeSessionFactory() {
        registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
        }
    }

    public void start() {
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    createProduct();
                    break;
                case "2":
                    getProductById();
                    break;
                case "3":
                    deleteProduct();
                    break;
                case "4":
                    updateProduct();
                    break;
                case "5":
                    displayAllProducts();
                    break;
                case "6":
                    displayProductsByPriceGreaterThan();
                    break;
                case "7":
                    displayProductsPurchasedBetweenDates();
                    break;
                case "8":
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (!choice.equals("5"));

    }

    private void menu() {
        System.out.println("########## Menu ##########");
        System.out.println("1- Créer un produit");
        System.out.println("2- Obtenir un produit par ID");
        System.out.println("3- Supprimer un produit");
        System.out.println("4- Mettre à jour un produit");
        System.out.println("5- Afficher la totalité des produits");
        System.out.println("6- Afficher la liste des produits dont le prix est supérieur à 100 euros");
        System.out.println("7- Afficher la liste des produits achetés entre deux dates");
        System.out.println("8- Quitter");
        System.out.print("Votre choix : ");
    }

    private void createProduct() {
        System.out.println("##### Création d'un produit #####");

        System.out.print("Marque : ");
        String brand = scanner.nextLine();

        System.out.print("Référence : ");
        String reference = scanner.nextLine();

        System.out.print("Date d'achat (YYYY-MM-DD) : ");
        String dateString = scanner.nextLine();
        LocalDate datePurchase = LocalDate.parse(dateString);

        System.out.print("Prix : ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Stock : ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product();
        product.setBrand(brand);
        product.setReference(reference);
        product.setDatePurchase(datePurchase);
        product.setPrice(price);
        product.setStock(stock);

        productService.createProduct(product);

        System.out.println("Produit créé avec succès !");
    }

    private void getProductById() {
        System.out.println("##### Obtenir un produit par ID #####");
        System.out.print("ID du produit : ");
        Long productId = scanner.nextLong();
        scanner.nextLine();

        Product product = productService.getProductById(productId);

        if (product != null) {
            System.out.println("Informations du produit : " + product);
        } else {
            System.out.println("Aucun produit trouvé avec l'ID spécifié.");
        }
    }

    private void deleteProduct() {
        System.out.println("##### Supprimer un produit #####");
        System.out.print("ID du produit à supprimer : ");
        Long productId = scanner.nextLong();
        scanner.nextLine();

        productService.deleteProduct(productId);

        System.out.println("Produit supprimé avec succès !");
    }

    private void updateProduct() {
        System.out.println("##### Mettre à jour un produit #####");
        System.out.print("ID du produit à mettre à jour : ");
        Long productId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Nouvelle marque : ");
        String newBrand = scanner.nextLine();

        System.out.print("Nouvelle référence : ");
        String newReference = scanner.nextLine();

        System.out.print("Nouvelle date d'achat (YYYY-MM-DD) : ");
        String newDateString = scanner.nextLine();
        LocalDate newDatePurchase = LocalDate.parse(newDateString);

        System.out.print("Nouveau prix : ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();

        productService.updateProduct(productId, newBrand, newReference, newDatePurchase, newPrice);

        System.out.println("Produit mis à jour avec succès !");
    }


    private void displayAllProducts() {
        System.out.println("##### Afficher la totalité des produits #####");
        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private void displayProductsByPriceGreaterThan() {
        System.out.println("##### Afficher la liste des produits dont le prix est supérieur à 100 euros #####");
        double minPrice = 100.0;
        List<Product> products = productService.getProductsByPriceGreaterThan(minPrice);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private void displayProductsPurchasedBetweenDates() {
        System.out.println("##### Afficher la liste des produits achetés entre deux dates #####");
        System.out.print("Date de début (YYYY-MM-DD) : ");
        String startDateString = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(startDateString);

        System.out.print("Date de fin (YYYY-MM-DD) : ");
        String endDateString = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(endDateString);

        List<Product> products = productService.getProductsPurchasedBetweenDates(startDate, endDate);
        for (Product product : products) {
            System.out.println(product);
        }
    }



}

