package com.grupoprosaudi.projectB.enums;

public enum SurgeryType {
        GENERAL_SURGERY("General Surgery"),
        CARDIAC_SURGERY("Cardiac Surgery"),
        ORTHOPEDIC_SURGERY("Orthopedic Surgery"),
        NEUROSURGERY("Neurosurgery"),
        PLASTIC_SURGERY("Plastic Surgery"),
        OPHTHALMIC_SURGERY("Ophthalmic Surgery"),
        DENTAL_SURGERY("Dental Surgery");

        private final String displayName;

        SurgeryType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
}
