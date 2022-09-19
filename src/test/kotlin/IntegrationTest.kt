package es.unizar.webeng.hello

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

/**  
 *  Integration test for the class LAB1-GIT-RACE/src/main/kotlin/controller/IntegrationTest.kt
 *
 *  Collection of integration tests to check the operation of the server.
 *
 *  @param webEnvironment creates a web application context with triggers usually listening on a random port.
 *  @param port local server port
 *  @property SpringBootTest provides a convenient way to start up an application context to be used in a test.
 *  @property LocalServerPort this is a way to define a value for the tomcat port of our service.
 *  @property TestRestTemplate this is an alternative that simplifies integration testing and facilitates 
 *      authentication during tests. It helps in customization of Apache HTTP client.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class IntegrationTest {
    @LocalServerPort
    private var port: Int = 0

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    /**  
     *  Tests that creates a modified Apache HTTP client that connects to the server address and checks that the code of
     *      status and the body returned by the server is correct.
     *
     *  @property assertThat is one of the JUnit methods from the Assert object that can be used to check if a specific 
     *      value match to an expected one. It primarily accepts 2 parameters. First one if the actual value and the second is a matcher object.
     */
    @Test
    fun testHome() {
        with(restTemplate.getForEntity("http://localhost:$port", String::class.java)) {
            assertThat(statusCode).isEqualTo(HttpStatus.OK)
            assertThat(body).contains("<title>Hello")
        }
    }

    @Test
    fun testCss() {
        with(restTemplate.getForEntity("http://localhost:$port/webjars/bootstrap/5.1.0/css/bootstrap.min.css", String::class.java)) {
            assertThat(statusCode).isEqualTo(HttpStatus.OK)
            assertThat(body).contains("body")
            assertThat(headers.contentType).isEqualTo(MediaType.valueOf("text/css"))
        }
    }
}