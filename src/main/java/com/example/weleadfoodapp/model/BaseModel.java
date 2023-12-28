package com.example.weleadfoodapp.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class BaseModel implements Serializable {
    private Long id;
}
