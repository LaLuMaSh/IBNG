package ch.lalumash.IBNG.entities

import org.springframework.data.redis.core.RedisHash
import java.io.Serializable


@RedisHash("Feed")
class FeedEntity : Serializable {
    var postEntities: List<PostEntity> = ArrayList()
    var id: String = ""


    constructor(owner: String) {
        this.id = owner
        postEntities = ArrayList()
    }

    constructor(postEntities: List<PostEntity>, owner: String) {
        this.postEntities = postEntities
        this.id = owner
    }

    constructor()


}