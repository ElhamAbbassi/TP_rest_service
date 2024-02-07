package ch.admin.zas.TP_rest_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Map;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TpRestServiceTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void helloTest(){
        // send the request ....
        String url = "/api/hello";
        Map<String, String> response = template.getForObject(url, Map.class);

        // check the response from JSON file
        assertEquals("Hello world!", response.get("title"), "expected message to match");
    }
    @Test
    public void helloTest1(){
        // send the request ....
        String url = "/api/hello?name=Thierry";
        Map<String, String> response = template.getForObject(url, Map.class);


        // check the response ...
        assertEquals("Hello Thierry!", response.get("title"), "expected name to be Thierry");

    }
}
