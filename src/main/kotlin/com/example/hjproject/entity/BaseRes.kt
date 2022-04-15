package com.example.hjproject.entity

import org.springframework.http.HttpStatus


data class BaseRes(
        val message: HttpStatus,
        val status: String
)
