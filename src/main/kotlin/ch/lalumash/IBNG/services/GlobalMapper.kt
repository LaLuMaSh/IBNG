package ch.lalumash.IBNG.services

import ch.lalumash.IBNG.dtos.UserDto
import ch.lalumash.IBNG.dtos.feed.FeedDto
import ch.lalumash.IBNG.dtos.feed.TextPostDto
import ch.lalumash.IBNG.entities.FeedEntity
import ch.lalumash.IBNG.entities.TextPostEntity
import ch.lalumash.IBNG.entities.UserEntity
import org.springframework.stereotype.Service

@Service
class GlobalMapper {
    fun userEntityToDto(user: UserEntity): UserDto {
        return UserDto(
                username = user.username,
                nickname = user.nickname
        )
    }
    fun feedEntityToDto(feed: FeedEntity?): FeedDto? {
        val list = ArrayList<TextPostDto>();
        if (feed != null) {
            for (postEntity in feed.postEntities) {
                list.add(TextPostDto(postEntity.author!!, postEntity.created!!, postEntity.text!!))
            }
        }
        return if (feed != null) {
            FeedDto(id = feed.id, postEntities = list)
        }else {
            null;
        }
    }
}
