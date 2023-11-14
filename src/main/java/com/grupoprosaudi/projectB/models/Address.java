package com.grupoprosaudi.projectB.models;

import com.grupoprosaudi.projectB.enums.Country;
import com.grupoprosaudi.projectB.enums.State;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "tb_address")
public class Address extends AbstarctModel {

    @NotEmpty
    @Column(name = "street", length = 100)
    private String street;

    @NotEmpty
    @Column(name = "city", length = 50)
    private String city;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "uf")
    private State uf;

    @NotEmpty
    @Column(name = "zip_code", length = 8)
    private String zipCode;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country country;

    @NotEmpty
    @Column(name = "neighborhood", length = 50)
    private String neighborhood;

}
