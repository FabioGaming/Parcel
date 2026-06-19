package net.fabidev.parcelserver.modules.auth.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "device", schema = "auth")
class Device(

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(name = "device_id", unique = true, nullable = false)
    var deviceId: String,

    @Column(name = "device_name", nullable = false)
    var deviceName: String,

    @Column(name = "created_at", nullable = false)
    var createdAt: Instant,

    @Column(name = "last_seen_at", nullable = false)
    var lastSeenAt: Instant,

    @Column(name = "verified_at")
    var verifiedAt: Instant? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    var account: Account
)