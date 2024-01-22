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
@Entity
@Table(name = "CATEGORIES")
@SequenceGenerator(name = "idGenerator", sequenceName = "CATEGORIES_SEQ", initialValue = 1, allocationSize = 1)
public class Category extends BaseModel {
    @NotNull
    @Column(length = 50, nullable = false)
    private String description;
}