package net.fabidev.parcelserver.modules.auth.routes.register

import net.fabidev.parcelserver.modules.auth.entity.Account
import net.fabidev.parcelserver.modules.auth.entity.Device
import net.fabidev.parcelserver.modules.auth.repository.AccountRepository
import net.fabidev.parcelserver.modules.auth.repository.DeviceRepository
import net.fabidev.parcelserver.modules.auth.repository.RefreshTokenRepository
import net.fabidev.parcelserver.modules.auth.repository.VerificationChallengeRepository
import net.fabidev.parcelserver.modules.auth.routes.register.dtos.RegisterRequest
import net.fabidev.parcelserver.modules.auth.shared.PasswordHasher
import net.fabidev.parcelserver.shared.AccountRole
import net.fabidev.parcelserver.shared.events.abstractions.DomainEventPublisher
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.UUID

@Service
class RegisterUseCaseImpl(
    private val passwordHasher: PasswordHasher,
    private val accountRepository: AccountRepository,
    private val deviceRepository: DeviceRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val verificationChallengeRepository: VerificationChallengeRepository,
    private val eventPublisher: DomainEventPublisher
) : RegisterUseCase {

    override fun execute(request: RegisterRequest, deviceId: String): RegisterResult {
        if(this.accountRepository.existsAccountByEmail(request.email)) {
            return RegisterResult.Error.EmailAlreadyUsed;
        }

        val desiredProfileUuid: UUID = UUID.randomUUID()

        val account = Account(
            email = request.email,
            passwordHash = this.passwordHasher.hash(request.password),
            profileId = desiredProfileUuid,
            createdAt = Instant.now(),
            modifiedAt = Instant.now(),
            accountRole = AccountRole.USER,
            verifiedAt = null
        )

        val device = Device(
            deviceId = deviceId,
            deviceName =

        )
    }
}