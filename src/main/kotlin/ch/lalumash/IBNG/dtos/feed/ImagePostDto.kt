package ch.lalumash.IBNG.dtos.feed

import java.time.LocalDateTime

class ImagePostDto(
        author: String,
        created: LocalDateTime,
        text: String,
        parentPostDto: PostDto,
        var image: String
) : PostDto(author, created, text, parentPostDto)