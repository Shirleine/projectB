package com.grupoprosaudi.projectB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_reminders")
public class Reminder extends AbstarctModel {

    @NotEmpty
    @Column(name = "medicine", length = 100)
    private String medicine;

    @NotNull
    @Column(name = "time")
    private LocalTime time;

}
