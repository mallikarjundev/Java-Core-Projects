package com.multithreaded.utils;

import model.DataItem;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import utils.FileReaderUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileWriterUtilTest {

    @Test
    public void testWriteDataToFile() throws Exception {
        // Arrange: Create a list of data items to be written to file
        List<DataItem> dataItems = Arrays.asList(new DataItem("Data 1"), new DataItem("Data 2"));

        // Mock the BufferedWriter class
        BufferedWriter mockedBufferedWriter = Mockito.mock(BufferedWriter.class);

        // Mock the FileWriter constructor to return the mocked BufferedWriter instance
        try (MockedStatic<FileWriter> mockedFileWriter = Mockito.mockStatic(FileWriter.class)) {
            mockedFileWriter.when(() -> new FileWriter(Mockito.anyString())).thenReturn(new FileWriterMock(mockedBufferedWriter));

            // Mock the write and close methods of BufferedWriter
            Mockito.doNothing().when(mockedBufferedWriter).write(Mockito.anyString());
            Mockito.doNothing().when(mockedBufferedWriter).close();

            // Act: Call the method being tested
            FileReaderUtil.writeDataToFile("testOutput.rtf", dataItems);

            // Assert: Verify that the write method was called for each item in the list
            Mockito.verify(mockedBufferedWriter, Mockito.times(dataItems.size()))
                    .write(Mockito.anyString());
        }
    }

    // Custom FileWriterMock class to return mocked BufferedWriter
    private static class FileWriterMock extends FileWriter {
        private final BufferedWriter mockedWriter;

        public FileWriterMock(BufferedWriter mockedWriter) throws IOException {
            super("");
            this.mockedWriter = mockedWriter;
        }

//        @Override
        public BufferedWriter getBufferedWriter() {
            return mockedWriter;
        }
    }
}