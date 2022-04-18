package com.example.hjproject.controller

import com.example.hjproject.model.Board
import com.example.hjproject.service.BoardQueryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(private val boardService: BoardQueryService) {
//    @GetMapping("/board")
//    fun listBoard(): ResponseEntity<List<BoardEntity>> {
//        return ResponseEntity(boardService.getBoard(), HttpStatus.OK)
//    }
    @GetMapping("/board")
    fun getBoard(): ResponseEntity<List<Board>> {
        return ResponseEntity(boardService.getBoardAsModel(), HttpStatus.OK)
    }
}