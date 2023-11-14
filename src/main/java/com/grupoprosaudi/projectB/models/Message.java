package com.grupoprosaudi.projectB.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_messages")
public class Message extends AbstarctModel {

    @OneToOne
    @JoinColumn(name = "sender_client")
    private Client senderClient;

    @OneToOne
    @JoinColumn(name = "sender_partner")
    private Partner senderPartner;

    @OneToOne
    @JoinColumn(name = "sender_social_media_professional")
    private SocialMediaProfessional senderSocialMediaProfessional;

    @OneToOne
    @JoinColumn(name = "sender_administrator")
    private Administrator senderAdministrator;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "files")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> files;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;
}