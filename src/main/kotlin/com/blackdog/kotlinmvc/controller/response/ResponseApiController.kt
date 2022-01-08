package com.blackdog.kotlinmvc.controller.response

import com.blackdog.kotlinmvc.model.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    // 1. get 4xx

    @GetMapping
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {
        return age?.let{
            // age != null
            if (it < 20) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body("age 값은 20보다 커야합니다.")
            }

            ResponseEntity.ok("OK");
        }?: kotlin.run {
            // age == null
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body("age 값은 누락되었습니다.")
        }

/*
    [ 코틀린 스럽지 못함 ]
        // 1. age == null >> 400
        if (age == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body("age 값은 누락되었습니다.")
        }

        // 2. age < 20 >> 400
        if (age < 20) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body("age 값은 20보다 커야합니다.")
        }
*/
//        return ResponseEntity.ok("OK");
    }

    // 2. post 200

    @PostMapping
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.OK).body(userRequest)
    }

    // 3. put 201
    @PutMapping
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        // 기존 데이터가 없어서 새로 생성
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    // 4. delete 500
    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable("id") id: Int): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }

}