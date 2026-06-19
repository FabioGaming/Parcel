package net.fabidev.parcelserver.shared.events.abstractions

interface DomainEventPublisher {
    fun publish(event: DomainEvent)
}