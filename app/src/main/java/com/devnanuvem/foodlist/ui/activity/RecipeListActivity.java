package com.devnanuvem.foodlist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.devnanuvem.foodlist.R;
import com.devnanuvem.foodlist.dao.RecipeDAO;
import com.devnanuvem.foodlist.model.Recipe;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static com.devnanuvem.foodlist.ui.activity.ActivitiesConstants.RECIPE_KEY;

public class RecipeListActivity extends AppCompatActivity {

    public static final String APP_BAR_TITLE = "Lista de receitas";
    private final RecipeDAO recipeDAO = new RecipeDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recipe_list_activity);
        setTitle(APP_BAR_TITLE);

        recipeDAO.saveRecipe(new Recipe("Ovos Mexidos", "1", "1"));
        recipeDAO.saveRecipe(new Recipe("Ovos Cozidos", "1", "1"));
        recipeDAO.saveRecipe(new Recipe("Ovos Fritos", "1", "1"));

        newRecipeFABSetting();

    }

    private void newRecipeFABSetting() {
        FloatingActionButton newRecipeButton = findViewById(R.id.activity_recipe_list_fab_new_recipe);
        newRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreationForm();
            }
        });
    }

    private void openCreationForm() {
        startActivity(new Intent(this,
                RecipeFormActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        configureList();
    }

    private void configureList() {
        ListView recipeListView = findViewById(R.id.activity_recipe_list_listview);

        final List<Recipe> recipes = recipeDAO.all();
        configureAdapter(recipeListView, recipes);

        configureOnItemClickListener(recipeListView);

    }

    private void configureOnItemClickListener(ListView recipeListView) {
        recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Recipe selectedRecipe = (Recipe) parent.getItemAtPosition(position);
                openEditForm(selectedRecipe);
            }
        });
    }

    private void openEditForm(Recipe recipe) {
        Intent goToRecipeFormActivity = new Intent(RecipeListActivity.this, RecipeFormActivity.class);
        goToRecipeFormActivity.putExtra(RECIPE_KEY, recipe);

        startActivity(goToRecipeFormActivity);
    }

    private void configureAdapter(ListView recipeListView, List<Recipe> recipes) {
        recipeListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipes));
    }
}
