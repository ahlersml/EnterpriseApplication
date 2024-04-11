function createArrayOfObjectsFromText() {
    // Split the text into an array using comma as delimiter
    let text = document.getElementById('ingredients').value
    let name = document.getElementById('recipeName').value
    let description = document.getElementById('description').value
    var samples = text.split(", ");

    // Create an array to store objects
    var resultArray = [];

    // Iterate through the samples and create objects with "item" key
    samples.forEach(function(sample) {
        var obj = { "item": sample , "quantity": 1 };
        resultArray.push(obj);
    });

    if(text || name || description){
        console.log({
            "meal": name,
            "ingredients": resultArray,
            "description": description
        })
        var result = {
            "meal": name,
            "ingredients": resultArray,
            "description": description
        }
        //Server post
        const myHeaders = new Headers();
        myHeaders.append("x-master-key", "your_master_key");
        myHeaders.append("Content-Type", "application/json");

        const raw = JSON.stringify(result);

        const requestOptions = {
            method: "POST",
            headers: myHeaders,
            body: JSON.stringify(result),
            redirect: "follow"
        };

        fetch("https://sweepster-api.onrender.com/api/meals", requestOptions)
            .then((response) => response.text())
            .then((result) => console.log(result))
            .catch((error) => console.error(error));
        alert("Success");
        return resultArray;
    }else{
        alert("Enter a name, a description or ingredients.");
    }
}