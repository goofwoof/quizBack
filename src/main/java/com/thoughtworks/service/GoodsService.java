package com.thoughtworks.service;

import com.thoughtworks.dto.GoodsDto;
import com.thoughtworks.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    public List<GoodsDto> getAllGoods() {
        return goodsRepository.findAll();
    }
}
