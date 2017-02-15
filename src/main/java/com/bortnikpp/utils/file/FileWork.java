package com.bortnikpp.utils.file;

import com.bortnikpp.models.ThreadModel;
import com.bortnikpp.resources.ArgumentValidator;
import com.bortnikpp.resources.Parser;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Класс служит для работы с файлами
 * @author Bortnik Pavel
 * @version 1.0
 */
public class FileWork {
    private static Logger logger = Logger.getLogger(FileWork.class);

    /**
     * Метод для чтения из файла
     * @param fileName - имя файла
     */
    public void readFile(String fileName) {
        String stringRead;
        Parser parser = new Parser();
        if (ArgumentValidator.isValidFileName(fileName)) {
            try {
                File file = new File(fileName);
                try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
                    while ((stringRead = in.readLine()) != null && ThreadModel.flag) {
                        parser.parseLine(stringRead);
                    }
                }
            } catch (IOException e) {
                logger.error("File " + ThreadModel.currentThread() + " contains invalid characters!");
                System.err.println(fileName + "   " + e.getMessage());
            }
        }
    }
}
