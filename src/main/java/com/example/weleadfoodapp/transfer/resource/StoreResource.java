package com.example.weleadfoodapp.transfer.resource;

import com.example.weleadfoodapp.model.StoreCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
public class StoreResource extends BaseResource {
    private String name;
    private StoreCategory storeCategory;
    private Set<StoreResource> stores = new HashSet<>();


}
