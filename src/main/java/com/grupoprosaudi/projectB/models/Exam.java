package com.grupoprosaudi.projectB.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_exams")
public class Exam extends AbstarctModel {

    @NotEmpty
    @Column(name = "institution", length = 100)
    private String institution;

    @NotEmpty
    @Column(name="name", length = 100)
    private String name;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File>  files;

    @NotEmpty
    @Column(name = "result", columnDefinition = "TEXT" )
    private String result;

    @NotEmpty
    @Column(name = "reference_value", length = 25)
    private String referenceValue;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotEmpty
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @NotNull
    @OneToMany(mappedBy = "exam")
    private Set<HealthProfessional> professionals;

    @NotNull
    @Column(name = "shared")
    private Boolean shared;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @ManyToOne
    @JoinColumn(name = "health_history_id")
    private HealthHistory healthHistory;

    @ManyToOne
    @JoinColumn(name = "pregnancy_id")
    private Pregnancy pregnancy;
}
