package com.blackdog.kotlinmvc.controller.put

import com.blackdog.kotlinmvc.controller.get.model.Result
import com.blackdog.kotlinmvc.controller.get.model.UserRequest
import com.blackdog.kotlinmvc.controller.get.model.UserResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("/api")
@RestController
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }

    @PutMapping(path = ["/put-mapping-object"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {
        return UserResponse().apply {
            Result().apply{
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }
        }.apply {
            this.description = "sdjfklsjfls";
        }.apply {
            val userList = mutableListOf<UserRequest>()

             userList.add(userRequest)

             userList.add(UserRequest().apply {
                 this.name = "우성환1"
                 this.age = 28
                 this.address = "주소주소"
                 this.email = "이메일주소"
                 this.phoneNumber = "01037195510"
             })

            userList.add(UserRequest().apply {
                this.name = "우성환2"
                this.age = 28
                this.address = "주소주소"
                this.email = "이메일주소"
                this.phoneNumber = "01037195510"
            })

            this.user = userList
        }
    }

}