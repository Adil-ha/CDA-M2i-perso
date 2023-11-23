package org.example.book;

public class Demo {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book("Book_1", new Auteur[]{new Auteur("Jon", "Johnson")}, new Editeur(
                        "Publisher_1"), 1990, 231, Double.valueOf(24.99), CoverType.Relie),


                new Book("Book_2", new Auteur[]{new Auteur("Jon", "Johnson"), new Auteur("William", "Wilson")}
                        , new Editeur("Publisher_2 "), 2000, 120,
                        Double.valueOf(14.99), CoverType.Relie),

                new Book("Livre_3", new Auteur[]{new Auteur("Walter", "Peterson")}, new Editeur
                        ("Publisher_1"), 1997, 350, Double.valueOf(34.99),
                        CoverType.Broche),

                new Book("Book_4", new Auteur[]{new Auteur("Craig", "Gregory")}, new Editeur("Publisher_3")
                        , 1992, 185, Double.valueOf(19.99), CoverType.Broche)
        };

        Book bookService = new Book();

        Auteur auteurTest = new Auteur("Jon", "Johnson");
        Editeur editeurTest = new Editeur("Publisher_1");

        // Filtrer les livres par auteur
        Book[] livresParAuteur = bookService.filterBooksByAuthor(auteurTest, books);
        System.out.println("Livres par auteur:");
        for (Book livre : livresParAuteur) {
            System.out.println(livre);
        }
//
//        // Filtrer les livres par éditeur
//        Book[] livresParEditeur = bookService.filterBooksByPublisher(editeurTest, books);
//        System.out.println("Livres par éditeur:");
//        for (Book livre : livresParEditeur) {
//            System.out.println(livre);
//        }




    }
}
