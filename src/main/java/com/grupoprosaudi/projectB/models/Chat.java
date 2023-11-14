package com.grupoprosaudi.projectB.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_chats")
public class Chat extends AbstarctModel{

    @OneToOne
    @JoinColumn(name = "social_media_professional")
    private SocialMediaProfessional socialMediaProfessional;

    @OneToOne
    @JoinColumn(name = "partner")
    private Partner partner;

    @OneToOne
    @JoinColumn(name = "client")
    private Client client;

    @OneToOne
    @JoinColumn(name = "administrator")
    private Administrator administrator;

    @NotNull
    @Column(name="date")
    private LocalDate date;

    @OneToMany(mappedBy = "chat")
    private List<Message> messages;
}