package com.example.weleadfoodapp.mapper;

import com.example.weleadfoodapp.model.Order;
import com.example.weleadfoodapp.transfer.resource.OrderResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface OrderMapper extends BaseMapper<Order, OrderResource> {
}

