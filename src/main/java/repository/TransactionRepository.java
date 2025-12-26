package com.radoslav.santa.santasmartbudget.repository;

import com.radoslav.santa.santasmartbudget.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByType(String type);
    List<Transaction> findByCategory(String category);
}





