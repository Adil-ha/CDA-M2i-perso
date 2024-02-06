package org.example.repository;

import org.example.entity.Book;

import java.util.List;

public class BookEntityRepository extends BaseEntityRepository<Book>{
    @Override
    Book findById(Long id) {
        return null;
    }

    @Override
    List<Book> findAll() {
        return null;
    }
}
