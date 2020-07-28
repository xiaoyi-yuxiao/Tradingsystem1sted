package com.company;

import java.util.Objects;

public class Stock {
    private String name;
    private double price;
    private double share;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
        share = 0;
    }

    public Stock(){
        name = null;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getShare() {
        return share;
    }

    public void changeShare(double share) {
        this.share += share;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", share=" + share +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;
        Stock stock = (Stock) o;
        return Double.compare(stock.price, price) == 0 &&
                name.equals(stock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
