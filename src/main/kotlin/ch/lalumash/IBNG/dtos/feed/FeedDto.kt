package ch.lalumash.IBNG.dtos.feed


class FeedDto(
        var postEntities: List<TextPostDto>,
        var id: String
)
class CreateFeedDto {
    var id: String = ""

    constructor(id: String) {
        this.id = id
    }

    constructor()
}