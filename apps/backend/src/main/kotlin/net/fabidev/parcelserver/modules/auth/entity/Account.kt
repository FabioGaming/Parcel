package net.fabidev.parcelserver.modules.auth.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import net.fabidev.parcelserver.shared.AccountRole
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "account", schema = "auth" )
class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false)
    var id: UUID? = null,

    @Column(name = "email", unique = true, nullable = false)
    var email: String,

    @Column(name = "password_hash", nullable = false)
    var passwordHash: String,

    @Column(name = "profile_id", nullable = true)
    var profileId: UUID? = null,

    @Column(name = "created_at", nullable = false)
    var createdAt: Instant,

    @Column(name = "modified_at", nullable = false)
    var modifiedAt: Instant,

    @Column(name = "verified_at", nullable = true)
    var verifiedAt: Instant?,

    @Column(name = "account_role", nullable = false)
    var accountRole: AccountRole,

    @OneToMany(mappedBy = "account", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var devices: MutableList<Device> = mutableListOf(),

    @OneToMany(mappedBy = "account", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var refreshTokens: MutableList<RefreshToken> = mutableListOf(),

    @OneToMany(mappedBy = "account", cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    var verificationChallenges: MutableList<VerificationChallenge> = mutableListOf()
)