package com.grupoprosaudi.projectB.enums;

public enum ProfessionalType {
    PHYSICIAN("Physician"),
    NURSE("Nurse"),
    DENTIST("Dentist"),
    PHARMACIST("Pharmacist"),
    PSYCHOLOGIST("Psychologist"),
    PHYSIOTHERAPIST("Physiotherapist"),
    NUTRITIONIST("Nutritionist"),
    OPTOMETRIST("Optometrist"),
    PODIATRIST("Podiatrist"),
    RADIOLOGIST("Radiologist");

    private final String name;

    ProfessionalType(String displayName) {
        this.name = displayName;
    }

    public String getDisplayName() {
        return name;
    }
}
