package com.example.enterpriseapplication;

import com.example.enterpriseapplication.dto.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class RecipeManagerTest {

    @Mock
    RecipeManager recipeManager;

    @Mock
    Recipe recipe;

    @Test
    void testReadRecipesFromJson() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = RecipeManager.class.getDeclaredMethod("readRecipesFromJson");
        method.setAccessible(true);

        List<Recipe> recipes = (List<Recipe>) method.invoke(null);
        Assertions.assertEquals(1, recipes.size());
        Assertions.assertNotNull(recipes.get(0));
    }

    @Test
    void testDisplayRecipes() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        verifyPrivateMethodListArgument("displayRecipes");
    }

    @Test
    void testSaveRecipesToJson() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        verifyPrivateMethodListArgument("saveRecipesToJson");
    }

    void verifyPrivateMethodListArgument(String methodName) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException {
        Method method = RecipeManager.class.getDeclaredMethod(methodName, List.class);
        method.setAccessible(true);
        method.invoke(recipeManager, List.of(recipe));
        Assertions.assertTrue(true);
    }

    @Test
    void testFindRecipeByName() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Assertions.assertEquals(recipe, mockAndInvokeFindRecipeByName("name"));
    }

    @Test
    void testFindRecipeByNameNoMatch() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Assertions.assertNull(mockAndInvokeFindRecipeByName("recipe name"));
    }

    Recipe mockAndInvokeFindRecipeByName(String expectedRecipeName) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Mockito.when(recipe.getRecipeName()).thenReturn(expectedRecipeName);
        Method method = RecipeManager.class.getDeclaredMethod("findRecipeByName", List.class, String.class);
        method.setAccessible(true);
        return (Recipe) method.invoke(recipeManager, List.of(recipe), "name");
    }

}
