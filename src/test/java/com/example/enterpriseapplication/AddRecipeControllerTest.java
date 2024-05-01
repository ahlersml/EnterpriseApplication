package com.example.enterpriseapplication;

import com.example.enterpriseapplication.service.IRecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AddRecipeControllerTest {

    @InjectMocks
    AddRecipeController addRecipeController;

    @Mock
    IRecipeService recipeService;

    @Test
    void testConstructor() {
        AddRecipeController addRecipeController = new AddRecipeController(recipeService);
        Assertions.assertInstanceOf(AddRecipeController.class, addRecipeController);
    }

    @Test
    void testAddRecipe() throws Exception {
        Assertions.assertNull(addRecipeController.addRecipe("recipe name", "ingredients", "description"));
    }

}
