package controller;

import model.DataItem;
import service.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

public class DataController {
    private DataProcessingService dataProcessingService;

    public DataController() {
        this.dataProcessingService = new DataProcessingService();
    }

    public void processData() {
        // Sample data to process
        List<DataItem> dataItems = new ArrayList<>();
        dataItems.add(new DataItem("Data 1"));
        dataItems.add(new DataItem("Data 2"));
        dataItems.add(new DataItem("Data 3"));

        // Call the service to process data
        dataProcessingService.processData(dataItems);
    }
}
