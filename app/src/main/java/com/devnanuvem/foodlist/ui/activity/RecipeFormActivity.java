package com.devnanuvem.foodlist.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.devnanuvem.foodlist.R;
import com.devnanuvem.foodlist.dao.RecipeDAO;
import com.devnanuvem.foodlist.model.Recipe;

public class RecipeFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_form);
        setTitle("Adicionar Comida");

        final RecipeDAO recipeDAO = new RecipeDAO();

        Button saveButton = findViewById(R.id.activity_recipe_form_save_button);

        final EditText recipeNameField = findViewById(R.id.activity_recipe_form_name);
        final EditText recipeNumberOfIngredientsField = findViewById(R.id.activity_recipe_form_number_of_ingredients);
        final EditText recipeNumberOfStepsField = findViewById(R.id.activity_recipe_form_number_of_steps);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String recipeName = recipeNameField.getText().toString();
                String recipeNumberOfIngredients = recipeNumberOfIngredientsField.getText().toString();
                String recipeNumberOfSteps = recipeNumberOfStepsField.getText().toString();

                Recipe recipe = new Recipe(recipeName, recipeNumberOfIngredients, recipeNumberOfSteps);

                recipeDAO.saveRecipe(recipe);

                finish();

            }
        });


    }
}
