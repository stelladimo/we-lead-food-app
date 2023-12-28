package com.example.weleadfoodapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Customer extends BaseModel {
    private String email; //required
    private String phone; //required and unique
    private String firstname;
    private String lastname;
    private Integer age;
    private String address;
    private Order order;

}
