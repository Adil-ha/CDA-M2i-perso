import { readFileSync, writeFileSync } from "fs";
import { resolve } from "path";

export class CustomerDao {
  constructor() {
    this.file = resolve("./data/dbCustomers.json");
    this.customers = [];
  }

  readFile() {
    const file = readFileSync(this.file, { encoding: "utf-8" });
    this.customers = JSON.parse(file);
  }

  writeFile() {
    writeFileSync(this.file, JSON.stringify(this.customers));
  }

  getAll() {
    return this.customers;
  }

  save(customer) {
    customer.id = new Date().getTime();
    this.customers.push(customer);
    this.writeFile();
    return customer;
  }

  findById(id) {
    return this.customers.find((t) => t.id === id);
  }
}
