package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PROGRAMMER("Программист"),
    DRIVER("Водитель"),
    TEACHER("Учитель");
    String profileName;


    public String getProfileName() {
        return profileName;
    }

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    @Override
    public String toString() {
        return "StudyProfile{" +
                "profileName='" + profileName + '\'' +
                '}';
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}
