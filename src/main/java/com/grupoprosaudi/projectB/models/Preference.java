package com.grupoprosaudi.projectB.models;

import com.grupoprosaudi.projectB.enums.Language;
import com.grupoprosaudi.projectB.enums.MeasuredUnit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_preferences")
public class Preference extends AbstarctModel {

    @Enumerated(EnumType.STRING)
    @Column(name = "measured_unit")
    private MeasuredUnit measuredUnit;

    @Enumerated(EnumType.STRING)
    @Column(name = "language")
    private Language language;

    @NotEmpty
    @Column(name = "date_format", length = 10)
    private String date_format;
}