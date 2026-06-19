package net.fabidev.parcelserver.shared.events

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class EventType(val value: String)