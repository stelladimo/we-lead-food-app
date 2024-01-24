package com.example.weleadfoodapp.mapper;

import com.example.weleadfoodapp.model.OrderItem;
import com.example.weleadfoodapp.transfer.resource.OrderItemResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface OrderItemMapper extends BaseMapper<OrderItem, OrderItemResource> {
}

