let displayNotes = document.querySelector(".notes");
let noteLength = document.querySelector(".noteLength");
let best = document.querySelector(".best");
let bad = document.querySelector(".bad");
let average = document.querySelector(".average");

let table = [];
let nb = parseInt(prompt("Nombre de notes à saisir"));
for (let i = 0; i < nb; i++) {
  table[i] = parseInt(prompt(`Entrer la note numéro ${i + 1}`));
}

let bestNote = table[0];
let badNote = table[0];
let totalNotes = 0;

displayNotes.innerHTML = "";

for (let j = 0; j < table.length; j++) {
  displayNotes.innerHTML += `<li>En note ${j + 1} vous avez saisi ${
    table[j]
  }/20. </li> `;
  if (table[j] < badNote) {
    badNote = table[j];
  }
  if (table[j] > bestNote) {
    bestNote = table[j];
  }
  totalNotes += table[j];
}
console.log(totalNotes);
console.log(table.length);
let averageNote = totalNotes / table.length;

noteLength.innerHTML += `<hr> Sur l'ensemble des ${table.length} notes :`;

best.innerHTML = `La meilleure note est de : ${bestNote}/20`;
bad.innerHTML = `La moins bonne note est de : ${badNote}/20`;
average.innerHTML = `La moyenne des notes est de : ${averageNote.toFixed(
  1
)}/20`;
