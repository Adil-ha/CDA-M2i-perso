package org.example.spi.port;

import org.example.entity.Book;

import java.util.List;

public interface BookRepository {
    boolean create(Book todo);
    boolean delete(Long id);

    Book findById(Long id);

    List<Book> findAll();
}
