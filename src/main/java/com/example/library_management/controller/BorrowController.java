package com.example.library_management.controller;

import com.example.library_management.model.BorrowRecord;
import com.example.library_management.service.BorrowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    private final BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping("/{bookId}")
    public String borrowBook(@PathVariable Long bookId,
                             @RequestParam String borrowerName) {

        return borrowService.borrowBook(bookId, borrowerName);
    }

    @PutMapping("/return/{bookId}")
    public String returnBook(@PathVariable Long bookId) {

        return borrowService.returnBook(bookId);
    }

    @GetMapping
    public List<BorrowRecord> getBorrowRecords() {

        return borrowService.getBorrowRecords();
    }
}