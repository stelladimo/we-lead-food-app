package com.example.weleadfoodapp.mapper;

import com.example.weleadfoodapp.model.Category;
import com.example.weleadfoodapp.transfer.resource.CategoryResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface CategoryMapper extends BaseMapper<Category, CategoryResource> {
}

