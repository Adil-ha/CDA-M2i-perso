// 1. Créer une interface User comprenant les propriétés suivantes :
interface User {
  nom: string;
  age: number;
  occupation: string;
}

// 2. Créer une interfaces Admin comprenant les propriétés suivantes :
interface Admin {
  nom: string;
  age: number;
  role: string;
}

// 3. Créer un tableau contenant les personnes suivantes (créer un type Personne)

type Personne = User | Admin;

const personnes: Personne[] = [
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
