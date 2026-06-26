package com.example.demo.controller;

import com.example.demo.entity.ProductImage;
import com.example.demo.service.ProductImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product-images")
@Tag(name = "Product Images")
public class ProductImageController {

    private final ProductImageService imageService;

    public ProductImageController(ProductImageService imageService) {
        this.imageService = imageService;
    }

    @Operation(
            summary = "Upload image for a product",
            description = "Upload an image file and associate it with a product",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Image uploaded successfully"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product not found"
                    )
            }
    )
    @PostMapping(
            value = "/product/{productId}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ProductImage upload(

            @Parameter(description = "Product ID", example = "1")
            @PathVariable Long productId,

            @Parameter(
                    description = "Image file to upload",
                    content = @Content(mediaType = MediaType.MULTIPART_FORM_DATA_VALUE)
            )
            @RequestParam("file") MultipartFile file)

            throws IOException {

        return imageService.upload(productId, file);
    }

    @Operation(
            summary = "Get images by product",
            description = "Retrieve all images belonging to a specific product"
    )
    @GetMapping("/product/{productId}")
    public List<ProductImage> getImages(

            @Parameter(description = "Product ID", example = "1")
            @PathVariable Long productId) {

        return imageService.getByProduct(productId);
    }

    @Operation(
            summary = "Delete image",
            description = "Delete a product image by ID"
    )
    @DeleteMapping("/{id}")
    public String delete(

            @Parameter(description = "Image ID", example = "1")
            @PathVariable Long id) {

        imageService.delete(id);

        return "Image deleted";
    }
}