package net.fabidev.parcelserver.modules.auth.register

import net.fabidev.parcelserver.modules.auth.entity.Account
import net.fabidev.parcelserver.modules.auth.repository.AccountRepository
import net.fabidev.parcelserver.modules.auth.shared.PasswordHasher
import org.springframework.stereotype.Service

@Service
class RegisterUseCaseImpl(private val passwordHasher: PasswordHasher, private val accountRepository: AccountRepository) : RegisterUseCase {

    override fun execute(email: String, password: String): Account {
        TODO("implement execution")
    }
}