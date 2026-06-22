package net.fabidev.parcelserver.modules.auth.repository

import net.fabidev.parcelserver.modules.auth.entity.Device
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface DeviceRepository : JpaRepository<Device, UUID> {}