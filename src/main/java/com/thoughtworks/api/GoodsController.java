package com.thoughtworks.api;

import com.thoughtworks.domain.Goods;
import com.thoughtworks.dto.GoodsDto;
import com.thoughtworks.exception.ErrorInputException;
import com.thoughtworks.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods")
    public ResponseEntity getGoodsList(){
        return ResponseEntity.ok(goodsService.getAllGoods());
    }

    @PostMapping("/good")
    public ResponseEntity getGoodsList(@RequestBody @Valid Goods goods){
        System.out.println(goods);
        goodsService.addGoods(goods);
        return ResponseEntity.ok().build();
    }

}
