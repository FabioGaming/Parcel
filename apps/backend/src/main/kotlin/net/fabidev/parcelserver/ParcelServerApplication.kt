package net.fabidev.parcelserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.data.redis.autoconfigure.DataRedisAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataRedisAutoConfiguration::class])
class ParcelServerApplication

fun main(args: Array<String>) {
    runApplication<ParcelServerApplication>(*args)
}

