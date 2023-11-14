package com.grupoprosaudi.projectB.models;

import jakarta.persistence.*;
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
@Entity(name = "tb_pregnancies")
public class Pregnancy extends AbstarctModel {

    @NotNull
    @Column(name = "shared")
    private Boolean shared;

    @OneToMany(mappedBy = "pregnancy")
    private Set<Query> querys;

    @OneToMany(mappedBy = "pregnancy")
    private Set<Exam> exams;

    @OneToMany(mappedBy = "pregnancy")
    private Set<Development> developments;

    @ManyToOne
    @JoinColumn(name = "health_history_id")
    private HealthHistory healthHistory;
}
