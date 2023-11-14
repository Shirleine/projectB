package com.grupoprosaudi.projectB.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tb_publicationS")
public class Publication extends AbstarctModel{

    @NotEmpty
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToOne
    @JoinColumn(name = "author_social_media_professional")
    private SocialMediaProfessional authorSocialMediaProfessional;

    @OneToOne
    @JoinColumn(name = "author_partner")
    private Partner authorPartner;

    @Column(name = "files")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> files;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @OneToMany
    private Set<Client> likes;

    @OneToMany(mappedBy = "publication")
    private Set<Comment> comments;

    @NotNull
    @Column(name = "approval")
    private Boolean approval;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    @ManyToOne
    @JoinColumn(name = "social_media_professional_id")
    private SocialMediaProfessional socialMediaProfessional;

    @ManyToOne
    @JoinColumn(name = "partner")
    private Partner partner;
}