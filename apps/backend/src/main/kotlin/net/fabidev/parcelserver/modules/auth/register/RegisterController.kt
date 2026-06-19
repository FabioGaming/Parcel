package net.fabidev.parcelserver.modules.auth.register

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth/register")
class RegisterController(val registerUseCase: RegisterUseCase) {
}