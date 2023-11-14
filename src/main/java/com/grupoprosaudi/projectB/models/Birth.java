package com.grupoprosaudi.projectB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity(name = "tb_births")
public class Birth extends AbstarctModel {

    @NotEmpty
    @Column(name = "name", length = 100)
    private String name;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @Column(name = "weight")
    private Double weight;

    @NotNull
    @Column(name = "length")
    private Double length;

    @NotEmpty
    @Column(name = "other_information", columnDefinition = "TEXT")
    private String otherInformation;
}