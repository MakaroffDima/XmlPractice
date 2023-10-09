package org.example.excel;

import org.example.model.FullInformation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriteOperation {

    private static final Logger logger = Logger.getLogger(XmlWriteOperation.class.getName());

    private XmlWriteOperation() {
    }

    public static void generateXmlReq(FullInformation fullInformation) {

        try {
            logger.log(Level.INFO, "XML marshalling is started");

            JAXBContext jaxbContext = JAXBContext.newInstance(FullInformation.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectory(Paths.get("src/main/resources/xmlReqs"));
                logger.log(Level.INFO, "Directory created successfully");
            } catch (IOException ioEx) {
                logger.log(Level.FINE, "Directory already created", ioEx);
            }
            File requestFile = new File("src/main/resources/xmlReqs/infoReq" + new Date().getTime() + ".xml");

            marshaller.marshal(fullInformation, requestFile);
        } catch (JAXBException jaxbEx) {
            logger.log(Level.SEVERE, "XML marshalling  is failed", jaxbEx);
            return;
        }

        logger.log(Level.INFO, "XML marshalling is finished successfully");
    }
}
