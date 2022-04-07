//package com.example.hjproject
//
//import org.springframework.web.bind.annotation.*
//import javax.annotation.PostConstruct
//
//@RestController
//class UserController {
//
//    private val userMap: MutableMap<String, User> = mutableMapOf()
//
//    @PostConstruct
//    fun init() {
//        userMap["1"] = User("1", "박정수", "0701", "01012345678")
//        userMap["2"] = User("2", "김희철", "0710", "01012345678")
//        userMap["3"] = User("3", "김려욱", "0621", "01012345678")
//    }
//
//    @GetMapping(path = ["/user/{id}"])
//    fun getUserInfo(@PathVariable("id") id: String) = userMap[id]
//
//    @GetMapping(path = ["user/all"])
//    fun getUserInfoAll() = ArrayList<User>(userMap.values)
//
//    @PutMapping(path = ["/user/{id}"])
//    fun putUserInfo(@PathVariable("id") id: String, @RequestParam("name") name: String, @RequestParam("phone") phone: String, @RequestParam("password") password: String) {
//
//        val userInfo = User(id, name, phone, password)
//        userMap[id] = userInfo
//    }
//
//    @PostMapping(path = ["/user/{id}"])
//    fun postUserInfo(@PathVariable("id") id: String, @RequestParam("name") name: String, @RequestParam("phone") phone: String, @RequestParam("password") password: String) {
//
//        val userInfo = userMap[id]
//        userInfo?.name = name
//        userInfo?.phone = phone
//        userInfo?.password = password
//    }
//
//    @DeleteMapping(path = ["/user/{id}"])
//    fun deleteUserInfo(@PathVariable("id") id: String) = userMap.remove(id)
//}