package com.example.enterpriseapplication;

import com.example.enterpriseapplication.dto.Recipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeManager {
    private static final String JSON_FILE = "recipes.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Read recipes from JSON file
    private static List<Recipe> readRecipesFromJson() {
        try (FileReader reader = new FileReader(JSON_FILE)) {
            Type listType = new TypeToken<ArrayList<Recipe>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Save recipes to JSON file
    private static void saveRecipesToJson(List<Recipe> recipes) {
        try (Writer writer = new FileWriter(JSON_FILE)) {
            gson.toJson(recipes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Find recipe by name
    private static Optional<Recipe> findRecipeByName(List<Recipe> recipes, String name) {
        return recipes.stream()
                .filter(recipe -> recipe.getRecipeName().equals(name))
                .findFirst();
    }
}