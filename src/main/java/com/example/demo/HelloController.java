package com.example.demo;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@Tag(name = "Hello")
public class HelloController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
                "message", "Spring Boot is running successfully!",
                "currentTime", LocalDateTime.now()
        );
    }
}