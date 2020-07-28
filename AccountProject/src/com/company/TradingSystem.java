package com.company;

import java.io.IOException;
//Trading system responsible for trading money and stocks
public class TradingSystem {
    public TradingSystem(DataProcessor processor) {
        this.processor = processor;
        stockSystem = new StockSystem(this.processor);
        this.recorder = new HistoryRecorder(this.processor);
        stockAccount = new StockAccount(this.processor);
        bankAccount = new BankAccount(this.processor);
    }
    //use processor interface
    private final DataProcessor processor;
    private final StockSystem stockSystem;
    private final StockAccount stockAccount;
    private final BankAccount bankAccount;
    private final HistoryRecorder recorder;

    public void start() throws IOException {
        longForStock("AMZN",3);
    }

    public void longForStock(String stockName, double shares) throws IOException {
        Stock stock = stockSystem.getAStock(stockName);
        if (stock!=null&&bankAccount.isSufficient(stock,shares)) {
            stockAccount.changePortfolio(stock, shares);
            bankAccount.withdraw(stock.getPrice()*shares);
            recorder.bankRecord("withdraw",stock.getPrice()*shares,bankAccount.getBalance());
            recorder.stockRecord(stock,shares,"buy");
        }
    }

    public void showStocks(){
        stockSystem.printAllStocks();
    }

    public void end() throws IOException {
        stockAccount.close(processor);
        bankAccount.close(processor);
    }
}
