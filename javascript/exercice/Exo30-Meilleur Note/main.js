const notes = document.querySelector(".notes");
const length = document.querySelector(".length");
const displayBest = document.querySelector(".best");
const displayBad = document.querySelector(".bad");
const displayAverage = document.querySelector(".average");
let grasped = 0;
let i = 0;
let best = 0;
let bad = 0;
let total;

while (grasped != 777) {
  total = 0;
  grasped = parseInt(prompt("Veuillez saisir les notes, 777 pour arrêter"));
  i++;
  if (grasped != 777) {
    notes.innerHTML += `<li> En note ${i}, vous avez saisi ${grasped}/20`;
    if (grasped > best) {
      best = grasped;
    }
    if (grasped < bad) {
      bad = grasped;
    }
    total = grasped + total;
  }
}
average = total / i;

length.innerHTML += `Sur l'ensemble des ${i - 1} notes :`;
displayBest.innerHTML = `La meilleur note est de ${best}/20`;
displayBad.innerHTML = `La moins bonne note est de ${bad}/20`;
displayAverage.innerHTML = `La moyenne  est de ${average}/20`;
