package com.grupoprosaudi.projectB.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_communities")
public class Community extends AbstarctModel {

    @NotEmpty
    @Column(name = "name", length = 100)
    private String name;

    @ManyToMany
    @Column(name = "administrators_social_media_professionals")
    private Set<SocialMediaProfessional> administratorsSocialMediaProfessionals;

    @ManyToMany
    @Column(name = "administrators_partners")
    private Set<Partner> administratorsPartners;

    @ManyToMany
    @Column(name = "members")
    private Set<Client> members;

    @OneToMany(mappedBy = "community")
    private Set<Publication> publications;
}
