package net.fabidev.parcelserver.modules.auth.routes.register.dtos

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class RegisterRequest(
    @field:Email
    @field:NotBlank
    val email: String,

    @field:NotBlank
    @field:Size(min = 8, max = 512)
    val password: String,

    @field:NotBlank
    @field:Size(max = 32)
    val username: String,
)
