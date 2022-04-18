package com.example.hjproject.exception

import org.springframework.http.HttpStatus

enum class BaseResponseCode(status: HttpStatus, message: String) {
    INVALID_PASSWORD(HttpStatus.BAD_REQUEST, "잘못된 비밀번호입니다. 다시 입력해주세요."),
    DUPLICATE_EMAIL(HttpStatus.BAD_REQUEST, "중복된 이메일입니다. 다시 입력해주세요."),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다."),
    OK(HttpStatus.OK, "요청 성공");

    val status: HttpStatus = status
    val message: String = message
}