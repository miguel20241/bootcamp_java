function checkInputsAreNotEmpty(input1, input2) {
    if (input1.length == 0 || input2.length == 0) {
        return false;
    }

    return true;
}

document.getElementById('sumBtnId').addEventListener('click', function () {
    const input1 = document.getElementById('firstNumberId').value;
    const input2 = document.getElementById('secondNumberId').value;

    if (!checkInputsAreNotEmpty(input1, input2)) {
        alert('Falta un número para realizar la operación');
    } else {
        const sum = parseInt(input1) + parseInt(input2);
        document.getElementById('resultDiv').innerText = 'El resultado de la suma es: ' + sum;
    }
});

document.getElementById('subBtnId').addEventListener('click', function () {
    const input1 = document.getElementById('firstNumberId').value;
    const input2 = document.getElementById('secondNumberId').value;

    if (!checkInputsAreNotEmpty(input1, input2)) {
        alert('Falta un número para realizar la operación');
    } else {
        const sum = parseInt(input1) - parseInt(input2);
        document.getElementById('resultDiv').innerText = 'El resultado de la resta es: ' + sum;
    }
});

document.getElementById('mulBtnId').addEventListener('click', function () {
    const input1 = document.getElementById('firstNumberId').value;
    const input2 = document.getElementById('secondNumberId').value;

    if (!checkInputsAreNotEmpty(input1, input2)) {
        alert('Falta un número para realizar la operación');
    } else {
        const sum = parseInt(input1) * parseInt(input2);
        document.getElementById('resultDiv').innerText = 'El resultado de la multiplicación es: ' + sum;
    }
});

document.getElementById('divBtnId').addEventListener('click', function () {
    const input1 = document.getElementById('firstNumberId').value;
    const input2 = document.getElementById('secondNumberId').value;

    if (!checkInputsAreNotEmpty(input1, input2)) {
        alert('Falta un número para realizar la operación');
    } else {
        const sum = parseInt(input1) / parseInt(input2);
        document.getElementById('resultDiv').innerText = 'El resultado de la división es: ' + sum;
    }
});