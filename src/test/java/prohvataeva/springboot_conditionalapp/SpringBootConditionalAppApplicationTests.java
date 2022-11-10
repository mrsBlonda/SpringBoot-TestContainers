package prohvataeva.springboot_conditionalapp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootConditionalAppApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;
    @Container
    private static final GenericContainer<?> myAppDev = new GenericContainer<>("devapp")
            .withExposedPorts(8080);
    @Container
    private static final GenericContainer<?> myAppProd = new GenericContainer<>("prodapp")
            .withExposedPorts(8081);

//    @BeforeAll
//    public static void setUp() {
//        myAppDev.start();
//        myAppProd.start();
//    }

    @Test
    void contextLoads() {
        Integer devPort = myAppDev.getMappedPort(8080);
        Integer prodPort = myAppProd.getMappedPort(8081);
        ResponseEntity<String> devEntity = restTemplate.getForEntity("http://localhost:" + devPort, String.class);
        ResponseEntity<String> prodEntity = restTemplate.getForEntity("http://localhost:" + prodPort, String.class);
        System.out.println("DevApp: " + devEntity.getBody());
        System.out.println("ProdApp: " + prodEntity.getBody());
    }

}
