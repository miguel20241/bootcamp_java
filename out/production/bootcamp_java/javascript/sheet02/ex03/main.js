const palabras = ["hola", "mundo"];

console.log(convertirMayusculas(palabras));

function convertirMayusculas(palabras) {
    return palabras.map((item) => {
        return item.toUpperCase();
    });
}