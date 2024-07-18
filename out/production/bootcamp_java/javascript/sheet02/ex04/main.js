const numeros = [1, 2, 3, 4, 5];

console.log(sumarNumeros(numeros));

function sumarNumeros(numeros) {
    return numeros.reduce((total, item) => {
        return total + item;
    });
}