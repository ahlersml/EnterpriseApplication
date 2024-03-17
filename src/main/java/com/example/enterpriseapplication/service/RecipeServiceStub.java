package com.example.enterpriseapplication.service;

import com.example.enterpriseapplication.dto.Recipe;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceStub implements IRecipeService {

    private static final Map<Integer, Recipe> recipes = new HashMap<>();

    static {
        Recipe chickenAlfredo = new Recipe();
        chickenAlfredo.setRecipeName("Chicken Alfredo");
        chickenAlfredo.setRecipeID(1);
        chickenAlfredo.setRecipeSteps(new String[]{"cook pasta", "cook chicken", "make sauce", "add chicken and sauce to pasta", "Add cheese"});
        chickenAlfredo.setRecipeIngredients(new String[]{"Pasta", "Chicken Breast", "Alfredo Sauce", "Parmasean Cheese"});
        recipes.put(1, chickenAlfredo);

        Recipe pizza = new Recipe();
        pizza.setRecipeName("Pizza");
        pizza.setRecipeID(2);
        pizza.setRecipeSteps(new String[]{"make dough", "add sauce", "add toppings", "add cheese", "bake"});
        pizza.setRecipeIngredients(new String[]{"Pizza Dough", "Pizza Sauce", "Pepperoni", "Cheese"});
        recipes.put(2, pizza);
    }

    @Override
    public Recipe fetchById(int recipeId) {
        return recipes.get(recipeId);
    }
}