package com.example.library_aop.service;

import com.example.library_aop.annotation.Performance;
import com.example.library_aop.entity.Book;
import com.example.library_aop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Performance
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Performance
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Performance
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Performance
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Performance
    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Performance
    public List<Book> searchBooksByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase(author);
    }

    @Performance
    public Optional<Book> borrowBook(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        optionalBook.ifPresent(book -> {
            if (!book.isBorrowed()) {
                book.setBorrowed(true);
                bookRepository.save(book);
            }
        });
        return optionalBook;
    }

    @Performance
    public Optional<Book> returnBook(Long bookId) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        optionalBook.ifPresent(book -> {
            if (book.isBorrowed()) {
                book.setBorrowed(false);
                bookRepository.save(book);
            }
        });
        return optionalBook;
    }
}
