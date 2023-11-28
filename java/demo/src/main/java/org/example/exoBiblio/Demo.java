package org.example.exoBiblio;

public class Demo {

    public static void main(String[] args) {
        Library library = new Library();
        PaperbackBook paperbackBook1 = new PaperbackBook("test", "test", 59, "test");
        PaperbackBook paperbackBook2 = new PaperbackBook("potter", "harry", 262, "london");
        PaperbackBook paperbackBook3 = new PaperbackBook( "anneau", "seigneur", 5369, "british");
        PaperbackBook paperbackBook4 = new PaperbackBook( "foot", "ronaldo", 102, "fifa");
        PaperbackBook paperbackBook5 = new PaperbackBook( "foot", "ronaldo", 198, "fifa");
        DigitalBook digitalBook1 = new DigitalBook("java", "toto", "PDF", 1000);
        DigitalBook digitalBook2 = new DigitalBook("php", "tata", "EPUB", 1200);

        library.addBook(paperbackBook1);
        library.addBook(paperbackBook2);
        library.addBook(paperbackBook3);
        library.addBook(paperbackBook4);
        library.addBook(paperbackBook5);
        library.addBook(digitalBook1);
        library.addBook(digitalBook2);

//        System.out.println(library.getBookList());

        // library.removeBook(1);
        // System.out.println(library.getBookList());

        System.out.println(library.findBooksByTitle("foot"));
        System.out.println(library.findBooksByAuthor("seigneur"));

        System.out.println(library.returnBook(5));
    }
}
