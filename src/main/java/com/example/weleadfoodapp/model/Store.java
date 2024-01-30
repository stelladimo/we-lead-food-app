package com.example.weleadfoodapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(callSuper = true)
@Table(name = "STORES")
@SequenceGenerator(name = "idGenerator", sequenceName = "STORES_SEQ", initialValue = 1, allocationSize = 1)
public class Store extends BaseModel {

    @Column(length = 20, nullable = false)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private StoreCategory storeCategory;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private final Set<Product> products = new HashSet<>();


}