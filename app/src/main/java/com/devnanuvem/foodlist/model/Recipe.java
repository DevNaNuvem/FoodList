package com.devnanuvem.foodlist.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Recipe implements Serializable {
    private int id = 0;
    private String recipeName;
    private String recipeNumberOfIngredients;
    private String recipeNumberOfSteps;

    public Recipe(String recipeName, String recipeNumberOfIngredients, String recipeNumberOfSteps) {
        this.recipeName = recipeName;
        this.recipeNumberOfIngredients = recipeNumberOfIngredients;
        this.recipeNumberOfSteps = recipeNumberOfSteps;
        this.id = id;
    }

    public Recipe() {
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public void setRecipeNumberOfIngredients(String recipeNumberOfIngredients) {
        this.recipeNumberOfIngredients = recipeNumberOfIngredients;
    }

    public void setRecipeNumberOfSteps(String recipeNumberOfSteps) {
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public boolean hasValidId() {
        return id > 0;

    }
}
