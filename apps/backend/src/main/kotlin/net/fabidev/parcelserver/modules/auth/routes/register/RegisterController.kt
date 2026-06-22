package net.fabidev.parcelserver.modules.auth.routes.register

import jakarta.validation.Valid
import net.fabidev.parcelserver.modules.auth.routes.register.dtos.RegisterRequest
import net.fabidev.parcelserver.shared.Constants
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth/register")
class RegisterController(val registerUseCase: RegisterUseCase) {

    @PostMapping
    fun register(@Valid @RequestBody body: RegisterRequest, @RequestHeader(Constants.HEADER_DEVICE_ID) deviceId: String) {

    }
}