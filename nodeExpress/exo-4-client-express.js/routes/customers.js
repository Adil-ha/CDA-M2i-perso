import express from "express";
import { CustomerDao } from "../dao/CustomerDao.js";
import { Customer } from "../models/Customer.js";

const customers = express.Router();

const customerDao = new CustomerDao();
customerDao.readFile();

customers.get("/", (req, res) => {
  res.json(customerDao.getAll());
});

customers.post("/", (req, res) => {
  const { lastname, firstname, telephone } = req.body;
  let customer = new Customer(null, lastname, firstname, telephone);
  res.json(customerDao.save(customer));
});

customers.get("/:id", (req, res) => {
  let customer = customerDao.findById(+req.params.id);

  if (customer == undefined) {
    res
      .status(404)
      .json({ code: 404, message: "aucun client trouvé avec cet id" });
  }

  res.json(customer);
});

export default customers;
