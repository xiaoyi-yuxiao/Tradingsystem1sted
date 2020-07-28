package com.company;

import java.util.ArrayList;

public class PortfolioLoader implements Loader{
    public ArrayList<Stock> getStocks() {
        return stocks;
    }
    @Override
    public void load(String[] arr) {
        Stock stock = new Stock(arr[0], Double.parseDouble(arr[1]));
        stock.changeShare(Double.parseDouble(arr[2]));
        stocks.add(stock);
    }

    @Override
    public String getLine() {
        try {
            String curLine = stocks.get(curData).getName()+" "+ stocks.get(curData).getPrice()+" "+stocks.get(curData).getShare();
            curData++;
            return curLine;
        }catch (IndexOutOfBoundsException ido){
            return null;
        }
    }

    private ArrayList<Stock> stocks=new ArrayList<Stock>();
    private int curData = 0;
}
