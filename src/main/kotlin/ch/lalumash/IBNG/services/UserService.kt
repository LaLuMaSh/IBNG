package ch.lalumash.IBNG.services

import ch.lalumash.IBNG.dtos.UserDto
import ch.lalumash.IBNG.dtos.UserDtoCreate
import ch.lalumash.IBNG.entities.UserEntity
import ch.lalumash.IBNG.repositories.UserEntityRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(private val userEntityRepository: UserEntityRepository, private val passwordEncoder: PasswordEncoder): UserDetailsService {
    fun getUserById(id: String): UserEntity? {
        return userEntityRepository.findById(id).orElse(null)
    }
    fun addUser(user: UserDtoCreate): UserDto {
        val entity = UserEntity().apply {
            username = user.username
            nickname = user.nickname
            passwordBcrypt = passwordEncoder.encode(user.password)
        }

        val save = userEntityRepository.save(entity)

        return UserDto(save.username, save.nickname)
    }

    override fun loadUserByUsername(p0: String?): UserDetails {
        val user: UserEntity? = this.getUserById(p0 ?: "")
                ?: throw UsernameNotFoundException("User not found with username: $p0")

        return User(user?.username, user?.passwordBcrypt, ArrayList());
    }
}
