package com.devnanuvem.foodlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        List<String> listaComidas = new ArrayList<>(Arrays.asList("Lasanha", "Bife à cavalo", "Macarronada"));

        TextView comida1 = findViewById(R.id.textView);
        TextView comida2 = findViewById(R.id.textView1);
        TextView comida3 = findViewById(R.id.textView2);

        comida1.setText(listaComidas.get(0));
        comida2.setText(listaComidas.get(1));
        comida3.setText(listaComidas.get(2));
    }
}
