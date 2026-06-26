package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Tulio Outlet API")
                        .version("1.0")
                        .description("""
                                REST APIs for managing Users, Products,
                                and Product Images.
                                """)
                        .contact(new Contact()
                                .name("Prasenjit")
                                .email("prasenjit@example.com")))

                // Order of tags in Swagger UI
                .tags(Arrays.asList(
                        new Tag()
                                .name("Hello"),

                        new Tag()
                                .name("User")
                                .description("User management APIs"),

                        new Tag()
                                .name("Product")
                                .description("Product management APIs"),

                        new Tag()
                                .name("Product Images")
                                .description("Product image upload and management APIs")
                ));
    }
}