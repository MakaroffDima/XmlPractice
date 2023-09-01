package org.example;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XlsReader {


    public void openBook() { //Метод для чтения данных по студентам
        try {
            File file = new File("src/main/resources/universityInfo.xlsx");
            var book = (XSSFWorkbook) WorkbookFactory.create(file);
            InputStream is = new FileInputStream(file);
            book = (XSSFWorkbook) WorkbookFactory.create(is);
            var stud = book.getSheet("Студенты");
            Iterator<Row> ri = stud.rowIterator();
            ri.next();

            while (ri.hasNext()) {
                XSSFRow row = (XSSFRow) ri.next();
                String id = row.getCell(0).getStringCellValue();
                String fio = row.getCell(1).getStringCellValue();
                Double course = row.getCell(2).getNumericCellValue();
                Double average = row.getCell(3).getNumericCellValue();
                List<String> students = new ArrayList<>();
                students.add(id);
                students.add(fio);
                students.add(String.valueOf(course));
                students.add(String.valueOf(average));
                System.out.println(students);


            }
            is.close();
        } catch (EncryptedDocumentException | IOException e1) {
            e1.printStackTrace();
        }
    }

    public void openBook2() { // метод для чтения данных по университетам
        try {
            File file = new File("src/main/resources/universityInfo.xlsx");
            var book = (XSSFWorkbook) WorkbookFactory.create(file);
            InputStream is = new FileInputStream(file);
            book = (XSSFWorkbook) WorkbookFactory.create(is);
            var stud = book.getSheet("Университеты");
            Iterator<Row> ri = stud.rowIterator();
            ri.next();

            while (ri.hasNext()) {
                XSSFRow row = (XSSFRow) ri.next();
                String id = row.getCell(0).getStringCellValue();
                String fullName = row.getCell(1).getStringCellValue();
                String abbreviation = row.getCell(2).getStringCellValue();
                Double yearOfFoundation = row.getCell(3).getNumericCellValue();
                String trainingProfile = row.getCell(4).getStringCellValue();
                List<String> universities = new ArrayList<>();
                universities.add(id);
                universities.add(fullName);
                universities.add(abbreviation);
                universities.add(String.valueOf(yearOfFoundation));
                universities.add(trainingProfile);
                System.out.println(universities);


            }
            is.close();
        } catch (EncryptedDocumentException | IOException e1) {
            e1.printStackTrace();
        }
    }

}
