let arrayWeekDays = ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"];

arrayWeekDays.forEach(element => {
    console.log(element);
});

function sumarArreglo(arrayToSum) {
    let totalSum = 0;
    arrayToSum.forEach(element => {
        totalSum += element;
    });
    return totalSum;
}

console.log(sumarArreglo([1, 3, 5, 1]));
console.log(sumarArreglo([12, 33, 53, 31]));