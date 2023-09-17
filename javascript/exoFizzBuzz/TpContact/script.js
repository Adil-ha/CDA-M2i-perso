import { Contact } from "./class/Contact.js";

let button = document.querySelector("input[type=submit]");
let table = document.querySelector(".table");
let tabContact = [];

function getContact() {
  let titre = document.querySelector("input[name=drone]").value;
  let nom = document.querySelector(".nom").value;
  let prenom = document.querySelector(".prenom").value;
  let dateNaissance = document.querySelector(".date").value;
  let telephone = document.querySelector(".telephone").value;
  let email = document.querySelector(".email").value;

  if (nom && prenom && dateNaissance && telephone && email) {
    let contact = new Contact(
      titre,
      nom,
      prenom,
      dateNaissance,
      telephone,
      email
    );
    tabContact.push(contact);
    createContactInTable(tabContact);
    resetInput();
  } else {
    alert("Veuillez remplir tous les champs avant d'ajouter un contact.");
  }
}

function createContactInTable(tabContact) {
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

function resetInput() {
  document.querySelector("input[type=radio]:checked").value = "";
  document.querySelector(".nom").value = "";
  document.querySelector(".prenom").value = "";
  document.querySelector(".date").value = "";
  document.querySelector(".telephone").value = "";
  document.querySelector(".email").value = "";
}

button.addEventListener("click", (e) => {
  e.preventDefault();
  getContact();
});
