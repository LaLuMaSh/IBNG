package ch.lalumash.IBNG.dtos.feed

import ch.lalumash.IBNG.entities.PostEntity

class FeedDto(
        var postEntities: List<PostEntity>,
        var id: String
)
class CreateFeedDto {
    var id: String = ""

    constructor(id: String) {
        this.id = id
    }

    constructor()
}