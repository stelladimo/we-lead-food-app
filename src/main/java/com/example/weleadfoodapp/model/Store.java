package com.example.weleadfoodapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
public class Store extends BaseModel {
    private  String Name;
    private StoreCategory storeCategory;
    private final Set<Product> products = new HashSet<>();


}