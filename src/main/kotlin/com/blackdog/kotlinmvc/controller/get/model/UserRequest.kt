package com.blackdog.kotlinmvc.controller.get.model

import lombok.AllArgsConstructor

data class UserRequest(
    var name: String?=null,
    var age: Int?=null,
    var email: String?=null,
    var address: String?=null
)