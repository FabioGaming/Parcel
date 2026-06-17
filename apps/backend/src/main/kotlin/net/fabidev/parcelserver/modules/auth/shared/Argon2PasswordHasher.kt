package net.fabidev.parcelserver.modules.auth.shared

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder
import org.springframework.stereotype.Component

@Component
class Argon2PasswordHasher : PasswordHasher {
    private val argon2: Argon2PasswordEncoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

    override fun hash(inputPassword: String): String {
        return argon2.encode(inputPassword)!!;
    }

    override fun check(inputPassword: String, sourcePassword: String): Boolean {
        return argon2.matches(inputPassword, sourcePassword);
    }
}