import { Vehicule } from "./class/Vehicule.js";

let btnAddCar = document.querySelector(".btnAddCar");

btnAddCar.addEventListener("click", () => {
  let inputPlaque = document.querySelector(".inputPlaque").value;

  let vehicule = new Vehicule(inputPlaque);
  console.log(vehicule);
  let tabVehicule = [];
  tabVehicule.push;
});
