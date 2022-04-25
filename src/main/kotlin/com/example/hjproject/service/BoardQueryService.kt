package com.example.hjproject.service

import com.example.hjproject.entity.BoardEntity
import com.example.hjproject.entity.User
import com.example.hjproject.model.*
import com.example.hjproject.repository.BoardRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BoardQueryService(private val boardRepository: BoardRepository) {
    @Transactional

    fun getBoardAsModel(): List<Board>{
        return boardRepository.findAllListBy()
    }

    fun BoardReg(boardRegisterReq: BoardRegisterReq): BoardRegisterRes{
        val reg = BoardEntity(number = 1,boardRegisterReq.title,boardRegisterReq.content,boardRegisterReq.nicnname)
        boardRepository.save(reg)
        return BoardRegisterRes(reg.number)
    }


}