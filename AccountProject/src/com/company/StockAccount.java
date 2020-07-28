package com.company;

import java.io.IOException;
import java.util.Iterator;

public class StockAccount extends Account{
    private PortfolioLoader portfolioLoader;
    public StockAccount(DataProcessor processor) {
        super(processor);
        portfolioLoader = new PortfolioLoader();
        processor.readData(FilePathInfo.portfolio, portfolioLoader);
    }

    public void changePortfolio(Stock stock, double shares){
        if (!canChange(stock,shares)){
            stock.changeShare(shares);
            portfolioLoader.getStocks().add(stock);
        }
    }

    private boolean canChange(Stock stock, double shares){
        Iterator<Stock> s = portfolioLoader.getStocks().iterator();
        while (s.hasNext()){
            Stock tmp = s.next();
            if (tmp.equals(stock)){
                tmp.changeShare(shares);
                return true;
            }
        }
        return false;
    }

    public void close(DataProcessor processor) throws IOException {
        processor.writeData(FilePathInfo.portfolio, portfolioLoader);
    }
}
