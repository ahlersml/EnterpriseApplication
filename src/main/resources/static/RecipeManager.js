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
function generateMealHTML(meal) {
    let html = `<h2 onclick="changeDisplay('${meal.meal}')">${meal.meal}</h2>`;
    return html;
}

// Function to render meals
function renderMeals(meals) {
    const mealIngredientsElement = document.getElementById("app");
    mealIngredientsElement.innerHTML = "";
    meals.forEach(meal => {
        const mealHTML = generateMealHTML(meal);
        mealIngredientsElement.innerHTML += mealHTML;
    });
}
function changeDisplay(meal){
    // Get the current URL
    let url = new URL(window.location.href);

    // Create a new URLSearchParams object
    let params = new URLSearchParams(url.search);

    // Add or update the query parameter
    params.set('meal', meal);

    // Update the URL with the new query parameters
    url.search = params.toString();

    // Redirect to the updated URL
    window.location.href = url.toString();
}
function getQueryParam() {
    const urlParams = new URLSearchParams(window.location.search);

    return urlParams.get("meal");
}
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
function renderMealWanted(meals, mealWanted) {
    console.log(mealWanted)
    const targetMeal = meals.find((f) => f.meal === mealWanted)
    console.log(targetMeal)
    const mealIngredientsElement = document.getElementById("app");
    mealIngredientsElement.innerHTML = "";
    meals.forEach((meal,index) => {

        if(index === 0){
            const mealHTML = generateMealWantedHTML(targetMeal);
            mealIngredientsElement.innerHTML += mealHTML;
        }

    });
    // const mealHTML = generateMealWantedHTML(mealWanted);
    // mealIngredientsElement.innerHTML += mealHTML;
}
const urlParams = new URLSearchParams(window.location.search);
if(urlParams.size >0){
    renderMealWanted(mealsData, getQueryParam());
}else{
    renderMeals(mealsData);
}
// Render meals

// Render meals

getQueryParam()