package com.example.hjproject.entity

import com.example.hjproject.model.Board
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "board")
class BoardEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val number: Long,
    val title : String,
    val content : String,
    val nickname : String
)

fun BoardEntity.toModel(): Board {
    return Board(
        number = this.number,
        title = this.title,
        content = this.content,
        nickname = this.nickname,
    )
}