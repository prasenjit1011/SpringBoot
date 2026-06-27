package com.example.demo.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabaseService {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void truncateAllTables() {

        // PostgreSQL
        jdbcTemplate.execute(
            "TRUNCATE TABLE product_images, products, users RESTART IDENTITY CASCADE"
        );

        System.out.println("All tables truncated successfully.");
    }
}