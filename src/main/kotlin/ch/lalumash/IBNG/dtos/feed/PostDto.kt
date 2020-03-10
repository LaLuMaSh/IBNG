package ch.lalumash.IBNG.dtos.feed

import java.time.LocalDateTime
import java.util.*

abstract class PostDto(val author: String, val created: LocalDateTime, val text: String, parentPostDto: PostDto?) {
    private val childPostEntities: MutableList<PostDto>

    init {
        childPostEntities = ArrayList()
        parentPostDto?.childPostEntities?.add(this)
    }
}
