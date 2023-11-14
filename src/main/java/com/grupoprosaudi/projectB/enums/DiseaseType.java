package com.grupoprosaudi.projectB.enums;

public enum DiseaseType {
        INFECTIOUS("Infectious Disease"),
        CHRONIC("Chronic Disease"),
        GENETIC("Genetic Disease"),
        AUTOIMMUNE("Autoimmune Disease"),
        CARDIOVASCULAR("Cardiovascular Disease"),
        RESPIRATORY("Respiratory Disease"),
        NEUROLOGICAL("Neurological Disease"),
        MENTAL_HEALTH("Mental Health Disorder"),
        CANCER("Cancer"),
        GASTROINTESTINAL("Gastrointestinal Disease");

        private final String name;

        DiseaseType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
}
