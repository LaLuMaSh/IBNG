package ch.lalumash.IBNG.controllers

import ch.lalumash.IBNG.entities.UserEntity
import ch.lalumash.IBNG.repositories.UserEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("user/")
class UserController(private val userEntityRepository: UserEntityRepository) {
    @GetMapping("get/{userName}")
    fun getUser(@PathVariable userName: String): ArrayList<UserEntity> {
        return userEntityRepository.findAllByOrderByUsername()
    }

}