import { Vehicule } from "./Vehicule.js";

export class Parking {
  static price1 = 0.8;
  static price2 = 1.3;
  static price3 = 1.7;
  static price4 = 6;

  constructor() {
    this.parking = [];
  }

  addVehicule(plaque) {
    let vehicule = new Vehicule(plaque);
    this.parking.push(vehicule);
  }
}
