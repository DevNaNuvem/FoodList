package com.devnanuvem.foodlist.model;

public class Recipe {
    private final String recipeName;
    private final String recipeNumberOfIngredients;
    private final String recipeNumberOfSteps;

    public Recipe(String recipeName, String recipeNumberOfIngredients, String recipeNumberOfSteps) {
        this.recipeName = recipeName;
        this.recipeNumberOfIngredients = recipeNumberOfIngredients;
        this.recipeNumberOfSteps = recipeNumberOfSteps;
    }

    @Override
    public String toString() {
        return recipeName;
    }
}
