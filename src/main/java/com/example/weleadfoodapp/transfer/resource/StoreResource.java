package com.example.weleadfoodapp.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class StoreResource extends BaseResource {
    private String name;
    private StoreCategoryResource storeCategory;


}
