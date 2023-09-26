package org.example.model;

import com.google.gson.annotations.SerializedName;
import org.example.enums.StudyProfile;

public class University {
    @SerializedName("universityId")
    String id;
    @SerializedName("universityFullName")
    String fullName;
    @SerializedName("universityShortName")
    String shortName;
    @SerializedName("YoF")
    int yearOfFoundation;
    @SerializedName("mainProfile")
    StudyProfile mainProfile;

    public University() {
    }

    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return String.format("id = %s, fullName = %s, shortName = %s, yearOfFoundation = %s, mainProfile = %s",
                this.id,
                this.fullName,
                this.shortName,
                this.yearOfFoundation,
                this.mainProfile.getProfileName());
    }
}