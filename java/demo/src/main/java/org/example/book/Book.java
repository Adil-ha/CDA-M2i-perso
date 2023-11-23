package org.example.book;

import java.util.Arrays;

public class Book {

    private int cpt;
    private int id;

    private String name;

    private Auteur[] auteurs;

    private Editeur editeur;

    private int publishedAnnee;

    private int amountOfPages;

    private double prix;

    private CoverType coverType;

    public Book() {
        this.id = cpt++;
    }

    public Book(String name, Auteur[] auteurs, Editeur editeur, int publishedAnnee, int amountOfPages, double prix, CoverType coverType) {
        this.id = cpt++;
        this.name = name;
        this.auteurs =  auteurs;
        this.editeur = editeur;
        this.publishedAnnee = publishedAnnee;
        this.amountOfPages = amountOfPages;
        this.prix = prix;
        this.coverType = coverType;
    }

    public Book[] filterBooksByAuthor(Auteur author, Book[] books) {
        int count = 0;
        Book[] result = new Book[books.length];

        for (Book book : books) {
            for (Auteur auteur : book.auteurs) {
                if (auteur.getId() == author.getId()) {
                    result[count++] = book;
                    break; // Sortir de la boucle intérieure une fois qu'un auteur correspond
                }
            }
        }

        // Réduire la taille du tableau résultant si nécessaire
        return Arrays.copyOf(result, count);
    }

    public Book[] filterBooksByPublisher(Editeur publisher, Book[] books) {
        int count = 0;
        Book[] result = new Book[books.length];

        for (Book book : books) {
            if (book.editeur.getId() == publisher.getId()) {
                result[count++] = book;
            }
        }

        // Réduire la taille du tableau résultant si nécessaire
        return Arrays.copyOf(result, count);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishedAnnee() {
        return publishedAnnee;
    }

    public void setPublishedAnnee(int publishedAnnee) {
        this.publishedAnnee = publishedAnnee;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public void setAmountOfPages(int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", auteurs=" + Arrays.toString(auteurs) +
                ", editeur=" + editeur +
                ", publishedAnnee=" + publishedAnnee +
                ", amountOfPages=" + amountOfPages +
                ", prix=" + prix +
                ", coverType=" + coverType +
                '}';
    }
}
