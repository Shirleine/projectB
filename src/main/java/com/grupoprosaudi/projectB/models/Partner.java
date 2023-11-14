package com.grupoprosaudi.projectB.models;

import com.grupoprosaudi.projectB.enums.Approval;
import com.grupoprosaudi.projectB.enums.PartnerType;
import com.grupoprosaudi.projectB.enums.ProfessionalType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_partners")
public class Partner extends AbstarctModel {

    @NotEmpty
    @Column(name = "name", length = 100)
    private String name;

    @Email
    @Column(name = "email", length = 100)
    private String email;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "phone", length = 11)
    private String phone;

    @CNPJ
    @Column(name = "cnpj", length = 14)
    private String cnpj;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "approval")
    private Approval approval;

    @NotNull
    @JoinColumn(name = "address")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @ManyToMany
    @Column(name ="followers")
    private Set<Client> followers;

    @NotNull
    @Column(name="partner_type")
    @Enumerated(EnumType.STRING)
    private PartnerType partnerType;

    @OneToMany(mappedBy = "partner")
    private Set<Publication> publications;
}