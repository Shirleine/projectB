package com.grupoprosaudi.projectB.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "tb_clients")
public class Client extends AbstarctModel {

    @CPF
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "associated_number", length = 8)
    private String associatedNumber;

    @JoinColumn(name = "health_history")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private HealthHistory healthHistory;

    @OneToMany(mappedBy = "client")
    private Set<BankData> bankData;

    @OneToMany(mappedBy = "client")
    private Set<Shopping> shopping;

    @OneToMany(mappedBy = "client")
    private Set<MenstrualCycle> menstrualCycle;

    @OneToMany(mappedBy = "client")
    private Set<Child> children;

    @OneToMany(mappedBy = "client")
    private Set<HealthInsurance> healthInsurences;

    @OneToMany(mappedBy = "client")
    private Set<Time> times;

    @OneToOne
    @JoinColumn(name = "preference")
    private Preference preference;
}
