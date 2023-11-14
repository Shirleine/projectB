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

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_developments")
public class Development extends AbstarctModel {

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @Column(name ="weight")
    private Double weight;

    @NotNull
    @Column(name ="height")
    private Double height;

    @NotEmpty
    @Column(name = "other_information", columnDefinition = "TEXT")
    private String otherInformation;

    @ManyToOne
    @JoinColumn(name = "pregnancy_id")
    private Pregnancy pregnancy;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
}
