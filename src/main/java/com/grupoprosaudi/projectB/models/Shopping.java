package com.grupoprosaudi.projectB.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_shopping")
public class Shopping extends AbstarctModel {

    @NotNull
    @Column(name = "items")
    @ManyToMany
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}