import express from "express";
import { ProductDao } from "../dao/ProductDao.js";
import { Product } from "../models/Product.js";

const products = express.Router();

const productDao = new ProductDao();
productDao.readFile();

products.get("/", (req, res) => {
  res.json(productDao.getAll());
});

products.post("/", (req, res) => {
  const { title, price, stock } = req.body;
  const product = new Product(null, title, price, stock);
  res.json(productDao.save(product));
});

products.get("/:id", (req, res) => {
  const product = productDao.findById(+req.params.id);

  if (!product) {
    res
      .status(404)
      .json({ code: 404, message: "Aucun produit trouvé avec cet ID" });
  } else {
    res.json(product);
  }
});

export default products;
