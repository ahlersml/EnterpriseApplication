package com.example.enterpriseapplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.enterpriseapplication.dto.Recipe;
import com.example.enterpriseapplication.service.IRecipeService;

@Controller
@RequestMapping("/recipes")
public class AddRecipeController {

    private final IRecipeService recipeService;

    public AddRecipeController(IRecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/add")
    public String addRecipe(@RequestParam("recipeName") String recipeName,
                            @RequestParam("ingredients") String ingredients,
                            @RequestParam("description") String description) {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeName);
        recipe.setRecipeIngredients(parseIngredients(ingredients));
        recipe.setRecipeSteps(parseSteps(description));

        // Call service method to save the recipe
        recipeService.saveRecipe(recipe);

        // Redirect to a confirmation page
        return "redirect:/recipes/confirmation";
    }

    private String[] parseIngredients(String ingredients) {
        return ingredients.split("\\r?\\n");
    }

    private String[] parseSteps(String description) {
        return description.split("\\r?\\n");
    }
}

