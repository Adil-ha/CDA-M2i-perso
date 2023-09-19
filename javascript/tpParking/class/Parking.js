import { Vehicule } from "./Vehicule.js";

export class Parking {
  static price1 = 0.8;
  static price2 = 1.3;
  static price3 = 1.7;
  static price4 = 6;

  constructor() {
    this.parking = [];
  }

  // Méthode de vérification de véhicule
  isVehicleAvailable(plaque) {
    return !this.parking.some((vehicule) => vehicule.plaque == plaque);
  }

  addVehicule(plaque) {
    if (this.isVehicleAvailable(plaque)) {
      let vehicule = new Vehicule(plaque);
      this.parking.push(vehicule);
    } else {
      let message = `Un véhicule avec la plaque ${plaque} existe déjà dans le parking.`;
      this.renderWarning("danger", message);
    }
  }

  exitCar(plaque) {
    this.parking = this.parking.filter((car) => car.plaque !== plaque);
  }

  renderWarning(type, text) {
    let warning = document.querySelector(".warning");
    warning.style.display = "block";
    warning.innerHTML = `
    <div class="alert alert-dismissible alert-${type}">
      <p class="m-auto text-center">${text}</p>
    </div>

`;
    setTimeout(() => {
      warning.style.display = "none";
    }, 5000);
  }
}
