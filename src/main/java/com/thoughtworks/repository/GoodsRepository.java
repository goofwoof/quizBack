package com.thoughtworks.repository;

import com.thoughtworks.dto.GoodsDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GoodsRepository extends CrudRepository<GoodsDto, Integer> {
    @Override
    List<GoodsDto> findAll();
}
