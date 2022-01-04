package com.blackdog.kotlinmvc.advice

import com.blackdog.kotlinmvc.exception.ExceptionApiController
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.IndexOutOfBoundsException
import java.lang.RuntimeException

@RestControllerAdvice(basePackageClasses = [ExceptionApiController::class ])
class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [RuntimeException::class])
    fun exception(e : RuntimeException): String {
        return "Server Error"
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundException(): String {
        return "Index Error"
    }

}