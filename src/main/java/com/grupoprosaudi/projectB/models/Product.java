package com.grupoprosaudi.projectB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_products")
public class Product extends AbstarctModel {

    @NotEmpty
    @Column(name = "name", length = 100)
    private String name;

    @NotNull
    @Column(name = "value")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
