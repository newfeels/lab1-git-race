package es.unizar.webeng.hello.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
*   This class has the unit tests of the HelloController class. 
*   Is designed using JUnit5 to compare the results obtained with the results expected with assertions.
*/
class HelloControllerUnitTests {
    private lateinit var controller: HelloController
    /**
    *   This function will be executed before each unit test of the class.
    *   @constructor Creates a new empty controller. 
    */
    @BeforeEach
    fun setup() {
        controller = HelloController()
    }
    /**
    *   This test generates the values needed for the function "welcome" of the controller
    *   which is being tested and compares if the return is the expected and the map is modified correctly.
    */
    @Test
    fun testMessage() {
        val map = mutableMapOf<String,Any>()
        val view = controller.welcome(map)
        assertThat(view).isEqualTo("welcome")
        assertThat(map.containsKey("message")).isTrue
        assertThat(map["message"]).isEqualTo("Hello World")
    }
}
