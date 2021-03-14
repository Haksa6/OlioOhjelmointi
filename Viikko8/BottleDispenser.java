package com.example.bottledispernser;

import android.content.Context;
import android.widget.TextView;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class BottleDispenser {
    private static BottleDispenser single_instance = null;
    private int bottles;
    private final ArrayList<Bottle> bottleArray;
    private float money;


    public static BottleDispenser getInstance() {
        if (single_instance == null) {
            single_instance = new BottleDispenser();
        }
        return single_instance;
    }

    private BottleDispenser() {
        bottles = 5;
        money = 0;

        bottleArray = new ArrayList<Bottle>(bottles);
        bottleArray.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 1.8, 0.5, 1));
        bottleArray.add(new Bottle("Pepsi Max", "Pepsi", 0.3, 2.2, 1.5, 1));
        bottleArray.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 2.0, 0.5, 1));
        bottleArray.add(new Bottle("Coca-Cola Zero", "Coca-Cola", 0.3, 2.5, 1.5, 1));
        bottleArray.add(new Bottle("Fanta Zero", "Coca-Cola", 0.3, 1.95, 0.5, 2));
    }

    public void addMoney(TextView text, int i) {
        money += i;
        String s = "Klink! Added more money: " + money;
        text.setText(s);
    }
    public void returnMoney(TextView text) {
        String s = "Klink Klink. Money came out! You got " + money + " € back.";
        text.setText(s);
        money = 0;
    }

    public void buyBottle(TextView text, int i, Context c) {

        if (bottleArray.get(i).getNumber() == 0) {
            String s = "No more bottles!";
            text.setText(s);
        } else {
            Bottle bottle = bottleArray.get(i);
            if (money < bottle.getPrice()) {
                String s = "Add money first!";
                text.setText(s);
            } else {
                bottles -= 1;
                money -= bottle.getPrice();
                int number = bottle.getNumber();
                number--;
                bottleArray.set(i, new Bottle(bottle.getName(),bottle.getManufacturer(),bottle.getEnergy(),bottle.getPrice(),bottle.getSize(), number));
                String s = "KACHUNK! " + bottle.getName() + " came out of the dispenser!";
                text.setText(s);
                try {
                    String kuitti = "Receipt! " + bottle.getName() + " " + bottle.getPrice() + " €";
                    OutputStreamWriter ows = new OutputStreamWriter(c.openFileOutput("Kuitti.txt", Context.MODE_PRIVATE));
                    ows.write(kuitti);
                    ows.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public ArrayList<String> listBottles() {
        ArrayList<String> arraySpinner = new ArrayList<String> ();
        for (int i = 0; i < bottles; i++) {
            Bottle b = bottleArray.get(i);
            String nimi = b.getName();
            double koko = b.getSize();
            String kokos = String.valueOf(koko);
            arraySpinner.add(nimi + ", Size: " + kokos);
        }

        return arraySpinner;
    }

}

