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
    var username: String = ""

    @Column(name = "password_sha256", nullable = false)
    var passwordSha256: String = ""

    @Column(name = "nickname", nullable = false)
    var nickname: String = ""

    companion object {
        private const val serialVersionUID = 1L
    }
}
