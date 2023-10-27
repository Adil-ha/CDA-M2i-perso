import { readFileSync, writeFileSync } from "fs";
import { resolve } from "path";

export class ContactDao {
  constructor() {
    this.file = resolve("./data/dbContact.json");
    this.contacts = [];
  }

  readFile() {
    const file = readFileSync(this.file, { encoding: "utf-8" });
    this.contacts = JSON.parse(file);
  }

  writeFile() {
    writeFileSync(this.file, JSON.stringify(this.contacts));
  }

  getAll() {
    return this.contacts;
  }

  save(contact) {
    contact.id = Date.now();
    this.contacts.push(contact);
    this.writeFile();
    return contact;
  }

  findById(id) {
    return this.contacts.find((t) => t.id == id);
  }

  deleteContact(id) {
    this.contacts = this.contacts.filter((t) => t.id !== id);
    this.writeFile();
  }

  updateContact(contactUpdate) {
    const contact = this.findById(contactUpdate.id);
    if (contact == undefined) {
      return false;
    }
    contact.lastname = contactUpdate.lastname;
    contact.firstname = contactUpdate.firstname;
    contact.phoneNumber = contactUpdate.phoneNumber;

    this.writeFile();
    return true;
  }
}
