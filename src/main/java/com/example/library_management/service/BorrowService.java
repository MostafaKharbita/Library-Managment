package com.example.library_management.service;

import com.example.library_management.model.Book;
import com.example.library_management.model.BorrowRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowService {

    private final BookService bookService;

    private List<BorrowRecord> borrowRecords = new ArrayList<>();

    private Long borrowIdCounter = 1L;

    public BorrowService(BookService bookService) {
        this.bookService = bookService;
    }

    // Borrow Book
    public String borrowBook(Long bookId, String borrowerName) {

        Book book = bookService.getBookById(bookId);

        if (book == null) {
            return "Book not found";
        }

        if (!book.isAvailable()) {
            return "Book is already borrowed";
        }

        if (hasReachedBorrowLimit(borrowerName)) {
            return "Borrow limit reached (Maximum 5 books)";
        }

        if (hasTooManyOverdueBooks(borrowerName)) {
            return "Borrowing blocked due to overdue books";
        }

        BorrowRecord record = new BorrowRecord(
                borrowIdCounter++,
                bookId,
                borrowerName,
                LocalDate.now(),
                LocalDate.now().plusDays(14),
                null,
                "Borrowed"
        );

        borrowRecords.add(record);

        book.setAvailable(false);

        return "Book borrowed successfully";
    }

    // Return Book
    public String returnBook(Long bookId) {

        for (BorrowRecord record : borrowRecords) {

            if (record.getBookId().equals(bookId)
                    && record.getReturnDate() == null) {

                record.setReturnDate(LocalDate.now());
                record.setStatus("Returned");

                Book book = bookService.getBookById(bookId);

                if (book != null) {
                    book.setAvailable(true);
                }

                return "Book returned successfully";
            }
        }

        return "Borrow record not found";
    }

    // Borrow Limit
    private boolean hasReachedBorrowLimit(String borrowerName) {

        int count = 0;

        for (BorrowRecord record : borrowRecords) {

            if (record.getBorrowerName().equalsIgnoreCase(borrowerName)
                    && record.getReturnDate() == null) {

                count++;
            }
        }

        return count >= 5;
    }

    // Overdue Check
    private boolean hasTooManyOverdueBooks(String borrowerName) {

        int overdueCount = 0;

        LocalDate today = LocalDate.now();

        for (BorrowRecord record : borrowRecords) {

            if (record.getBorrowerName().equalsIgnoreCase(borrowerName)
                    && record.getReturnDate() == null
                    && today.isAfter(record.getDueDate())) {

                record.setStatus("Overdue");
                overdueCount++;
            }
        }

        return overdueCount >= 3;
    }

    public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }

    public boolean isBookBorrowed(Long bookId) {
        for (BorrowRecord record : borrowRecords) {
            if (record.getBookId().equals(bookId)
                    && record.getReturnDate() == null) {
                return true;
            }
        }
        return false;
    }

}