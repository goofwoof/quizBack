package com.thoughtworks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int Id;
    private int goodId;
    private int price;
    private String unit;
    private int Number;
}
