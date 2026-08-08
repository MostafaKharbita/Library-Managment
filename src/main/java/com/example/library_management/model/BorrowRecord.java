package com.example.library_management.model;

import java.time.LocalDate;

public class BorrowRecord {

    private Long borrowId;

    private Long bookId;

    private String borrowerName;

    private LocalDate borrowDate;

    private LocalDate dueDate;

    private LocalDate returnDate;

    private String status;

    public BorrowRecord() {
    }

    public BorrowRecord(Long borrowId,
                        Long bookId,
                        String borrowerName,
                        LocalDate borrowDate,
                        LocalDate dueDate,
                        LocalDate returnDate,
                        String status) {

        this.borrowId = borrowId;
        this.bookId = bookId;
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}