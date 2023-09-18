// import { Contact } from "./class/Contact.js";
// let button = document.querySelector("input[type=submit]");
// let table = document.querySelector(".table");
// console.log(table);
// let tabContact = [];

// function getContact() {
//   let titre = document.querySelector("input[type=radio]").value;
//   let nom = document.querySelector(".nom").value;
//   let prenom = document.querySelector(".prenom").value;
//   let dateNaissance = document.querySelector(".date").value;
//   let telephone = document.querySelector(".telephone").value;
//   let email = document.querySelector(".email").value;
//   console.log(nom);

//   let contact = new Contact(
//     titre,
//     nom,
//     prenom,
//     dateNaissance,
//     telephone,
//     email
//   );
//   tabContact.push(contact);
//   console.log(tabContact);
//   createContact(tabContact);
// }

// function createContact(tabContact) {
//   for (let i = 0; i < tabContact.length; i++) {
//     let tr = document.createElement("tr");
//     let contact = {};
//     for (const key in contact.length) {
//       let td = document.createElement("td");
//       td.innerHTML += contact[key];
//       tr.appendChild(td);
//     }
//     table.appendChild(tr);
//   }
// }

// button.addEventListener("click", (e) => {
//   e.preventDefault();
//   getContact();
// });

import { Contact } from "./class/Contact.js";

let button = document.querySelector("input[type=submit]");
let table = document.querySelector(".table");
let tabContact = [];

function getContact() {
  let titre = document.querySelector("input[type=radio]:checked").value;
  let nom = document.querySelector(".nom").value;
  let prenom = document.querySelector(".prenom").value;
  let dateNaissance = document.querySelector(".date").value;
  let telephone = document.querySelector(".telephone").value;
  let email = document.querySelector(".email").value;

  let contact = new Contact(
    titre,
    nom,
    prenom,
    dateNaissance,
    telephone,
    email
  );
  tabContact.push(contact);
  console.log(tabContact);
  createContact(tabContact);
  resetInput();
}

function createContact(tabContact) {
  // Effacez le contenu précédent de la table
  table.innerHTML = "";

  for (let i = 0; i < tabContact.length; i++) {
    let tr = document.createElement("tr");
    let currentContact = tabContact[i];

    for (const key in currentContact) {
      let td = document.createElement("td");
      td.innerHTML += currentContact[key];
      tr.appendChild(td);
    }
    table.appendChild(tr);
  }
}

button.addEventListener("click", (e) => {
  e.preventDefault();
  getContact();
});

function resetInput() {
  document.querySelector("input[type=radio]:checked").value = "";
  document.querySelector(".nom").value = "";
  document.querySelector(".prenom").value = "";
  document.querySelector(".date").value = "";
  document.querySelector(".telephone").value = "";
  document.querySelector(".email").value = "";
}
