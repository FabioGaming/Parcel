package net.fabidev.parcelserver.shared.events.abstractions

interface EventConsumer<T : DomainEvent> {
    fun handle(event: T)
}