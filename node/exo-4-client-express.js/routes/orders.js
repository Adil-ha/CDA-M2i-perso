import express from "express";
import { OrderDao } from "../dao/OrderDao.js";
import { Order } from "../models/Order.js";

const orders = express.Router();

const orderDao = new OrderDao();
orderDao.readFile();

orders.get("/", (req, res) => {
  res.json(orderDao.getAll());
});

orders.post("/", (req, res) => {
  const { customerId, products } = req.body;
  const order = new Order(null, customerId, products);
  res.json(orderDao.save(order));
});

orders.get("/:id", (req, res) => {
  const order = orderDao.findById(+req.params.id);

  if (!order) {
    res
      .status(404)
      .json({ code: 404, message: "Aucune commande trouvée avec cet ID" });
  } else {
    res.json(order);
  }
});

export default orders;
