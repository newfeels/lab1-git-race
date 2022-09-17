package es.unizar.webeng.hello.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
*   This class HelloController configures the controller and set the initial message. 
*   @constructor creates an empty controller.
*/
@Controller
class HelloController {
    @Value("\${app.message}")
    private var message: String = "Hello World"
    @GetMapping("/")
    /**
    *   Adds "Hello world"(value) in the key identified as "message" in model 
    *   @param model : modifiable collection that holds pairs of objects (keys and values).
    *   @return string "welcome". 
    */
    fun welcome(model: MutableMap<String,Any>): String {
        model["message"] =  message
        return "welcome"
    }
}
