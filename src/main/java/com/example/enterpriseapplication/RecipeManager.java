package com.example.enterpriseapplication;

import com.example.enterpriseapplication.dto.Recipe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RecipeManager {

    private static final Log logger = LogFactory.getLog(RecipeManager.class);

    private static final String JSON_FILE = "recipes.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private RecipeManager() {
        // empty constructor
    }

    private static List<Recipe> readRecipesFromJson() {
        try (Reader reader = new FileReader(JSON_FILE)) {
            Type listType = new TypeToken<ArrayList<Recipe>>() {
            }.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private static void displayRecipes(List<Recipe> recipes) {
        for (Recipe recipe : recipes) {
            logger.info(recipe);
        }
    }

    private static void saveRecipesToJson(List<Recipe> recipes) {
        try (Writer writer = new FileWriter(JSON_FILE)) {
            gson.toJson(recipes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Recipe findRecipeByName(List<Recipe> recipes, String name) {
        for (Recipe recipe : recipes) {
            if (recipe.getRecipeName().equals(name)) {
                return recipe;
            }
        }
        return null;
    }
}
