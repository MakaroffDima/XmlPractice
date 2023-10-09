package org.example.excel;


import org.example.model.FullInformation;
import org.example.utils.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriteOperation {

    private static final Logger logger = Logger.getLogger(JsonWriteOperation.class.getName());

    private JsonWriteOperation() {
    }

    public static void writeJsonReq(FullInformation fullInformation) {

        logger.log(Level.INFO, "JSON writing operation started");

        try {
            Files.createDirectory(Paths.get("src/main/resources/jsonReqs"));
            logger.log(Level.INFO, "Directory created successfully");
        } catch (IOException ioEx) {
            logger.log(Level.FINE, "Directory already exist", ioEx);
        }

        writeStudents(fullInformation);
        writeUniversities(fullInformation);
        writeStatisticsList(fullInformation);

        logger.log(Level.INFO, "JSON writing operation finished successfully");
    }

    private static void writeStudents(FullInformation fullInformation) {
        String studentsJson = JsonUtil.writeListToJson(fullInformation.getStudentList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("src/main/resources/jsonReqs/students" + fullInformation.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Students JSON writing operation failed", e);
        }
    }

    private static void writeUniversities(FullInformation fullInformation) {
        String universitiesJson = JsonUtil.writeListToJson(fullInformation.getUniversityList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("src/main/resources/jsonReqs/universities" + fullInformation.getProcessDate().getTime() + ".json");
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Universities JSON writing operation failed", e);
        }
    }

    private static void writeStatisticsList(FullInformation fullInformation) {
        String studentsJson = JsonUtil.writeListToJson(fullInformation.getStatisticsList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("src/main/resources/jsonReqs/statistics" + fullInformation.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Statistics JSON writing operation failed", e);
        }
    }
}