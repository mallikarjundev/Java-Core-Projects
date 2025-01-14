package service;

import model.DataItem;

import java.util.List;

public class DataProcessingService {
    public void processData(List<DataItem> dataItems){
        // Sample processing logic (could be multithreaded later)
        for (DataItem item: dataItems){
            item.setProcessed(true); // Simulate processing
            System.out.println("Processing data: "+item.getData());
        }
    }
}
