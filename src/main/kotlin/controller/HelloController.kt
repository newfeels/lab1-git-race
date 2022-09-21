package es.unizar.webeng.hello.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/**
 *   [HelloController] configures the controller and set the initial message. 
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
