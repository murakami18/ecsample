package com.example.mapper;

import com.example.entity.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    /** 全商品を取得する */
    List<Product> findAll();

    /** IDで商品を1件取得する */
    Product findById(int id);
}