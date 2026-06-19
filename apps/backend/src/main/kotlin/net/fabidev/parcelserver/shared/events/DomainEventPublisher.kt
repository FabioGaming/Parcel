package net.fabidev.parcelserver.shared.events

interface DomainEventPublisher {
    fun publish(event: DomainEvent)
}