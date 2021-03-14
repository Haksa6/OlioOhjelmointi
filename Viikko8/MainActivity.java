package com.example.bottledispernser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView text;
    SeekBar slider;
    TextView text2;
    Spinner menu;
    ArrayAdapter<String> adapt;
    Context context = null;
    BottleDispenser bottle = BottleDispenser.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        slider = (SeekBar) findViewById(R.id.seekBar);
        text2 = (TextView) findViewById(R.id.textView2);
        menu = (Spinner) findViewById(R.id.spinner);
        context = MainActivity.this;
        ArrayList<String> arraySpinner = bottle.listBottles();
        adapt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menu.setAdapter(adapt);
    }

    public void lisaaRaha(View v) {
        int i = slider.getProgress();
        bottle.addMoney(text, i);
        slider.setProgress(0);
    }

    public void palautaRaha(View v) {
        bottle.returnMoney(text);
    }

    public void ostaPullo(View v) throws IOException {
        int pullo = menu.getSelectedItemPosition();
        System.out.println(pullo);
        bottle.buyBottle(this.text, pullo, context);

    }



}
