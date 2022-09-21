package es.unizar.webeng.hello.controller

import org.hamcrest.CoreMatchers.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * The [WebMvcTest] annotation is used for Spring MVC tests. It disables full
 * autoconfiguration and instead apply only configuration relevant to MVC tests.
 *
 * The [WebMvcTest] annotation autoconfigure MockMvc instance as well.
 *
 * Using HelloController::class as parameter, we are asking to initialize only one web controller,
 * and you need to provide remaining dependencies required using Mock objects.
 */
@WebMvcTest(HelloController::class)
class HelloControllerMVCTests {
    /**
     * The variable [message] takes the value of the key [app.message] in the resource file [application.properties].
     */
    @Value("\${app.message}")
    private lateinit var message: String

    /**
     * The [Autowired] annotation marks a Constructor, Setter method, Properties and Config() method
     * as to be autowired that is injecting beans (Objects) at runtime by Spring Dependency Injection mechanism.
     * It enables you to inject the object dependency implicitly.
     */
    @Autowired
    private lateinit var mockMvc: MockMvc

    /**
     * Integration test that calls a GET request to /,
     * prints the request and response
     * and verifies that response HTTP status is Ok (ensuring that the request was successfully executed)
     * and also the model attribute [message] has the expected value.
     */
    @Test
    fun testMessage() {
        mockMvc.perform(get("/"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(model().attribute("message", equalTo(message)))
    }
}

