package org.example;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Dmitry Makarov","123",3,88);
        University university = new University("123","Университет им.Лобачевского","ННГУ",1995,StudyProfile.MEDICINE);
        System.out.println(student);
        System.out.println(university);
    }
}