package com.grupoprosaudi.projectB.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_bank_data")
public class BankData extends AbstarctModel {

    @NotEmpty
    @Column(name = "card_number", length = 16)
    private String cardNumber;

    @NotEmpty
    @Column(name = "cvv" , length = 3)
    private String cvv;

    @NotNull
    @Column(name = "validity")
    private LocalDate validity;

    @NotNull
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "charge_address")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address chargeAddress;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
