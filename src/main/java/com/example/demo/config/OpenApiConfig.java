package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Tulio Outlet API")
                        .version("1.0.0")
                        .description("""
                                REST APIs for managing:
                                - Auth
                                - Users
                                - Products
                                - Product Images
                                """)
                        .contact(new Contact()
                                .name("Prasenjit")
                                .email("prasenjit@example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))

                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation")
                        .url("https://github.com/prasenjit1011/SpringBoot"))

                // Order of tags in Swagger UI
                .tags(List.of(
                        new Tag()
                                .name("Hello")
                                .description("Health check APIs"),

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