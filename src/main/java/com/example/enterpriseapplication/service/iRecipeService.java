package com.example.enterpriseapplication.service;

import com.example.enterpriseapplication.dto.Recipe;

public interface iRecipeService {
    /**
     * Fetch a recipe with a given ID.
     * @param recipeId a unique identifier for a recipe
     * @return the matching recipe, or null if no matches found
     */
    Recipe fetchById(int recipeId);
}
