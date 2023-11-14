package com.grupoprosaudi.projectB.models;

import com.grupoprosaudi.projectB.enums.EventType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_events")
public class Event extends AbstarctModel {

    @NotEmpty
    @Column(name="name", length = 100)
    private String name;

    @NotNull
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @NotEmpty
    @Column(name = "place", length = 100)
    private String place;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType eventType;

    @NotNull
    @Column(name = "shared")
    private Boolean shared;

}
