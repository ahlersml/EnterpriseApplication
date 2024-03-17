package com.example.enterpriseapplication.dto;


import lombok.Data;

public @Data
class Recipe {
    private int recipeID;
    private String recipeName;
    private String[] recipeSteps;
    private String[] recipeIngredients;
}
