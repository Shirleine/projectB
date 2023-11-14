package com.grupoprosaudi.projectB.models;

import com.grupoprosaudi.projectB.enums.DiseaseType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_diseases")
public class Disease extends AbstarctModel {

    @NotEmpty
    @Column(name = "name", length = 100)
    private String name;

    @NotEmpty
    @Column(name = "diagnosis", columnDefinition = "TEXT")
    private String diagnosis;

    @Column(name = "symptoms")
    @ElementCollection
    @CollectionTable(name = "tb_symptoms")
    private Set<String> symptoms;

    @OneToMany(mappedBy = "disease")
    private Set<Treatment> treatments;

    @OneToMany(mappedBy = "disease")
    private Set<HealthProfessional> doctors;

    @OneToMany(mappedBy = "disease")
    private Set<Exam> exams;

    @Enumerated(EnumType.STRING)
    @Column(name = "disease_type")
    private DiseaseType diseaseType;

    @ManyToOne
    @JoinColumn(name = "health_history_id")
    private HealthHistory healthHistory;
}
