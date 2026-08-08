package com.example.library_management.controller;

import com.example.library_management.config.LibraryProperties;
import com.example.library_management.model.Book;
import com.example.library_management.service.BookService;
import com.example.library_management.service.BorrowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final LibraryProperties properties;
    private final String applicationMessage;
    private final BorrowService borrowService;

    public BookController(BookService bookService,
                          LibraryProperties properties,
                          String applicationMessage,
                          BorrowService borrowService) {

        this.bookService = bookService;
        this.properties = properties;
        this.applicationMessage = applicationMessage;
        this.borrowService = borrowService;
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
    public String deleteBook(@PathVariable Long id) {
        if (borrowService.isBookBorrowed(id)) {
            return "Cannot delete borrowed book";
        }
        bookService.deleteBook(id);
        return "Book deleted successfully";
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