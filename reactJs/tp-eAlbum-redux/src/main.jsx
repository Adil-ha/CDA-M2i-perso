import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css"; 
import { Provider } from "react-redux";
import "bootstrap/dist/css/bootstrap.min.css";

import store from "./store.js";
import { RouterProvider } from "react-router-dom";
import router from "./app-routing.jsx";

ReactDOM.createRoot(document.getElementById("root")).render(
  <Provider store={store}>
    <RouterProvider router={router} />
  </Provider>
);
