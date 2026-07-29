package com.kanishak.voy.api.dataclasses

data class LoginResponse(
    val message: String?,
    val status: String?,
    val success: Boolean,
    val tokens: Tokens?,
    val user: User?
)