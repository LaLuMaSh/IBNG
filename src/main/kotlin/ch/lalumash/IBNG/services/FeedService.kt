package ch.lalumash.IBNG.services

import ch.lalumash.IBNG.dtos.feed.CreateFeedDto
import ch.lalumash.IBNG.dtos.feed.FeedDto
import ch.lalumash.IBNG.entities.FeedEntity
import ch.lalumash.IBNG.repositories.FeedEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FeedService @Autowired constructor(var feedEntityRepository: FeedEntityRepository) {
    fun getByUser(userName: String): FeedEntity? {
        return feedEntityRepository.findById(userName).orElse(null)
    }

    fun createForId(feed: CreateFeedDto): FeedDto {
        val entity = FeedEntity(ArrayList(), feed.id);
        val save = feedEntityRepository.save(entity)

        return FeedDto(save.postEntities, save.id)
    }
}