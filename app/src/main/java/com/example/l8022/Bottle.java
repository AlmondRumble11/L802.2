package com.example.l8022;

public class Bottle {
    private String name;
    private String manuf;
    private double  totalE;
    private double price;
    private double size;
    public Bottle() {}
    public Bottle(String n, String m, double t, double p, double s){
        name = n;
        manuf = m;
        totalE = t;
        price = p;
        size = s;
    }
    public String getName(){
        return name;
    }
    public String getManufacturer(){
        return manuf;
    }
    public double getEnergy(){
        return totalE;
    }
    public double getPrice() {
        return price;
    }
    public double getSize() {
        return size;
    }
}
