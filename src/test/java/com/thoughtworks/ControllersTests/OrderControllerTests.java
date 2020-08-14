package com.thoughtworks.ControllersTests;


import com.thoughtworks.dto.GoodsDto;
import com.thoughtworks.repository.GoodsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderControllerTests {

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
        goodsRepository.save(goodsDto2);
        goodsRepository.save(goodsDto1);
        goodsRepository.save(goodsDto3);
    }

    @Test
    public void should_return_bad_when_add_order() throws Exception {
        mockMvc.perform(post("/order")
                .param("good", "300"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void should_return_ok_when_add_order() throws Exception {
        mockMvc.perform(post("/order")
                .param("good", String.valueOf(goodsDto2.getId())))
                .andExpect(status().isOk());
    }
}
