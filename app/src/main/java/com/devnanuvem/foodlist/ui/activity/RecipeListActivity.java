package com.devnanuvem.foodlist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.devnanuvem.foodlist.R;
import com.devnanuvem.foodlist.dao.RecipeDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecipeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recipe_list_activity);
        setTitle("Lista de receitas");

        FloatingActionButton newRecipeButton = findViewById(R.id.activity_recipe_list_fab_new_recipe);
        newRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipeListActivity.this, RecipeFormActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        RecipeDAO recipeDAO = new RecipeDAO();

        ListView recipeListView = findViewById(R.id.activity_recipe_list_listview);

        recipeListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipeDAO.all()));
    }
}
