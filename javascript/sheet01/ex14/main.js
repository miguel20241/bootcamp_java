var secretNum = undefined;

document.getElementById('startBtnId').addEventListener('click', function() {
    secretNum = Math.floor(Math.random() * 100) + 1;
    //console.log(secretNum);
});

document.getElementById('checkBtnId').addEventListener('click', function() {
    if (secretNum == undefined) {
        alert("Primero debes generar un número a adivinar");
    } else {
        const tryNum = document.getElementById('numCheckInputId').value; 
        let resultDiv = document.getElementById('resultDiv');

        if (tryNum == secretNum) {
            resultDiv.innerText = '¡Correcto!';
            resultDiv.style.color = "green";
            secretNum = undefined;
        } else if (tryNum > secretNum) {
            resultDiv.innerText = 'El número es menor';
            resultDiv.style.color = "red";
        } else {
            resultDiv.innerText = 'El número es mayor'
            resultDiv.style.color = "red";
        }
    }
});