package service;

import model.DataItem;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataProcessingService {
    private final ExecutorService executorService;

    public DataProcessingService() {
        // Create a thread pool with 4 threads
        this.executorService = Executors.newFixedThreadPool(4);
    }

    public void processData(List<DataItem> dataItems){
        for (DataItem item: dataItems){
            // Submit each item to be processed by a separate thread
            executorService.submit(()-> {
                processItem(item);
            });
        }

        // Shutdown the executor service after all tasks are submitted
        executorService.shutdown();
    }

    private void processItem(DataItem item){
        // Simulate data processing (could be enhanced with real processing logic)
        item.setProcessed(true);
        System.out.println("Processing data: "+item.getData() + " by thread: " + Thread.currentThread().getName());
    }
}
