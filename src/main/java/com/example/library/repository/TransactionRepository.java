package com.example.library.repository;

import com.example.library.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Custom queries can go here, for example:
    // List<Transaction> findByUserId(Long userId);
}
