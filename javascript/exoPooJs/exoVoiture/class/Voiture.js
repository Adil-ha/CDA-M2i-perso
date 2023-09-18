import { Vehicule } from "./Vehicule.js";

export class Voiture extends Vehicule {
  constructor(modele, marque, kilometrage, annee, clim = null) {
    super(modele, marque, kilometrage, annee);
    clim ? (this.clim = "Climatisé") : (this.clim = "Non climatisé");
  }

  display() {
    return `${super.display()}, ${this.clim}`;
  }
}
