package net.fabidev.parcelserver.modules.auth.repository

import net.fabidev.parcelserver.modules.auth.entity.VerificationChallenge
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface VerificationChallengeRepository : JpaRepository<VerificationChallenge, UUID> {}