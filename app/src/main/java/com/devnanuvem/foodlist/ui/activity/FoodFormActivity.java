package com.devnanuvem.foodlist.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devnanuvem.foodlist.R;
import com.devnanuvem.foodlist.dao.RecipeDAO;
import com.devnanuvem.foodlist.model.Recipe;

public class FoodFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_form);
        setTitle("Adicionar Comida");

        final RecipeDAO recipeDAO = new RecipeDAO();

        Button saveButton = findViewById(R.id.activity_food_form_save_button);

        final EditText foodNameField = findViewById(R.id.activity_food_form_name);
        final EditText foodNumberOfIngredientsField = findViewById(R.id.activity_food_form_number_of_ingredients);
        final EditText foodNumberOfStepsField = findViewById(R.id.activity_food_form_number_of_steps);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String foodName = foodNameField.getText().toString();
                String foodNumberOfIngredients = foodNumberOfIngredientsField.getText().toString();
                String foodNumberOfSteps = foodNumberOfStepsField.getText().toString();

                Recipe recipe = new Recipe(foodName, foodNumberOfIngredients, foodNumberOfSteps);

                recipeDAO.saveRecipe(recipe);

                startActivity(new Intent(FoodFormActivity.this, FoodListActivity.class));

            }
        });


    }
}
