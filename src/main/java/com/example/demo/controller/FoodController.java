package com.example.demo.controller;

import com.example.demo.entity.Food;
import com.example.demo.service.FoodService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/myfoods")
@Tag(name = "Food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @Hidden
    @Operation(summary = "Get all products")
    @GetMapping
    public List<Food> all() {
        return foodService.findAll();
    }
}