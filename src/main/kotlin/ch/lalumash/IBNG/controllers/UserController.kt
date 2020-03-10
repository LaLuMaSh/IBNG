package ch.lalumash.IBNG.controllers

import ch.lalumash.IBNG.dtos.UserDto
import ch.lalumash.IBNG.services.GlobalMapper
import ch.lalumash.IBNG.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("user/")
class UserController(
        private val mapper: GlobalMapper,
        private val userService: UserService
) {

    @GetMapping("{username}")
    fun getUser(@PathVariable username: String): Optional<UserDto> {
        return userService.getUserbyUsername(username).map { mapper.userEntityToDto(it) }
    }
}
