package com.bortnikpp.resources;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Павел on 13.02.2017.
 */
class ArgumentValidatorTest {
    @Test
    void isValidURL() {
        assertTrue(ArgumentValidator.isValidURL("https://vk.com/p.bortnik"));
        assertFalse(ArgumentValidator.isValidURL(null));
        assertTrue(ArgumentValidator.isValidURL("https://gist.githubusercontent.com/romanlex/5e0359bc9fc78860c34ca2d68389a588/raw/3322cf68caf5e7caaa7a95327032db03fbd41281/file6.txt"));
        assertFalse(ArgumentValidator.isValidURL("pasha.txt"));
        assertFalse(ArgumentValidator.isValidURL("pasha.html"));

    }

    @Test
    void isValidFileName() {
        assertTrue(ArgumentValidator.isValidFileName("E:\\tra.txt"));
        assertFalse(ArgumentValidator.isValidFileName("pom.xml"));
        assertFalse(ArgumentValidator.isValidFileName("tra1.txt"));
        assertFalse(ArgumentValidator.isValidFileName(null));
    }



}