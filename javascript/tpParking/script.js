import { Parking } from "./class/Parking.js";

let btnPay = document.querySelector(".btnPay");
let btnTicket = document.querySelector(".btnTicket");
let display = false;
let parking = new Parking();
parking.parking = [];
console.log(parking.parking);

btnTicket.addEventListener("click", () => {
  let inputPlaque = document.querySelector(".inputPlaque").value.trim();
  if (inputPlaque !== "") {
    parking.addVehicule(inputPlaque);
    console.log(parking.parking);
    document.querySelector(".inputPlaque").value = "";
    let message = `Veuillez prendre votre ticket pour le véhicule ${inputPlaque}`;
    parking.renderWarning("success", message);
  } else {
    let message = "Le format de la plaque n'est pas correcte";
    parking.renderWarning("danger", message);
  }
});

btnPay.addEventListener("click", () => {
  let inputPlaque = document.querySelector(".inputPlaque").value.trim();
  if (inputPlaque !== "") {
    verificationCar();
  } else {
    let message = "Le format de la plaque n'est pas correcte";
    parking.renderWarning("danger", message);
  }
});

function verificationCar() {
  let inputPlaque = document.querySelector(".inputPlaque").value.trim();
  const vehiculeExiste = parking.parking.some(
    (vehicule) => vehicule.plaque === inputPlaque
  );

  if (!vehiculeExiste) {
    let message = `Le véhicule ${inputPlaque} n'existe pas`;
    parking.renderWarning("danger", message);
  } else if (vehiculeExiste) {
    let exitDate = new Date().getTime();
    let timeParking = exitDate - parking.parking[0].enterDate;
    let heures = Math.floor(timeParking / 3600000); // 1 heure = 3600000 millisecondes
    timeParking -= heures * 3600000;
    let minutes = Math.floor(timeParking / 60000); // 1 minute = 60000 millisecondes
    timeParking -= minutes * 60000;
    let secondes = Math.floor(timeParking / 1000); // 1 seconde = 1000 millisecondes

    let price = 0;

    if (minutes <= 15) {
      price = Parking.price1;
    } else if (minutes > 15 && minutes <= 30) {
      price = Parking.price2;
    } else if (minutes > 30 && minutes <= 45) {
      price = Parking.price3;
    } else if (minutes > 45) {
      price = Parking.price4;
    }

    let message = `Le prix à payer pour le véhicule ${inputPlaque} est de ${price}`; // Complétez le message avec le calcul du prix.
    parking.renderWarning("warning", message);
    parking.exitCar(inputPlaque);
    console.log(parking.parking);
  }
  document.querySelector(".inputPlaque").value = "";
}
