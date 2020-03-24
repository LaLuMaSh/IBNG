package ch.lalumash.IBNG.entities

import org.springframework.data.redis.core.RedisHash
import java.io.Serializable
import java.util.*


@RedisHash("Feed")
class FeedEntity : Serializable {
    var postEntities: List<PostEntity>
    var id: String

    constructor(owner: String) {
        this.id = owner
        postEntities = ArrayList()
    }

    constructor(postEntities: List<PostEntity>, owner: String) {
        this.postEntities = postEntities
        this.id = owner
    }
}