package net.fabidev.parcelserver.modules.auth.shared

interface PasswordHasher {
    fun hash(inputPassword: String): String;
    fun check(inputPassword: String, sourcePassword: String): Boolean;
}