package com.cub.demo.service;

import java.util.List;

import com.cub.demo.dao.CurrencyDao;
import com.cub.demo.entity.Currency;
import com.cub.demo.vo.CurrencyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyDao.Jpa repo;

    public List<Currency> getAll() {
        return repo.findAll();
    }

    public Currency getByCode(String code) {
        return repo.findByCode(code).orElseThrow(() -> new NullPointerException("查無資料"));
    }

    public Currency create(CurrencyVo vo, String account) {
        Currency entity = Currency.builder()
                                  .name(vo.getName())
                                  .code(vo.getCode())
                                  .build();
        entity.create(account);
        return repo.save(entity);
    }

    public Currency update(CurrencyVo vo, String account) {
        Currency entity = repo.findById(vo.getId()).orElseThrow(() -> new NullPointerException("查無資料"));
        entity.setName(vo.getName());
        entity.setCode(vo.getCode());
        entity.update(account);
        return repo.save(entity);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
