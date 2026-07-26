package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequest(

    @Schema(
        description = "User email",
        example = "apurba@admin.com"
    )
    String email,

    @Schema(
        description = "User password",
        example = "12345678"
    )
    String password
) {}