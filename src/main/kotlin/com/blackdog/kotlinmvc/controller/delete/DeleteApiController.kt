package com.blackdog.kotlinmvc.controller.delete

import org.springframework.web.bind.annotation.*

@RequestMapping("/api")
@RestController
class DeleteApiController {

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam name: String,
        @RequestParam age: Int
    ): String {
        println(name)
        println(age)

        return "$name $age"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @PathVariable("name") name:String,
        @PathVariable("age") age:Int
    ): String {
        println(name)
        println(age)

        return "$name $age"
    }

}