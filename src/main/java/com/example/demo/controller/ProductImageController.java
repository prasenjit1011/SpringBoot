package com.example.demo.controller;

import com.example.demo.entity.ProductImage;
import com.example.demo.service.ProductImageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product-images")
public class ProductImageController {

    private final ProductImageService imageService;

    public ProductImageController(ProductImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(
            value = "/product/{productId}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ProductImage upload(
            @PathVariable Long productId,
            @RequestParam("file") MultipartFile file)
            throws IOException {

        return imageService.upload(productId, file);
    }

    @GetMapping("/product/{productId}")
    public List<ProductImage> getImages(
            @PathVariable Long productId) {

        return imageService.getByProduct(productId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        imageService.delete(id);

        return "Image deleted";
    }
}