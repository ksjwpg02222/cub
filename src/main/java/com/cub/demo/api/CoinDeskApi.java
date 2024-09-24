package com.cub.demo.api;

import com.cub.demo.constant.SystemValues;
import com.cub.demo.facade.CoinDeskFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/coinDesk")
public class CoinDeskApi {

    @Autowired
    private CoinDeskFacade facade;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<String> getCoinDesk() {
        ResponseEntity<String> resEntity = restTemplate.getForEntity(
                SystemValues.COIN_DESK,
                String.class
        );

        return ResponseEntity.ok(resEntity.getBody());
    }

    @GetMapping("/convert")
    public ResponseEntity<String> getCoinDeskThenConvert() {
        return ResponseEntity.ok(facade.convertToString());
    }
}
