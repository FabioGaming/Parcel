package net.fabidev.parcelserver.modules.auth.repository

import net.fabidev.parcelserver.modules.auth.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AccountRepository : JpaRepository<Account, UUID> {
    fun existsAccountByEmail(email: String): Boolean
}