package com.example.hjproject.model

data class Board (
    val number: Long? = null,
    val title: String? = null,
    val content: String? = null,
    val nickname: String? = null
)

class BoardRegisterReq(title: String, content: String, nickname: String) {
    var title: String = title
    var content: String = content
    var nicnname: String = nickname
}

class BoardRegisterRes(val number: Long) {
}