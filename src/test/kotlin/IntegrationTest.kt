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

/*  
    Integration test for the class LAB1-GIT-RACE/src/main/kotlin/controller/IntegrationTest.kt
    - @SpringBootTest annotation provides a convenient way to start up an application context 
      to be used in a test. 
    - @LocalServerPort is a way to define a value for the tomcat port of our service. 
*/
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class IntegrationTest {
    @LocalServerPort
    private var port: Int = 0

    /* 
        TestRestTemplate is an alternative that simplifies integration testing and facilitates 
        authentication during tests. It helps in customization of Apache HTTP client. 
    */
    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    /*
        Test that creates a modified Apache HTTP client that connects to the server address and checks that the code of
        status and the body returned by the server is correct.
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