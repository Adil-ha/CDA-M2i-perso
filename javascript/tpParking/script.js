import { Parking } from "./class/Parking.js";

let btnPay = document.querySelector(".btnPay");
let btnTicket = document.querySelector(".btnTicket");
let warning = document.querySelector(".warning");
let display = false;
let parking = new Parking();
parking.parking = [];
console.log(parking.parking);

btnTicket.addEventListener("click", () => {
  let inputPlaque = document.querySelector(".inputPlaque").value;
  parking.addVehicule(inputPlaque);
  console.log(parking.parking);
  document.querySelector(".inputPlaque").value = "";
});

btnPay.addEventListener("click", () => {
  verificationCar();
});

function verificationCar() {
  let inputPlaque = document.querySelector(".inputPlaque").value;
  const vehiculeExiste = parking.parking.some(
    (vehicule) => vehicule.plaque === inputPlaque
  );

  if (!vehiculeExiste) {
    let message = `Le véhicule ${inputPlaque} n'existe pas`;
    createWarning("danger", message);

    setTimeout(() => {
      warning.style.display = "none";
      display = true;
    }, 5000);
    if (display) {
      warning.style.display = "block";
      message = `Veuillez prendre votre ticket pour le véhicule ${inputPlaque}`;
      createWarning("success", message);
    }
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
    createWarning("warning", message);
  }
  document.querySelector(".inputPlaque").value = "";
}

function createWarning(type, message) {
  warning.innerHTML = `
                          <div class="alert alert-dismissible alert-${type}">
                            <p class="m-auto text-center">${message}</p>
                          </div>
  
  `;
}
