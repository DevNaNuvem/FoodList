package com.devnanuvem.foodlist.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.devnanuvem.foodlist.R;
import com.devnanuvem.foodlist.dao.RecipeDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.food_list_activity);
        setTitle("Lista de comidas");

        RecipeDAO recipeDAO = new RecipeDAO();

        ListView foodListView = findViewById(R.id.activity_food_list_listview);

        foodListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeDAO.all()));
    }
}
