package ch.lalumash.IBNG.services

import ch.lalumash.IBNG.entities.UserEntity
import ch.lalumash.IBNG.repositories.UserEntityRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userEntityRepository: UserEntityRepository) {
    fun getUserbyUsername(username: String): Optional<UserEntity> {
        return userEntityRepository.findById(username)
    }
}
