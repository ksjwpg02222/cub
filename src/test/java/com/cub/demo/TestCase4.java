package com.cub.demo;

import java.util.List;

import com.cub.demo.constant.SystemValues;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCase4 {

    @Autowired
    private RestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void test() {
        String url = "http://localhost:" + port + "/currency/1";

        restTemplate.delete(url);

        ResponseEntity<List> res = restTemplate.getForEntity(
                SystemValues.TEST_URL + port + "/currency",
                List.class
        );

        assertNotNull(res);
        res.getBody().forEach(System.out::println);

    }

}

