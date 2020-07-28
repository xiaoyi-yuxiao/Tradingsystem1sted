package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        //initiate fileIO system, initiated with the working path
        var sdi = new SuperDataIO(FilePathInfo.path);
        //initiate trading system
        var tradingSys = new TradingSystem(sdi);
        tradingSys.start();
        tradingSys.end();
    }
}
