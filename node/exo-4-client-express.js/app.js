import express from "express";
import customers from "./routes/customers.js";
import products from "./routes/products.js";
import orders from "./routes/orders.js";

const port = 3001;

const app = express();

app.use(express.json());
app.use("/products", products);
app.use("/customers", customers);
app.use("/orders", orders);

app.listen(port, () => {
  console.log(`http://127.0.0.1:${port}`);
});
