package com.example.enterpriseapplication;

import com.example.enterpriseapplication.dto.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class RecipeEaseControllerTest {

    @InjectMocks
    RecipeEaseController recipeEaseController;

    @Test
    void testIndex() {
        Assertions.assertEquals("home", recipeEaseController.index());
    }

    @Test
    void testAddRecipe() {
        Assertions.assertEquals("AddRecipe", recipeEaseController.addRecipe());
    }

    @Test
    void testFetchAllRecipes() {
        Assertions.assertEquals(HttpStatus.OK, recipeEaseController.fetchAllRecipes().getStatusCode());
    }

    @Test
    void testFetchRecipeById() {
        Assertions.assertEquals(HttpStatus.OK, recipeEaseController.fetchRecipeById("id").getStatusCode());
    }

    @Test
    void testCreateRecipe() {
        Recipe recipe = Mockito.mock(Recipe.class);
        Assertions.assertEquals(recipe, recipeEaseController.createRecipe(recipe));
    }

    @Test
    void testDeleteRecipe() {
        Assertions.assertEquals(HttpStatus.OK, recipeEaseController.deleteRecipe("id").getStatusCode());
    }

}
