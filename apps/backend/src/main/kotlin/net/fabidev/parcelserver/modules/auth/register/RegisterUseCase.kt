package net.fabidev.parcelserver.modules.auth.register

import net.fabidev.parcelserver.modules.auth.entity.Account

interface RegisterUseCase {
    fun execute(email: String, password: String): Account
}