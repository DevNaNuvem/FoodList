package com.devnanuvem.foodlist.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devnanuvem.foodlist.R;
import com.devnanuvem.foodlist.model.Recipe;

public class FoodFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_form);
        setTitle("Adicionar Comida");

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

                Toast.makeText(FoodFormActivity.this,
                        recipe.getFoodName() + " - "
                                + recipe.getFoodNumberOfIngredients() + " - "
                                + recipe.getFoodNumberOfSteps(),
                        Toast.LENGTH_LONG).show();

            }
        });


    }
}
