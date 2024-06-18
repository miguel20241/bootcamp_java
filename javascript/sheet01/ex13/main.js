document.getElementById('generatorBtnId').addEventListener('click', function() {
    const num1 = document.getElementById('num1Id').value;
    const num2 = document.getElementById('num2Id').value;
    const result = Math.floor(Math.random() * (parseInt(num2) - parseInt(num1) + 1) + parseInt(num1));

    document.getElementById('resultDiv').innerText = 'El número aleatorio es: ' + result;
});