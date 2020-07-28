package com.company;

import java.io.IOException;

public class BankAccount extends Account{
    public BankAccount(DataProcessor processor) {
        super(processor);
    }

    public void close(DataProcessor processor) throws IOException {
        processor.writeData(FilePathInfo.bankAccount, loader);
    }

    public boolean isSufficient(Stock stock, double shares){
        return stock.getPrice()*shares<loader.getCASH_BALANCE();
    }
    public void withdraw(double amount){loader.setCASH_BALANCE(loader.getCASH_BALANCE()-amount);}
    public void deposit(double amount){loader.setCASH_BALANCE(loader.getCASH_BALANCE()+amount);}
    public double getBalance(){return loader.getCASH_BALANCE();}
}
