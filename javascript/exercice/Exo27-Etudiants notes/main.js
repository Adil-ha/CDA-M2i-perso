const name = document.querySelector(".name");
const notes = document.querySelector(".notes");
let total;
let length = 0;
let average = 0;

let etudiants = [
  {
    prenom: "José",
    nom: " Garcia",
    matieres: {
      francais: 16,
      anglais: 7,
      humour: 14,
    },
  },
  {
    prenom: "Antoine",
    nom: " De Caunes",
    matieres: {
      francais: 15,
      anglais: 6,
      humour: 14,
      informatique: 4,
      sport: 10,
    },
  },
];

for (const etudiant of etudiants) {
  total = 0;
  name.innerHTML += `${etudiant.prenom + etudiant.nom}<br><br>`;
  for (const value in etudiant.matieres) {
    name.innerHTML += `<li>${value}: ${etudiant.matieres[value]}/20</li>`;

    length = Object.keys(etudiant.matieres).length;
    total += etudiant.matieres[value];
  }

  average = total / length;
  name.innerHTML += `<br> Moyenne générale ${average.toFixed(1)}/20`;

  name.innerHTML += `<hr>`;
}
