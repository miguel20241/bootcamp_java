
(async () => {

    let users = ['usuario1'];

    await fetch('https://pokeapi.co/api/v2/pokemon/')
        .then(resp => {
            resp.json()
        })
    
        .then(data => {
            data.forEach((persona) => {
                let nombres = persona.name;
                users.push(nombres);
            });
        });

    //AQUI SE PUEDE USAR USERS
    console.log(users);


})();

// Solicitud GET (Request).
fetch('https://api.github.com/users/manishmshiva')
    // Exito
    .then(response => response.json())  // convertir a json
    .then(json => console.log(json))    //imprimir los datos en la consola
    .catch(err => console.log('Solicitud fallida', err)); // Capturar errores