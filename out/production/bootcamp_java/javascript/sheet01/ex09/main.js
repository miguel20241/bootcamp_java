function invertirCadena(originalString) {
    let arrayString = originalString.split(" ");
    arrayString = arrayString.reverse();
    let reverseString = arrayString.join(" ");
    
    return reverseString;
}

function contarVocales(stringToCountVocals) {
    let arrayVocals = stringToCountVocals.match(/[aeiouAEIOU]/g);

    return arrayVocals;
}

let string = "Lambda Expressions were added in Java 8.";

console.log(string)
console.log(invertirCadena(string));
console.log(contarVocales(string));