import { readFileSync, writeFileSync } from "fs";
import { resolve } from "path";

export class ProductDao {
  constructor() {
    this.file = resolve("./data/dbProducts.json");
    this.products = [];
  }

  readFile() {
    const file = readFileSync(this.file, { encoding: "utf-8" });
    this.products = JSON.parse(file);
  }

  writeFile() {
    writeFileSync(this.file, JSON.stringify(this.products));
  }

  getAll() {
    return this.products;
  }

  save(product) {
    product.id = new Date().getTime();
    this.products.push(product);
    this.writeFile();
    return product;
  }

  findById(id) {
    return this.products.find((t) => t.id === id);
  }
}
