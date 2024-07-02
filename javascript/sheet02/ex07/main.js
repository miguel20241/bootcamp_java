const texto = "Hola MundoI";

console.log(contarVocales(texto));

function contarVocales(texto) {
    const arr = texto.match(/[aeiou]/gi);
    
    return arr.length;
}