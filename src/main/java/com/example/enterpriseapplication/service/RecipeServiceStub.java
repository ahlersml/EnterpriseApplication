package com.example.enterpriseapplication.service;

import com.example.enterpriseapplication.dao.IRecipeDAO;
import com.example.enterpriseapplication.dto.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceStub implements IRecipeService {
    @Autowired
    private IRecipeDAO recipeDAO;

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
    public Recipe save(Recipe recipe) throws Exception {
        return recipeDAO.save(recipe);
    }
}
