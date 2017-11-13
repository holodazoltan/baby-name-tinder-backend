package com.holoda.babynametinder.backend.controller

import com.holoda.babynametinder.backend.model.ApplicationUser
import com.holoda.babynametinder.backend.persistence.ApplicationUserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sign-up")
class SignUpController(val applicationUserRepository: ApplicationUserRepository, val bCryptPasswordEncoder: BCryptPasswordEncoder) {

    @PostMapping
    fun signUp(@RequestBody applicationUser: ApplicationUser) {
        applicationUser.password = bCryptPasswordEncoder.encode(applicationUser.password)
        applicationUserRepository.save(applicationUser)
    }
}