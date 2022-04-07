package com.example.hjproject

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
//@RequestMapping("/api")
class MemberController(
    val memberRepository: MemberRepository
) {
    @GetMapping("member/all")
    fun getMembers(): ResponseEntity<*> {
        val users = memberRepository.findAll()

        return ResponseEntity.ok(users)
    }

    @PostMapping("/member/{id}")
    fun setMember(@RequestBody member: Member): ResponseEntity<*> {
        val res = memberRepository.save(member)

        return ResponseEntity.ok(res)
    }

}