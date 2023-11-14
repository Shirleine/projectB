package com.grupoprosaudi.projectB.models;

import com.grupoprosaudi.projectB.enums.TimeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_times")
public class Time extends AbstarctModel {

    @NotNull
    @Column(name = "time")
    private LocalTime time;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type_time")
    private TimeType typeTime;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
