package net.fabidev.parcelserver.shared.events.type

import net.fabidev.parcelserver.shared.events.abstractions.DomainEvent
import java.util.UUID

data class AccountCreatedEvent(
    val accountId: UUID,
    val desiredProfileId: UUID,
    val username: String
) : DomainEvent
