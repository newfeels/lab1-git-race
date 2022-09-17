package es.unizar.webeng.hello.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/*  Unit test for the class LAB1-GIT-RACE/src/main/kotlin/controller/HelloController.kt
    which is designed using JUnit5 with a @BeforeEach label(methods that are executed before the
    execution of each of the test methods) for create de controller. */
class HelloControllerUnitTests {
    private lateinit var controller: HelloController
    @BeforeEach
    fun setup() {
        controller = HelloController()
    }
    /* Unit method to test the functionality of the controller where we create values for him
    and we check if the results obtained are the results expected */
    @Test
    fun testMessage() {
        val map = mutableMapOf<String,Any>()
        val view = controller.welcome(map)
        assertThat(view).isEqualTo("welcome")
        assertThat(map.containsKey("message")).isTrue
        assertThat(map["message"]).isEqualTo("Hello World")
    }
}
