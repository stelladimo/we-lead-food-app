package com.example.weleadfoodapp.mapper;

import com.example.weleadfoodapp.model.Customer;
import com.example.weleadfoodapp.transfer.resource.CustomerResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", config = IgnoreUnmappedMapperConfig.class)
public interface CustomerMapper extends BaseMapper<Customer, CustomerResource> {
}
