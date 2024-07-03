const texto = "JavaScript";

console.log(revertirCadena(texto));

function revertirCadena(text) {
    return text.split("").reverse().join("");
}