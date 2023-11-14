package com.grupoprosaudi.projectB.enums;

public enum TreatmentType {
        ODONTOLOGICAL("Odontological Treatment"),
        MEDICAL("Medical Treatment"),
        AESTHETIC("Aesthetic Treatment"),
        NUTRITIONAL("Nutritional Treatment");

        private final String name;

        TreatmentType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
}
