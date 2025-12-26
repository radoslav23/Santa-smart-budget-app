package controller;

import model.Transaction;
import service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public Transaction add(@RequestBody Transaction t) {
        return service.save(t);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return service.getAll();
    }

    @GetMapping("/type/{type}")
    public List<Transaction> getByType(@PathVariable String type) {
        return service.getByType(type);
    }

    @GetMapping("/summary")
    public Map<String, Double> getSummary() {
        return service.getSummary();
    }

    @GetMapping("/category/{category}")
    public List<Transaction> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/chart-data")
    public Map<String, Double> getChartData() {
        return service.getChartData();
    }

    @GetMapping("/advice")
    public String getAdvice() {
        return service.getAdvice();
    }

}