// Sample data
const mealsData = [
    {
        meal: "Meat",
        ingredients: [
            { item: "cabbage", quantity: 2 },
            { item: "carrot", quantity: 3 },
            { item: "potato", quantity: 4 }
        ]
    },
    {
        meal: "Fish",
        ingredients: [
            { item: "lettuce", quantity: 1 },
            { item: "tomato", quantity: 2 },
            { item: "onion", quantity: 1 }
        ]
    }
];

// Function to generate HTML for a meal
function generateMealWantedHTML(meal) {
    let html = `<h2>${meal.meal}</h2>`;
    html += "<ul>";
    meal.ingredients.forEach(ingredient => {
        html += `<li>${ingredient.item} - ${ingredient.quantity}</li>`;
    });
    html += "</ul>";
    
    return html;
}

// Function to render meals
function renderMealWanted(meals) {
    const mealIngredientsElement = document.getElementById("meal");
    mealIngredientsElement.innerHTML = "";
    meals.forEach(meal => {
        const mealHTML = generateMealWantedHTML(meal);
        mealIngredientsElement.innerHTML += mealHTML;
    });

}

// Render meals
renderMealWanted(mealsData);