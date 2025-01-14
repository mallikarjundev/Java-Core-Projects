package service;

import model.DataItem;

import java.util.List;

public class DataProcessingService {
    public void processData(List<DataItem> dataItems){
        for (DataItem item: dataItems){
            item.setProcessed(true);
            System.out.println("Processing data: "+item.getData());
        }
    }
}
