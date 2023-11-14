package com.grupoprosaudi.projectB.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_children")
public class Child extends AbstarctModel{

    @NotEmpty
    @Column(name = "name", length = 100)
    private String name;

    @JoinColumn(name = "health_history")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private HealthHistory healthHistorys;

    @NotNull
    @OneToMany(mappedBy = "child")
    private Set<Development> development;

    @NotNull
    @Column(name = "shared")
    private Boolean shared;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
