package com.example.weleadfoodapp.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class StoreCategoryResource extends BaseResource {
    private String description;
}
