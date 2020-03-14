package com.devnanuvem.foodlist.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.devnanuvem.foodlist.R;

public class FoodFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_form);
        setTitle("Adicionar Comida");
    }
}
