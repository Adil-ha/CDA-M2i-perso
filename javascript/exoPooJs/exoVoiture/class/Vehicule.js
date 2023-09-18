export class Vehicule {
  constructor(modele, marque, kilometrage, annee) {
    this.modele = modele;
    this.marque = marque;
    this.kilometrage = kilometrage;
    this.annee = annee;
  }
  display() {
    return `<strong>${this.constructor.name}</strong> : ${this.modele}, ${this.marque}, ${this.kilometrage}km, ${this.annee}`;
  }
}
