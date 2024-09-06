import { useEffect, useState } from 'react'
import './App.css'
import './style.css'
import PokemonList from './pokemonList/PokemonList'

function App() {
  const [pokemonListData, setPokemonListData] = useState([])

  useEffect(() => {
    const pokemonData = async () => {
      try {
        const url = "https://pokeapi.co/api/v2/pokemon/";

        const pokemonListResponse = await fetch(url);
        let pokemonListJson;

        if (pokemonListResponse.status >= 200 && pokemonListResponse.status <= 299) {
          pokemonListJson = await pokemonListResponse.json();

        } else {
          throw new Error('Error: Estado ' + pokemonListResponse.status);
        }

        const pokemonDataJson = await getPokemonData(pokemonListJson.results);
        setPokemonListData(pokemonDataJson);

      } catch (err) {
        console.error(err);
      }
    }

    pokemonData();

  }, [])

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

  return (
    <div>
      <div className="top_corners left"></div>
      <div className="top_corners right"></div>
      <div className="bottom_corners left"></div>
      <div className="bottom_corners right"></div>
      <main>
        <PokemonList pokemonListData={pokemonListData} />
      </main>
    </div>
  )
}

export default App
