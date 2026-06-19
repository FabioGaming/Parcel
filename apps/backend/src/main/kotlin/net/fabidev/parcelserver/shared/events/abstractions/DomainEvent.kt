package net.fabidev.parcelserver.shared.events.abstractions

interface DomainEvent {
    fun eventType(): String = this::class.simpleName!!
}