package com.example.hjproject

import javax.persistence.*

@Entity
@Table(name = "MEMBER")
data class Member(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "email")
    var email: String = "",

    @Column(name = "password")
    var password: String = "",

)