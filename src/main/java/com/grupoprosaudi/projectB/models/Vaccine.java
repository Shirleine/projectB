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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tb_vaccines")
public class Vaccine extends AbstarctModel{

    @NotEmpty
    @Column(name = "name", length = 100)
    private String name;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

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
