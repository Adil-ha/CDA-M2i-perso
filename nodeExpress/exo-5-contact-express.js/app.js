import express from "express";
import { ContactDao } from "./dao/ContactDao.js";
import { Contact } from "./models/Contact.js";
import { authenticationMiddleware } from "./middleware/middleware.js";
import { logDateMiddleware } from "./middleware/middleware.js";

const app = express();

const contactDao = new ContactDao();

app.use(express.json());

// app.use("/contacts", authenticationMiddleware);

app.use(logDateMiddleware);

app.get("/contacts", (req, res) => {
  res.json(contactDao.getAll());
});

app.get("/contacts/:contactId", (req, res) => {
  let contact = contactDao.findById(req.params.contactId);

  if (contact == undefined) {
    res
      .status(404)
      .json({ code: 404, message: "aucun contact trouvé avec cet id" });
  }

  res.json(contact);
});

app.post("/contacts", (req, res) => {
  const { lastname, firstname, phoneNumber } = req.body;
  let contact = new Contact(null, lastname, firstname, phoneNumber);
  res.json(contactDao.save(contact));
});

app.put("/contacts/:contactId", (req, res) => {
  const { id, lastname, firstname, phoneNumber } = req.body;
  if (req.params.contactId != id) res.sendStatus(409);
  let contact = new Contact(id, lastname, firstname, phoneNumber);

  contactDao.updateContact(contact)
    ? res.sendStatus(200)
    : res.status(400).json({
        code: 400,
        message: "problème lors de la mise à jour du contact",
      });
});

app.delete("/contacts/:contactId", (req, res) => {
  contactDao.deleteContact(+req.params.contactId);
  res.sendStatus(200);
});

app.listen(3001, () => {
  contactDao.readFile();
  console.log("http://127.0.0.1:3001");
});
