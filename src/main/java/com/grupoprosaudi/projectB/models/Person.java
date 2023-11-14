package com.grupoprosaudi.projectB.models;

import com.grupoprosaudi.projectB.enums.Approval;
import com.grupoprosaudi.projectB.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public abstract class Person extends AbstarctModel {

    @NotEmpty
    @Column(name = "name", length = 100)
    private String name;

    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotNull
    @Column(name = "phone", length = 11)
    private String phone;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Email
    @Column(name = "email", length = 100)
    private String email;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "approval")
    private Approval approval;

    @NotNull
    @JoinColumn(name = "address")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
}