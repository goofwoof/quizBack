package com.thoughtworks.api;

import com.thoughtworks.exception.ErrorInputException;
import com.thoughtworks.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods")
    public ResponseEntity getGoodsList(){
        return ResponseEntity.ok(goodsService.getAllGoods());
    }
}
