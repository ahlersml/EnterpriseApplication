package com.example.enterpriseapplication.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RecipeTest {

    @InjectMocks
    Recipe recipe;

    @Test
    void testSetters() {
        Recipe recipe = new Recipe();
        recipe.setRecipeID(0);
        recipe.setRecipeName("recipe name");
        recipe.setRecipeSteps(new String[]{"recipe step"});
        recipe.setRecipeIngredients(new String[]{"recipe ingredient"});

        Assertions.assertEquals(0, recipe.getRecipeID());
        Assertions.assertEquals("recipe name", recipe.getRecipeName());
        Assertions.assertEquals(1, recipe.getRecipeSteps().length);
        Assertions.assertEquals("recipe step", recipe.getRecipeSteps()[0]);
        Assertions.assertEquals(1, recipe.getRecipeIngredients().length);
        Assertions.assertEquals("recipe ingredient", recipe.getRecipeIngredients()[0]);
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Recipe{recipeID=0, recipeName='null', recipeSteps=null, recipeIngredients=null}", recipe.toString());
    }

}
