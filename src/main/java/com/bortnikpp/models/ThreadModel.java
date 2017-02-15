package com.bortnikpp.models;

import com.bortnikpp.resources.ArgumentValidator;
import com.bortnikpp.utils.file.FileWork;
import com.bortnikpp.utils.web.URLWork;
import org.apache.log4j.Logger;

/**
 * Класс служит для задания поведения потока
 * @author Bortnik Pavel
 * @version 1.0
 */
public class ThreadModel extends Thread {
    private static Logger logger = Logger.getLogger(ThreadModel.class);
    /**Флаг для завершения потока*/
    public static boolean flag = true;
    /**Имя файла или URL*/
    public String resourceName;

    /**
     * Создает новый объект с заданным именем ресурса
     * @param fileName
     */
    public ThreadModel(String fileName){
        super(fileName);
        this.resourceName = fileName;
    }

    /**
     * Метод проверяет валидность ресурса и запускает обработку
     */
    @Override
    public void run() {
        logger.trace("Thread " + this.getName() + " started to work");
        if(ArgumentValidator.isValidFileName(resourceName)&&ThreadModel.flag){
            FileWork fileWork = new FileWork();
            fileWork.readFile(resourceName);
        }else if(ArgumentValidator.isValidURL(resourceName)&&ThreadModel.flag) {
            URLWork work = new URLWork();
            FileWork fileWork = new FileWork();
            fileWork.readFile(work.readURL(resourceName));
        }else {
            flag = false;
        }
    }
}
