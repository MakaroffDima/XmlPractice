package org.example;

import java.io.IOException;
import java.util.List;

public class Launch {
    public static void main(String[] args) throws IOException {
        List<University> universities =
                XlsReader.readFileUniversity("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students =
                XlsReader.readFileStudent("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.COURSE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}
