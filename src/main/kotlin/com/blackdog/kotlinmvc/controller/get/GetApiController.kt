package com.blackdog.kotlinmvc.controller.get

import com.blackdog.kotlinmvc.model.http.UserRequest
import org.springframework.web.bind.annotation.*

@RequestMapping("/api")
@RestController
class GetApiController {

    @GetMapping("/hello")
    fun hello(): String {
        return "hello Kotlin"
    }

    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "mapping"
    }

    @GetMapping("/get-mapping/path-variable/{name}/{age}")
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("${name}, $age")
        return name + " " + age
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")
    fun pathVariable2(@PathVariable("name") _name: String, @PathVariable age: Int): String {
        val name = "kotlin"

        println("${_name}, $age")
        return "$_name $age"
    }

    @GetMapping("/get-mapping/query-param")
    fun queryParam(
        @RequestParam name: String,
        @RequestParam age: Int
    ): String {
        println("${name}, $age")
        return "$name $age"
    }

    @GetMapping("/get-mapping/query-param-object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    @GetMapping("/get-mapping/query-param-map")
    fun queryParamMap(map: Map<String, Any>): Map<String, Any> {
        println(map)
        return map
    }
}