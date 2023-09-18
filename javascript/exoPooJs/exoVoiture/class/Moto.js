import { Vehicule } from "./Vehicule.js";

export class Moto extends Vehicule {
  constructor(modele, marque, kilometrage, annee) {
    super(modele, marque, kilometrage, annee);
  }

  display() {
    return `${super.display()}`;
  }
}
