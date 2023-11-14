package com.grupoprosaudi.projectB.models;

import com.grupoprosaudi.projectB.enums.FileType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_files")
public class File extends AbstarctModel {

    @NotEmpty
    @Column(name = "name",length = 25)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column (name = "file_type")
    private FileType fileType;
}