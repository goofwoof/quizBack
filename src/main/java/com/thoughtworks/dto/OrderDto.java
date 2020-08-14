package com.thoughtworks.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @javax.persistence.Id
    @GeneratedValue
    private int Id;
    @ManyToOne(targetEntity = GoodsDto.class)
    @JoinColumn(name = "order_id")
    private int goodId;
}
