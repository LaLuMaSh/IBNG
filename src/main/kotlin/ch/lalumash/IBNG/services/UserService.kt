package ch.lalumash.IBNG.services

import ch.lalumash.IBNG.dtos.UserDto
import ch.lalumash.IBNG.dtos.UserDtoCreate
import ch.lalumash.IBNG.entities.UserEntity
import ch.lalumash.IBNG.repositories.UserEntityRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userEntityRepository: UserEntityRepository) {
    fun getUserByUsername(username: String): UserEntity? {
        return userEntityRepository.findById(username).orElse(null)
    }
    fun addUser(user: UserDtoCreate): UserDto {
        val entity = UserEntity().apply {
            username = user.username
            nickname = user.nickname
            passwordSha256 = user.passwordHash;
        }

        val save = userEntityRepository.save(entity)

        return UserDto(save.username, save.nickname)
    }
}
