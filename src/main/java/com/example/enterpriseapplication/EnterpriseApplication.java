package com.example.enterpriseapplication;
import com.example.enterpriseapplication.dto.Recipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnterpriseApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnterpriseApplication.class, args);
        RecipeManager recipeManager = new RecipeManager();
        recipeManager.run();
    }
}

class RecipeManager {
    private static final String JSON_FILE = "recipes.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void run() {
        List<Recipe> recipes = readRecipesFromJson();
        displayRecipes(recipes);

       // Example: Add a new recipe
Recipe newRecipe = new Recipe();
newRecipe.setName("Tacos");
newRecipe.setDescription("Mexican dish consisting of a tortilla filled with various ingredients");
List<String> tacoIngredients = new ArrayList<>();
tacoIngredients.add("Tortillas");
tacoIngredients.add("Ground beef or chicken");
tacoIngredients.add("Cheese");
tacoIngredients.add("Lettuce");
tacoIngredients.add("Tomatoes");
newRecipe.setIngredients(tacoIngredients);
recipes.add(newRecipe);

// Example: Update a recipe
Recipe recipeToUpdate = findRecipeByName(recipes, "Pizza");
if (recipeToUpdate != null) {
    recipeToUpdate.setDescription("Italian dish with a yeasted flatbread typically topped with tomato sauce and cheese");
}

// Example: Delete a recipe
Recipe recipeToDelete = findRecipeByName(recipes, "Burger");
if (recipeToDelete != null) {
    recipes.remove(recipeToDelete);
}
    }

    private List<Recipe> readRecipesFromJson() {
        try (Reader reader = new FileReader(JSON_FILE)) {
            Type listType = new TypeToken<ArrayList<Recipe>>(){}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void displayRecipes(List<Recipe> recipes) {
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }

    private void saveRecipesToJson(List<Recipe> recipes) {
        try (Writer writer = new FileWriter(JSON_FILE)) {
            gson.toJson(recipes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Recipe findRecipeByName(List<Recipe> recipes, String name) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().equals(name)) {
                return recipe;
            }
        }
        return null;
    }
}