package com.company;

public class BankAccountLoader implements Loader{
    @Override
    public void load(String[] arr) {
        CASH_BALANCE = Double.parseDouble(arr[0]);
    }

    @Override
    public String getLine() {
        if (!got) {
            got = true;
            String curLine = String.format("%.4f",CASH_BALANCE);
            return curLine;
        }else {return null;}
    }

    public double getCASH_BALANCE() {
        return CASH_BALANCE;
    }

    public void setCASH_BALANCE(double CASH_BALANCE) {
        this.CASH_BALANCE = CASH_BALANCE;
    }

    private double CASH_BALANCE=10_000;
    private boolean got = false;//see if getLine already get the data
}
