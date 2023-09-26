package org.example.enums;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PROGRAMMER("Программиование"),

    PHYSICS("Физика"),
    LINGUISTICS("Лингвистика"),
    TEACHER("Педагог"),
    MATHEMATICS("Математика");
    private final String profileName;


    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}