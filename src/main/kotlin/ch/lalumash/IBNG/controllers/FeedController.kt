package ch.lalumash.IBNG.controllers

import ch.lalumash.IBNG.dtos.feed.FeedDto
import ch.lalumash.IBNG.services.FeedService
import ch.lalumash.IBNG.services.GlobalMapper
import ch.lalumash.IBNG.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("feed/")
class FeedController @Autowired constructor(
        private val mapper: GlobalMapper,
        private val feedService: FeedService,
        private val userService: UserService
) {
    @GetMapping("{userName}")
    fun getFeedById(@PathVariable userName: String?): FeedDto? {
        if (userName == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzernamen darf nicht null sein.")
        }

        if (feedService.getByUser(userName) == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer mit dem Benutzernamen $userName existiert nicht.")
        }

        return mapper.feedEntityToDto(feedService.getByUser(userName))
    }

    @PostMapping("create/{userName}")
    fun addFeedForUser(@PathVariable userName: String?) {
        if (userName == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzernamen darf nicht null sein.")
        }

        if (userService.getUserbyUsername(userName).orElse(null) == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer mit dem Benutzernamen $userName existiert nicht.")
        }

        feedService.createForUser(userName)
    }
}