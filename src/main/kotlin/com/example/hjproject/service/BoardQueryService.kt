package com.example.hjproject.service

import com.example.hjproject.entity.BoardEntity
import com.example.hjproject.model.Board
import com.example.hjproject.repository.BoardRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BoardQueryService(private val boardRepository: BoardRepository) {
    @Transactional

    fun getBoardAsModel(): List<Board>{
        return boardRepository.findAllListBy()
    }
}