package com.kanishak.voy.api.dataclasses

data class VerifyRequest(
    val email: String,
    val otp: String

)