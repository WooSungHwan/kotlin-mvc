package com.blackdog.kotlinmvc.controller.exception

import com.blackdog.kotlinmvc.model.http.UserRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.util.LinkedMultiValueMap

@WebMvcTest
@AutoConfigureMockMvc
class ExceptionApiControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun helloTest() {
        mockMvc.perform(get("/api/exception/hello"))
            .andExpect(status().isOk)
            .andExpect {
                content().string("hello")
            }.andDo(print())
    }

    @Test
    fun getTest() {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name", "woo")
        queryParams.add("age", "20")

        mockMvc.perform(get("/api/exception")
            .queryParams(queryParams))
            .andExpect(status().isOk)
            .andExpect(content().string("woo 20"))
            .andDo(print())
    }

    @Test
    fun getFailTest() {
        val queryParams = LinkedMultiValueMap<String, String>()
        queryParams.add("name", "woo")
        queryParams.add("age", "9")

        mockMvc.perform(get("/api/exception")
            .queryParams(queryParams)
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isBadRequest)
            .andExpect(
                jsonPath("\$.result_code").value("FAIL")
            ).andExpect(
                jsonPath("\$.errors[0].field").value("age")
            ).andExpect(
                jsonPath("\$.errors[0].value").value("9")
            )
            .andDo(print())
    }

    @Test
    fun postTest() {
        val userRequest = UserRequest().apply {
            this.name = "woo"
            this.age = 10
            this.phoneNumber = "010-3982-4903"
            this.address = "경기도 읮어부시"
            this.email = "djkfsjdl@naver.com"
            this.createdAt = "2020-10-30 14:40:40"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest)

        mockMvc.perform(post("/api/exception")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk)
            .andExpect(
                jsonPath("\$.name").value("woo")
            )
            .andExpect(
                jsonPath("\$.age").value("10")
            )
            .andExpect(
                jsonPath("\$.phoneNumber").value("010-3982-4903")
            )
            .andDo(print())
    }

    @Test
    fun postFailTest() {
        val userRequest = UserRequest().apply {
            this.name = "woo"
            this.age = -1
            this.phoneNumber = "010-3982-4903"
            this.address = "경기도 읮어부시"
            this.email = "djkfsjdl@naver.com"
            this.createdAt = "2020-10-30 14:40:40"
        }

        val json = jacksonObjectMapper().writeValueAsString(userRequest)

        mockMvc.perform(post("/api/exception")
            .content(json)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isBadRequest)
            .andExpect(
                jsonPath("\$.result_code").value("FAIL")
            ).andExpect(
                jsonPath("\$.errors[0].field").value("age")
            ).andExpect(
                jsonPath("\$.errors[0].value").value("-1")
            )
            .andDo(print())
    }

}