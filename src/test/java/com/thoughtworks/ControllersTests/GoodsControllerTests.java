package com.thoughtworks.ControllersTests;


import com.thoughtworks.api.GoodsController;
import com.thoughtworks.dto.GoodsDto;
import com.thoughtworks.repository.GoodsRepository;
import com.thoughtworks.service.GoodsService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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


    @BeforeEach
    void setup(){
        goodsRepository.deleteAll();
        GoodsDto goodsDto1 = GoodsDto.builder().GoodName("海飞丝").Description("洗发露").build();
        GoodsDto goodsDto2 = GoodsDto.builder().GoodName("小米手机").Description("电子产品").build();
        GoodsDto goodsDto3 = GoodsDto.builder().GoodName("台灯").Description("照明设备").build();
        goodsRepository.save(goodsDto1);
        goodsRepository.save(goodsDto2);
        goodsRepository.save(goodsDto3);
    }

    @Test
    public void should_return_GoodsList_when_get_Goods() throws Exception {
        mockMvc.perform(get("/goods"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
}
