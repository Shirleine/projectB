package com.grupoprosaudi.projectB.models;

import com.grupoprosaudi.projectB.enums.TreatmentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_treatments")
public class Treatment extends AbstarctModel {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "treatment_type")
    private TreatmentType treatmentType;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @OneToMany(mappedBy = "treatment")
    private Set<HealthProfessional> professionals;

    @NotEmpty
    @Column(name = "other_information", columnDefinition = "TEXT")
    private String otherInformation;

    @ManyToOne
    @JoinColumn(name = "health_history_id")
    private HealthHistory healthHistory;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;
}
