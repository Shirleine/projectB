package com.grupoprosaudi.projectB.models;


import com.grupoprosaudi.projectB.enums.SurgeryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_surgeries")
public class Surgery extends AbstarctModel {

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "surgery_type")
    private SurgeryType surgeryType;

    @NotNull
    @OneToMany(mappedBy = "surgery")
    private Set<HealthProfessional> doctors;

    @NotEmpty
    @Column(name = "body_place", length = 100)
    private String bodyPlace;

    @NotEmpty
    @Column(name = "institution", length = 100)
    private String institution;

    @ManyToOne
    @JoinColumn(name = "health_history_id")
    private HealthHistory healthHistory;
}
