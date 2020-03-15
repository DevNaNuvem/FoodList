package com.devnanuvem.foodlist.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.devnanuvem.foodlist.R;
import com.devnanuvem.foodlist.dao.RecipeDAO;
import com.devnanuvem.foodlist.model.Recipe;

public class RecipeFormActivity extends AppCompatActivity {

    public static final String APP_BAR_TITLE = "Nova Receita";
    private EditText recipeNameField;
    private EditText recipeNumberOfIngredientsField;
    private EditText recipeNumberOfStepsField;
    private final RecipeDAO recipeDAO = new RecipeDAO();
    private Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_form);
        setTitle(APP_BAR_TITLE);
        initializingFields();

        saveButtonSetting();

        recipe = (Recipe) getIntent().getSerializableExtra("recipe");
        recipeNameField.setText(recipe.getRecipeName());
        recipeNumberOfIngredientsField.setText(recipe.getRecipeNumberOfIngredients());
        recipeNumberOfStepsField.setText(recipe.getRecipeNumberOfSteps());
    }

    private void saveButtonSetting() {
        Button saveButton = findViewById(R.id.activity_recipe_form_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        fillRecipeForm();
        recipeDAO.editRecipe(recipe);
        finish();
//                saveRecipe(recipe);

            }
        });
    }

    private void initializingFields() {
        recipeNameField = findViewById(R.id.activity_recipe_form_name);
        recipeNumberOfIngredientsField = findViewById(R.id.activity_recipe_form_number_of_ingredients);
        recipeNumberOfStepsField = findViewById(R.id.activity_recipe_form_number_of_steps);


    }

    private void saveRecipe(Recipe recipe) {
        recipeDAO.saveRecipe(recipe);
        finish();
    }

    private void fillRecipeForm() {
        String recipeName = recipeNameField.getText().toString();
        String recipeNumberOfIngredients = recipeNumberOfIngredientsField.getText().toString();
        String recipeNumberOfSteps = recipeNumberOfStepsField.getText().toString();

        recipe.setRecipeName(recipeName);
        recipe.setRecipeNumberOfIngredients(recipeNumberOfIngredients);
        recipe.setRecipeNumberOfSteps(recipeNumberOfSteps);

    }
}
