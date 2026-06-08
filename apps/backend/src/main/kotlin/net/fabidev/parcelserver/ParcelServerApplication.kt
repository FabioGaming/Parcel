package net.fabidev.parcelserver

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.data.redis.autoconfigure.DataRedisAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication(exclude = [DataRedisAutoConfiguration::class])
class ParcelServerApplication

fun main(args: Array<String>) {
    runApplication<ParcelServerApplication>(*args)
}

