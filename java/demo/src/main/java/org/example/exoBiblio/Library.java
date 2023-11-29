package org.example.exoBiblio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList;
    private List<Loan> loanList;

    public Library() {
        this.bookList = new ArrayList<Book>();
        this.loanList = new ArrayList<Loan>();
    }

    public boolean addBook(Book book) {
        return bookList.add(book);

    }

    public boolean removeBook(int bookId) {


        for (Book book : bookList) {
            if (book.getId()==(bookId)) {
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBooks.add(book);
            }
        }
        return foundBooks.isEmpty() ? null : foundBooks;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks.isEmpty() ? null : foundBooks;
    }

    public String borrowBook(int bookId, Person person, LocalDate endDate) {
        Book foundBook = null;

        // Recherche du livre par son ID
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                foundBook = book;
                break;
            }
        }

        if (foundBook != null) {
            // Vérification si le livre est déjà emprunté
            for (Loan loan : loanList) {
                if (loan.getBook().getId() == bookId) {
                    return "Book already borrowed";
                }
            }

            // Création d'un nouvel emprunt
            Loan loan = new Loan(foundBook, person, endDate);
            loanList.add(loan);

            // Mise à jour du statut du livre (par exemple, marquer comme emprunté)
            foundBook.setBorrowed(true);

            return "Book borrowed successfully";
        } else {
            return "Book not found";
        }
    }

    public String returnBook(int bookId) {
        Book foundBook = null;

        for (Book book : bookList) {
            if (book.getId()== bookId) {
                foundBook = book;
                break;
            }
        }

        if (foundBook != null) {
            return foundBook.getTitle();
        } else {
            return "Book not found";
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public void setLoanList(List<Loan> loanList) {
        this.loanList = loanList;
    }
}