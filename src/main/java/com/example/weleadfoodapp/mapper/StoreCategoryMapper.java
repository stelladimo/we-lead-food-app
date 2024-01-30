package com.example.weleadfoodapp.mapper;

import com.example.weleadfoodapp.model.StoreCategory;
import com.example.weleadfoodapp.transfer.resource.StoreCategoryResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface StoreCategoryMapper extends BaseMapper<StoreCategory, StoreCategoryResource> {
}
