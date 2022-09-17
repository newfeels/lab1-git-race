package es.unizar.webeng.hello.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/* This class HelloController.kt creates a variable of type map and implements a function 
    called "welcome" which recieves a MutableMap<String,Any> where the function writes the message created before
    and returns a String with "welcome". */
@Controller
class HelloController {
    @Value("\${app.message}")
    private var message: String = "Hello World"
    @GetMapping("/")
    fun welcome(model: MutableMap<String,Any>): String {
        model["message"] =  message
        return "welcome"
    }
}
