"use strict";
const personnes = [
  { nom: "Toto Dupont", age: 35, occupation: "Facteur" },
  { nom: "Jeanne Doe", age: 25, role: "Admin" },
  { nom: "Michel Michel", age: 23, occupation: "Lutteur" },
  { nom: "Michael Flinch", age: 64, role: "Gérant" },
];
personnes.forEach((personne) => {
  console.log(`${personne.nom} ${personne.age}`);
  let bonus =
    "occupation" in personne
      ? "Son occupation est :" + personne.occupation
      : "Son role : " + personne.role;
  console.log(bonus);
});
