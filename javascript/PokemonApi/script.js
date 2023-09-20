let btnSuprise;
let nbRandom;
let container = document.querySelector(".container");
const pokemonContainer = document.querySelector(".pokemon-container");

function createPokemonCard(data) {
  const cardDiv = document.createElement("div");

  cardDiv.classList.add("card");
  cardDiv.style.width = "18rem";

  const imgElement = document.createElement("img");
  imgElement.classList.add("card-img-top");
  imgElement.style.objectFit = "cover";
  imgElement.src = `${data.sprites.front_default}`;
  imgElement.alt = `picture:${data.name}`;

  const arrowLeft = document.createElement("i");
  arrowLeft.classList.add("fas", "fa-arrow-left", "arrow", "arrowLeft");
  //   arrowLeft.addEventListener("click", previousPokemon); // Ajoutez un gestionnaire d'événements pour gérer le clic sur la flèche gauche

  const arrowRight = document.createElement("i");
  arrowRight.classList.add("fas", "fa-arrow-right", "arrow", "arrowRight");
  //   arrowRight.addEventListener("click", nextPokemon);

  const cardBodyDiv = document.createElement("div");
  cardBodyDiv.classList.add("card-body");

  const titleElement = document.createElement("h5");
  titleElement.classList.add("card-title");
  titleElement.textContent = `${data.name}`;

  const weightElement = document.createElement("p");
  weightElement.classList.add("card-text");
  weightElement.classList.add("weightPokemon");
  weightElement.textContent = `Poids ${data.weight}`;

  const heightElement = document.createElement("p");
  heightElement.classList.add("card-text");
  heightElement.classList.add("hightPokemon");
  heightElement.textContent = `Taille  ${data.height}`;

  const linkElement = document.createElement("a");
  linkElement.classList.add("btn");
  linkElement.classList.add("btn-primary");
  linkElement.href = "#";
  linkElement.textContent = "Surprise";

  cardDiv.appendChild(imgElement);
  cardDiv.appendChild(cardBodyDiv);
  cardBodyDiv.appendChild(arrowLeft);
  cardBodyDiv.appendChild(arrowRight);
  cardBodyDiv.appendChild(titleElement);
  cardBodyDiv.appendChild(weightElement);
  cardBodyDiv.appendChild(heightElement);
  cardBodyDiv.appendChild(linkElement);

  //   container.appendChild(cardDiv);
  pokemonContainer.innerHTML = "";
  pokemonContainer.appendChild(cardDiv);
  randomSuprise();
  clickArrowLeft();
  clickArrowRight();
}

function fetchApiPokemon(nbRandom) {
  fetch(`https://pokeapi.co/api/v2/pokemon/${nbRandom}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("Success:", data);
      console.log(data.name);
      createPokemonCard(data);

      if (data == "error") {
        console.error("erreur fonctionnel !");
      }
    })
    .catch((error) => {
      console.error("Error:", error);
    });
}
function randomSuprise() {
  let btnSuprise = document.querySelector(".btn-primary");
  btnSuprise.addEventListener("click", () => {
    nbRandom = Math.floor(Math.random() * 151) + 1;
    fetchApiPokemon(nbRandom);
  });
}

function clickArrowLeft() {
  let arrowLeft = document.querySelector(".arrowLeft");
  arrowLeft.addEventListener("click", (e) => {
    nbRandom = nbRandom - 1;
    fetchApiPokemon(nbRandom);
    console.log(e);
  });
}
function clickArrowRight() {
  let arrowRight = document.querySelector(".arrowRight");
  arrowRight.addEventListener("click", (e) => {
    console.log(e);
    nbRandom = nbRandom + 1;
    fetchApiPokemon(nbRandom);
  });
}

window.addEventListener("load", () => {
  const pokemonDiv = document.createElement("div");
  pokemonDiv.classList.add("pokemon-card");
  container.appendChild(pokemonDiv);

  nbRandom = Math.floor(Math.random() * 151) + 1;
  fetchApiPokemon(nbRandom);
});
