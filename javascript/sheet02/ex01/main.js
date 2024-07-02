const numeros = [1,2,3,4,5,6,7,8,9];

console.log(filtrarImpares(numeros));

function filtrarImpares(numeros) {
    return numeros.filter((num) => num%2 != 0);
}