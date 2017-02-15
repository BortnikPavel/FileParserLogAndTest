package com.bortnikpp.resources;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Павел on 15.02.2017.
 */
class ParserTest {
    @Test
    void parseLine() throws IOException {
        Map<String, Integer> consoleMock = new HashMap<>();

        Parser testedParser = new Parser(){
            @Override
            protected void printWordAndCount(String word, int count) {
                consoleMock.put(word, count);
            }
        };

        String words = "ыврпыалопв ыыы нггпг агага ыыы";
        testedParser.parseLine(words);

        int expectedCountOfAAA = 2;

        int actualCountOfAAA = consoleMock.get("ыыы");

        assertEquals(expectedCountOfAAA, actualCountOfAAA);


    }

}