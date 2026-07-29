package com.kanishak.voy.api.dataclasses

data class DriverRequestList(
    val `data`: List<DataXXXX>,
    val success: Boolean,
    val details: String,
    val error: String
)