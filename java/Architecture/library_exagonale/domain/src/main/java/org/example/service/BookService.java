package org.example.service;

import org.example.entity.Book;
import org.example.spi.port.BookRepository;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(String title, String author) {
        Book book = new Book(title, author);
        if (bookRepository.create(book)) {
            return book;
        }
        throw new RuntimeException();
    }

    public boolean deleteBook(long id) {
        if (!bookRepository.delete(id)) {
            throw new RuntimeException("Unable to delete book with id: " + id);
        }
        return true;
    }

    public Book findById(long id) {
        return bookRepository.findById(id);

    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBook(String search) {
        if(search.length() < 3) {
            throw new RuntimeException("search word length must be gt 3 char");
        }
        List<Book> list = bookRepository.searchBook(search);
        return list;
    }
}
