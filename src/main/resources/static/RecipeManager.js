
let mealsData = null
document.addEventListener('DOMContentLoaded', function() {
    // // Your code here will execute after the DOM is fully loaded, but before all external resources are loaded
    // // Sample data
    // fetch('meals.json')
    //     .then(response => response.json())
    //     .then(data => {
    //         // Do something with the JSON data
    //         console.log(data);
    //         mealsData = data
    //         const urlParams = new URLSearchParams(window.location.search);
    //         if(urlParams.size >0){
    //             renderMealWanted(mealsData, getQueryParam());
    //         }else{
    //             renderMeals(mealsData);
    //         }
    //
    //         getQueryParam()
    //     })
    //     .catch(error => console.error('Error fetching JSON:', error));
    const myHeaders = new Headers();
    myHeaders.append("x-master-key", "your_master_key");

    const requestOptions = {
        method: "GET",
        headers: myHeaders,
        redirect: "follow"
    };
    fetch("https://sweepster-api.onrender.com/api/meals", requestOptions)
        .then((response) => response.json())
        .then((result) => {
            console.log(result);
            mealsData = result
            const urlParams = new URLSearchParams(window.location.search);
            if(urlParams.size >0){
                renderMealWanted(mealsData, getQueryParam());
            }else{
                renderMeals(mealsData);
            }
        })
        .catch((error) => console.error(error));
});
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


