package com.example.library_management.controller;

import com.example.library_management.config.LibraryProperties;
import com.example.library_management.model.Book;
import com.example.library_management.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final LibraryProperties properties;
    private final String applicationMessage;

    public BookController(BookService bookService,
                           LibraryProperties properties,
                           String applicationMessage) {

        this.bookService = bookService;
        this.properties = properties;
        this.applicationMessage = applicationMessage;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping("/config")
    public LibraryProperties getConfig() {
        return properties;
    }

    @GetMapping("/message")
    public String getMessage() {
        return applicationMessage;
    }

}