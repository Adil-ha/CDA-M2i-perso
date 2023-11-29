package org.example.stationery;

public class Demo {
    public static void main(String[] args) {
        // Création d'articles
        ArticleUnitary penArticle = new Pen("Blue Pen", 1.5, "Blue");
        ArticleUnitary reamArticle = new Ream("Printer Paper", 5.0, 80);

        // Création d'un lot
        Batch batch = new Batch(penArticle, 3, 10);

        // Création d'une facture
        Invoice invoice = new Invoice("John Doe", "2023-11-29");

        // Ajout de lignes à la facture
        invoice.addLine(penArticle.getReference(), 2);
        invoice.addLine(reamArticle.getReference(), 1);

        // Ajout d'un lot à la facture
        invoice.addLine(batch.getReference(), 1);

        // Affichage de la facture
        System.out.println("Invoice details:");
        System.out.println(invoice);

        // Récupération d'un article par référence
        Article retrievedArticle = ArticleManager.getArticleByReference(penArticle.getReference());
        if (retrievedArticle != null) {
            System.out.println("Retrieved Article: " + retrievedArticle);
        } else {
            System.out.println("Article not found.");
        }
    }
}

