package com.example.weleadfoodapp.mapper;


import com.example.weleadfoodapp.model.Store;
import com.example.weleadfoodapp.transfer.resource.StoreResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface StoreMapper extends BaseMapper<Store, StoreResource> {
}