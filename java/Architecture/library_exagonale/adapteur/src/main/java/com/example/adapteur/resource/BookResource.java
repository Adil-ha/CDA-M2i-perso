package com.example.adapteur.resource;

import com.example.adapteur.dto.BookDto;
import jakarta.inject.Inject;
import org.example.service.BookService;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    private final BookService bookService;

    @Inject
    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    public List<BookDto> getAllBooks() {
        return bookService.findAllBooks().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @POST
    public Response createBook(BookDto bookDto) {
        org.example.entity.Book book = convertToEntity(bookDto);
        bookService.createBook(bookDto.getTitle(), bookDto.getAuthor());
        URI location = URI.create("/books/" + book.getId());
        return Response.created(location).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBook(@PathParam("id") Long id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    private BookDto convertToDto(org.example.entity.Book book) {
        return new BookDto(book.getTitle(), book.getAuthor());
    }

    private org.example.entity.Book convertToEntity(BookDto bookDto) {
        return new org.example.entity.Book(bookDto.getTitle(), bookDto.getAuthor());
    }
}


