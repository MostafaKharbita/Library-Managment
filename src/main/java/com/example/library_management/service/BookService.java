package com.example.library_management.service;

import com.example.library_management.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private static final Logger logger =
            LoggerFactory.getLogger(BookService.class);

    private final List<Book> books = new ArrayList<>();


    public BookService() {

        books.add(new Book(
                1L,
                "Java",
                "Mostafa",
                "Programming",
                true
        ));

        books.add(new Book(
                2L,
                "Spring Boot",
                "Mona",
                "Backend",
                true
        ));

        books.add(new Book(
                3L,
                "Clean Code",
                "Robert Martin",
                "Software",
                true
        ));
    }

    public List<Book> getAllBooks() {
        logger.info("Getting all books");
        return books;
    }

    public Book getBookById(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public Book addBook(Book book) {
        logger.info("Adding book: {}", book.getTitle());
        books.add(book);
        return book;
    }
    public void deleteBook(Long id) {
        logger.info("Deleting book with id {}", id);
        books.removeIf(book -> book.getId().equals(id));
    }
}