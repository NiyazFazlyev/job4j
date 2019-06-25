package ru.job4j.Professions;

public class Doctor extends Profession {
    private String degree;
    private Nurse nurse;

    public String getDegree() {
        return degree;
    }

    public Nurse getNurse() {
        return nurse;
    }

    public Document writeDocument(Patient patient) {
        return null;
    }
}
