package com.example.demo.controller;

import com.example.demo.service.DatabaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
// import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@Tag(name = "Truncate")
public class DatabaseController {

    private final DatabaseService databaseService;

    public DatabaseController(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    // @Hidden
    @Operation(summary = "All Data")
    @DeleteMapping("/truncate")
    public String truncateDatabase() {
        databaseService.truncateAllTables();
        return "Database truncated successfully.";
    }
}