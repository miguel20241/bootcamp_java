const numeros = [1, 2, 3, 2, 4, 1, 5];

console.log(removerDuplicados(numeros));

function removerDuplicados(numeros) {
    return new Set(numeros);
}