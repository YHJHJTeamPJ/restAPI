package com.example.hjproject

import lombok.AllArgsConstructor
import lombok.Getter
import org.springframework.http.HttpStatus

@Getter
@AllArgsConstructor
class UserLoginRes(public val status: HttpStatus, public val token: String?) {
//
}