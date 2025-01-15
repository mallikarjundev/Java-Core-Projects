package com.multithreaded;

import model.DataItem;
import org.junit.jupiter.api.Test;
import utils.FileReaderUtil;

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileReaderUtilTest {
    private static final String TEST_INPUT_FILE="testInput.rtf";
    private static final String TEST_OUTPUT_FILE="testOutput.rtf";

    @Test
    public void testReadDataFromFile() throws Exception{
        // Arrange
        try(FileWriter writer = new FileWriter(TEST_INPUT_FILE)) {
            writer.write("Data 1\nData 2");
        }


        // Act
        List<DataItem> dataItems = FileReaderUtil.readDataFromFile(TEST_INPUT_FILE);

        // Assert
        assertEquals("Data 1", dataItems.get(0).getData());
        assertEquals("Data 2", dataItems.get(1).getData());
    }

    @Test
    public void testWriteDataToFile() throws Exception{
        // Arrange
        List<DataItem> dataItems = Arrays.asList(new DataItem("Data 1"), new DataItem("Data 2"));

        // Act
        FileReaderUtil.writeDataToFile(TEST_OUTPUT_FILE, dataItems);


        // Assert
        List<String> lines = Files.readAllLines(Paths.get(TEST_OUTPUT_FILE), StandardCharsets.UTF_8);
        String content = String.join(System.lineSeparator(), lines);
        assertTrue(content.contains("Data 1"));
        assertTrue(content.contains("Data 2"));
    }
}
