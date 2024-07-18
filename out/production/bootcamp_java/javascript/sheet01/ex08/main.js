let person = {"nombre": "Miguel", "apellido": "Ligero", "ciudad": "Málaga"};

for (const key in person) {
    if (Object.hasOwnProperty.call(person, key)) {
        console.log(person[key]);
    }
}

function describirPersona(objectPerson) {
    let description = "";
    console.log(JSON.stringify(objectPerson));
    for (const key in person) {
        if (Object.hasOwnProperty.call(person, key)) {
            description += key + ": " + person[key] + ", ";
            
        }
    }

    console.log(description);
}

describirPersona(person);