package ch.lalumash.IBNG.services

import ch.lalumash.IBNG.dtos.UserDto
import ch.lalumash.IBNG.dtos.feed.FeedDto
import ch.lalumash.IBNG.entities.FeedEntity
import ch.lalumash.IBNG.entities.UserEntity
import org.springframework.stereotype.Service

@Service
class GlobalMapper {
    fun userEntityToDto(user: UserEntity): UserDto {
        return UserDto(
                userName = user.username,
                nickname = user.nickname
        )
    }
    fun feedEntityToDto(feed: FeedEntity?): FeedDto {
        if (feed != null) {
            return FeedDto(id = feed.id, postEntities = feed.postEntities)
        }else {
            return FeedDto(id = "", postEntities = ArrayList())
        }
    }
}
