package com.devnanuvem.foodlist.model;

public class Recipe {
    private final String foodName;
    private final String foodNumberOfIngredients;
    private final String foodNumberOfSteps;

    public Recipe(String foodName, String foodNumberOfIngredients, String foodNumberOfSteps) {
        this.foodName = foodName;
        this.foodNumberOfIngredients = foodNumberOfIngredients;
        this.foodNumberOfSteps = foodNumberOfSteps;
    }

    @Override
    public String toString() {
        return foodName;
    }
}
