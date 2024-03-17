package com.example.enterpriseapplication.service;

import com.example.enterpriseapplication.dto.Recipe;

public interface IRecipeService {
    /**
     * Fetch a recipe with a given ID.
     * @param recipeId a unique identifier for a recipe
     * @return the matching recipe, or null if no matches found
     */
    Recipe fetchById(int recipeId);

    Recipe save(Recipe recipe) throws Exception;
}
