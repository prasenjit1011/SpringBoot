package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // create product for a user
    @Operation(summary = "Create a new product")
    @PostMapping("/user/{userId}")
    public Product create(@PathVariable Long userId,
                          @RequestBody Product product) {

        return productService.create(userId, product);
    }

    @Operation(summary = "Get all products")
    @GetMapping
    public List<Product> all() {
        return productService.findAll();
    }

    @Operation(summary = "Get all user's products")
    @GetMapping("/user/{userId}")
    public List<Product> byUser(@PathVariable Long userId) {
        return productService.findByUser(userId);
    }

    @Operation(summary = "Update products")
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,
                          @RequestBody Product product) {

        return productService.update(id, product);
    }

    @Operation(summary = "Delete products")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "Deleted";
    }
}