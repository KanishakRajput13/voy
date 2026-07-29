package com.kanishak.voy.api.dataclasses

data class VerificationStatus(
    val email_verified: Boolean,
    val phone_verified: Boolean
)