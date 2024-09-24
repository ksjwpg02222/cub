package com.cub.demo.facade;

import com.cub.demo.constant.SystemValues;
import com.cub.demo.service.CurrencyService;
import com.cub.demo.vo.CoinDeskVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinDeskFacade {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private RestTemplate restTemplate;

    public String convertToString() {
        ResponseEntity<CoinDeskVo> resEntity = restTemplate.getForEntity(
                SystemValues.COIN_DESK,
                CoinDeskVo.class
        );

        CoinDeskVo vo = resEntity.getBody();
        CoinDeskVo.Bpi bpi = vo.getBpi();

        bpi.getUsd().setName(getCurrencyName(bpi.getUsd()));
        bpi.getEur().setName(getCurrencyName(bpi.getEur()));
        bpi.getGbp().setName(getCurrencyName(bpi.getGbp()));

        return vo.convertToString();

    }

    private String getCurrencyName(CoinDeskVo.Info info) {
        return currencyService.getByCode(info.getCode()).getName();
    }

}
