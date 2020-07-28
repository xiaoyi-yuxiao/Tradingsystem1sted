package com.company;

import java.io.*;

public class SuperDataIO implements DataProcessor {
    public SuperDataIO(String path) {
        this.path = path;
    }

    private String path;

    @Override
    public boolean readData(String filename, Loader loader) {
        try (FileReader reader = new FileReader(path + filename);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\\s+");
                loader.load(arr);//this can be customizable, loader is just a buffer
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void writeData(String filename, Loader loader) throws IOException {
        File file = new File(path+filename);
        if (!file.exists()){file.createNewFile();}
        PrintStream printStream = new PrintStream(new FileOutputStream(path+filename));
        while (true) {
            String s = loader.getLine();
            if (s != null) {
                printStream.println(s);
            } else {
                break;
            }
        }
        printStream.close();
    }

    @Override
    public void recordHistory(String filename, String record) throws IOException {
        File file = new File(path+filename);
        if (!file.exists()){file.createNewFile();}
        PrintStream printStream = new PrintStream(new FileOutputStream(path+filename,true));
        printStream.println(record);
    }
}
