package com.blackdog.kotlinmvc.controller.get.model

import com.blackdog.kotlinmvc.annotation.StringFormatDateTime
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequest(
    @field:NotBlank
    @field:Size(min = 2, max = 8)
    var name: String?=null,

    @field:PositiveOrZero
    var age: Int?=null,

    @field:Email
    var email: String?=null,

    @field:NotBlank
    var address: String?=null,

    @field:Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}\$")
    var phoneNumber: String?=null,

    @field:StringFormatDateTime(pattern = "yyyy-MM-dd HH:mm:ss", message = "패턴이 올바르지 않습니다.")
    var createdAt:String?=null // yyyy-MM-dd HH:mm:ss ex)2020-10-22 13:00:00
)