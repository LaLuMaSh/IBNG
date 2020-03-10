package ch.lalumash.IBNG.entities

import java.io.Serializable
import java.time.LocalDateTime
class TextPostEntity(author: String?, created: LocalDateTime?, text: String?, parentPostEntity: PostEntity?) : PostEntity(author!!, created!!, text!!, parentPostEntity), Serializable
