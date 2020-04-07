package ch.lalumash.IBNG.dtos

data class UserDto(
        var username: String,
        var nickname: String
)

data class UserDtoCreate(
        var username: String,
        var nickname: String,
        var password: String
)
