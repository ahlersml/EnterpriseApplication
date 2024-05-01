package com.example.enterpriseapplication.dto;


import lombok.Data;
import java.util.Arrays;

public @Data
class Recipe {
    private int recipeID;
    private String recipeName;
    private String[] recipeSteps;
    private String[] recipeIngredients;

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeID=" + recipeID +
                ", recipeName='" + recipeName + '\'' +
                ", recipeSteps=" + Arrays.toString(recipeSteps) +
                ", recipeIngredients=" + Arrays.toString(recipeIngredients) +
                '}';
    }
}
