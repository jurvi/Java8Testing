package com.jjarvela;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jjarvela on 09/01/17.
 */
public class ReadFileToStringTest {

    @Test
    public void fileReadAndWriteTest() throws IOException, URISyntaxException {
        // Set charset and get Path to a file under classpath (resources folder)
        Charset charset = Charset.forName("UTF-8");
        Path testFilePath = Paths.get(ClassLoader.getSystemResource("filetostring.txt").toURI());
        String testMessage = "test hello";

        // Write data to path
        Files.write(testFilePath, testMessage.getBytes(charset));

        // Read data from path
        String content = new String(Files.readAllBytes(testFilePath), charset);

        // Asserts
        assertNotNull(content);
        assertTrue(content.contains(testMessage));
    }

}
