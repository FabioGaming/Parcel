package net.fabidev.parcelserver.modules.auth.routes.register

import net.fabidev.parcelserver.modules.auth.routes.register.dtos.RegisterRequest

interface RegisterUseCase {
    fun execute(request: RegisterRequest, deviceId: String): RegisterResult
}