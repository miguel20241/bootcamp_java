
document.getElementById('myForm').addEventListener('submit', (ev) => {
    ev.preventDefault();

    let form = ev.target;
    if (form.passwordId.value == form.confirmPasswordId.value) {
        if (form.passwordId.checkValidity()) {
            ev.target.reportValidity();
            form.submit();
        }  
    } else {
        form.confirmPasswordId.setCustomValidity('Las contraseñas deben coincidir');
    }
});