package com.example.hjproject.model

import lombok.AllArgsConstructor
import lombok.Getter
import org.springframework.http.HttpStatus

@Getter
@AllArgsConstructor
class UserLoginRes(val status: HttpStatus, val token: String?) {
//
}