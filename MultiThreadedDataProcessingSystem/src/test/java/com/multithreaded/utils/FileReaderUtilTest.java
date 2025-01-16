package com.multithreaded.utils;

import model.DataItem;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import utils.FileReaderUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

public class FileReaderUtilTest {

    @Test
    public void testReadDataFromFile() throws Exception{

        // Arrange
        // Simulate the file content
        List<String> mockLines = Arrays.asList("Data 1", "Data 2");
        try(MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {
            mockedFiles.when(() -> Files.readAllLines(Paths.get("testInput.rtf"))).thenReturn(mockLines);

            // Act
            // Call the method being tested
            List<DataItem> dataItems = FileReaderUtil.readDataFromFile("testInput.rtf");

            // Assert
            // Verify the output is as expected
            assertEquals(2, dataItems.size());
            assertEquals("Data 1",dataItems.get(0).getData());
            assertEquals("Data 2",dataItems.get(1).getData());
        }
    }
}
