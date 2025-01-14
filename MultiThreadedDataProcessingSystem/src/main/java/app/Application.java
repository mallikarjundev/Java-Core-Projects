package app;

import controller.DataController;

public class Application {
    public static void main(String[] args) {
        // Initialize the controller and start the data processing
        DataController controller = new DataController();
        controller.processData();
    }
}
