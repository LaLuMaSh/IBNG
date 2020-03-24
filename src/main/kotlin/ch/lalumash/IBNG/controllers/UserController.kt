package ch.lalumash.IBNG.controllers

import ch.lalumash.IBNG.dtos.UserDto
import ch.lalumash.IBNG.dtos.UserDtoCreate
import ch.lalumash.IBNG.services.GlobalMapper
import ch.lalumash.IBNG.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("user/")
class UserController(
        private val mapper: GlobalMapper,
        private val userService: UserService
) {

    @GetMapping("{username}")
    fun getUser(@PathVariable username: String): UserDto {
        val userByUsername = userService.getUserByUsername(username)

        if (userByUsername == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer mit dem namen $username nicht gefunden.")
        }else {
            return mapper.userEntityToDto(userByUsername)
        }
    }

    @PostMapping("add")
    fun addUser(@RequestBody user: UserDtoCreate): UserDto {
        return userService.addUser(user)
    }
}
