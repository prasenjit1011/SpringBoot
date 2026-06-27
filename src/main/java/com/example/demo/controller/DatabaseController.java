package com.example.demo.controller;

import com.example.demo.service.DatabaseService;
// import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class DatabaseController {

    private final DatabaseService databaseService;

    public DatabaseController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    // @Hidden
    @DeleteMapping("/truncate")
    public String truncateDatabase() {
        databaseService.truncateAllTables();
        return "Database truncated successfully.";
    }
}