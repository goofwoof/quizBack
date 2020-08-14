package com.thoughtworks.ControllersTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.api.GoodsController;
import com.thoughtworks.dto.GoodsDto;
import com.thoughtworks.repository.GoodsRepository;
import com.thoughtworks.service.GoodsService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoodsControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private GoodsRepository goodsRepository;

    GoodsDto goodsDto2;

    @BeforeEach
    void setup(){
        goodsRepository.deleteAll();
        goodsDto2 = GoodsDto.builder().GoodName("小米手机").unit("台").src("").price(199).build();
        GoodsDto goodsDto1 = GoodsDto.builder().GoodName("海飞丝").build();

        GoodsDto goodsDto3 = GoodsDto.builder().GoodName("台灯").build();
        goodsRepository.save(goodsDto1);
        goodsRepository.save(goodsDto3);
    }

    @Test
    public void should_return_GoodsList_when_get_Goods() throws Exception {
        mockMvc.perform(get("/goods"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void should_return_ok_when_add_Goods() throws Exception {
        String jsonParam = new ObjectMapper().writeValueAsString(goodsDto2);
        mockMvc.perform(post("/good")
                .content(jsonParam).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        mockMvc.perform(get("/goods"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void should_return_4XX_when_add_Goods_give_null() throws Exception {
        goodsDto2.setGoodName(null);
        String jsonParam = new ObjectMapper().writeValueAsString(goodsDto2);
        mockMvc.perform(post("/good")
                .content(jsonParam).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }


}
