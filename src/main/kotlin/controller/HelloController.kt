package es.unizar.webeng.hello.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 * A HTTP request controller
 */
@Controller
class HelloController {
    /**
     * The variable [message] will take the value of [src.main.resources.application.properties.app.message], or "Hello World" if not defined
     * 
     */
    @Value("\${app.message}")
    private var message: String = "Hello World"

    /**
     * Response to http://localhost:8080/ (root URL) route request
     * 
     * This function is executed when the HTTP route request matches the root URL of the server.  
     * 
     * @param model HelloController[message] will be saved in [model]["message"] map key
     * @return "welcome"
     */
    @GetMapping("/")
    fun welcome(model: MutableMap<String,Any>): String {
        model["message"] =  message
        return "welcome"
    }
}
