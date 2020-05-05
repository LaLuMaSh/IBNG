package ch.lalumash.IBNG.dtos.feed

import java.time.LocalDateTime

class TextPostDto(
        val author: String,
        val created: LocalDateTime,
        val text: String
)