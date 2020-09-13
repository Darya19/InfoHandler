package com.epam.task2.reader;

import com.epam.task2.exeption.ProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReader {

    private static final String DEFAULT_FILE = "data\\defaultFile.txt";

    private static Logger logger = LogManager.getLogger();

    public String readFromFile(String file) throws ProjectException {
        StringBuilder builder = new StringBuilder();
        String line;
        Path path = Paths.get(file);
        if (Files.notExists(path)) {
            path = Paths.get(DEFAULT_FILE);
            logger.log(Level.INFO, "file wasn't found, was used default file");
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            logger.log(Level.INFO, "file was read");
            return builder.toString();
        } catch (IOException e) {
            throw new ProjectException("reading issues", e);
        }
    }
}
