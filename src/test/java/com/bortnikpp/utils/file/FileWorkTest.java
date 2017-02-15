package com.bortnikpp.utils.file;

import com.bortnikpp.resources.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Павел on 15.02.2017.
 */
class FileWorkTest {
    @Test
    void readFile() throws FileNotFoundException {
        FileWork fileWork = new FileWork();
        BufferedReader r = new BufferedReader(new FileReader(new File("tra.txt").getAbsolutePath()));
        assertNotNull(r);
    }

}