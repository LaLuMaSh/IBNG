package ch.lalumash.IBNG.repositories

import ch.lalumash.IBNG.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.*

interface UserEntityRepository : JpaRepository<UserEntity, String>, JpaSpecificationExecutor<UserEntity> {
    fun findAllByOrderByUsername(): ArrayList<UserEntity>
}