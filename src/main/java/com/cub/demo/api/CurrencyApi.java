package com.cub.demo.api;

import java.util.List;

import com.cub.demo.entity.Currency;
import com.cub.demo.service.CurrencyService;
import com.cub.demo.vo.CurrencyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrencyApi {

    @Autowired
    private CurrencyService service;

    @GetMapping
    public ResponseEntity<List<Currency>> getCurrency() {
        try {
            return ResponseEntity.ok(service.getAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createCurrency(@RequestHeader String account, @RequestBody CurrencyVo vo) {
        try {
            service.create(vo, account);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<Void> updateCurrency(@RequestHeader String account, @RequestBody CurrencyVo vo) {
        try {
            service.update(vo, account);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrency(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
