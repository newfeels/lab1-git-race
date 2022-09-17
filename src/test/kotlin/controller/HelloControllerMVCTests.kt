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

/* @WebMvcTest annotation is used for Spring MVC tests. It disables full 
   auto-configuration and instead apply only configuration relevant to MVC tests. 
   
   The WebMvcTest annotation auto-configure MockMvc instance as well.
   
   Using HelloController::class as parameter, we are asking to initialize only one web controller and you need to provide remaining dependencies required using Mock objects. */
@WebMvcTest(HelloController::class)
class HelloControllerMVCTests {
    /* Variable "message" takes the value of src.main.resources.application.properties.app.message */
    @Value("\${app.message}")
    private lateinit var message: String

    /* @Autowired annotation enables you to inject the object dependency implicitly. 
    
    MockMvc provides support for Spring MVC testing. It encapsulates all web application beans and makes them available for testing. */
    @Autowired
    private lateinit var mockMvc: MockMvc

    /* Integration test that calls a GET request to root URL, 
       prints the request and response 
       and verifies that response HTTP status is Ok (ensuring that the request was successfully executed) 
       and also the model attribute "message" has the expected value. */
    @Test
    fun testMessage() {
        mockMvc.perform(get("/"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(model().attribute("message", equalTo(message)))
    }
}

