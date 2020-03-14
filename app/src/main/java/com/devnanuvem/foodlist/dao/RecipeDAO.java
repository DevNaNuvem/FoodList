package com.devnanuvem.foodlist.dao;

import com.devnanuvem.foodlist.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {

    private static List<Recipe> recipes = new ArrayList<>();

    public void saveRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public List<Recipe> all() {
        return new ArrayList<>(recipes);
    }
}
