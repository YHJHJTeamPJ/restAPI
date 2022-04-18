package com.example.hjproject.repository

import com.example.hjproject.entity.BoardEntity
import com.example.hjproject.entity.toModel
import com.example.hjproject.model.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : JpaRepository<BoardEntity, Long> {

    fun findAllListBy(): List<Board>{
        return this.findAll().map {it.toModel()}
    }
}