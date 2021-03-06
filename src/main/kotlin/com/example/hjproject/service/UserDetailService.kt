package com.example.hjproject.service

import com.example.hjproject.exception.BaseException
import com.example.hjproject.exception.BaseResponseCode
import com.example.hjproject.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailService(private val userRepository: UserRepository): UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByEmail(username).orElseThrow{ BaseException(BaseResponseCode.USER_NOT_FOUND) }
    }
}