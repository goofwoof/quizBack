package com.thoughtworks.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "Goods")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDto {
    @Id
    @GeneratedValue
    private int Id;
    private String GoodName;
    private String Description;
}
