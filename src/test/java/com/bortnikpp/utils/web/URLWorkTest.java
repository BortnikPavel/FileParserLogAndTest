package com.bortnikpp.utils.web;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Павел on 15.02.2017.
 */
class URLWorkTest {
    URLWork urlWork = new URLWork();
    byte[] getArr = {1,2,3,4,5,6,7,8,9,10};
    byte[] arr = new byte[10];
    BufferedReader bis = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(getArr)));
    BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(new ByteArrayOutputStream()));

    @Test
    void readURL(){
        urlWork.readURL("https://gist.githubusercontent.com/romanlex/bbe28fdba5e7f4ed740b1b3671b0a37e/raw/e00cc87b653f24619d48126119a295c900186ac5/file5.txt");
        urlWork.readURL(null);
        urlWork.readURL("https://vk.com/p.bortnik");
    }

    @Test
    void copy() {
        urlWork.copy(bis, bos);
    }

}