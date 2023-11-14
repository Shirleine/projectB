package com.grupoprosaudi.projectB.models;

import jakarta.persistence.*;
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
@Entity(name = "tb_comments")
public class Comment extends AbstarctModel {

    @OneToOne
    @JoinColumn(name = "author_social_media_professional")
    private SocialMediaProfessional authorSocialMediaProfessional;

    @OneToOne
    @JoinColumn(name = "author_partner")
    private Partner authorPartner;

    @OneToOne
    @JoinColumn(name = "author_client")
    private Client authorClient;

    @NotEmpty
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @NotNull
    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "publication_id")
    private Publication publication;
}
