package org.example;

public class ComparatorUtil {
    private ComparatorUtil() {
    }
        public static StudentComparator getStudentComparator (StudentComparatorType studentComparatorType){

            switch (studentComparatorType) {
                case UNIVERSITY_ID:
                    return new StudentUniversityIdComparator();
                case FULL_NAME_STUDENT:
                    return new StudentFullNameComparator();
                case COURSE:
                    return new StudentCourseComparator();
                case AVG_EXAM_SCORE:
                    return new StudentAverageExamScoreComparator();
                default:
                    return new StudentFullNameComparator();
            }
        }

        public static UniversityComparator getUniversityComparator (UniversityComparatorType universityComparatorType){

            switch (universityComparatorType) {
                case ID:
                    return new UniversityIdComparator();
                case FULL_NAME_UNIVERSITY:
                    return new UniversityFullNameComparator();
                case SHORT_NAME:
                    return new UniversityShortNameComparator();
                case PROFILE:
                    return new UniversityProfileComparator();
                case YEAR:
                    return new UniversityYofComparator();
                default:
                    return new UniversityFullNameComparator();
            }
        }
    }

