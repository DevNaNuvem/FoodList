package com.devnanuvem.foodlist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("Lista de comidas");

        List<String> foodList = new ArrayList<>(Arrays.asList("Lasanha", "Bife à cavalo", "Macarronada", "Parmegianna"));
        ListView foodListView = findViewById(R.id.activity_main_food_list_view);

        foodListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foodList));
    }
}
