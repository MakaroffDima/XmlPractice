package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PROGRAMMER("Программист"),
    DRIVER("Водитель"),
    TEACHER("Учитель");
    private final String profileName;


    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}