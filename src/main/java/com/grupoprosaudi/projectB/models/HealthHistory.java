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
@Entity(name = "tb_health_histories")
public class HealthHistory extends AbstarctModel {

    @OneToMany(mappedBy = "healthHistory")
    private Set<BloodDonation> bloodDonations;

    @OneToMany(mappedBy = "healthHistory")
    private Set<Surgery> surgerys;

    @OneToMany(mappedBy = "healthHistory")
    private Set<Treatment> treatments;

    @OneToMany (mappedBy = "healthHistory")
    private Set<Disease> diseases;

    @OneToMany (mappedBy = "healthHistory")
    private Set<Exam> exams;

    @OneToMany (mappedBy = "healthHistory")
    private Set<Query> querys;

    @OneToMany (mappedBy = "healthHistory")
    private Set<Vaccine> vaccines;

    @OneToMany (mappedBy = "healthHistory")
    private Set<Pregnancy> pregnancies;

    @NotNull
    @Column(name = "shared")
    private Boolean shared;
}