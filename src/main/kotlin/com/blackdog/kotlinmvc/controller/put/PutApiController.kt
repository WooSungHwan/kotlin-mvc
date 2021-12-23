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
        Result().apply{

        }
    }

}