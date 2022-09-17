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
     * The variable [message] will take the value of the key [app.message] in the resource file [application.properties] , or "Hello World" if not defined
     * 
     */
    @Value("\${app.message}")
    private var message: String = "Hello World"

    /**
     * Response to / request
     * 
     * This function is executed when the HTTP route request matches the root URL of the server.  
     * 
     * @param model the model in MVC (Model-View-Controller pattern)
     * @return the name of the view in MVC
     */
    @GetMapping("/")
    fun welcome(model: MutableMap<String,Any>): String {
        model["message"] =  message
        return "welcome"
    }
}
