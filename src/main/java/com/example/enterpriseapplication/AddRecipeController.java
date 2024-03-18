package com.example.enterpriseapplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.enterpriseapplication.dto.Recipe;
import com.example.enterpriseapplication.service.IRecipeService;

@Controller
@RequestMapping("/recipes")
public class AddRecipeController {

    @Autowired
    IRecipeService recipeService;

    @Autowired
    public AddRecipeController(IRecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/add")
    public String addRecipe(@RequestParam("recipeName") String recipeName,
                            @RequestParam("ingredients") String ingredients,
                            @RequestParam("description") String description) throws Exception {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeName);
        recipe.setRecipeIngredients(ingredients.split("\\r?\\n"));
        recipe.setRecipeSteps(description.split("\\r?\\n"));

        // Call service method to save the recipe
        recipeService.save(recipe);

        // Redirect to a confirmation page
        return "redirect:/recipes/confirmation";
    }
}

