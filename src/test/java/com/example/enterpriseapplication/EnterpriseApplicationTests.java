package com.example.enterpriseapplication;

import com.example.enterpriseapplication.dto.Recipe;
import com.example.enterpriseapplication.service.iRecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EnterpriseApplicationTests {

	@Autowired
	private iRecipeService recipeService;
	private Recipe recipe;
	@Test
	void contextLoads() {
	}

	@Test
	void fetchRecipeById_WithGivenIdOf1_ReturnChickenAlfredoRecipe(){

		int givenId = 1;
		recipe = recipeService.fetchById(givenId);

		String recipeName = recipe.getRecipeName();
		int recipeId = recipe.getRecipeID();
		String[] recipeSteps = recipe.getRecipeSteps();
		String[] recipeIngredients = recipe.getRecipeIngredients();


		assertEquals("Chicken Alfredo", recipeName);
		assertEquals(recipeId, 1);
		assertArrayEquals(recipeSteps, new String[]{"cook pasta", "cook chicken", "make sauce", "add chicken and sauce to pasta", "Add cheese"});
		assertArrayEquals(recipeIngredients, new String[]{"Pasta", "Chicken Breast", "Alfredo Sauce", "Parmasean Cheese"});
	}
	@Test
	void fetchRecipeById_WithGivenIdOf2_ReturnPizzaRecipe(){

		int givenId = 2;
		recipe = recipeService.fetchById(givenId);

		String recipeName = recipe.getRecipeName();
		int recipeId = recipe.getRecipeID();
		String[] recipeSteps = recipe.getRecipeSteps();
		String[] recipeIngredients = recipe.getRecipeIngredients();


		assertEquals("Pizza", recipeName);
		assertEquals(recipeId, 2);
		assertArrayEquals(recipeSteps, new String[]{"make dough", "add sauce", "add toppings", "add cheese", "bake"});
		assertArrayEquals(recipeIngredients, new String[]{"Pizza Dough", "Pizza Sauce", "Pepperoni", "Cheese"});
	}

}
