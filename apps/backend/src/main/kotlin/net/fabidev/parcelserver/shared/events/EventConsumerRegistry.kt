package net.fabidev.parcelserver.shared.events

import net.fabidev.parcelserver.shared.events.abstractions.DomainEvent
import net.fabidev.parcelserver.shared.events.abstractions.EventConsumer
import org.springframework.stereotype.Component

@Component
class EventConsumerRegistry(
    private val consumers: List<EventConsumer<*>>
) {

    fun dispatch(event: DomainEvent) {

        consumers.forEach { consumer ->

            if (consumer.supports(event)) {

                @Suppress("UNCHECKED_CAST")
                (consumer as EventConsumer<DomainEvent>).handle(event)
            }
        }
    }
}