/* eslint-disable react/prop-types */
import PokemonCard from "../pokemonCard/PokemonCard.jsx";

function PokemonList({ pokemonListData }) {
    return (
        <div id="cardContainer" className="grid-container">
            {pokemonListData.map((pokemon) => (
                <PokemonCard
                    key={pokemon.id}
                    id={pokemon.id}
                    name={pokemon.name}
                    types={pokemon.types}
                    img={pokemon.img}
                    parent={pokemon.parent}
                />
            ))}
        </div>
    )
}

export default PokemonList;