package com.example.weleadfoodapp.mapper;

import com.example.weleadfoodapp.model.Product;
import com.example.weleadfoodapp.transfer.resource.ProductResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface ProductMapper extends BaseMapper<Product, ProductResource> {
}
