package net.fabidev.parcelserver.shared.events

interface EventConsumer<T : DomainEvent> {
    fun handle(event: T)
}