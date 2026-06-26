package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.ProductImage;
import com.example.demo.repository.ProductImageRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.UUID;

@Service
public class ProductImageService {

    private final ProductRepository productRepository;
    private final ProductImageRepository imageRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public ProductImageService(ProductRepository productRepository,
                               ProductImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    public ProductImage upload(Long productId,
                               MultipartFile file)
            throws IOException {

        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        Files.createDirectories(Paths.get(uploadDir));

        String fileName =
                UUID.randomUUID() + "_" + file.getOriginalFilename();

        Path path = Paths.get(uploadDir, fileName);

        Files.copy(file.getInputStream(),
                path,
                StandardCopyOption.REPLACE_EXISTING);

        ProductImage image = new ProductImage();
        image.setFileName(fileName);
        image.setImageUrl("/uploads/" + fileName);
        image.setProduct(product);

        return imageRepository.save(image);
    }

    public List<ProductImage> getByProduct(Long productId) {
        return imageRepository.findByProductId(productId);
    }

    public void delete(Long id) {

        ProductImage image = imageRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Image not found"));

        try {
            Files.deleteIfExists(
                    Paths.get(uploadDir, image.getFileName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        imageRepository.delete(image);
    }
}