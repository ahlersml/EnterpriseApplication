package com.example.enterpriseapplication.service;

import com.example.enterpriseapplication.dto.Recipe;
import org.springframework.stereotype.Component;

@Component
public class RecipeServiceStub implements IRecipeService{
    private Recipe savedRecipe;

    @Override
    public Recipe fetchById(int recipeId) {

        if(recipeId == 1){
            String[] recipeSteps = {"cook pasta", "cook chicken", "make sauce", "add chicken and sauce to pasta", "Add cheese"};
            String[] recipeIngredients = {"Pasta", "Chicken Breast", "Alfredo Sauce", "Parmasean Cheese"};

            Recipe recipe = new Recipe();
            recipe.setRecipeName("Chicken Alfredo");
            recipe.setRecipeID(1);
            recipe.setRecipeSteps(recipeSteps);
            recipe.setRecipeIngredients(recipeIngredients);
            return recipe;
        }
        if(recipeId ==2){
            String[] recipeSteps = {"make dough", "add sauce", "add toppings", "add cheese", "bake"};
            String[] recipeIngredients = {"Pizza Dough", "Pizza Sauce", "Pepperoni", "Cheese"};

            Recipe recipe = new Recipe();
            recipe.setRecipeName("Pizza");
            recipe.setRecipeID(2);
            recipe.setRecipeSteps(recipeSteps);
            recipe.setRecipeIngredients(recipeIngredients);
            return recipe;
        }
        return null;
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        this.savedRecipe = recipe;
    }
    public Recipe getSavedRecipe() {
        return savedRecipe;
    }
}
