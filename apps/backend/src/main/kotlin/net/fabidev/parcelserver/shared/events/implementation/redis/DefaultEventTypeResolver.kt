package net.fabidev.parcelserver.shared.events.implementation.redis

import net.fabidev.parcelserver.shared.events.EventType
import net.fabidev.parcelserver.shared.events.abstractions.DomainEvent
import net.fabidev.parcelserver.shared.events.abstractions.EventTypeResolver
import org.springframework.stereotype.Component
import tools.jackson.databind.ObjectMapper

@Component
class DefaultEventTypeResolver(
    private val objectMapper: ObjectMapper
) : EventTypeResolver {

    private val map = mutableMapOf<String, Class<out DomainEvent>>()

    init {}

    fun register(clazz: Class<out DomainEvent>) {
        val annotation = clazz.getAnnotation(EventType::class.java)
            ?: return

        map[annotation.value] = clazz
    }

    override fun resolve(type: String): Class<out DomainEvent> =
        map[type] ?: throw IllegalArgumentException("Unknown event type: $type")
}