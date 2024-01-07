package com.example.weleadfoodapp.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CustomerResource extends BaseResource {
    private String email;
    private String firstname;
    private String lastname;
    private Integer age;
    private String address;

}
