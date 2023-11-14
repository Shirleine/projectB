package com.grupoprosaudi.projectB.models;

import jakarta.persistence.*;
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
@Entity(name = "tb_queries")
public class Query extends AbstarctModel{

    @NotNull
    @Column(name="date")
    private LocalDate date;

    @OneToMany(mappedBy = "query")
    private Set<HealthProfessional> professionals;

    @Column(name = "symptoms")
    @ElementCollection
    @CollectionTable(name = "tb_symptoms")
    private Set<String> symptoms;

    @Column(name = "files")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> files;

    @ManyToOne
    @JoinColumn(name = "health_history_id")
    private HealthHistory healthHistory;

    @ManyToOne
    @JoinColumn(name = "pregnancy_id")
    private Pregnancy pregnancy;
}