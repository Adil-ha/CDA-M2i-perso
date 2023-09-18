const row = document.querySelector(".row");
const taux = 0.89;
let population = 96809;
let year = 2015;
let i = 0;

while (population < 120000) {
  year = year + 1;
  population = Math.round(population * (1 + taux / 100));
  row.innerHTML += ` En ${year}, il y aura ${population.toLocaleString()} habitants <br> <hr>`;
  i = i + 1;
}
row.innerHTML += `Avec  un taux d'accroissement de la population de ${taux}%, en ${year}, il y aura ${population.toLocaleString()} dans la ville de Tourcoing. Il aura fallu ${i} années`;
