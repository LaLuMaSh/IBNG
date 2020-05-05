package ch.lalumash.IBNG.dtos

data class AuthResponse (
    var token: String = "",
    var username: String = "",
    var nickname: String = ""
)