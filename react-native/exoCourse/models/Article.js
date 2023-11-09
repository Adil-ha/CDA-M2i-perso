export class Article {
  constructor(name, price) {
    this.id = Date.now();
    this.name = name;
    this.price = price;
  }

  getId() {
    return this.id;
  }

  getName() {
    return this.name;
  }

  getPrice() {
    return this.price;
  }
}
