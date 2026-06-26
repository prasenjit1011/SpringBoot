package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // create product for a user
    @PostMapping("/user/{userId}")
    public Product create(@PathVariable Long userId,
                          @RequestBody Product product) {

        return productService.create(userId, product);
    }

    @GetMapping
    public List<Product> all() {
        return productService.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Product> byUser(@PathVariable Long userId) {
        return productService.findByUser(userId);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,
                          @RequestBody Product product) {

        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "Deleted";
    }
}