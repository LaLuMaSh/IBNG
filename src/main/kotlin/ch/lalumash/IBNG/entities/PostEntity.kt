package ch.lalumash.IBNG.entities

import java.io.Serializable
import java.time.LocalDateTime
import java.util.*

abstract class PostEntity(
        val author: String,
        val created: LocalDateTime,
        val text: String,
        val parentPostEntity: PostEntity?
) : Serializable {
    private val childPostEntities: MutableList<PostEntity>

    init {
        childPostEntities = ArrayList()
        parentPostEntity?.childPostEntities?.add(this)
    }
}