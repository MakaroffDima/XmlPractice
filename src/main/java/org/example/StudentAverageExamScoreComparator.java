package org.example;

public class StudentAverageExamScoreComparator implements StudentComparator {

    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());
    }
}
