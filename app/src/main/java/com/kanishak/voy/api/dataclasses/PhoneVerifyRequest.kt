package com.kanishak.voy.api.dataclasses

data class PhoneVerifyRequest(
    val user_id: String,
    val phone_otp: String
)