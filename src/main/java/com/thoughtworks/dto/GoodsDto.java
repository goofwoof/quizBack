package com.thoughtworks.dto;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Goods")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class GoodsDto {
    @Id
    @GeneratedValue
    private int Id;
    private String GoodName;
    private int price;
    private String unit;
    private String src;

    @OneToMany(targetEntity = OrderDto.class, cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "order_id")
    private List<OrderDto> rsEventDtoList;
}
