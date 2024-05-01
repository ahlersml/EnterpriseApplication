package com.example.enterpriseapplication;

import com.example.enterpriseapplication.dto.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeEaseController {

    @RequestMapping("/")
    public String index(){
        return "home";
    }

    @RequestMapping("/addRecipe")
    public String addRecipe(){
        return "AddRecipe";
    }
    @GetMapping("/recipe")
    public ResponseEntity fetchAllRecipes(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/recipe/{id}/")
    public ResponseEntity fetchRecipeById(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value="/recipe", consumes="application/json", produces="application/json")
    public Recipe createRecipe(@RequestBody Recipe recipe){
        return recipe;
    }

    @DeleteMapping("/recipe/{id}/")
    public ResponseEntity deleteRecipe(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

}
