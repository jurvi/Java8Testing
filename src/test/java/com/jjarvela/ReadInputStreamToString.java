package com.jjarvela;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by jjarvela on 09/01/17.
 */
public class ReadInputStreamToString {

    @Test
    public void readInputStreamToString() throws URISyntaxException, IOException {
        // Set charset and get Path to a file under classpath (resources folder)
        Charset charset = Charset.forName("UTF-8");
        Path testFilePath = Paths.get(ClassLoader.getSystemResource("inputstreamtostring.txt").toURI());

        // Create InputStream from file and read it's contents to String
        InputStream inputStream = new ByteArrayInputStream(Files.readAllBytes(testFilePath));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String result = bufferedReader.lines().collect(Collectors.joining("\n"));

        // Asserts
        assertNotNull(result);
        assertEquals("inputstreamtostring", result);
    }
}
