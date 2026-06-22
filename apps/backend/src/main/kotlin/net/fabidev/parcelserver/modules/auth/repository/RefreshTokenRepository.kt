package net.fabidev.parcelserver.modules.auth.repository

import net.fabidev.parcelserver.modules.auth.entity.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface RefreshTokenRepository : JpaRepository<RefreshToken, UUID> {}