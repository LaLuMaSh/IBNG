package ch.lalumash.IBNG.dtos.feed

import java.time.LocalDateTime

class TextPostDto(
        author: String,
        created: LocalDateTime,
        text: String,
        parentPostDto: PostDto?
) : PostDto(author, created, text, parentPostDto)