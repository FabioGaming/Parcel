package net.fabidev.parcelserver.shared.events.implementation.redis

import net.fabidev.parcelserver.shared.events.EventStreams
import net.fabidev.parcelserver.shared.events.abstractions.DomainEvent
import net.fabidev.parcelserver.shared.events.abstractions.DomainEventPublisher
import org.slf4j.LoggerFactory
import org.springframework.data.redis.connection.stream.StreamRecords
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component
import tools.jackson.databind.ObjectMapper

@Component
class RedisStreamDomainEventPublisher(
    private val redis: StringRedisTemplate,
    private val objectMapper: ObjectMapper
) : DomainEventPublisher {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun publish(event: DomainEvent) {

        val eventType = event.eventType()
        val payload = objectMapper.writeValueAsString(event)

        val streamKey = resolveStream(event)

        logger.info("Publishing {} to {} ({} bytes)", eventType, streamKey, payload.length)

        redis.opsForStream<String, String>().add(
            StreamRecords.newRecord()
                .ofMap(
                    mapOf(
                        "type" to eventType,
                        "payload" to payload
                    )
                )
                .withStreamKey(streamKey)
        )
    }

    private fun resolveStream(event: DomainEvent): String {
        return when (event) {
            else -> EventStreams.DEFAULT
        }
    }
}