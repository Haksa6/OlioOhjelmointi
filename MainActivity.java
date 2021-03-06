package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    EditText tiedostonimi, teksti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        tiedostonimi = findViewById(R.id.tiedosto);
        teksti = findViewById(R.id.tiedot);
        System.out.println("KANSION SIJAINTI " +context.getFilesDir());
    }

    public void readFile (View v) {
        try{
            InputStream inp = context.openFileInput(tiedostonimi.getText().toString());

            BufferedReader br = new BufferedReader(new InputStreamReader(inp));
            String s = "";

            while((s=br.readLine()) != null){
                teksti.setText(s);
            }


        }catch(IOException e){
            Log.e("IOException", "Virhe syötteessä");
        } finally{
            System.out.println("LUETTU");
        }
    }
    public void writeFile (View v) {
        try{
            OutputStreamWriter oup = new OutputStreamWriter(context.openFileOutput(tiedostonimi.getText().toString(), Context.MODE_PRIVATE));

            String s = "";

            s += teksti.getText();
            oup.write(s);
            oup.close();
        }catch(IOException e) {
            Log.e("IOException", "Virhe syötteessä");
        }finally{
            System.out.println("KIRJOITETTU");
        }
    }
}
