package com.example.library.service;

import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.entity.Transaction;
import com.example.library.repository.BookRepository;
import com.example.library.repository.UserRepository;
import com.example.library.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // ---------- BOOK METHODS ----------
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // ---------- USER METHODS ----------
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    // ---------- TRANSACTION METHODS ----------
    public Transaction borrowBook(Long userId, Long bookId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Book> bookOpt = bookRepository.findById(bookId);

        if (userOpt.isPresent() && bookOpt.isPresent()) {
            Transaction transaction = new Transaction();
            transaction.setUser(userOpt.get());
            transaction.setBook(bookOpt.get());
            transaction.setBorrowDate(LocalDateTime.now());
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("User or Book not found");
        }
    }

    public Transaction returnBook(Long transactionId) {
        Optional<Transaction> transOpt = transactionRepository.findById(transactionId);

        if (transOpt.isPresent()) {
            Transaction transaction = transOpt.get();
            transaction.setReturnDate(LocalDateTime.now());
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Transaction not found");
        }
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}
