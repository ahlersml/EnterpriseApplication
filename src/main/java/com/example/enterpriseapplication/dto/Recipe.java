package com.example.enterpriseapplication.dto;

import java.util.List;

import lombok.Data;

public @Data
class Recipe {
    private int recipeID;
    private String recipeName;
    private String recipeDescription;
    private String[] recipeSteps;
    private List<String> recipeIngredients;

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + recipeName + '\'' +
                ", description='" + recipeDescription + '\'' +
                ", ingredients=" + recipeIngredients +
                '}';
    }
}
