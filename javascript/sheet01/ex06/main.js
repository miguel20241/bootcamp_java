function saludar(nombre) {
    console.log("Hola " + nombre);
}

function mayor(num1, num2) {
    if (num1 > num2) {
        return num1;
    } else {
        return num2;
    }
}

saludar("Pepe");
saludar("Miguel");

console.log(mayor(14, 6));
console.log(mayor(2132, 34242));