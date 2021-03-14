package com.example.bottledispernser;

public class Bottle {
    private final String name;
    private final String manufacturer;
    private final double total_energy;
    private final double price;
    private final double size;
    private final int number;

    public Bottle(String name, String manuf, double totE, double price, double size, int number) {
        this.name = name;
        this.manufacturer = manuf;
        this.total_energy = totE;
        this.price = price;
        this.size = size;
        this.number = number;
    }
    public String getName(){return name;}
    public String getManufacturer(){return manufacturer;}
    public double getEnergy(){return total_energy;}
    public double getPrice(){return price;}
    public double getSize(){return size;}
    public int getNumber(){return number;}
}
