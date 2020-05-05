package ch.lalumash.IBNG.services

import ch.lalumash.IBNG.dtos.feed.CreateFeedDto
import ch.lalumash.IBNG.dtos.feed.FeedDto
import ch.lalumash.IBNG.dtos.feed.TextPostDto
import ch.lalumash.IBNG.entities.FeedEntity
import ch.lalumash.IBNG.entities.TextPostEntity
import ch.lalumash.IBNG.repositories.FeedEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FeedService @Autowired constructor(
        var feedEntityRepository: FeedEntityRepository,
        var mapper: GlobalMapper
) {
    fun getByUser(userName: String): FeedEntity? {
        return feedEntityRepository.findById(userName).orElse(null)
    }

    fun createForId(feed: CreateFeedDto): FeedDto {
        val entity = FeedEntity(ArrayList(), feed.id);
        val save = feedEntityRepository.save(entity)

        val list = ArrayList<TextPostDto>();
        for (postEntity in save.postEntities) {
            list.add(TextPostDto(postEntity.author!!, postEntity.created!!, postEntity.text!!))
        }

        return FeedDto(list, save.id)
    }

    fun convertFeed(feed: FeedDto): FeedDto {
        val list = ArrayList<TextPostEntity>();
        for (postEntity in feed.postEntities) {
            list.add(TextPostEntity(postEntity.author, postEntity.created, postEntity.text))
        }
        val entity = FeedEntity(list, feed.id);
        feedEntityRepository.save(entity)
        return feed;
    }

    fun getAllFeeds(): List<FeedDto> {
        val list = ArrayList<FeedDto>();
        for (feedEntity in feedEntityRepository.findAll().toList()) {
            list.add(mapper.feedEntityToDto(feedEntity)!!);
        }
        return list;
    }
}