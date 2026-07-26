package com.example.demo.config;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
@Order(2)
public class ProductSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductSeeder(ProductRepository productRepository,
                         UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        // Prevent duplicate seed data
        if (productRepository.count() > 0) {
            System.out.println("Products already exist. Skipping product seeding.");
            return;
        }

        User user = userRepository.findById(1L)
                .orElseThrow(() ->
                        new RuntimeException("User with ID 1 not found"));


        record ProductSeed(String name, double price) {}

        ProductSeed[] products = {
            new ProductSeed("Apple MacBook Air M3", 1299.99),
            new ProductSeed("Dell XPS 13", 1199.99),
            new ProductSeed("HP Spectre x360", 1399.99),
            new ProductSeed("Lenovo ThinkPad X1 Carbon", 1599.99),
            new ProductSeed("ASUS ROG Zephyrus G14", 1799.99),
            new ProductSeed("Acer Aspire 5", 699.99),
            new ProductSeed("Samsung Galaxy S25", 999.99),
            new ProductSeed("Apple iPhone 17", 1099.99),
            new ProductSeed("Google Pixel 10", 899.99),
            new ProductSeed("OnePlus 14", 799.99),
            new ProductSeed("Xiaomi 16 Pro", 749.99),
            new ProductSeed("Sony WH-1000XM6", 399.99),
            new ProductSeed("Apple AirPods Pro 3", 279.99),
            new ProductSeed("Samsung Galaxy Buds 3 Pro", 249.99),
            new ProductSeed("JBL Charge 6", 199.99),
            new ProductSeed("Bose SoundLink Flex", 169.99),
            new ProductSeed("LG UltraGear 27-inch Monitor", 449.99),
            new ProductSeed("Dell UltraSharp 32 Monitor", 799.99),
            new ProductSeed("Samsung Odyssey G8", 999.99),
            new ProductSeed("Logitech MX Master 3S Mouse", 99.99),
            new ProductSeed("Logitech MX Keys Keyboard", 119.99),
            new ProductSeed("Razer BlackWidow V4 Keyboard", 179.99),
            new ProductSeed("SteelSeries Rival 5 Mouse", 69.99),
            new ProductSeed("Corsair K70 RGB Keyboard", 169.99),
            new ProductSeed("Apple iPad Air", 699.99),
            new ProductSeed("Samsung Galaxy Tab S10", 849.99),
            new ProductSeed("Amazon Kindle Paperwhite", 159.99),
            new ProductSeed("Garmin Forerunner 965", 599.99),
            new ProductSeed("Apple Watch Series 11", 499.99),
            new ProductSeed("Samsung Galaxy Watch 8", 429.99),
            new ProductSeed("Canon EOS R10 Camera", 999.99),
            new ProductSeed("Sony Alpha A6700", 1399.99),
            new ProductSeed("Nikon Z50 II", 1199.99),
            new ProductSeed("GoPro HERO14 Black", 499.99),
            new ProductSeed("DJI Mini 5 Pro Drone", 1099.99),
            new ProductSeed("Anker Power Bank 20000mAh", 59.99),
            new ProductSeed("Belkin USB-C Hub", 89.99),
            new ProductSeed("SanDisk Extreme SSD 1TB", 129.99),
            new ProductSeed("Samsung T9 Portable SSD 2TB", 249.99),
            new ProductSeed("WD Black SN850X 2TB SSD", 219.99),
            new ProductSeed("Seagate Backup Plus 4TB", 119.99),
            new ProductSeed("TP-Link Archer AX73 Router", 179.99),
            new ProductSeed("Netgear Nighthawk AX12", 399.99),
            new ProductSeed("ASUS ZenWiFi XT9", 499.99),
            new ProductSeed("Philips Hue Starter Kit", 199.99),
            new ProductSeed("Google Nest Hub Max", 229.99),
            new ProductSeed("Amazon Echo Show 10", 249.99),
            new ProductSeed("Ring Video Doorbell Pro", 249.99),
            new ProductSeed("Blink Outdoor Camera", 99.99),
            new ProductSeed("Dyson V15 Detect Vacuum", 749.99),
            new ProductSeed("iRobot Roomba j9+", 999.99),
            new ProductSeed("Nespresso Vertuo Coffee Maker", 199.99),
            new ProductSeed("Instant Pot Duo 7-in-1", 99.99),
            new ProductSeed("KitchenAid Stand Mixer", 449.99),
            new ProductSeed("Ninja Air Fryer Max", 169.99),
            new ProductSeed("Breville Smart Oven Air", 399.99),
            new ProductSeed("Sony PlayStation 5 Pro", 699.99),
            new ProductSeed("Microsoft Xbox Series X", 599.99),
            new ProductSeed("Nintendo Switch 2", 449.99),
            new ProductSeed("Valve Steam Deck OLED", 649.99),
            new ProductSeed("Meta Quest 4 VR Headset", 599.99),
            new ProductSeed("Razer Kraken V4 Headset", 129.99),
            new ProductSeed("HyperX Cloud III Headset", 99.99),
            new ProductSeed("Elgato Stream Deck XL", 249.99),
            new ProductSeed("Blue Yeti USB Microphone", 139.99),
            new ProductSeed("Shure MV7 Podcast Microphone", 249.99),
            new ProductSeed("Fujifilm Instax Mini 12", 89.99),
            new ProductSeed("Fitbit Charge 7", 199.99),
            new ProductSeed("Oral-B iO Series 10", 349.99),
            new ProductSeed("Braun Series 9 Pro Shaver", 329.99),
            new ProductSeed("Beats Studio Pro", 349.99),
            new ProductSeed("Marshall Emberton III", 189.99),
            new ProductSeed("Jabra Elite 10 Earbuds", 249.99),
            new ProductSeed("Nothing Ear (3)", 149.99),
            new ProductSeed("Motorola Edge 60 Pro", 699.99),
            new ProductSeed("Realme GT 8 Pro", 649.99),
            new ProductSeed("Honor Magic 8 Pro", 899.99),
            new ProductSeed("Vivo X300 Pro", 949.99),
            new ProductSeed("OPPO Find X9 Pro", 999.99),
            new ProductSeed("Huawei MateBook X Pro", 1599.99),
            new ProductSeed("MSI Katana Gaming Laptop", 1399.99),
            new ProductSeed("Alienware Aurora R16 Desktop", 2299.99),
            new ProductSeed("HP Envy Desktop", 1099.99),
            new ProductSeed("Lenovo Legion Tower 7", 1899.99),
            new ProductSeed("Corsair RM850x Power Supply", 159.99),
            new ProductSeed("NZXT H7 Flow Case", 149.99),
            new ProductSeed("Intel Core Ultra 9 Processor", 649.99),
            new ProductSeed("AMD Ryzen 9 9950X", 699.99),
            new ProductSeed("NVIDIA GeForce RTX 5090", 1999.99),
            new ProductSeed("AMD Radeon RX 9900 XT", 1199.99),
            new ProductSeed("Kingston Fury DDR5 32GB RAM", 159.99),
            new ProductSeed("Crucial DDR5 64GB RAM", 299.99),
            new ProductSeed("Samsung 990 Pro 4TB SSD", 399.99),
            new ProductSeed("TP-Link Tapo Smart Plug", 24.99),
            new ProductSeed("Xiaomi Smart Band 10", 69.99),
            new ProductSeed("Eufy Smart Scale P3", 79.99),
            new ProductSeed("Withings Body Smart Scale", 119.99),
            new ProductSeed("Yale Smart Lock", 249.99),
            new ProductSeed("Tile Pro Tracker", 39.99),
            new ProductSeed("Apple AirTag", 29.99),
            new ProductSeed("SanDisk Ultra microSD 512GB", 59.99),
            new ProductSeed("Lexar Professional SDXC 256GB", 89.99),
            new ProductSeed("UGREEN USB-C Charger 100W", 69.99),
            new ProductSeed("Anker 737 GaN Charger", 89.99),
            new ProductSeed("Baseus USB-C Cable", 14.99)
        };

        for (ProductSeed p : products) {        
            productRepository.save(
                new Product(
                    null,
                    p.name(),
                    p.price(),
                    user,
                    new ArrayList<>()
                )
            );
        }



        productRepository.save(new Product(
                null,
                "Apple iPhone 16",
                79999.0,
                user,
                null
        ));

        productRepository.save(new Product(
                null,
                "Samsung Galaxy S25",
                74999.0,
                user,
                null
        ));

        productRepository.save(new Product(
                null,
                "Google Pixel 10",
                69999.0,
                user,
                null
        ));

        productRepository.save(new Product(
                null,
                "OnePlus 14",
                54999.0,
                user,
                null
        ));

        productRepository.save(new Product(
                null,
                "Nothing Phone 4",
                42999.0,
                user,
                null
        ));

        System.out.println("Product seed completed.");
    }
}