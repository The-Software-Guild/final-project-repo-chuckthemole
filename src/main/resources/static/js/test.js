fetch("https://api-basketball.p.rapidapi.com/{endpoint}", {
    "method": "GET",
    "headers": {
        "x-rapidapi-host": "api-basketball.p.rapidapi.com",
        "x-rapidapi-key": "XxXxXxXxXxXxXxXxXxXxXxXx"
    }
})
.then(response => {
    console.log(response);
})
.catch(err => {
    console.log(err);
});
