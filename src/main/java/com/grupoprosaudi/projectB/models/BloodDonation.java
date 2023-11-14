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
@Entity(name = "tb_blood_donations")
public class BloodDonation extends AbstarctModel {

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotEmpty
    @Column(name = "institution", length = 100)
    private String institution;

    @NotEmpty
    @Column(name = "other_information", columnDefinition = "TEXT")
    private String otherInformation;

    @ManyToOne
    @JoinColumn(name = "health_history_id")
    private HealthHistory healthHistory;
}
