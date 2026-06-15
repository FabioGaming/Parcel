package net.fabidev.parcelserver.modules.auth.entity

import com.fasterxml.jackson.databind.JsonNode
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.time.Instant
import java.util.UUID


@Entity
@Table(name = "verification_challenge", schema = "auth")
class VerificationChallenge(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, unique = true)
    var id: UUID,

    @Column(name = "account_id", nullable = false)
    var accountId: UUID,

    @Column(name = "device_id", nullable = false)
    var deviceId: UUID,

    @Column(name = "recipient_email", nullable = false)
    var recipientEmail: String,

    @Column(name = "code_hash", nullable = false)
    var codeHash: String,

    @Column(name = "purpose", nullable = false)
    var purpose: String,

    @Column(name = "created_at", nullable = false)
    var createdAt: Instant,

    @Column(name = "expires_at", nullable = false)
    var expiresAt: Instant,

    @Column(name = "consumed_at", nullable = false)
    var consumedAt: Instant,

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "metadata", nullable = true, columnDefinition = "jsonb")
    var metadata: JsonNode



)