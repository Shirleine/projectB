package com.grupoprosaudi.projectB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_symptoms_and_moods")
public class SymptomsAndMood extends AbstarctModel {

    @NotNull
    @Column(name = "colic")
    private Boolean colic;

    @NotNull
    @Column(name = "mood_changes")
    private Boolean moodChanges;

    @NotNull
    @Column(name = "other_discomforts")
    private Boolean otherDiscomforts;
}
