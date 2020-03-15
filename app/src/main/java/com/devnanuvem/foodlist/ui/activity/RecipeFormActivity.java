package com.devnanuvem.foodlist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.devnanuvem.foodlist.R;
import com.devnanuvem.foodlist.dao.RecipeDAO;
import com.devnanuvem.foodlist.model.Recipe;

import static com.devnanuvem.foodlist.ui.activity.ActivitiesConstants.RECIPE_KEY;

public class RecipeFormActivity extends AppCompatActivity {

    public static final String APP_BAR_TITLE_NEW_RECIPE = "Nova Receita";
    public static final String APP_BAR_TITLE_EDIT_RECIPE = "Editar Receita";
    private EditText recipeNameField;
    private EditText recipeNumberOfIngredientsField;
    private EditText recipeNumberOfStepsField;
    private final RecipeDAO recipeDAO = new RecipeDAO();
    private Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_form);
        bindFields();

        configureSaveButton();

        loadRecipe();
    }

    private void loadRecipe() {
        Intent intent = getIntent();
        if (intent.hasExtra(RECIPE_KEY)) {
            recipe = (Recipe) intent.getSerializableExtra(RECIPE_KEY);
            setTitle(APP_BAR_TITLE_EDIT_RECIPE);
            if (recipe != null) {
                fillFieldsForEdit();
            }
        } else {
            recipe = new Recipe();
            setTitle(APP_BAR_TITLE_NEW_RECIPE);
        }
    }

    private void fillFieldsForEdit() {
        recipeNameField.setText(recipe.getRecipeName());
        recipeNumberOfIngredientsField.setText(recipe.getRecipeNumberOfIngredients());
        recipeNumberOfStepsField.setText(recipe.getRecipeNumberOfSteps());
    }

    private void configureSaveButton() {
        Button saveButton = findViewById(R.id.activity_recipe_form_save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishForm();
            }
        });
    }

    private void finishForm() {
        fillRecipeWithFormData();
        if (recipe.hasValidId()) {
            recipeDAO.editRecipe(recipe);
        } else {
            recipeDAO.saveRecipe(recipe);
        }
        finish();
    }

    private void bindFields() {
        recipeNameField = findViewById(R.id.activity_recipe_form_name);
        recipeNumberOfIngredientsField = findViewById(R.id.activity_recipe_form_number_of_ingredients);
        recipeNumberOfStepsField = findViewById(R.id.activity_recipe_form_number_of_steps);

    }

    private void fillRecipeWithFormData() {
        String recipeName = recipeNameField.getText().toString();
        String recipeNumberOfIngredients = recipeNumberOfIngredientsField.getText().toString();
        String recipeNumberOfSteps = recipeNumberOfStepsField.getText().toString();

        recipe.setRecipeName(recipeName);
        recipe.setRecipeNumberOfIngredients(recipeNumberOfIngredients);
        recipe.setRecipeNumberOfSteps(recipeNumberOfSteps);

    }
}
