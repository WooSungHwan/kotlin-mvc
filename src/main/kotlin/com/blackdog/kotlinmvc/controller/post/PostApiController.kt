package com.blackdog.kotlinmvc.controller.post

import com.blackdog.kotlinmvc.controller.get.model.UserRequest
import org.springframework.web.bind.annotation.*

@RequestMapping("/api")
@RestController
class PostApiController {

    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "mapping"
    }

    @RequestMapping(method = [RequestMethod.POST], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }

    @PostMapping("/post-mapping-object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

}