const table = document.querySelector(".table");
const response = document.querySelector(".response");
let td;
let tr;

let person = [
  ["Jean", "Dupont", 15],
  ["Pierre", "Durand", 16],
  ["Jean", "Martin", 17],
];

for (let i = 0; i < person.length; i++) {
  tr = document.createElement("tr");
  for (let j = 0; j < person[i].length; j++) {
    td = document.createElement("td");
    td.innerHTML += `${person[i][j]}`;
    tr.appendChild(td);
  }
  table.appendChild(tr);
}

response.innerHTML = `<strong>${person[1][0]} ${person[1][1]}</strong>`;

document.addEventListener("keydown", (e) => {
  console.log(e.key);
});
