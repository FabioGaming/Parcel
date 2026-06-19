package net.fabidev.parcelserver.shared.events

import net.fabidev.parcelserver.shared.events.abstractions.DomainEvent
import net.fabidev.parcelserver.shared.events.implementation.redis.DefaultEventTypeResolver
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class EventTypeScanner(
    private val resolver: DefaultEventTypeResolver
) : ApplicationRunner {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun run(args: ApplicationArguments) {

        val reflections = org.reflections.Reflections("net.fabidev.parcelserver")

        val eventTypes = reflections.getSubTypesOf(DomainEvent::class.java)

        eventTypes.forEach { clazz ->
            resolver.register(clazz as Class<out DomainEvent>)

            logger.info("Registered EventType: ${clazz.simpleName}")
        }

        logger.info("Registered ${eventTypes.count()} event types")
    }
}