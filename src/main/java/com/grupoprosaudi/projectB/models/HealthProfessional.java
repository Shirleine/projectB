package com.grupoprosaudi.projectB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_health_professionals")
public class HealthProfessional extends AbstarctModel {

    @NotEmpty
    @Column(name="name", length = 100)
    private String name;

    @NotEmpty
    @Column(name = "records", length = 8)
    private String record;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;

    @ManyToOne
    @JoinColumn(name = "query_id")
    private Query query;

    @ManyToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;
}
