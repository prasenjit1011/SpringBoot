package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Tulio Outlet API")
                        .version("1.0")
                        .description("User and Product CRUD APIs")
                        .contact(new Contact()
                                .name("Prasenjit")
                                .email("prasenjit@example.com")));
    }
}