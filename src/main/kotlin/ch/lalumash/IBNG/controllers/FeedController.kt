package ch.lalumash.IBNG.controllers

import ch.lalumash.IBNG.dtos.feed.CreateFeedDto
import ch.lalumash.IBNG.dtos.feed.FeedDto
import ch.lalumash.IBNG.entities.FeedEntity
import ch.lalumash.IBNG.entities.PostEntity
import ch.lalumash.IBNG.entities.TextPostEntity
import ch.lalumash.IBNG.services.FeedService
import ch.lalumash.IBNG.services.GlobalMapper
import ch.lalumash.IBNG.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@RestController
@RequestMapping("feed/")
@CrossOrigin
class FeedController @Autowired constructor(
        private val mapper: GlobalMapper,
        private val feedService: FeedService,
        private val userService: UserService
) {
    @GetMapping("{userName}")
    fun getFeedById(@PathVariable userName: String?): FeedDto {
        if (userName == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Feedname darf nicht null sein.")
        }

        if (feedService.getByUser(userName) == null) {
            return feedService.createForId(CreateFeedDto(userName))
        }

        return mapper.feedEntityToDto(feedService.getByUser(userName))
    }

    @PostMapping("user/add")
    fun addFeedForUser(@RequestBody feed: CreateFeedDto?) {
        if (feed == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Feed darf nicht null sein.")
        }

        if (userService.getUserById(feed.id) == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Feed mit der ID ${feed.id} existiert nicht.")
        }

        feedService.createForId(feed)
    }
    @PostMapping("user/update")
    fun updateFeed(@RequestBody feed: FeedDto?) {
        if (feed == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Feed darf nicht null sein.")
        }

        if (userService.getUserById(feed.id) == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Feed mit der ID ${feed.id} existiert nicht.")
        }
        feedService.convertFeed(feed);
    }
    @PostMapping("user/mockdata")
    fun test(@RequestBody feed: CreateFeedDto) {
        val list = listOf(
                TextPostEntity("test", LocalDateTime.now(), "ein beispieltext", null),
                TextPostEntity("test", LocalDateTime.now(), "ein zweiter post", null)
        )

        feedService.convertFeed(FeedDto(list, feed.id));
    }
}