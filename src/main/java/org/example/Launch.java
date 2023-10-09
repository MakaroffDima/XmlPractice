package org.example;

import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;
import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;
import org.example.excel.JsonWriteOperation;
import org.example.excel.XlsReader;
import org.example.excel.XlsWriter;
import org.example.excel.XmlWriteOperation;
import org.example.model.FullInformation;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;
import org.example.utils.ComparatorUtil;
import org.example.utils.StatisticsUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Launch {

    private static final Logger logger = Logger.getLogger(Launch.class.getName());

    public static void main(String[] args) throws IOException {

        try {
            LogManager.getLogManager().readConfiguration(
                    Launch.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(INFO, "Application start, Logger configured");


        List<University> universities =
                XlsReader.readFileUniversity("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.sort(universityComparator);

        List<Student> students =
                XlsReader.readFileStudent("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "src/main/resources/statistics.xlsx");

        FullInformation fullInformation = new FullInformation()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XmlWriteOperation.generateXmlReq(fullInformation);
        JsonWriteOperation.writeJsonReq(fullInformation);


        logger.log(INFO, "Application finished");

    }
}