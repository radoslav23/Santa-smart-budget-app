package com.radoslav.santa.santasmartbudget.service;

import com.radoslav.santa.santasmartbudget.model.Transaction;
import com.radoslav.santa.santasmartbudget.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public Transaction save(Transaction t) {
        return repo.save(t);
    }

    public List<Transaction> getAll() {
        return repo.findAll();
    }

    public Map<String, Double> getSummary() {
        List<Transaction> all = repo.findAll();
        double income = all.stream().filter(t -> t.getType().equals("income")).mapToDouble(Transaction::getAmount).sum();
        double expense = all.stream().filter(t -> t.getType().equals("expense")).mapToDouble(Transaction::getAmount).sum();
        Map<String, Double> summary = new HashMap<>();
        summary.put("income", income);
        summary.put("expense", expense);
        summary.put("balance", income - expense);
        return summary;
    }

    public List<Transaction> getByType(String type) {
        return repo.findByType(type);
    }

    public List<Transaction> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    public Map<String, Double> getChartData() {
        List<Transaction> all = repo.findAll();

        return all.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCategory,
                        Collectors.summingDouble(Transaction::getAmount)
                ));
    }

    public String getAdvice() {
        List<Transaction> all = repo.findAll();

        double decorations = all.stream()
                .filter(t -> t.getCategory().equalsIgnoreCase("Decorations"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        double gifts = all.stream()
                .filter(t -> t.getCategory().equalsIgnoreCase("Gifts"))
                .mapToDouble(Transaction::getAmount)
                .sum();

        if (decorations > 100) {
            return "You’ve spent too much on decorations — consider reallocating to gifts 🎁";
        }

        if (gifts < decorations) {
            return "Your gift budget is lower than decorations — Santa might need to rebalance!";
        }

        return "Your holiday spending looks balanced so far. Keep it up!";
    }
}