package net.fabidev.parcelserver.modules.auth.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "device", schema = "auth")
class Device(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", unique = true, nullable = false)
    var id: UUID,

    @Column(name = "device_id", unique = true, nullable = false)
    var deviceId: String,

    @Column(name = "device_name", unique = false, nullable = false)
    var deviceName: String,

    @Column(name = "account_id", nullable = false)
    var accountId: UUID,

    @Column(name = "created_at", nullable = false)
    var createdAt: Instant,

    @Column(name = "last_seen_at", nullable = false)
    var lastSeenAt: Instant,

    @Column(name = "verified_at", nullable = true)
    var verifiedAt: Instant?
)