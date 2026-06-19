package net.fabidev.parcelserver.shared.events.abstractions

interface EventConsumer<T : DomainEvent> {

    fun supports(event: DomainEvent): Boolean

    fun handle(event: T)
}