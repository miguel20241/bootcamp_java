async function getListPokemon() {
    try {
        const url = "https://pokeapi.co/api/v2/pokemon/";

        const pokemonListResponse = await fetch(url);
        let pokemonListJson;

        if (pokemonListResponse.status >= 200 && pokemonListResponse.status <= 299) {
            pokemonListJson = await pokemonListResponse.json();
        } else {
            throw new Error('Error: Estado ' + pokemonListResponse.status);
        }

        const pokemonData = await getPokemonData(pokemonListJson.results);

        createCard(pokemonData);

    } catch (err) {
        console.error(err);
    }

    // "https://pokeapi.co/api/v2/pokemon/?offset=20&limit=20"

    /*await fetch(url)
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
          });*/
}

async function getPokemonData(urls) {
    let pokemonData = [];

    try {
        for (const key in urls) {
            if (Object.hasOwnProperty.call(urls, key)) {
                let pokemonTypes = [];
                const element = urls[key];
                const pokemonResponse = await fetch(element.url);
                const pokemonJson = await pokemonResponse.json();

                pokemonJson.types.forEach((element) => {
                    pokemonTypes.push(element.type.name);
                });

                pokemonData.push({
                    id: pokemonJson.id,
                    name: pokemonJson.name,
                    types: pokemonTypes,
                    parent: await getPokemonParent(pokemonJson.species.url),
                    img: pokemonJson.sprites.front_default,
                });
            }
        }

        return pokemonData;

    } catch (err) {
        console.error(err);
        throw new Error('Error: Mensaje: ' + err);
    }
}

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
        throw new Error('Error: Mensaje: ' + err);
    }
}

function createCard(pokemonData) {
    const container = document.getElementById("cardContainer");

    for (const key in pokemonData) {
        if (Object.hasOwnProperty.call(pokemonData, key)) {
            const element = pokemonData[key];
            const card = document.createElement("div");
            card.className  = "card";
            card.id = element.name;

            card.innerHTML =    `<div class="imgContainer" onClick="showDetails(${element.name})">
                                    <img src="${element.img}" alt="Imagen pokemon" style="width:100%">
                                    <p class="pokemonIdLabel">ID/${element.id}</p>
                                </div>
                                <div class="dataContainer">
                                    <h4><b>${capitalizeFirstLetter(element.name)}</b></h4>
                                    <div id="typeContainer${element.id}" class="typeContainer"></div>
                                    <div id="evolutionContainer${element.id}" class="evolutionContainer"></div>
                                </div>
                                <div class="btnContainer">
                                    <button id="backBtn_${element.name}" class="hideBtn" onClick="closeDetails(${element.name})">Volver</button>
                                </div>`;

            container.appendChild(card);

            let span = "";
            const divTypeContainer = document.getElementById(`typeContainer${element.id}`);

            for (const key in element.types) {
                if (Object.hasOwnProperty.call(element.types, key)) {
                    const type = element.types[key];

                    span += `<span class="pokemonType">${capitalizeFirstLetter(type)}</span>`;
                }
            }

            divTypeContainer.innerHTML = span;

            const divEvolutionContainer = document.getElementById(`evolutionContainer${element.id}`);

            if (element.parent != null) {
                divEvolutionContainer.innerHTML = `<p>Evoluciona de:</p>
                                                    <p><b>${capitalizeFirstLetter(element.parent)}</b></p>`;
            } else {
                divEvolutionContainer.innerHTML = `<p>Evoluciona de:</p>
                                                    <p><b>nada</b></p>`;
                divEvolutionContainer.className = "hideEvolution evolutionContainer";
            }
        }
    }
}

function capitalizeFirstLetter(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

// Seleccionar pokemons al buscar por nombre
document.getElementById('searchInputId').addEventListener('keyup', (event) => {
    let search = document.getElementById('searchInputId').value;
    
    [...document.getElementsByClassName('hideCard')].forEach(element => {
        element.className = 'card';
    });
    
    const pokemonList = [...document.getElementsByClassName('card')];    

    let filterPokemonList = pokemonList.filter(function (str) { 
        return str.id.indexOf(search) === -1; 
    });
    
    for (const key in filterPokemonList) {
        if (Object.hasOwnProperty.call(filterPokemonList, key)) {
            filterPokemonList[key].className = 'hideCard';
        }
    }
});

function showDetails(card) {
    [...document.getElementsByClassName('card')].forEach(element => {
        element.className = 'hideCard';
    });
    
    card.className = 'card resizeCard';
    
    let backBtn = document.getElementById(`backBtn_${card.id}`);
    backBtn.className = '';
}

function closeDetails(cardId) {
    [...document.getElementsByClassName('hideCard')].forEach(element => {
        element.className = 'card';
    });
    cardId.className = 'card';
    
    const backBtn = document.getElementById('backBtn_' + cardId.id);
    backBtn.className = 'hideBtn';
}


getListPokemon();