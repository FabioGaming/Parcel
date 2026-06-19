package net.fabidev.parcelserver.shared.events

import net.fabidev.parcelserver.shared.events.abstractions.DomainEvent
import net.fabidev.parcelserver.shared.events.implementation.redis.DefaultEventTypeResolver
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class EventTypeScanner(
    private val resolver: DefaultEventTypeResolver
) : ApplicationRunner {

    override fun run(args: ApplicationArguments) {

        val reflections = org.reflections.Reflections("net.fabidev.parcelserver")

        val eventTypes = reflections.getSubTypesOf(DomainEvent::class.java)

        eventTypes.forEach { clazz ->
            resolver.register(clazz as Class<out DomainEvent>)
        }
    }
}