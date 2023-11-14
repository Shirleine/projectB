package com.grupoprosaudi.projectB.models;

import com.grupoprosaudi.projectB.enums.ProfessionalType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_social_media_professionals")
public class SocialMediaProfessional extends Person {

      @NotEmpty
      @Column(name = "records", length = 8)
      private String record;

      @Column(name ="followers")
      @ManyToMany
      private Set<Client> followers;

      @NotNull
      @Column(name="professional_type")
      @Enumerated(EnumType.STRING)
      private ProfessionalType professionalType;

      @OneToMany(mappedBy = "socialMediaProfessional")
      private Set<Publication> publications;
}
