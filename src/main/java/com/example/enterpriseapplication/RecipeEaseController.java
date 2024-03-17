package com.example.enterpriseapplication;

import com.example.enterpriseapplication.dto.Recipe;
import com.example.enterpriseapplication.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeEaseController {

    private final RecipeService recipeService;

    public RecipeEaseController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> fetchAllRecipes(){
        List<Recipe> recipes = recipeService.getAllRecipes();
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> fetchRecipeById(@PathVariable("id") String id){
        Recipe recipe = recipeService.getRecipeById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping(consumes="application/json", produces="application/json")
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe){
        Recipe createdRecipe = recipeService.createRecipe(recipe);
        return new ResponseEntity<>(createdRecipe, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable("id") String id){
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}