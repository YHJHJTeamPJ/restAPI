package com.example.hjproject.exception

class BaseException(baseResponseCode: BaseResponseCode): RuntimeException() {
    public val baseResponseCode: BaseResponseCode = baseResponseCode
}