package net.fabidev.parcelserver.modules.auth.routes.register

import net.fabidev.parcelserver.modules.auth.entity.Account

sealed class RegisterResult {
    data class Success(val account: Account, val accessToken: String, val refreshToken: String): RegisterResult()

    sealed class Error : RegisterResult() {
        data object EmailAlreadyUsed : Error()
    }
}