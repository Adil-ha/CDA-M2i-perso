import { Parking } from "./class/Parking.js";

let btnPay = document.querySelector(".btnPay");
let btnTicket = document.querySelector(".btnTicket");

let parking = new Parking();
parking.parking = [];

btnTicket.addEventListener("click", () => {
  let inputPlaque = document.querySelector(".inputPlaque").value.trim();
  const vehiculeExiste = parking.isVehicleAvailable(inputPlaque);
  if (inputPlaque !== "" && !vehiculeExiste) {
    parking.addVehicule(inputPlaque);
    console.log(parking.parking);
    const message = `Veuillez prendre votre ticket pour le véhicule ${inputPlaque}`;
    parking.renderWarning("success", message);
  } else if (vehiculeExiste) {
    const message = `Un véhicule avec la plaque ${inputPlaque} existe déjà dans le parking.`;
    parking.renderWarning("danger", message);
  } else {
    const message = "Le format de la plaque n'est pas correct.";
    parking.renderWarning("danger", message);
  }
  document.querySelector(".inputPlaque").value = "";
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

  const vehiculeExiste = parking.isVehicleAvailable(inputPlaque);
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
    switch (true) {
      case minutes <= 15:
        price = Parking.price1;
        break;
      case minutes > 15 && minutes <= 30:
        price = Parking.price2;
        break;
      case minutes > 30 && minutes <= 45:
        price = Parking.price3;
        break;
      default:
        price = Parking.price4;
    }

    let message = `Le prix à payer pour le véhicule ${inputPlaque} est de ${price}`;
    parking.renderWarning("warning", message);
    parking.exitCar(inputPlaque);
    console.table(parking.parking);
  }
  document.querySelector(".inputPlaque").value = "";
}
