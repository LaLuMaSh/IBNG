package ch.lalumash.IBNG.entities

import org.springframework.data.redis.core.RedisHash
import java.io.Serializable
import java.util.*

@RedisHash("Feed")
class FeedEntity : Serializable {
    var postEntities: List<PostEntity>
    var owner: String

    constructor(owner: String) {
        this.owner = owner
        postEntities = ArrayList()
    }

    constructor(postEntities: List<PostEntity>, owner: String) {
        this.postEntities = postEntities
        this.owner = owner
    }
}