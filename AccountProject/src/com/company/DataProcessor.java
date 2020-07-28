package com.company;

import java.io.IOException;

public interface DataProcessor {
    boolean readData(String filename, Loader loader);//may change in future due to expand to database system
    void writeData(String filename, Loader loader) throws IOException;

    void recordHistory(String filename, String record) throws IOException;
}
