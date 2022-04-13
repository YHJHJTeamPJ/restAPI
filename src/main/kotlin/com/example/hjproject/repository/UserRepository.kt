package com.example.hjproject.repository

import com.example.hjproject.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, Long> {

    //EMAIL을 Where 조건절로 하여, 데이터를 가져올 수 있도록 findByEMAIL() 메소드를 정의
    fun findByEmail(email: String): Optional<User>
}