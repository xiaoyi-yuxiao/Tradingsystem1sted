package com.company;

import java.io.IOException;

public class HistoryRecorder {
    public HistoryRecorder(DataProcessor processor) {
        this.processor = processor;
    }

    private DataProcessor processor;

    public void stockRecord(Stock stock, double share, String buy_sell) throws IOException {
        String record = buy_sell+" "+share+" shares of "+stock.getName()+" at "+stock.getPrice();
        processor.recordHistory(FilePathInfo.history, record);
    };

    public void bankRecord(String withdraw_deposit,double amount,double balance) throws IOException {
        String record = withdraw_deposit+" $"
                +String.format("%.3f",amount)
                +" remain:$"+String.format("%.3f",balance);
        processor.recordHistory(FilePathInfo.history,record);
    }
}
