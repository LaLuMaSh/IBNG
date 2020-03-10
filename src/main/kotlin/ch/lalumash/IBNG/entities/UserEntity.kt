package ch.lalumash.IBNG.entities

import lombok.Data
import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Data
@Table(name = "user")
class UserEntity : Serializable {
    @Id
    @Column(name = "username", nullable = false)
    val username: String? = null

    @Column(name = "password_sha256", nullable = false)
    val passwordSha256: String? = null

    @Column(name = "nickname", nullable = false)
    val nickname: String? = null

    companion object {
        private const val serialVersionUID = 1L
    }
}