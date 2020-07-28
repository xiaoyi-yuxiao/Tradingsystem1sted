package com.company;

public abstract class Account {
    public static BankAccountLoader loader;
    public Account(DataProcessor processor){
        loader = new BankAccountLoader();
        processor.readData(FilePathInfo.bankAccount, loader);
    }
}
