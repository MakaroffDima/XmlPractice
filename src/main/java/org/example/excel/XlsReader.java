package org.example.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Student;
import org.example.model.University;
import org.example.enums.StudyProfile;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsReader {

    private static final Logger logger = Logger.getLogger(XlsReader.class.getName());

    private XlsReader() {
    }


    public static List<Student> readFileStudent(String filepath) throws IOException { //Метод для чтения данных по студентам
        List<Student> students = new ArrayList<>();

        try {

            logger.log(Level.INFO, "Excel file reading started");

            FileInputStream inputStream = new FileInputStream("src/main/resources/universityInfo.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Студенты");

            Iterator<Row> rows = sheet.iterator();
            rows.next();
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Student student = new Student();
                students.add(student);
                student.setUniversityId(currentRow.getCell(0).getStringCellValue());
                student.setFullName(currentRow.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Excel file reading failed", e);
            return students;
        }

        logger.log(Level.FINE, "Excel file reading finished successfully");
        return students;

    }


    public static List<University> readFileUniversity(String filepath) throws IOException { //Метод для чтения данных по университетам
        List<University> universities = new ArrayList<>();

        try {

            logger.log(Level.INFO, "Excel file reading started");

            FileInputStream inputStream = new FileInputStream("src/main/resources/universityInfo.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Университеты");

            Iterator<Row> rows = sheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                University university = new University();
                universities.add(university);
                university.setId(currentRow.getCell(0).getStringCellValue());
                university.setFullName(currentRow.getCell(1).getStringCellValue());
                university.setShortName(currentRow.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(
                        StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Excel file reading failed", e);
            return universities;
        }

        logger.log(Level.FINE, "Excel file reading finished successfully");
        return universities;
    }


}


