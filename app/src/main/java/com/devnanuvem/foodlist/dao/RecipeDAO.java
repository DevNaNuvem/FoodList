package com.devnanuvem.foodlist.dao;

import com.devnanuvem.foodlist.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {

    private static List<Recipe> recipes = new ArrayList<>();
    private static int idCounter = 1;

    public void saveRecipe(Recipe recipe) {
        recipe.setId(idCounter);
        recipes.add(recipe);
        updateId();
    }

    private void updateId() {
        idCounter++;
    }

    public void editRecipe(Recipe recipe) {
        Recipe foundRecipe = findRecipeById(recipe);
        if (foundRecipe != null) {
            int recipePosition = recipes.indexOf(foundRecipe);
            recipes.set(recipePosition, recipe);
        }
    }

    private Recipe findRecipeById(Recipe recipe) {
        for (Recipe r : recipes
        ) {
            if (r.getId() == recipe.getId()) {
                return r;
            }
        }
        return null;
    }


    public List<Recipe> all() {
        return new ArrayList<>(recipes);
    }
}
