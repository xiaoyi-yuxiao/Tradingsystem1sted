package com.company;

import java.util.Iterator;

public class StockSystem {
    private DataProcessor processor;//here the processor only responsible for acquiring files.
    private MarketPriceLoader MPLoader = new MarketPriceLoader();

    public StockSystem(DataProcessor processor) {
        this.processor = processor;
        this.processor.readData(FilePathInfo.marketFile, MPLoader);
    }

    public void dispPrice(String stockName){
        Stock target = getAStock(stockName);
        if(target!=null){
            System.out.println(target.getPrice());
        }
    }

    public Stock getAStock(String stockName){
        Iterator<Stock> s = MPLoader.getStocks().iterator();
        while (s.hasNext()){
            Stock tmp = s.next();
            if (stockName.equals(tmp.getName())){
                Stock stock = new Stock(tmp.getName(),tmp.getPrice());
                return stock;
            }
        }
        return null;
    }

    public void printAllStocks(){
        Iterator<Stock> s = MPLoader.getStocks().iterator();
        while (s.hasNext())
            System.out.println(s.next());
    }
}
