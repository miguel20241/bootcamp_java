let numberArray = [33, 0, -42];

numberArray.forEach(element => {
    if (element == 0) {
        console.log("El número " + element + " es cero");
    } else if (element > 0) {
        console.log("El número " + element + " es positivo");
    } else {
        console.log("El número " + element + " es negativo");
    }
});
