package app;

import controller.DataController;
import model.DataItem;
import service.DataProcessingService;
import utils.FileReaderUtil;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        // File paths
        String inputFile = "inputData.rtf";
        String outputFile = "outputData.rtf";

        // Read data from file
        List<DataItem> dataItems = FileReaderUtil.readDataFromFile(inputFile);

        // Create service and process data
        DataProcessingService processingService = new DataProcessingService();
        processingService.processData(dataItems);

        // Write data to file
        FileReaderUtil.writeDataToFile(outputFile, dataItems);
    }
}
