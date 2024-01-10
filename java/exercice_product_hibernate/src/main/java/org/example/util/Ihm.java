package org.example.util;

import org.example.model.Command;
import org.example.model.Product;
import org.example.service.CommandService;
import org.example.service.IProductService;
import org.example.service.ProductService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ihm {

    private Scanner scanner;

    private String choice;

    private IProductService productService;

    private CommandService  commandService;

    public Ihm() {
        productService = new ProductService();
        commandService = new CommandService();
        scanner = new Scanner(System.in);
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
                    displayProductsByStockLessThan();
                    break;
                case "9":
                    displayStockValueByBrand();
                    break;
                case "10":
                    calculateAveragePrice();
                    break;
                case "11":
                    displayProductsByBrand();
                    break;
                case "12":
                    deleteProductsByBrand();
                    break;
                case "13":
                    addImageToProduct();
                    break;
                case "14":
                    addCommentToProduct();
                    break;
                case "15":
                    displayProductsByHighRating();
                    break;
                case "16":
                    createCommand();
                    break;
                case "17":
                    displayAllCommands();
                    break;
                case "18":
                    displayCommandsOfTheDay();
                    break;

                case "0":
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (!choice.equals("0"));

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
        System.out.println("8- Afficher numéros et références dont le stock est inférieur à une valeur");
        System.out.println("9- Afficher la valeur du stock des produits d'une marque choisie");
        System.out.println("10- Calculer le prix moyen des produits");
        System.out.println("11- Récupérer la liste des produits d'une marque choisie");
        System.out.println("12- Supprimer les produits d'une marque choisie");
        System.out.println("13- Ajouter une image à un produit");
        System.out.println("14- Ajouter un commentaire à un produit");
        System.out.println("15- Afficher les produits avec une note de 4 ou plus");
        System.out.println("16- Créer une commande");
        System.out.println("17- Afficher la totalité des commandes");
        System.out.println("18- Afficher les commandes du jour");
        System.out.println("0- Quitter");
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

    private void displayProductsByStockLessThan() {
        System.out.println("##### Afficher les articles dont le stock est inférieur à une valeur #####");
        System.out.print("Stock maximal : ");
        int stockThreshold = scanner.nextInt();
        scanner.nextLine();

        List<Product> products = productService.getProductsByStockLessThan(stockThreshold);

        if (!products.isEmpty()) {
            System.out.println("Articles avec un stock inférieur à " + stockThreshold + " :");

            for (Product product : products) {
                System.out.println("Numéro : " + product.getIdProduct() + ", Référence : " + product.getReference());
            }
        } else {
            System.out.println("Aucun article trouvé avec un stock inférieur à " + stockThreshold + ".");
        }
    }

    private void displayStockValueByBrand() {
        System.out.println("##### Afficher la valeur du stock des produits d'une marque choisie #####");
        System.out.print("Marque : ");
        String brand = scanner.nextLine();

        double stockValue = productService.getStockValueByBrand(brand);

        System.out.println("Valeur du stock pour la marque " + brand + " : " + stockValue);
    }

    private void calculateAveragePrice() {
        System.out.println("##### Calculer le prix moyen des produits #####");

        double averagePrice = productService.calculateAveragePrice();

        System.out.println("Le prix moyen des produits est : " + averagePrice);
    }

    private void displayProductsByBrand() {
        System.out.println("##### Récupérer la liste des produits d'une marque choisie #####");
        System.out.print("Marque : ");
        String brand = scanner.nextLine();

        List<Product> products = productService.getProductsByBrand(brand);

        if (!products.isEmpty()) {
            System.out.println("Liste des produits de la marque " + brand + " :");

            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Aucun produit trouvé pour la marque spécifiée.");
        }
    }

    private void deleteProductsByBrand() {
        System.out.println("##### Supprimer les produits d'une marque choisie #####");
        System.out.print("Marque : ");
        String brand = scanner.nextLine();

        productService.deleteProductsByBrand(brand);

        System.out.println("Produits de la marque " + brand + " supprimés avec succès.");
    }

    private void addImageToProduct() {
        System.out.println("##### Ajouter une image à un produit #####");

        System.out.print("ID du produit auquel ajouter une image : ");
        Long productId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("URL de l'image : ");
        String imageUrl = scanner.nextLine();

        productService.addImageToProduct(productId, imageUrl);

        System.out.println("Image ajoutée au produit avec succès !");
    }

    private void addCommentToProduct() {
        System.out.println("##### Ajouter un commentaire à un produit #####");

        System.out.print("ID du produit auquel ajouter un commentaire : ");
        Long productId = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Contenu du commentaire : ");
        String content = scanner.nextLine();

        System.out.print("Note du commentaire (entre 1 et 5) : ");
        int rating = scanner.nextInt();
        scanner.nextLine();

        productService.addCommentToProduct(productId, content, rating);

        System.out.println("Commentaire ajouté au produit avec succès !");
    }

    private void displayProductsByHighRating() {
        System.out.println("##### Afficher les produits avec une note de 4 ou plus #####");

        List<Product> highRatedProducts = productService.getProductsByHighRating();
        for (Product product : highRatedProducts) {
            System.out.println(product);
        }
    }

    private void createCommand() {
        System.out.println("##### Création d'une commande #####");

        List<Product> existingProducts = getExistingProductsFromUserInput();

        Command command = new Command();
        command.setProducts(existingProducts);

        commandService.createCommand(command);

        System.out.println("Commande créée avec succès !");
    }

    private List<Product> getExistingProductsFromUserInput() {
        List<Product> existingProducts = new ArrayList<>();

        System.out.println("##### Liste des produits existants #####");
        List<Product> allProducts = productService.getAllProducts();

        for (Product product : allProducts) {
            System.out.println(product);
            System.out.print("Voulez-vous ajouter ce produit à la commande ? (O/N) : ");
            String userInput = scanner.nextLine().toUpperCase();

            if (userInput.equals("O")) {
                existingProducts.add(product);
            }
        }

        return existingProducts;
    }

    private void displayAllCommands() {
        System.out.println("##### Afficher la totalité des commandes #####");
        List<Command> commands = commandService.getAllCommands();
        if (commands != null && !commands.isEmpty()) {
            for (Command command : commands) {
                System.out.println(command);
            }
        } else {
            System.out.println("Aucune commande trouvée.");
        }
    }

    private void displayCommandsOfTheDay() {
        System.out.println("##### Afficher les commandes du jour #####");
        List<Command> commands = commandService.getCommandsOfTheDay();
        if (commands != null && !commands.isEmpty()) {
            for (Command command : commands) {
                System.out.println(command);
            }
        } else {
            System.out.println("Aucune commande du jour trouvée.");
        }
    }





}

