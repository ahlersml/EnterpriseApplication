package com.example.enterpriseapplication.service;

import com.example.enterpriseapplication.dto.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RecipeServiceStubTest {

    @InjectMocks
    RecipeServiceStub recipeServiceStub;

    Recipe recipe;

    @Test
    void testFetchByIdEquals1() {
        int givenId = 1;
        recipe = recipeServiceStub.fetchById(givenId);

        Assertions.assertEquals("Chicken Alfredo", recipe.getRecipeName());
        Assertions.assertEquals(1, recipe.getRecipeID());

        String[] recipeSteps = recipe.getRecipeSteps();
        Assertions.assertEquals(5, recipeSteps.length);
        Assertions.assertArrayEquals(new String[]{"cook pasta", "cook chicken", "make sauce", "add chicken and sauce to pasta", "Add cheese"}, recipeSteps);

        String[] recipeIngredients = recipe.getRecipeIngredients();
        Assertions.assertEquals(4, recipeIngredients.length);
        Assertions.assertArrayEquals(new String[]{"Pasta", "Chicken Breast", "Alfredo Sauce", "Parmasean Cheese"}, recipeIngredients);
    }

    @Test
    void testFetchByIdEquals2() {
        int givenId = 2;
        recipe = recipeServiceStub.fetchById(givenId);

        Assertions.assertEquals("Pizza", recipe.getRecipeName());
        Assertions.assertEquals(2, recipe.getRecipeID());

        String[] recipeSteps = recipe.getRecipeSteps();
        Assertions.assertEquals(5, recipeSteps.length);
        Assertions.assertArrayEquals(new String[]{"make dough", "add sauce", "add toppings", "add cheese", "bake"}, recipeSteps);

        String[] recipeIngredients = recipe.getRecipeIngredients();
        Assertions.assertEquals(4, recipeIngredients.length);
        Assertions.assertArrayEquals(new String[]{"Pizza Dough", "Pizza Sauce", "Pepperoni", "Cheese"}, recipeIngredients);
    }

    @Test
    void testFetchByIdNull() {
        Assertions.assertNull(recipeServiceStub.fetchById(0));
    }

    @Test
    void testSave() throws Exception {
        recipe = Mockito.mock(Recipe.class);
        Assertions.assertNull(recipeServiceStub.save(recipe));
    }

}
