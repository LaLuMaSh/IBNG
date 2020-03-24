package ch.lalumash.IBNG.entities

import java.io.Serializable
import java.time.LocalDateTime
class ImagePostEntity(
        author: String,
        created: LocalDateTime,
        text: String,
        parentPostEntity: PostEntity?,
        var image: String
) : PostEntity(author, created, text, parentPostEntity), Serializable

