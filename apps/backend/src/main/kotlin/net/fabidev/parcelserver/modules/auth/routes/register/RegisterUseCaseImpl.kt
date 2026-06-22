package net.fabidev.parcelserver.modules.auth.routes.register

import net.fabidev.parcelserver.modules.auth.entity.Account
import net.fabidev.parcelserver.modules.auth.repository.AccountRepository
import net.fabidev.parcelserver.modules.auth.routes.register.dtos.RegisterRequest
import net.fabidev.parcelserver.modules.auth.shared.PasswordHasher
import net.fabidev.parcelserver.shared.events.abstractions.DomainEventPublisher
import org.springframework.stereotype.Service

@Service
class RegisterUseCaseImpl(private val passwordHasher: PasswordHasher, private val accountRepository: AccountRepository, private val eventPublisher: DomainEventPublisher) : RegisterUseCase {

    override fun execute(request: RegisterRequest, deviceId: String): RegisterResult {
        if(this.accountRepository.existsAccountByEmail(request.email)) {
            return RegisterResult.Error.EmailAlreadyUsed;
        }
    }
}