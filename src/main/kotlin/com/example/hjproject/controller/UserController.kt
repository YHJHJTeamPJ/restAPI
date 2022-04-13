package com.example.hjproject.controller

@RestController
class UserController(private val userService: UserService, private val passwordEncoder: PasswordEncoder) {

    @PostMapping("/register")
    fun register(@RequestBody userRegisterReq: UserRegisterReq): ResponseEntity<UserRegisterRes> {

        if(userService.existsUser(userRegisterReq.email)) {
            throw BaseException(BaseResponseCode.DUPLICATE_EMAIL)
        }
        userRegisterReq.password = passwordEncoder.encode(userRegisterReq.password)

        return ResponseEntity.ok(userService.createUser(userRegisterReq))
    }

    @PostMapping("/login")
    fun login(@RequestBody userLoginReq: UserLoginReq): ResponseEntity<UserLoginRes> {
        if(!userService.existsUser(userLoginReq.email)) {
            throw BaseException(BaseResponseCode.USER_NOT_FOUND)
        }

        val user: User = userService.findUser(userLoginReq.email)

        if(!passwordEncoder.matches(userLoginReq.password, user.password)) {
            throw BaseException(BaseResponseCode.INVALID_PASSWORD)
        }

        return ResponseEntity.ok(userService.login(userLoginReq))
    }

}