package com.devnanuvem.foodlist.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Recipe implements Serializable {
    private final String recipeName;
    private final String recipeNumberOfIngredients;
    private final String recipeNumberOfSteps;

    public Recipe(String recipeName, String recipeNumberOfIngredients, String recipeNumberOfSteps) {
        this.recipeName = recipeName;
        this.recipeNumberOfIngredients = recipeNumberOfIngredients;
        this.recipeNumberOfSteps = recipeNumberOfSteps;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeNumberOfIngredients() {
        return recipeNumberOfIngredients;
    }

    public String getRecipeNumberOfSteps() {
        return recipeNumberOfSteps;
    }

    @NonNull
    @Override
    public String toString() {
        return recipeName;
    }
}
