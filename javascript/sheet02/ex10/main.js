const palabras = ["hola", "programación", "mundo", "javascript"];

console.log(palabraMasLarga(palabras));

function palabraMasLarga(palabras) {
    return palabras.reduce((masLarga, palabra) => {
        return masLarga.length < palabra.length ? palabra : masLarga;
    });
}