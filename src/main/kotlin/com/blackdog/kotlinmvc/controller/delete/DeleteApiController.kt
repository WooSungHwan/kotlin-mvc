package com.blackdog.kotlinmvc.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Validated
@RequestMapping("/api")
@RestController
class DeleteApiController {

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam name: String,
        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message = "age 값은 {value}보다 커야합니다.")
        @RequestParam age: Int
    ): String {
        println(name)
        println(age)

        return "$name $age"
    }

    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @Size(min = 2, max = 5, message = "name 값의 길이는 2 ~ 5")
        @NotNull
        @PathVariable("name") name:String,
        @NotNull(message = "age 값이 누락되었습니다.")
        @Min(value = 20, message = "age 값은 {value}보다 커야합니다.")
        @PathVariable("age") age:Int
    ): String {
        println(name)
        println(age)

        return "$name $age"
    }

}