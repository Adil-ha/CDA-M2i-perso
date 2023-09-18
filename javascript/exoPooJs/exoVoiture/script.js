import { Voiture } from "./class/Voiture.js";
import { Moto } from "./class/moto.js";

let text = document.querySelector(".text");

let voiture = new Voiture("BMW", "X6", 20000, 2020, false);
text.innerHTML += voiture.display();

let moto = new Moto("kawasaki", "Z900", 15000, 2015);
text.innerHTML += `<br>${moto.display()}`;
