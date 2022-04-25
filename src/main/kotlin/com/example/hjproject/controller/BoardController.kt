package com.example.hjproject.controller

import com.example.hjproject.exception.BaseException
import com.example.hjproject.exception.BaseResponseCode
import com.example.hjproject.model.*
import com.example.hjproject.service.BoardQueryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(private val boardService: BoardQueryService) {

    @GetMapping("/board")
    fun getBoard(): ResponseEntity<List<Board>> {
        return ResponseEntity(boardService.getBoardAsModel(), HttpStatus.OK)
    }
    @PostMapping("/reg")
    fun register(@RequestBody boardRegisterReq: BoardRegisterReq): ResponseEntity<BoardRegisterRes> {

        return ResponseEntity.ok(boardService.BoardReg(boardRegisterReq))
    }
}