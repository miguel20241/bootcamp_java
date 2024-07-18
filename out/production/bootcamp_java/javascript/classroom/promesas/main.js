async function operacionAsincrona1 () {
    let newPromise = new Promise ((resolve, reject) => {
        let datos = {nombre: 'Miguel'};

        setTimeout(() => { 
            resolve(datos);
        }, 2000);
    });

    return await newPromise;
};

function operacionAsincrona2 (nombre) {
    return new Promise ((resolve, reject) => {
        let datos = {
            nombre: nombre.nombre,
            apellido: 'Ligero'
        };

        setTimeout(() => { 
            resolve(datos); 
        }, 3000);
    });
}

async function operacionAsincrona3 (nombreCompleto) {
    let newPromise = new Promise ((resolve, reject) => {
        let datos = {
            nombre: nombreCompleto.nombre,
            apellido: nombreCompleto.apellido,
            edad: 45
        }

        setTimeout(() => { 
            resolve(datos);
        }, 4000);
    });

    return await newPromise;
}

operacionAsincrona1()
    .then((res) => {
        console.log('fn 1 -- ' + new Date);
        console.log(res);

        return operacionAsincrona2(res);
    })
    .then((res) => {
        console.log('fn 2 -- ' + new Date);
        console.log(res);

        return operacionAsincrona3(res);
    })
    .then((res) => {
        console.log('fn 3 -- ' + new Date);
        console.log(res);
    });