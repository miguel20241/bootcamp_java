async function getListPokemon() {
    let url = 'https://pokeapi.co/api/v2/pokemon/';

    // "https://pokeapi.co/api/v2/pokemon/?offset=20&limit=20"

    await fetch(url)
        .then(response => {
            if (response.status >= 200 && response.status <= 299) {
                return response.json();
            }
        })
        .then(json => {
            return getPokemonData(json.results);
        })
        .then(pokemonData => {
            createCard(pokemonData);
        })
        .catch(err => {
            throw new Error('error: ' + err);
        });
}

async function getPokemonData(urls) {
    let pokemonData = [];

    try {
        for (const key in urls) {
            if (Object.hasOwnProperty.call(urls, key)) {
                let pokemonTypes = [];
                const element = urls[key]
                const pokemonResponse = await fetch(element.url)
                const pokemonJson = await pokemonResponse.json()

                pokemonJson.types.forEach(element => {
                    pokemonTypes.push(element.type.name);
                });

                pokemonData.push({
                    id: pokemonJson.id,
                    name: pokemonJson.name,
                    types: pokemonTypes,
                    parent: await getPokemonParent(pokemonJson.species.url),
                    img: pokemonJson.sprites.front_default
                });
            }
        }

        return pokemonData;

    } catch (err) {
        console.error(err);
    }
}

const urlParent = "https://pokeapi.co/api/v2/pokemon-species/";

async function getPokemonParent(speciesUrl) {
    try {
        const parentResponse = await fetch(speciesUrl);
        const parentJson = await parentResponse.json();

        if (parentJson.evolves_from_species != null) {
            return parentJson.evolves_from_species.name;
        }
        return null;
    } catch (err) {
        console.error(err);
    }
}


function createCard(pokemonData) {
    let container = document.getElementById('cardContainer');

    for (const key in pokemonData) {
        if (Object.hasOwnProperty.call(pokemonData, key)) {
            const element = pokemonData[key];

            let card = document.createElement('div');

            card.innerHTML = `<div class="card">
                        <div class="imgContainer">
                            <img src="${element.img}" alt="Avatar" style="width:100%">
                            <p class="pokemonIdLabel">ID/${element.id}</p>
                        </div>
                        <div class="dataContainer">
                            <h4><b>${element.name}</b></h4>
                            <div id="typeContainer${element.id}" class="typeContainer">
                                <span class="pokemonType">Grass</span>
                                <span class="pokemonType">Fire</span>
                            </div>
                            
                            <div class="evolutionContainer">
                                <p>Evoluciona de:</p>
                                <h4>${element.parent}</h4>
                            </div>
                        </div>
                    </div>`;

            container.appendChild(card);

            let divTypeContainer = document.getElementById(`typeContainer${element.id}`);
            divTypeContainer.className = 'typeContainer';
            console.log(element.types);
            let span = '';
            for (const key in element.types) {
                if (Object.hasOwnProperty.call(element.types, key)) {
                    const type = element.types[key];

                    
                    span += `<span class="pokemonType">${type}</span>`;
                    divTypeContainer.appendChild;
                    
                }
            }
            divTypeContainer.innerHTML = span;
            console.log(divTypeContainer);

            if (element.parent != null) {

            }
        }
    }
}

getListPokemon();

