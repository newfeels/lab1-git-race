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
 * Integration test for the class LAB1-GIT-RACE/src/main/kotlin/controller/IntegrationTest.kt
 *
 * Collection of integration tests to check the operation of the server.
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class IntegrationTest {

    /**
     * The annotation [LocalServerPort] tells the test runner that 
     * it must inject in [port] the HTTP port that got allocated at runtime.
     * Useful for building URI when the [web environment][SpringBootTest.webEnvironment] 
     * is set to use a [random port][WebEnvironment.RANDOM_PORT].
     */
    @LocalServerPort
    private var port: Int = 0

    /**
     * The annotation [Autowired] happens by placing an instance of one bean into the desired 
     * field in an instance of another bean. Both classes should be beans, i.e. they should be 
     * defined to live in the application context. TestRestTemplate is used to send http request in our 
     * SpringBootTests and has all necessary methods to send the request to server.
     */
    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    /**  
     * Tests that creates a modified Apache HTTP client that connects to the server address and checks that the code of
     * status and the body returned by the server is correct.
     */
    @Test
    fun testHome() {
        with(restTemplate.getForEntity("http://localhost:$port", String::class.java)) {
            /**
             * The method assertThat is one of the JUnit methods from the Assert object that can be used to check if a specific 
             * value match to an expected one. It primarily accepts 2 parameters. First one if the actual value and the second 
             * is a matcher object.
             */
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