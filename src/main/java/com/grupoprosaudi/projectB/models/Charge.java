package com.grupoprosaudi.projectB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "tb_charges")
public class Charge extends AbstarctModel {

    @CPF
    @Column(name = "cpf", length = 11)
    private String cpf;

    @NotNull
    @ManyToOne
    private Address address;

    @NotNull
    @ManyToOne
    private BankData bankData;
}
