package com.thoughtworks.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private int Id;
    @NotNull
    private String goodName;
    @NotNull
    private int price;
    @NotNull
    private String unit;
    @NotNull
    private String src;
}
