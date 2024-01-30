package com.example.weleadfoodapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STORECATEGORIES")
@SequenceGenerator(name = "idGenerator", sequenceName = "STORE_CATEGORIES_SEQ", initialValue = 1, allocationSize = 1)
public class StoreCategory extends BaseModel {
    @NotNull
    @Column(length = 50, nullable = false)
    private String description;
}
