const numeros = [1, 2, 10, 4, 5];

console.log(encontrarMaximo(numeros));

function encontrarMaximo(numeros) {
    return Math.max(...numeros);
}