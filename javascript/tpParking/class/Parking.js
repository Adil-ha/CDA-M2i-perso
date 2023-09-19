import { Vehicule } from "./Vehicule.js";

export class Parking {
  static price1 = 0.8;
  static price2 = 1.3;
  static price3 = 1.7;
  static price4 = 6;

  constructor() {
    this.parking = [];
  }

  isVehicleAvailable(plaque) {
    return this.parking.some((vehicule) => vehicule.plaque == plaque);
  }

  addVehicule(plaque) {
    let vehicule = new Vehicule(plaque);
    this.parking.push(vehicule);
  }

  exitCar(plaque) {
    this.parking = this.parking.filter((car) => car.plaque !== plaque);
  }

  renderWarning(type, text) {
    const warning = document.createElement("div");
    warning.classList.add("alert", "alert-dismissible", `alert-${type}`);

    const paragraph = document.createElement("p");
    paragraph.classList.add("m-auto", "text-center");
    paragraph.textContent = text;
    warning.appendChild(paragraph);

    const parentElement = document.querySelector(".warning");
    while (parentElement.firstChild) {
      parentElement.removeChild(parentElement.firstChild);
    }
    parentElement.appendChild(warning);

    warning.style.display = "block";

    setTimeout(() => {
      warning.style.display = "none";
    }, 5000);
  }
}
