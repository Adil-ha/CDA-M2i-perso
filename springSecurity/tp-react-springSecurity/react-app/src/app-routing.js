import { createBrowserRouter, redirect } from "react-router-dom";
import App from "./App";
import ErrorPage from "./components/ErrorPage";


import Login from "./components/Login";
import Register from "./components/Register";
import ProductList from "./components/ProductList";
import CreateProduct from "./components/CreateProduct";
import { getUserDetails } from "./helpers/user-details";

//commit
const userDetails = getUserDetails();
 
const isAdmin = () => {
  if (userDetails && userDetails.role === "ROLE_ADMIN") {
    return true;
  } else {
    if (isLoggedIn()) {
      return redirect("/products");
    }
  }
};
 
const isLoggedIn = () => {
  const user = localStorage.getItem("user");
  if (!!user) {
    return true;
  } else {
    return redirect("/");
  }
};

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: <ErrorPage />,
    children: [
        {
            path: "/",
            element: <Login />,
          },
      {
        path: "/login",
        element: <Login />,
      },
      {
        path: "/register",
        element: <Register />,
      },
      {
        path: "/products",
        element: <ProductList />,
        loader: () => isLoggedIn(),
      },
      {
        path: "/create-product",
        element: <CreateProduct />,
        loader: () => isAdmin(),
        
      },
    ],
  },
]);


export default router;


