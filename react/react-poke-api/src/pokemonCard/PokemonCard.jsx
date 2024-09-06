/* eslint-disable react/prop-types */

function PokemonCard({ id, name, types, img, parent }) {
    return (
        <div className="card" id={name}>
            <div className="imgContainer" onClick={() => showDetails(name)}>
                <img src={img} alt="Avatar" style={{ width: '100%' }} />
                <p className="pokemonIdLabel">ID/{id}</p>
            </div>
            <div className="dataContainer">
                <h4><b>{capitalizeFirstLetter(name)}</b></h4>
                <div id={`typeContainer${id}`} className="typeContainer">
                    {types.map((type, index) => (
                        <span key={index} className="pokemonType">{capitalizeFirstLetter(type)}</span>
                    ))}
                </div>
                <div id={`evolutionContainer${id}`} className="evolutionContainer">
                    <p>{parent ? "Evoluciona de:" : ''}{parent ? <br /> : ''}<b>{parent ? capitalizeFirstLetter(parent) : ''}</b></p>
                </div>
            </div>
            <div className="btnContainer">
                <button id={`backBtn_${name}`} className="hideBtn" onClick={() => closeDetails(name)}>Volver</button>
            </div>
        </div >
    );


    function capitalizeFirstLetter(string) {
        return string.charAt(0).toUpperCase() + string.slice(1);
    }

    function showDetails(cardId) {
        [...document.getElementsByClassName('card')].forEach(element => {
            element.className = 'hideCard';
        });

        const pokemonCard = document.getElementById(cardId);
        pokemonCard.className = 'card resizeCard';

        const backBtn = document.getElementById(`backBtn_${cardId}`);
        backBtn.className = 'showBtn';
    }

    function closeDetails(cardId) {
        [...document.getElementsByClassName('hideCard')].forEach(element => {
            element.className = 'card';
        });

        const pokemonCard = document.getElementById(cardId);
        pokemonCard.className = 'card';

        const backBtn = document.getElementById('backBtn_' + cardId);
        backBtn.className = 'hideBtn';
    }
}

export default PokemonCard