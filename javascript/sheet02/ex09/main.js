const texto = "A man, a plan, a canal, Panama";

console.log(esPalindromo(texto)); 
console.log(esPalindromo("Hola mundo"));

function esPalindromo(texto) {
    let arrOriginal = texto.replaceAll(",", "").split("");
    
    arrOriginal = arrOriginal.filter(item => item != " ");

    let arrInverso = [].concat(arrOriginal);

    arrInverso = arrInverso.reverse().join("");
    arrOriginal = arrOriginal.join("");

    return arrOriginal.toLowerCase() == arrInverso.toLowerCase();
}