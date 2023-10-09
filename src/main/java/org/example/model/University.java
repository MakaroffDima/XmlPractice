package org.example.model;

import com.google.gson.annotations.SerializedName;
import org.example.enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class University {
    @SerializedName("universityId")
    @XmlElement(name = "universityId")
    String id;
    @SerializedName("universityFullName")
    @XmlElement(name = "universityName")
    String fullName;
    @SerializedName("universityShortName")
    @XmlElement(name = "shortName")
    String shortName;
    @SerializedName("YoF")
    @XmlElement(name = "YoF")
    int yearOfFoundation;
    @SerializedName("mainProfile")
    @XmlElement(name = "universityProfile")
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
