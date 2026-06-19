package net.fabidev.parcelserver.shared.events.abstractions

interface EventTypeResolver {
    fun resolve(type: String): Class<out DomainEvent>
}