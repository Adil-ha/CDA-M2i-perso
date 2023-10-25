import { readFileSync, writeFileSync } from "fs";
import { resolve } from "path";

export class OrderDao {
  constructor() {
    this.file = resolve("./data/dbOrders.json");
    this.orders = [];
  }

  readFile() {
    const file = readFileSync(this.file, { encoding: "utf-8" });
    this.orders = JSON.parse(file);
  }

  writeFile() {
    writeFileSync(this.file, JSON.stringify(this.orders));
  }

  getAll() {
    return this.orders;
  }

  save(order) {
    order.id = new Date().getTime();
    this.orders.push(order);
    this.writeFile();
    return order;
  }

  findById(id) {
    return this.orders.find((t) => t.id === id);
  }
}
