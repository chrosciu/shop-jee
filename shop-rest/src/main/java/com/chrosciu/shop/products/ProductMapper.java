package com.chrosciu.shop.products;

import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    ProductOutputDto toDto(Product product);
}
