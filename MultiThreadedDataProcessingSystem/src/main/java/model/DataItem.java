package model;

public class DataItem {
    private String data;
    private boolean processed;

    public DataItem(String data) {
        this.data = data;
        this.processed = false;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }
}
