package com.company;

import java.util.ArrayList;

public class MarketPriceLoader implements Loader {

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    @Override
    public void load(String[] arr){
        Stock stock = new Stock(arr[0], Double.parseDouble(arr[1]));
        stocks.add(stock);
    }

    @Override
    public String getLine() {
        return null;
    }

    private ArrayList<Stock> stocks=new ArrayList<Stock>();
}
