package net.fabidev.parcelserver.shared.events.implementation.redis

import jakarta.annotation.PostConstruct
import net.fabidev.parcelserver.shared.events.EventConsumerRegistry
import net.fabidev.parcelserver.shared.events.EventStreams
import net.fabidev.parcelserver.shared.events.abstractions.DomainEvent
import net.fabidev.parcelserver.shared.events.abstractions.EventTypeResolver
import org.springframework.data.redis.connection.stream.Consumer
import org.springframework.data.redis.connection.stream.MapRecord
import org.springframework.data.redis.connection.stream.ReadOffset
import org.springframework.data.redis.connection.stream.StreamOffset
import org.springframework.data.redis.connection.stream.StreamReadOptions
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component
import tools.jackson.databind.ObjectMapper
import java.util.UUID

@Component
class RedisStreamConsumer(
    private val redis: StringRedisTemplate,
    private val objectMapper: ObjectMapper,
    private val registry: EventConsumerRegistry,
    private val eventTypeResolver: EventTypeResolver
) {

    private val group = "parcel-group"
    private val consumerId = "consumer-${UUID.randomUUID()}"

    @PostConstruct
    fun start() {
        Thread { loop() }.start()
    }

    private fun loop() {

        val stream = StreamOffset.create(EventStreams.DEFAULT, ReadOffset.lastConsumed())

        try {
            redis.opsForStream<String, String>()
                .createGroup(EventStreams.DEFAULT, group)
        } catch (_: Exception) {}

        while (true) {

            val records = redis.opsForStream<String, String>()
                .read(
                    Consumer.from(group, consumerId),
                    StreamReadOptions.empty().count(10),
                    stream
                )

            for (record in records) {
                handle(record)
            }
        }
    }

    private fun handle(record: MapRecord<String, String, String>) {

        val type = record.value["type"]!!
        val payload = record.value["payload"]!!

        val event = objectMapper.readValue(
            payload,
            eventTypeResolver.resolve(type)
        )

        registry.dispatch(event)

        redis.opsForStream<String, String>()
            .acknowledge(group, record)
    }

    private fun deserialize(type: String, payload: String): DomainEvent {

        val clazz = eventTypeResolver.resolve(type)

        return objectMapper.readValue(payload, clazz)
    }
}