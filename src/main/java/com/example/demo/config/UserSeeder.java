package com.example.demo.config;

import java.util.ArrayList;
import com.example.demo.entity.User;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class UserSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        // Prevent duplicate seed data
        if (userRepository.count() > 0) {
            System.out.println("Users already exist. Skipping user seeding.");
            return;
        }

        record UserSeed(String name, String email, String password) {}

        UserSeed[] users = {
            new UserSeed("Apurba", "apurba@admin.com", "12345678"),            
            new UserSeed("Sanjay", "sanjay@admin.com", "12345678"),
            new UserSeed("Anupam", "anupam@admin.com", "12345678"),
            new UserSeed("Robin", "robin@admin.com", "12345678")        
        };

        for (UserSeed p : users) {        
            userRepository.save(
                new User(
                    null,
                    p.name(),
                    p.email(),
                    passwordEncoder.encode(p.password()),
                    null
                )
            );
        }

        System.out.println("User seed completed.");
    }
}