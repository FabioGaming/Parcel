package net.fabidev.parcelserver.shared.events.implementation.redis

data class RedisEventEnvelope(
    val type: String,
    val payload: String
)