package com.thoughtworks.service;

import com.thoughtworks.domain.Goods;
import com.thoughtworks.dto.GoodsDto;
import com.thoughtworks.exception.ErrorIndexException;
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

    public void addGoods(Goods goods) {
        GoodsDto goodsDto = GoodsDto.builder().GoodName(goods.getGoodName()).price(goods.getPrice())
                .src(goods.getSrc()).unit(goods.getUnit()).build();
        try{
            goodsRepository.save(goodsDto);
        }catch (Exception e){
            throw new ErrorIndexException("新增操作失败");
        }
    }
}
