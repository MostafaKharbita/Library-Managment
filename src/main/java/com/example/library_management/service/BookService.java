package com.example.library_management.service;

import com.example.library_management.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private static final Logger logger =
            LoggerFactory.getLogger(BookService.class);

    public BookService() {
        books.add(new Book(1L, "Java Basics", "Kharbita", "Programming"));
        books.add(new Book(2L, "Spring Boot", "Aya", "Backend"));
        books.add(new Book(3L, "Angular", "Mostafa", "Frontend"));
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
