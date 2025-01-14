package utils;


import model.DataItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {

    public static List<DataItem> readDataFromFile(String fileName) {
        List<DataItem> dataItems = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine())!=null){
                dataItems.add(new DataItem(line)); // Assuming each line is a DataItem
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return dataItems;
    }

    public static void writeDataToFile(String fileName, List<DataItem> dataItems){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (DataItem item: dataItems){
                writer.write(item.getData() + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
