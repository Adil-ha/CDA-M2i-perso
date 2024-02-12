package com.example.adapteur.resource;

import com.example.adapteur.dto.BookDTO;
import org.example.entity.Book;
import org.example.repository.BookRepositoryImpl;
import org.example.service.BookService;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("book")
public class BookResource {
    private final BookService bookService;


    public BookResource() {
        this.bookService = new BookService(new BookRepositoryImpl());
    }

    @GET
    @Path("{search}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BookDTO> get(@PathParam("search") String search) {
        List<Book> list = bookService.searchBook(search);
        return list
                .stream()
                .map(book -> BookDTO.
                        builder().
                        author(book.getAuthor())
                        .title(book.getTitle())
                        .id(book.getId())
                        .build()).collect(Collectors.toList());
    }

    @POST
    public Response post(BookDTO bookDTO) {
        try {
            bookService.createBook(bookDTO.getTitle(), bookDTO.getAuthor());
            return Response.ok().build();
        }catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        try {
            bookService.deleteBook(id);
            return Response.ok().build();
        }catch (Exception ex) {
            return Response.status(500, "Erreur serveur").build();
        }
    }
}


