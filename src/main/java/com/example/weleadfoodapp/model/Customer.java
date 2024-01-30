package com.example.weleadfoodapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "CUSTOMERS", indexes = {@Index(columnList = "email")})
@SequenceGenerator(name = "idGenerator", sequenceName = "CUSTOMERS_SEQ", initialValue = 1, allocationSize = 1)
public class Customer extends BaseModel {
    @Email
    @Column(length = 50, nullable = false, unique = true)
    private String email; //required

    @Column(length = 20, nullable = false)
    private String phone; //required and unique

    @Column(length = 50, nullable = false)
    private String firstname;

    @Column(length = 50, nullable = false, unique = true)
    private String lastname;

    @Column(length = 50, nullable = false, unique = true)
    private Integer age;

    @Column(length = 50)
    private String address;


}
