package com.blackdog.kotlinmvc.controller.get.model

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


    var createdAt:String?=null // yyyy-MM-dd HH:mm:ss ex)2020-10-22 13:00:00
) {
    @AssertTrue(message = "생성일자의 패턴은 yyyy-MM-dd HH:mm:ss 이어야 합니다.")
    private fun isValidCreatedAt():Boolean { // 정상 : true, 비정상 : false
        return try {
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true
        } catch (e: Exception) {
            false
        }
    }
}