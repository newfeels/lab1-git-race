package es.unizar.webeng.hello.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

/** 
 *  Controller class.
 *
 *  The annotation [Controller], which are means of attaching
 *  metadata to code.
 *  The responsbility ofthis class is to accept requests
 *  from the user, to interact with the model and to select
 *  the view for response.
 */
@Controller
class HelloController {

    /**
     *  The value parameter is a special case in which
     *  its value can be specified without an explicit
     *  name. In this case, the value given to this
     *  parameter is the content of the app.message.
     *  This message is located at /resources/application.properties
     *  and contains the text "Hola estudiante".
     */
    @Value("\${app.message}")
    private var message: String = "Hello World"

    /**
     *  The annotation [GetMapping] maps a 'get' request 
     *  to a methodpassinf the "/" path as a patameter.
     *  The method returns the string "welcome", which is
     *  the view for response.
     */
    @GetMapping("/")
    fun welcome(model: MutableMap<String,Any>): String {
        model["message"] =  message
        return "welcome"
    }
}
